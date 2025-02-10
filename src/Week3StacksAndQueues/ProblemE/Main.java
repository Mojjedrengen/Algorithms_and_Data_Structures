package Week3StacksAndQueues.ProblemE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(in.readLine());
    Teque<Integer> teque = new Teque<>();
    for (int i = 0; i < N; i++) {
      String[] input = in.readLine().split(" ");
      int item = Integer.parseInt(input[1]);
      if      (input[0].equals("push_back")) teque.pushBack(item);
      else if (input[0].equals("push_front")) teque.pushFront(item);
      else if (input[0].equals("push_middle")) teque.pushMiddle(item);
      else if (input[0].equals("get")) System.out.println(teque.get(item)); 
    }
  }
}
