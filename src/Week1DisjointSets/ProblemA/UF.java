package Week1DisjointSets.ProblemA;

public class UF {
    private int[] parent;
    private int[] size;

    public UF(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0;  i < n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }
    public int find(int p) {
        if (parent[p] == p) {
            return p;
        }
        parent[p] = parent[parent[p]];
        return find(parent[p]);
    }
    public void union(int p, int q) {
        int headp = find(p);
        int headq = find(q);
        if (headp == headq) return;
        if (size[headp] >= size[headq]) {
            int temp = headp;
            headp = headq;
            headq = temp;
        }
        parent[headp] = headq;
        size[headq] += size[headp];
    }

    public int query(int p, int q) {
        if (p == q) return 1;
        if (find(p) == find(q)) return 1;
        return 0;
    }
}
