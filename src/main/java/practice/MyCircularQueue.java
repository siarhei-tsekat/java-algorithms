package practice;

public class MyCircularQueue {

    public MyCircularQueue(int k) {

    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {

        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {

        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return 0;
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        return 0;
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        return "";
    }
}

class Mainn {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(15);
        myCircularQueue.enQueue(15);
        myCircularQueue.enQueue(15);
        System.out.println("Expected: 15. Actual: " + myCircularQueue.Front());
        System.out.println("Expected: [15,15,15]. Actual: " + myCircularQueue);
        myCircularQueue.deQueue();
        System.out.println("Expected: 15. Actual: " + myCircularQueue.Front());
        System.out.println("Expected: [15,15]. Actual: " + myCircularQueue);
        myCircularQueue.enQueue(10);
        System.out.println("Expected: 10. Actual: " + myCircularQueue.Rear());
        System.out.println("Expected: [15,15,10]. Actual: " + myCircularQueue);

    }
}

