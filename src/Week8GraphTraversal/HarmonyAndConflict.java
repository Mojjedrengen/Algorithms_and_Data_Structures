package Week8GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class HarmonyAndConflict {
  static boolean[] marked;
  static boolean harmony = true;
  static int[] colour;
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int n, m;
    String[] nm = in.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);
    LinkedList<String>[] adj = new LinkedList[n];
    for (int i = 0; i < m; i++) {
      String[] input = in.readLine().split(" ");
      int u = Integer.parseInt(input[1]);
      String to = "-" + input[2];
      int v = Integer.parseInt(input[0]);

      if (adj[u] == null) adj[u] = new LinkedList<>();
      if (adj[v] == null) adj[v] = new LinkedList<>();
      adj[u].add(v+to);
      adj[v].add(u+to);
    }
    marked = new boolean[n];
    colour = new int[n];
    bjs(adj, 0);
    if (harmony == false) {
      System.out.println(0);
      return;
    }
    for (int i = 0; i < n; i++) {
      if (marked[i] == false) {
        bjs(adj, i);
      } 
      if (colour[i] == 0) {
        bjs(adj, i);
      }
    }
    if (harmony == false) System.out.println(0);
    else System.out.println(1);
  }

  private static void bjs(LinkedList<String>[] G, int s) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    if (marked == null) return;
    if (colour[s] == 0) colour[s] = 1;
    marked[s] = true;

    while (!queue.isEmpty()) {
      int v = queue.remove();
      for (String w : G[v]) {
        String[] edge = w.split("-");
        int edgeNode = Integer.parseInt(edge[0]);
        if (!marked[edgeNode]) {
          queue.add(edgeNode);
          marked[edgeNode] = true;
        }
        if (edge[1].equals("1")) {
          if (colour[edgeNode] == 0) {
            if (colour[v] == 1) colour[edgeNode] = 2;
            else colour[edgeNode] = 1;
          } else {
            if (colour[v] == colour[edgeNode]) {
              harmony = false;
              return;
            }
          }
        } else {
          if (colour[edgeNode] == 0) {
            colour[edgeNode] = colour[v];
          } else if (colour[edgeNode] != colour[v]) {
            harmony = false;
            return;
          }
        }
      }
    }
  }
}
