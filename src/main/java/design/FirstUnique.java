package design;

import java.util.BitSet;
import java.util.HashMap;

/***
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 *
 * Implement the FirstUnique class:
 *
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
 * void add(int value) insert value to the queue.
 *
 */

class App {
    public static void main(String[] args) {
        int[] var = {2, 3, 5};
        FirstUnique firstUnique = new FirstUnique(var);
        System.out.println("expected: 2. Actual: " + firstUnique.showFirstUnique());
        firstUnique.add(2);
        System.out.println("expected: 3. Actual: " + firstUnique.showFirstUnique());
        firstUnique.add(3);
        System.out.println("expected: 5. Actual: " + firstUnique.showFirstUnique());
        firstUnique.add(3);
        System.out.println("expected: 5. Actual: " + firstUnique.showFirstUnique());
        firstUnique.add(5);
        System.out.println("expected: -1. Actual: " + firstUnique.showFirstUnique());
    }
}

class FirstUnique {
    public static final int NOT_UNIQUE = 2;
    public static final int BAD_RESPONSE = -1;
    public static final int UNIQUE = 1;
    LinkedHashedList uniqueQueue = new LinkedHashedList();
    HashedSetStorage set = new HashedSetStorage();

    public FirstUnique(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (set.add(arr[i]) == NOT_UNIQUE) {
                uniqueQueue.remove(arr[i]);
            } else {
                uniqueQueue.add(arr[i]);
            }
        }
    }

    public int showFirstUnique() {
        return uniqueQueue.isEmpty() ? BAD_RESPONSE : uniqueQueue.peek();
    }

    public void add(int value) {
        if (set.add(value) == NOT_UNIQUE) {
            uniqueQueue.remove(value);
        } else {
            uniqueQueue.add(value);
        }
    }
}

class LinkedHashedList {
    HashMap<Integer, LinkedNode> map = new HashMap<>();

    private LinkedNode last;
    private LinkedNode first;
    private int size;

    public void remove(int integer) {
        if (isEmpty() || !map.containsKey(integer)) return;
        LinkedNode x = map.get(integer);

        final int element = x.item;
        final LinkedNode next = x.next;
        final LinkedNode prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        map.remove(integer);
        size--;
    }

    public void add(int i) {
        final LinkedNode l = last;
        final LinkedNode newNode = new LinkedNode(l, i, null);
        map.put(i, newNode);
        last = newNode;
        if (l == null) first = newNode;
        else l.next = newNode;

        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        return first.item;
    }
}

class LinkedNode {
    int item;
    LinkedNode next;
    LinkedNode prev;

    LinkedNode(LinkedNode prev, int element, LinkedNode next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}

class HashedSetStorage {
    BitSet set1 = new BitSet();
    BitSet set2 = new BitSet();

    public int add(int value) {
        if (set1.get(value)) {
            set2.set(value);
            return FirstUnique.NOT_UNIQUE;
        } else set1.set(value);
        return FirstUnique.UNIQUE;
    }
}