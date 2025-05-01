import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class IslandHopping {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        Node[] nodes;
        EdgeWeightedGraph graph;
        LazyPrimMST mst;

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(in.readLine());
            nodes = new Node[m];
            graph = new EdgeWeightedGraph(m);

            for (int j = 0; j < m; j++) {
                String[] input = in.readLine().split(" ");
                double x = Double.parseDouble(input[0]);
                double y = Double.parseDouble(input[1]);
                nodes[j] = new Node(x, y, j);
                if (j == 0) continue;
                for (int k = 0; k < j; k++) {
                    if (nodes[k] == null) break;
                    if (nodes[k].getDist(nodes[j]) < 100) {
                        Edge e = new Edge(nodes[k], nodes[j]);
                        graph.addEdge(e);
                    }
                }
            }
            mst = new LazyPrimMST(graph);
            double dist = 0;
            for (Edge e : mst.mst()) {
                dist += e.getWeight();
            }
            System.out.println(dist);
        }
    }
}

class Edge implements Comparable<Edge> {
    private final int v, w;
    private final Node nv, nw;
    private final double weight;

    public Edge(Node nv, Node nw) {
        this.nv = nv;
        this.nw = nw;
        this.v = this.nv.getIndex();
        this.w = this.nw.getIndex();
        this.weight = this.nv.getDist(this.nw);
    }
    
    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v) return w;
        else return v;
    }

    public double getWeight() { return this.weight; }

    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }
}

class EdgeWeightedGraph {
    private final int V;
    private final LinkedList<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        adj = (LinkedList<Edge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public int getV() { return this.V; }

    public void addEdge (Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
}

class Node {
    private final double x, y;
    private final int i;

    public Node(double x, double y, int i) {
        this.x = x;
        this.y = y;
        this.i = i;
    }

    public int getIndex() { return i; }

    public double getX() { return x; }
    public double getY() { return y; }

    public double getDist(Node that) {
        return Math.sqrt(Math.pow((that.getX() - this.x), 2) + Math.pow((that.getY() - this.y), 2));
    }
}

class LazyPrimMST {
    private boolean[] marked;
    private Queue<Edge> mst;
    private PriorityQueue<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new PriorityQueue<>();
        mst = new LinkedList<>();
        marked = new boolean[G.getV()];
        this.visit(G, 0);

        while (mst.size() < G.getV() - 1) {
            Edge e = pq.poll();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.add(e);
            if (!marked[v]) this.visit(G, v);
            if (!marked[w]) this.visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.add(e);
            }
        }
    }

    public Iterable<Edge> mst() {
        return mst;
    }
}
