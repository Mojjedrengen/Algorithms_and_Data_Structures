package Week3StacksAndQueues.ProblemA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
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
    Stack<Character> open = new Stack<>();
    for (int i = 0; i < inputString.length(); i++) {
      char bracket = inputString.charAt(i);
      if (bracket == '(' || bracket == '[') {
        open.push(bracket);
        continue;
      } else if (open.isEmpty()) {
        illigal = true;
        break;
      }
      char last = open.pop();
      if (last == '(' && bracket == ']' || last == '[' && bracket == ')') {
        illigal = true;
        break;
      } 
    }
    if (illigal || !open.isEmpty()) System.out.println(0);
    else System.out.println(1);
  }
}
