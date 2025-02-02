package Week2FixedLengthSequences.ProblemC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String input = in.readLine();
        int coffe = -1;
        int awake = 0;
        for (int i = 0; i < n; i++) {
            coffe = input.charAt(i) == '1' ? 2 : coffe - 1;
            if (coffe > -1) awake++;
        }
        System.out.println(awake);
    }
}
