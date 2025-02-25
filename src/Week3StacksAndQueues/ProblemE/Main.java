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
      else if (input[0].equals("push_middle")) teque.newPushMiddle(item);
      else if (input[0].equals("get")) System.out.println(teque.get(item)); 
    }
  }
}
/**
 * Teque
 */
class Teque<T> {

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
    } else {
      oldlast.next = last;
    }
    size++;
  }
  public void pushFront (T item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    if (isEmpty()) {
      middle = first;
      last = first;
    } else if (middle == null) {
      middle = first;
    }
    first.next = oldfirst;
    size++;
  }
  public void pushMiddle (T item) {
    Node oldmiddle = middle;
    middle = new Node();
    middle.item = item;
    if (isEmpty()) {
      first = middle;
      last = middle;
    }
    Node oldmiddleNext = oldmiddle.next;
    oldmiddle.next = middle;
    middle.next = oldmiddleNext;
    size++;
  }
  public void newPushMiddle (T item) {
    int findindex = (int) Math.ceil(size/2d) - 1;
    Node oldmiddle = find(first, findindex);
    middle = new Node();
    middle.item = item;
    middle.next = oldmiddle.next;
    oldmiddle.next = middle;
    size++;
  }

  public T get(int index) {
    return find(first, index).item;
  }

  private Node find(Node curr, int index) {
    if (index == 0) return curr;
    else {
      index--;
      return find(curr.next, index);
    }
  }
}

