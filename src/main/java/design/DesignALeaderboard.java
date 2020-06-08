package design;

import java.util.HashMap;
import java.util.Map;

public class DesignALeaderboard {
    public static void main(String[] args) {
        test1();

    }

    private static void test1() {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.addScore(1, 73);   // leaderboard = [[1,73]];
        leaderboard.addScore(2, 56);   // leaderboard = [[1,73],[2,56]];
        leaderboard.addScore(3, 39);   // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard.addScore(4, 51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard.addScore(5, 4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
        System.out.println("73 => " + leaderboard.top(1));           // returns 73;
        leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
        leaderboard.addScore(2, 51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
        System.out.println("141 => " + leaderboard.top(3));
        ;           // returns 141 = 51 + 51 + 39;
    }
}


class Leaderboard {
    Map<Integer, Integer> map;
    int[] queue;

    public Leaderboard() {
        map = new HashMap();
        queue = new int[351];
    }

    public void addScore(int playerId, int score) {
        if (map.containsKey(playerId)) {
            Integer oldScore = map.get(playerId);
            queue[oldScore]--;
            oldScore += score;
            queue[oldScore]++;
            map.put(playerId, oldScore);
        } else {
            map.put(playerId, score);
            queue[score]++;
        }
    }

    public int top(int K) {
        int sum = 0;
        for (int i = 350; i >= 0; i--) {
            if (queue[i] == 0) continue;

            if (K >= queue[i]) {
                sum += queue[i] * i;
                K-=queue[i];
            }else {
                sum += K * i;
                K-= queue[i];
            }

            if (K <=0) break;
        }
        return sum;
    }

    public void reset(int playerId) {
        Integer score = map.remove(playerId);
        queue[score]--;
    }
}
