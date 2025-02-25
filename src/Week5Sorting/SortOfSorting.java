package Week5Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SortOfSorting
 */
public class SortOfSorting {

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      int n = Integer.parseInt(in.readLine());
      if (n == 0) break;
      String[] lastnames = new String[n];
      for (int i = 0; i < n; i++) {
        lastnames[i] = in.readLine();
      }
      sort(lastnames, 0, lastnames.length-1);
      for (String name : lastnames) {
        System.out.println(name);
      }
      System.out.println();
    }
  }

  public static void merge(String[] arr, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    String[] L = new String[n1];
    String[] R = new String[n2];

    for (int i = 0; i < n1; i++) {
      L[i] = arr[l + i];
    }
    for (int j = 0; j < n2; j++) {
      R[j] = arr[m + j + 1];
    }
    int i = 0, j = 0;

    int k = l;
    while (i < n1 && j < n2) {
      String Lsub = L[i].substring(0,2);
      String Rsub = R[j].substring(0,2);

      if (Lsub.compareToIgnoreCase(Rsub) <= 0) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }
    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }

  public static void sort(String[] arr, int l, int r) {
    if (l >= r) return;

    int m = (l + r) / 2;

    sort(arr, l, m);
    sort(arr, m + 1 , r);

    merge(arr, l, m, r);
  }
}
