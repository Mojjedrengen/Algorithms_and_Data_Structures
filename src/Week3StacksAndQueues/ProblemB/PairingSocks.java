package Week3StacksAndQueues.ProblemB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * PairingSocks
 */
public class PairingSocks {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Stack<Integer> original = new Stack<>();
    Stack<Integer> auxiliary = new Stack<>();
    int numsocks = Integer.parseInt(in.readLine());
    String[] socks = in.readLine().split(" ");
    for (int i = 0; i < socks.length; i++) {
      original.push(Integer.parseInt(socks[i]));
      System.out.println(socks[i]);
    }
    int turns = 0;
    while (true) {
      int left = original.pop();
      if (auxiliary.isEmpty()) {
        auxiliary.push(left);
      } else {
        int right = auxiliary.pop();
        if (left == right) {
          numsocks--;
          turns++;
        } else if (!original.isEmpty()) {
          auxiliary.push(left);
          auxiliary.push(right);
        } else {
          original.push(left);
          original.push(right);
        }
      }

      if (numsocks == 0) break;
    }
    System.out.println(turns);
  }
}
