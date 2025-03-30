package MakeUps.ProblemIThroughTheGrapevine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class ThroughTheGrapevine {

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int n, m, d;
    String[] nmd = in.readLine().split(" ");
    n = Integer.parseInt(nmd[0]);
    m = Integer.parseInt(nmd[1]);
    d = Integer.parseInt(nmd[2]);
    double start = System.currentTimeMillis()*100d;

    Map<String, Edge> grapevine = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String[] inputs = in.readLine().split(" ");
      Edge edge = new Edge(Integer.parseInt(inputs[1]));
      grapevine.put(inputs[0], edge);
    }
    for (int j = 0; j < m; j++) {
      String[] inputs = in.readLine().split(" ");
      grapevine.get(inputs[0]).addFriend(inputs[1]);
      grapevine.get(inputs[1]).addFriend(inputs[0]);
    }
    String first = in.readLine();
    int heardRomour = 0;

    for (int i = 0; i < d; i++) {
      List<Edge> newConvertedList = new LinkedList<>();
      Iterator it = grapevine.entrySet().iterator();
      while (it.hasNext()) {
        Map.Entry<String, Edge> entry = (Map.Entry<String, Edge>)it.next();
        if (entry.getValue().getSkeptism() <= 0) {
          if (!entry.getValue().hasSpreed() && !entry.getValue().getNewConverted()) {
            entry.getValue().setSpreed(true);
            for (String f : entry.getValue().getFriends()) {
              if (!grapevine.containsKey(f)) continue;
              heardRomour = grapevine.get(f).heardRomour(heardRomour);
              if (grapevine.get(f).getNewConverted()) newConvertedList.add(grapevine.get(f)); 
            }
            it.remove();
          }
        }
      }
      newConvertedList.forEach((converted) -> {
        converted.resetConverted();
      });
    }

    System.out.println(heardRomour);
    
    System.out.println(start - System.currentTimeMillis()*100d);
  }
}

class Edge {

  private int skeptism;
  List<String> know;
  boolean hasHeardRomour;
  boolean spreed;
  boolean newConverted;

  public Edge(int skeptism) {
    this.skeptism = skeptism;
    this.know = new LinkedList<>();
    this.spreed = false;
    this.hasHeardRomour = false;
    this.newConverted = false;
    if (this.skeptism == 0) this.hasHeardRomour = true;
  }
  
  public void addFriend(String friend) {
    this.know.add(friend);
  } 

  public int heardRomour(int heard) {
    int returnval = heard;
    if (!this.hasHeardRomour) returnval++;
    this.hasHeardRomour = true;
    this.skeptism--;
    if (this.skeptism == 0) this.newConverted = true;
    return returnval;
  }

  public void setSpreed(boolean spreed) {
    this.spreed = spreed;
  }

  public void resetConverted() {
    this.newConverted = false;
  }

  public boolean getNewConverted() {
    return this.newConverted;
  }
  public boolean getHasHeardRomour() {
    return this.hasHeardRomour;
  }
  public boolean hasSpreed() {
    return this.spreed;
  }
  public int getSkeptism() {
    return this.skeptism;
  }
  public List<String> getFriends() {
    return this.know;
  }
}
