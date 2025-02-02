package Week2FixedLengthSequences.ProblemB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int championIndex = 0, championStrenght = 0, championHealth = 0;

        for (int i = 0; i < n; i++) {
            String[] input = in.readLine().split(" ");
            if (i == 0){
                championHealth = Integer.parseInt(input[0]);
                championStrenght = Integer.parseInt(input[1]);
            } else {
                int challengerHealth = Integer.parseInt(input[0]);
                int challengerStrength = Integer.parseInt(input[1]);
                while (championHealth > 0 && challengerHealth > 0) {
                    challengerHealth -= championStrenght;
                    if (challengerHealth <= 0) break;
                    championHealth -= challengerStrength;
                }
                if (championHealth <= 0) {
                    championIndex = i;
                    championHealth = challengerHealth;
                    championStrenght = challengerStrength;
                }
            }
        }
        System.out.println(championIndex+1);
    }
}
