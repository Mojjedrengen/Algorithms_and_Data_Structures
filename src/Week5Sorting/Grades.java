package Week5Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Grades
 */
public class Grades {

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(in.readLine());
    List<String> A = new ArrayList<>();
    List<String> B = new ArrayList<>();
    List<String> C = new ArrayList<>();
    List<String> D = new ArrayList<>();
    List<String> E = new ArrayList<>();
    List<String> FX = new ArrayList<>();
    List<String> F = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String[] input = in.readLine().split(" ");
      switch (input[1].charAt(0)) {
        case 'A': 
          if (A.isEmpty()) A.add(input[0]);
          else searchAndInsert(A, input[0], input[1]);
          break;
        case 'B':
          if (B.isEmpty()) B.add(input[0]);
          else searchAndInsert(B, input[0], input[1]);
          break;
        case 'C':
          if (C.isEmpty()) C.add(input[0]);
          else searchAndInsert(C, input[0], input[1]);
          break;
        case 'D':
          if (D.isEmpty()) D.add(input[0]);
          else searchAndInsert(D, input[0], input[1]);
          break;
        case 'E':
          if (E.isEmpty()) E.add(input[0]);
          else searchAndInsert(E, input[0], input[1]);
          break;
        case 'F':
          if (input[1].length() >= 2 && input[1].charAt(1) == 'X') {
            if (FX.isEmpty()) FX.add(input[0]);
            else searchAndInsert(FX, input[0], input[1]);
          } else {
            if (F.isEmpty()) F.add(input[0]);
            else searchAndInsert(F, input[0], input[1]);
          } 
          break;
        default:
          throw new IOException("Illigal grade: "+ input[1].charAt(0)+"\nIndex number: "+ i);
      }
    }
    for (String name : A) {
      System.out.println(name);
    } for (String name : B) {
      System.out.println(name);
    } for (String name : C) {
      System.out.println(name);
    } for (String name : D) {
      System.out.println(name);
    } for (String name : E) {
      System.out.println(name);
    } for (String name : FX) {
      System.out.println(name);
    } for (String name : F) {
      System.out.println(name);
    }
  }

  public static void searchAndInsert(List<String> list, String insert, String val) {
    int gradeValue = getGradeValue(val);
    
    int lIndex = 0;
    int rIndex = list.size()-1;
    int middle = (lIndex + rIndex)/2;
    int mVal = getGradeValue(list.get(middle));
    while (lIndex < rIndex) {
      middle = (lIndex + rIndex)/2;
      mVal = getGradeValue(list.get(middle));
      if (gradeValue == mVal){
        list.add(middle, insert);
        return;
      }
       else if (gradeValue > mVal) {
        rIndex = middle - 1;
      } else {
        lIndex = middle + 1;
      }
    }
    list.add(middle, insert);
  }
  private static int getGradeValue(String grade) {
    int gradeValue = 0;
    for (int i = 1; i < grade.length(); i++) {
      if (grade.charAt(i) == '+') gradeValue++;
      else if (grade.charAt(i) == '-') gradeValue--;
    }
    return gradeValue;
  }
}
