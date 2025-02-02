package Week2FixedLengthSequences.ProblemA;

public class Main {
    //Problem: https://itu.kattis.com/courses/KSALDAS/2025-Spring/assignments/cog4qt/problems/itu.ksaldas.changebto01
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int last = 1;
        String input = in.readLine();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if (input.charAt(i) == 'b') {
                if (last == 1) {
                    out.add(0);
                    last = 0;
                } else {
                    out.add(1);
                    last = 1;
                }
            } else {
                out.add(input.charAt(i));
            }
        }
        System.out.println(out);
    }
}
