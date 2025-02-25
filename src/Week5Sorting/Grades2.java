package Week5Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Grades2
 */
public class Grades2 {

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Map<String, Integer> inputMap = new HashMap<>();
    int n = Integer.parseInt(in.readLine());
    for (int i = 0; i < n; i++) {
      String[] input = in.readLine().split(" ");
      int val = 1000;
      val += getGradeValue(input[1]);
      inputMap.put(input[0], val);
    }
    inputMap.entrySet().stream().sorted(new GradeComparator<String, Integer>()).forEach(entry -> System.out.println(entry.getKey()));
  }


  private static int getGradeValue(String grade) {
    int gradeValue = 0;
    switch (grade.charAt(0)) {
      case 'A':
        gradeValue += 100;
        break;
      case 'B':
        gradeValue += 200; break;
      case 'C':
        gradeValue += 300; break;
      case 'D':
        gradeValue += 400; break;
      case 'E':
        gradeValue += 500; break;
      case 'F':
        if (grade.length() >= 2 && grade.charAt(1) == 'X') {
          gradeValue += 600;
        } else {
          gradeValue += 700;
        } 
        break;
      default:
        break;
    }
    for (int i = 1; i < grade.length(); i++) {
      if (grade.charAt(i) == '+') gradeValue--;
      else if (grade.charAt(i) == '-') gradeValue++;
    }
    return gradeValue;
  }
}

class GradeComparator<K extends Comparable<K>, V extends Comparable<V>> implements Comparator<Map.Entry<K, V>> {
  public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
    if (o1.getValue().compareTo(o2.getValue()) < 0) {
      return -1;
    } else if (o1.getValue().compareTo(o2.getValue()) == 0) {
      return o1.getKey().compareTo(o2.getKey());
    } else {
      return 1;
    }
  }
}
