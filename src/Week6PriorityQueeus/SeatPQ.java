package Week6PriorityQueeus;

/**
 * SeatPQ
 */
public class SeatPQ {

  /**
   * SeatPQNode
   */
  public class SeatPQNode {
    int key;
    double val;
    SeatPQNode(int key, double val) {
      this.key = key;
      this.val = val;
    }
  }

  SeatPQNode[] heap;
  int n;
  
  public SeatPQ(int size) {
    heap = new SeatPQNode[size+1];
    n = 0;
  }

  private void exch(int pos1, int pos2) {
    SeatPQNode temp = heap[pos1];
    heap[pos1] = heap[pos2];
    heap[pos2] = temp;
  }

  private void swim(int k) {
    while (k > 1 && less(k/2, k)) {
      exch(k, k/2);
      k = k/2;
    }
  }

  private boolean less(int less, int larger) {
    return heap[less].val < heap[larger].val;
  }

  public void insert(int key, double val) {
    SeatPQNode x = new SeatPQNode(key, val);
    n += 1;
    heap[n] = x;
    swim(n);
  }

  private void sink(int k) {
    while (2*k <= n) {
      int j = 2*k;
      if (j < n && less(j, j+1)) j += 1;
      if (!less(k, j)) break;
      exch(k, j);
      k = j;
    }
  }

  public int delMax() {
    SeatPQNode max = heap[1];
    exch(1, n);
    n -= 1;
    sink(1);
    heap[n+1] = null;
    return max.key;
  }
}
