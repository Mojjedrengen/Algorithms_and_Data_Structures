package Week1DisjointSets.ProblemA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // find problem here: https://itu.kattis.com/courses/KSALDAS/2025-Spring/assignments/uvsaz6/problems/disjointsetssimple
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        String[] inputs = input.split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        UF uf = new UF(n);
        for (int i = 0; i < m; i++) {
            String line = in.readLine();
            String[] chars = line.split(" ");
            int p = Integer.parseInt(chars[1]);
            int q = Integer.parseInt(chars[2]);
            if (chars[0].equals("?")){
                System.out.println(uf.query(p, q));
            } else {
                uf.union(p, q);
            }
        }
    }
}
