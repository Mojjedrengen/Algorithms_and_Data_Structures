package ProblemA;

/**
 * Stack
 */
public class AlgorithmStack<T> {
  private Node first;
  private int N;

  private class Node {
    T item;
    Node next;
  }
  public AlgorithmStack() {
    super();
  }
  public boolean isEmpty() { return first == null; }
  public int size() { return N; }
  
  public void push(T item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    N++;
  }

  public T pop() {
    T item = first.item;
    first = first.next;
    N--;
    return item;
  }
}
