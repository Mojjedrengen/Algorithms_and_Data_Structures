package Week1DisjointSets.ProblemC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //find here: https://itu.kattis.com/courses/KSALDAS/2025-Spring/assignments/uvsaz6/problems/skolavslutningen
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        String[] inputs = input.split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int K = Integer.parseInt(inputs[2]);

        ColorPicker colorPicker = new ColorPicker(N, M, K);
        for (int i = 0; i < N; i++){
            colorPicker.addRow(in.readLine(), i);
        }
        System.out.println(colorPicker.maxDiffColors());
    }
}
