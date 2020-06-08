package design.multithreding;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TrafficLightControlledIntersection {
    ReentrantLock lock = new ReentrantLock();
    Condition roadOne = lock.newCondition();
    Condition roadTwo = lock.newCondition();
    public boolean oneGreen = true;

    public void carArrived(int carId, int roadId, int direction, Runnable turnGreen, Runnable crossCar) {

        try {
            lock.lock();
            if (roadId == 1) {
                if (oneGreen) {
                    crossCar.run();
                } else if (!lock.hasWaiters(roadTwo)) {
                    oneGreen = true;
                    turnGreen.run();
                    crossCar.run();
                } else {
                    roadTwo.signal();
                    roadOne.await();

                    turnGreen.run();
                    crossCar.run();
                }
            } else {
                if (!oneGreen) {
                    crossCar.run();
                } else if (!lock.hasWaiters(roadOne)) {
                    oneGreen = false;
                    turnGreen.run();
                    crossCar.run();
                } else {
                    roadOne.signal();
                    roadTwo.await();

                    turnGreen.run();
                    crossCar.run();
                }
            }
            lock.unlock();
        } catch (Exception e) { }
    }
}
