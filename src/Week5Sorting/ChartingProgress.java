package Week5Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ChartingProgress
 */
public class ChartingProgress {

  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int i = 0;
    List<String> logs = new ArrayList<>();
    while (null != (line = in.readLine())) {
      if (line.length() == 0) {
        for (String logline : logs) {
          System.out.println(logline);
        }
        i = 0;
        logs.clear();
      }
      else {
        int asterics = 0;
        StringBuilder log = new StringBuilder();
        for (int j = 0; j < line.length(); j++) {
          if (line.charAt(j) == '*') asterics++;
        }
        System.out.println(asterics);
        i += asterics;
        for (int j = 0; j < line.length()-i; j++) {
          log.append('.');
        }
        for (int j = 0; j < asterics; j++){
          log.append('*');
        }
        for (int j = log.length(); j < line.length(); j++) {
          log.append('.');
        }
        logs.add(log.toString());
      }
    }
    for (String logline : logs) {
      System.out.println(logline);
    }
    in.close();
  }
}
