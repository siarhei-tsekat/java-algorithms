package design.multithreding;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BuildingH2O {
}

class H2O {

    ReentrantLock lock = new ReentrantLock();
    Condition ox = lock.newCondition();
    Condition hx = lock.newCondition();
    int hPrinted = 0;

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();

        while(hPrinted >= 2) hx.await();

        releaseHydrogen.run();

        hPrinted++;

        ox.signal();

        lock.unlock();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        lock.lock();

        while(hPrinted < 2) ox.await();

        releaseOxygen.run();

        hPrinted = 0;
        hx.signal();

        lock.unlock();
    }
}
