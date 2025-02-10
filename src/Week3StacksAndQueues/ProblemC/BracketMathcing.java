package Week3StacksAndQueues.ProblemC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * BracketMathcing
 */
public class BracketMathcing {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    in.readLine();
    String inputString = in.readLine();
    in.close();
    boolean illigal = false;
    Stack<Character> open = new Stack<>();
    for (int i = 0; i < inputString.length(); i++) {
      char bracket = inputString.charAt(i);
      if (bracket == '(' || bracket == '[' || bracket == '{') {
        open.push(bracket);
        continue;
      } else if (open.isEmpty()) {
        illigal = true;
        break;
      }
      char last = open.pop();
      if (last == '(' && bracket == ']' || last == '(' && bracket == '}' ||
          last == '[' && bracket == ')' || last == '[' && bracket == '}' ||
          last == '{' && bracket == ')' || last == '{' && bracket == ']') {
        illigal = true;
        break;
      } 
    }
    if (illigal || !open.isEmpty()) System.out.println("Invalid");
    else System.out.println("Valid");
  }
}
