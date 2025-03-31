package Week10Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Flights {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = in.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        TreeMap<LocalTime, String> allFlights = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputs = in.readLine().split(" ");
            LocalTime key = LocalTime.parse(inputs[0]);
            allFlights.put(key, inputs[1]);
        }

        for (int i = 0; i < m; i++) {
            String[] inputs = in.readLine().split(" ");
            if (inputs[0].equals("cancel")) {
                LocalTime key = LocalTime.parse(inputs[1]);
                allFlights.remove(key);
            } else if (inputs[0].equals("delay")) {
                LocalTime key = LocalTime.parse(inputs[1]);
                String distination = allFlights.remove(key);
                key = key.plusSeconds(Long.parseLong(inputs[2]));
                allFlights.put(key, distination);
            } else if (inputs[0].equals("reroute")) {
                LocalTime key = LocalTime.parse(inputs[1]);
                allFlights.replace(key, inputs[2]);
            } else if (inputs[0].equals("destination")) {
                LocalTime key = LocalTime.parse(inputs[1]);
                String val = allFlights.get(key);
                if (val == null) System.out.println("-");
                else System.out.println(val);
            } else if (inputs[0].equals("next")) {
                LocalTime key = LocalTime.parse(inputs[1]);
                Map.Entry<LocalTime, String> next = allFlights.ceilingEntry(key);
                if (next == null) System.out.println("-");
                else System.out.println(next.getKey() + " " + next.getValue());
            } else if (inputs[0].equals("count")) {
                LocalTime fromKey = LocalTime.parse(inputs[1]);
                LocalTime toKey = LocalTime.parse(inputs[2]);
                NavigableMap<LocalTime, String> countMap = allFlights.subMap(fromKey.minusSeconds(1l), false, toKey.plusSeconds(1l), false);
                System.out.println(countMap.size());
            }
        }
    }
}
