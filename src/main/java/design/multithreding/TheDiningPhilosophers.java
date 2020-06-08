package design.multithreding;

import java.util.HashMap;

public class TheDiningPhilosophers {
}

class DiningPhilosophers {
    public static int BUSY = 1;
    public static int NOT_BUSY = 0;

    Object waitForFork = new Object();
    HashMap<Integer, W> map = new HashMap<>();

    public void wantsToEat(int man, Runnable pickLeftF, Runnable pickRightF, Runnable eat, Runnable putLeftF, Runnable putRightF) throws InterruptedException {
        synchronized (waitForFork) {

            while (leftForkIsBusy(getLeftNeigh(man))) waitForFork.wait();
            pickLeftF.run();
            map.merge(man, new W(BUSY, NOT_BUSY), (oldV, newW) -> { oldV.leftFork = BUSY;return oldV; });
            while (rightForkIsBusy(getRightNeigh(man))) waitForFork.wait();
            pickRightF.run();
            map.get(man).rightFork = BUSY;
            eat.run();
            putLeftF.run();
            putRightF.run();
            map.put(man, W.empty());
            waitForFork.notify();
        }
    }

    private boolean rightForkIsBusy(int rightNeigh) {
        if (!map.containsKey(rightNeigh)) return false;
        return map.get(rightNeigh).rightFork == BUSY;
    }

    private boolean leftForkIsBusy(int leftNeigh) {
        if (!map.containsKey(leftNeigh)) return false;
        return map.get(leftNeigh).leftFork == BUSY;
    }

    private int getRightNeigh(int man) {
        return man == 0 ? 4 : man - 1;
    }

    private int getLeftNeigh(int man) {
        return man == 4 ? 0 : man + 1;
    }
}

class W {

    public int leftFork = DiningPhilosophers.NOT_BUSY;
    public int rightFork = DiningPhilosophers.NOT_BUSY;

    public W(int left, int right) {
        leftFork = left;
        rightFork = right;
    }

    public static W empty() {
        return new W(DiningPhilosophers.NOT_BUSY, DiningPhilosophers.NOT_BUSY);
    }
}