package Week5Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Zipfsong
 */
public class Zipfsong {

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = in.readLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);

    Map<String, Double> songs = new LinkedHashMap<>();
    double f1 = 0;

    for (int i = 0; i < n; i++) {
      String[] newSong = in.readLine().split(" ");
      double fi = Double.parseDouble(newSong[0]);
      if (i == 0) f1 = fi;
      double zi = f1/(i+1);
      double qi = fi/zi;
      songs.put(newSong[1], qi);
    }
    String[] bedstSongs = new String[m];
    double[] quality = new double[m];
    double max = 0;
    double min = 0;

    for (Map.Entry<String, Double> song: songs.entrySet()) {
      double qi = song.getValue();
      if (qi > max) {
        if (max == 0) {
          for (int i = 0; i < m; i++) {
            bedstSongs[i] = song.getKey();
            quality[i] = qi;
          }
          min = qi;
        } else {
          insert(bedstSongs, quality, song.getKey(), qi, 0);
          min = quality[quality.length-1];
        }
        max = qi;
      } else if (qi > min) {
        for (int i = 0; i < m; i++) {
          if (qi > quality[i]) {
            insert(bedstSongs, quality, song.getKey(), qi, i);
            i = m;
          }
        }
        min = quality[quality.length-1];
      }
    }
    for (String song : bedstSongs) {
      System.out.println(song);
    }
  }
  public static void insert(String[] songs, double[] quality, String song, double qi, int insertionPoint) {
    String lastSong = song;
    double lastQuality = qi;
    for (int i = insertionPoint; i < songs.length; i++) {
      String currSong = songs[i];
      double currQuality = quality[i];

      songs[i] = lastSong;
      quality[i] = lastQuality;

      lastSong = currSong;
      lastQuality = currQuality;
    }
  }
}
