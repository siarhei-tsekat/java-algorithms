package design;

import javafx.util.Pair;

import java.util.*;

public class LogSystem {
    Map<String, Map<Integer, List<Pair<Integer, String>>>> map = new HashMap<>();

    public LogSystem() {
        map.put("Year", new HashMap<>());
        map.put("Month", new HashMap<>());
        map.put("Day", new HashMap<>());
        map.put("Hour", new HashMap<>());
        map.put("Minute", new HashMap<>());
        map.put("Second", new HashMap<>());
    }

    public void put(int id, String timestamp) {

        putIn(map.get("Year"), id, timestamp, 4);
        putIn(map.get("Month"), id, timestamp, 7);
        putIn(map.get("Day"), id, timestamp, 10);
        putIn(map.get("Hour"), id, timestamp, 13);
        putIn(map.get("Minute"), id, timestamp, 16);
        putIn(map.get("Second"), id, timestamp, 19);
    }

    private void putIn(Map<Integer, List<Pair<Integer, String>>> innerMap, int id, String timestamp, int endIndex) {
        String year = timestamp.substring(0, 4);
        int intYear = Integer.parseInt(year);

        List<Pair<Integer, String>> pairList = innerMap.getOrDefault(intYear, new ArrayList<>());
        pairList.add(new Pair<>(id, timestamp.substring(0, endIndex)));
        innerMap.put(intYear, pairList);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        int x = 0;
        switch (gra) {
            case "Year":
                x = 4;
                break;
            case "Month":
                x = 7;
                break;
            case "Day":
                x = 10;
                break;
            case "Hour":
                x = 13;
                break;
            case "Minute":
                x = 16;
                break;
            case "Second":
                x = 19;
                break;
        }
        s = s.substring(0, x);
        e = e.substring(0, x);
        List<Integer> ans = new ArrayList<>();

        for (Pair<Integer, String> pair : getAllBetween(s.substring(0,4), e.substring(0,4), gra)) {
            String ss = pair.getValue();
            if (ss.compareTo(s) >= 0 && ss.compareTo(e) <= 0) ans.add(pair.getKey());
        }
        return ans;
    }

    private List<Pair<Integer, String>> getAllBetween(String s, String e, String gra) {
        int startInt =Integer.valueOf(s);
        int endInt =Integer.valueOf(e);
        Map<Integer, List<Pair<Integer, String>>> listMap = map.get(gra);
        List<Pair<Integer, String>> res  = new ArrayList<>();

        for (int i = startInt; i <=endInt; i++) {
            res.addAll(listMap.getOrDefault(i, Collections.emptyList()));
        }
        return res;
    }
}

class Run_ner {
    public static void main(String[] args) {
        test2();

    }

    private static void test2() {
        LogSystem logSystem = new LogSystem();
        logSystem.put(1, "2005:01:05:22:16:15");
        logSystem.put(2, "2003:12:12:20:30:51");
        logSystem.put(3, "2001:06:25:23:51:23");
        logSystem.put(4, "2004:10:25:13:49:48");
        logSystem.put(5, "2002:05:03:14:21:45");
        logSystem.put(6, "2004:10:04:21:49:49");
        logSystem.put(7, "2006:05:14:18:30:30");
        logSystem.put(8, "2003:04:02:22:12:41");
        logSystem.put(9, "2002:02:25:13:12:24");
        logSystem.put(10, "2005:01:17:23:36:39");
        logSystem.put(11, "2000:07:25:12:45:16");
        logSystem.put(12, "2001:08:12:16:35:55");
        logSystem.put(13, "2000:10:18:18:46:38");
        logSystem.put(14, "2000:08:07:16:15:34");
        logSystem.put(15, "2002:10:08:18:39:59");
        logSystem.put(16, "2001:12:13:15:17:44");
        logSystem.put(17, "2001:02:28:23:45:56");
        logSystem.put(18, "2007:10:08:23:17:56");
        logSystem.put(19, "2003:08:01:16:32:13");
        logSystem.put(20, "2000:03:08:13:35:49");
        logSystem.put(21, "2006:04:23:20:47:30");

        List<Integer> year = logSystem.retrieve("2003:03:28:18:45:21", "2005:09:12:17:33:45", "Month");
        System.out.println("[1, 2, 4, 6, 8, 10, 19] -> " + year);
    }

    private static void test1() {
        LogSystem logSystem = new LogSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:01:22:59:59");
        logSystem.put(3, "2016:01:01:00:00:00");

        List<Integer> year = logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year");
        System.out.println("[1,2,3] -> " + year);
        List<Integer> hour = logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour");
        System.out.println("[1,2] -> " + hour);
    }
}
