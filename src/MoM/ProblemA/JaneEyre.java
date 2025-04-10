import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class JaneEyre {

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] nmk = in.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);

        TreeMap<String, Integer> bookStack = new TreeMap<>();
        bookStack.put("Jane Eyre", k);
        for (int i = 0; i < n; i++) {
            String input = in.readLine();
            int quatindex = input.indexOf("\"", 1);
            bookStack.put(input.substring(1, quatindex), Integer.parseInt(input.substring(quatindex+2)));
        }

        JaneEyrePQ pq = new JaneEyrePQ(m);
        for (int i = 0; i < m; i++) {
            String input = in.readLine();
            int gooseIndex1 = input.indexOf("\"");
            int gooseIndex2 = input.indexOf("\"", gooseIndex1+1);
            int key = Integer.parseInt(input.substring(0, gooseIndex1-1));
            String name = input.substring(gooseIndex1+1, gooseIndex2);
            int readTime = Integer.parseInt(input.substring(gooseIndex2+2));
            pq.insert(key, name, readTime);
        }

        long time = 0;
        String currBook = null;
        int currReadTime = 0;
        while (k != 0) {
            if (currBook == null) {
                Map.Entry<String, Integer> entry = bookStack.pollFirstEntry();
                currBook = entry.getKey();
                currReadTime = entry.getValue();
            }
            getBook(time + currReadTime, bookStack, pq);
            time += currReadTime;
            if (currBook.equals("Jane Eyre")) break;
            currBook = null;
        }
        System.out.println(time);
    }

    private static boolean getBook(long time, TreeMap<String, Integer> bookStack, JaneEyrePQ pq) {
        if (time >= pq.peakMax() && pq.peakMax() != -1) {
            String[] book = pq.delMax().split("\"");
            bookStack.put(book[0], Integer.parseInt(book[1]));
            return getBook(time, bookStack, pq);
        } else return false;
    }
}

class JaneEyrePQ {
    class JaneEyrePQNode {
        int key;
        String name;
        int readTime;
        JaneEyrePQNode(int key, String name, int readTime) {
            this.key = key;
            this.name = name;
            this.readTime = readTime;
        }
    }

    JaneEyrePQNode[] heap;
    int n;
    
    JaneEyrePQ(int size) {
        heap = new JaneEyrePQNode[size+1];
        n = 0;
    }
   
    private void exch(int pos1, int pos2) {
        JaneEyrePQNode temp = heap[pos1];
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
        return heap[less].key > heap[larger].key;
    }
    
    public void insert(int key, String name, int readTime) {
        JaneEyrePQNode x = new JaneEyrePQNode(key, name, readTime);
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

    public String delMax() {
        JaneEyrePQNode max = heap[1];
        exch(1, n);
        n -= 1;
        sink(1);
        heap[n+1] = null;
        return max.name+"\""+max.readTime;
    }

    public int peakMax() {
        if (n == 0) return -1;
        return heap[1].key;
    }
}
