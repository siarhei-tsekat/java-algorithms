package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/***
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 *
 * Each function accepts a timestamp parameter (in seconds granularity)
 * and you may assume that calls are being made to the system in chronological order
 * (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
 *
 * It is possible that several hits arrive roughly at the same time.
 */

class HitCounter {

    HashMap<Range, List<Integer>> map = new HashMap<>();

    public void hit(int timestamp) {
        Range key = new Range(timestamp);
        List<Integer> list = map.getOrDefault(key, new ArrayList<>());
        list.add(timestamp);
        map.put(key, list);
    }

    public int getHits(int time) {
        int res = 0;
        List<Integer> list = map.getOrDefault(new Range(time), new ArrayList<>());

        for (Integer integer : list) {
            if (integer <= time) res++;
        }
        List<Integer> list1 = map.getOrDefault(new Range(time - 300), new ArrayList<>());

        if (list == list1) return res;

        for (Integer integer : list1) {
            if (integer > time - 300) res++;
        }

        return res;
    }

    private class Range {
        int start = 0;
        int end = 300;
        private int time;

        public Range(int time) {
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            Range range = (Range) o;
            return start == range.start && end == range.end;
        }

        @Override
        public int hashCode() {
            int i = this.time / 300;
            i++;
            end = i * 300;
            start = end - 300;
            return Objects.hash(start, end);
        }
    }
}


class Runn_er {
    public static void main(String[] args) {
        HitCounter counter = new HitCounter();

        counter.hit(1);
        counter.hit(2);
        counter.hit(3);

        System.out.println("3 == " + counter.getHits(4));
        counter.hit(300);
        System.out.println("4 == " + counter.getHits(300));
        System.out.println("3 == " + counter.getHits(301));
    }
}
