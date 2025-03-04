package Week6PriorityQueeus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SeatAllocation
 */
public class SeatAllocation {

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    String[] nm = in.readLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);

    SeatPQ pq = new SeatPQ(n);

    long[] seats = new long[n];
    long[] votes = new long[n];

    for (int i = 0; i < n; i++) {
      seats[i] = 0;
      votes[i] = Long.parseLong(in.readLine());
      pq.insert(i, votes[i]);
    }

    for (int j = 0; j < m; j++) {
      int maxKey = pq.delMax();
      seats[maxKey] += 1;
      double quotation = votes[maxKey]/(seats[maxKey]+1d);
      pq.insert(maxKey, quotation);
    }
    for (long seat : seats) {
      System.out.println(seat);
    }
  }
}
