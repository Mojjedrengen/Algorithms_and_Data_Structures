package MakeUps.ProblemIThroughTheGrapevine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TTG {

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int n, m, d;
    String[] nmd = in.readLine().split(" ");
    n = Integer.parseInt(nmd[0]);
    m = Integer.parseInt(nmd[1]);
    d = Integer.parseInt(nmd[2]);

    Map<String, Integer> skepticim = new HashMap<>();
    Map<String, LinkedList<String>> friends = new HashMap<>();
    Map<String, Boolean> heard = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String[] input = in.readLine().split(" ");
      skepticim.put(input[0], Integer.parseInt(input[1]));
      friends.put(input[0], new LinkedList<>());
      heard.put(input[0], false);
    }
    for (int i = 0; i < m; i++) {
      String[] input = in.readLine().split(" ");
      friends.get(input[0]).add(input[1]);
      friends.get(input[1]).add(input[0]);
    }
    
    Queue<String> queue = new LinkedList<>();
    String first = in.readLine();
    queue.add(first);
    heard.put(first, true);
    int heardRumor = 0;
    for (int i = 0; i < d; i++) {
      int queueLength = queue.size();
      for (int j = 0; j < queueLength; j++) {
        String spreader = queue.remove();
        for (String friend : friends.get(spreader)) {
          if (!heard.get(friend)) {
            heard.put(friend, true);
            heardRumor++;
          }
          skepticim.put(friend, skepticim.get(friend) - 1);
          if (skepticim.get(friend) == 0) queue.add(friend);
        }
      }
    }
    System.out.println(heardRumor);
  }
}
