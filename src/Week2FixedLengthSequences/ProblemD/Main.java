package Week2FixedLengthSequences.ProblemD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = in.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        String[] input = in.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int index = i+1;
            if (index % k == 0) {
                sb.append(input[i]);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
