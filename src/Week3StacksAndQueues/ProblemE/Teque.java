package Week3StacksAndQueues.ProblemE;

/**
 * Teque
 */
public class Teque<T> {

  /**
   *  Node
   */
  private class  Node{
    T item;
    Node next;
  }
  private Node first;
  private Node last;
  private Node middle;
  private int size;
  
  public boolean isEmpty() { return first == null; }
  
  public void pushBack (T item) {
    Node oldlast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    if (isEmpty()) {
      first = last;
      middle = last;
    } else {
      oldlast.next = last;
    }
  }
  public void pushFront (T item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    if (isEmpty()) {
      middle = first;
      last = first;
    }
    first.next = oldfirst;
  }
  public void pushMiddle (T item) {
    Node oldmiddle = middle;
    middle = new Node();
    middle.item = item;
    if (isEmpty()) {
      first = middle;
      last = middle;
    }
    middle.next = oldmiddle;
  }

  public T get(int index) {
    return find(first, index).item;
  }

  private Node find(Node curr, int index) {
    if (index == 0) return curr;
    else return find(curr.next, index--);
  }
}
