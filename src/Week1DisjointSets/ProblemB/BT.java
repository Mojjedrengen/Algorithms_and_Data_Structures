package Week1DisjointSets.ProblemB;

import java.util.HashMap;
import java.util.Map;

public class BT {
    private String[] parent;
    private Map<String, Integer> size;
    public BT(int n) {
        parent = new String[n];
        size = new HashMap<>();
        for (int i = 0; i < n; i++) {
            parent[i] = "";
        }
    }

    //not working
    private String find(String p) {
        if (parent[1] == p) return p;
        return "";
    }
}
