package design.undergroundsystem;

import design.Pair;

import java.util.HashMap;

/**
 * Implement the class UndergroundSystem that supports three methods:
 * <p>
 * 1. checkIn(int id, string stationName, int t)
 * <p>
 * A customer with id card equal to id, gets in the station stationName at time t.
 * A customer can only be checked into one place at a time.
 * 2. checkOut(int id, string stationName, int t)
 * <p>
 * A customer with id card equal to id, gets out from the station stationName at time t.
 * 3. getAverageTime(string startStation, string endStation)
 * <p>
 * Returns the average time to travel between the startStation and the endStation.
 * The average time is computed from all the previous traveling from startStation to endStation that happened directly.
 * Call to getAverageTime is always valid.
 * You can assume all calls to checkIn and checkOut methods are consistent.
 * That is, if a customer gets in at time t1 at some station, then it gets out at time t2 with t2 > t1.
 * All events happen in chronological order.
 */

class Runner {
    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();

        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);

        assert undergroundSystem.getAverageTime("Paradise", "Cambridge") == 14.00;
        assert undergroundSystem.getAverageTime("Leyton", "Waterloo") == 11.00;

        undergroundSystem.checkIn(10, "Leyton", 24);
        assert undergroundSystem.getAverageTime("Leyton", "Waterloo") == 11.00;

        undergroundSystem.checkOut(10, "Waterloo", 38);
        assert undergroundSystem.getAverageTime("Leyton", "Waterloo") == 12.00;

    }
}

public class UndergroundSystem {

    HashMap<Integer, Pair<String, Integer>> mapTimeIn = new HashMap<>();
    HashMap<String, HashMap<String, int[]>> map = new HashMap<>();

    public void checkIn(int id, String stationName, int t) {
        mapTimeIn.put(id, new Pair<String, Integer>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> timeIn = mapTimeIn.get(id);

        HashMap<String, int[]> hashMap = map.getOrDefault(timeIn.getKey(), new HashMap<String, int[]>());
        int[] pair = hashMap.getOrDefault(stationName, new int[2]);
        pair[0] += t - timeIn.getValue();
        pair[1]++;
        hashMap.put(stationName, pair);
        map.put(timeIn.getKey(), hashMap);
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] pair = this.map.get(startStation).get(endStation);
        double summ = pair[0];
        double amount = pair[1];
        return summ / amount;
    }
}


