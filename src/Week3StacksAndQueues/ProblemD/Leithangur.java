package Week3StacksAndQueues.ProblemD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Leithangur
 */
public class Leithangur {

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Stack<Character> backpack = new Stack<>();
    String path = in.readLine();
    boolean neibb = false;
    in.close();
    for (int i = 0; i < path.length(); i++) {
      char step = path.charAt(i);
      if (step == '.') continue;
      if (step == 'p' || step == 'g' || step == 'o') backpack.push(step);
      else if (backpack.isEmpty()) {
        neibb = true;
        break;
      } else {
        boolean looking = true;
        while (looking) {
          if (backpack.isEmpty()) {
            neibb = true;
            looking = false;
            i = path.length();
            break;
          }
          char topItem = Character.toUpperCase(backpack.pop());
          if (topItem == step) {
            looking = false;
          }
        }
      }
    }
    if (neibb) System.out.println("Neibb");
    else {
      int p = 0, g = 0, o = 0;
      for (Character item : backpack) {
        if      (item == 'p') p++;
        else if (item == 'g') g++;
        else if (item == 'o') o++;
      }
      System.out.println(p+"\n"+g+"\n"+o);
    }
  }
}
