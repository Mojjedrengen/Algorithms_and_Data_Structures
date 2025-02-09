package Week3StacksAndQueues.ProblemA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Week3StacksAndQueues.ProblemA.AlgorithmStack;
/**
 * Balance
 */
    //Problem: https://itu.kattis.com/courses/KSALDAS/2025-Spring/assignments/dmcjop/problems/itu.balance
// Does not work check sample 5.
// Rewrite maybe as a stack? FILO.
public class Balance {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String inputString = in.readLine();
    in.close();
    boolean illigal = false;
    AlgorithmStack<Character> open = new AlgorithmStack<>();
    for (int i = 0; i < inputString.length(); i++) {
      char bracket = inputString.charAt(i);
      if (bracket == '(' || bracket == '[') open.push(bracket);
      else if (bracket != open.pop()) {
        illigal = true;
        break;
      } 
    }
    if (illigal) System.out.println(0);
    else System.out.println(1);
  }
}
