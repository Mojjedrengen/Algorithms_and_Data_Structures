package Week2FixedLengthSequences.ProblemF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        int tens = 1;
        int last = 0;
        int out = 0;
        for (int i = 0; i < input.length(); i++) {
            if ((i+1) % 10 == 0) tens++;
            int number = Integer.parseInt(input.substring(i, i+tens));
            if (number == last+1) {
                last++;
                out++;
            } else {
                out = -1;
                break;
            }
        }
        System.out.println(out);
    }
}
