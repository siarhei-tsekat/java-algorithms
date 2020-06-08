package queue;

public class MovingAverage {

    CircQueue circQueue;

    public MovingAverage(int size) {
        circQueue = new CircQueue(size);
    }

    public double next(int val) {
        circQueue.enQueue(val);
        return (double) circQueue.get() / circQueue.count;
    }
}

class CircQueue {
    int sum = 0;
    int[] arr;
    int capacity;
    int head;
    int count;

    public CircQueue(int k) {
        count = 0;
        capacity = k;
        head = 0;
        arr = new int[capacity];
    }

    public boolean enQueue(int value) {
        if (count == capacity)
            this.deQueue();
        arr[(head + count) % capacity] = value;
        sum += value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (count == 0)
            return false;
        sum -= arr[head];
        head = (head + 1) % capacity;
        count--;
        return true;
    }

    public int get() {
        return sum;
    }
}

class App {
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(15));
        System.out.println(movingAverage.next(15));
        System.out.println(movingAverage.next(15));
        System.out.println(movingAverage.next(10));
    }
}
