package array;

public class HeapUsingArray {
    private static final int DEFAULT_SIZE = 10;
    private int[] array = new int[DEFAULT_SIZE];
    private int size = 0;
    private int firstElement = DEFAULT_SIZE / 2;
    private int capacity = DEFAULT_SIZE;


    public HeapUsingArray() {
    }

    public HeapUsingArray(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
        this.firstElement = capacity / 2;
    }

    public void add(int element) {
        if (firstElement == 0) {
            rebuild();
        }
        findPlaceForNewElement(element);
    }

    private void findPlaceForNewElement(int element) {
        if (size == 0) {
            array[firstElement] = element;
            size++;
        } else if (element >= array[firstElement]) {
            array[--firstElement] = element;
            size++;
        } else {
            boolean inserted = false;
            for (int i = firstElement + 1, j = 1; j < size; i++, j++) {
                if (element >= array[i]) {
                    System.arraycopy(array, firstElement, array, firstElement - 1, i - firstElement);
                    array[i - 1] = element;
                    firstElement--;
                    inserted = true;
                    size++;
                    break;
                }
            }
            if (!inserted) {
                array[firstElement + size] = element;
                size++;
            }
        }
    }

    private void rebuild() {
        int[] ints = new int[capacity * 2];
        System.arraycopy(array, 0, ints, ints.length - array.length, array.length);
        array = ints;
        capacity = capacity * 2;
        firstElement = ints.length - array.length;
    }

    public int poll() {
        if (size == 0) {
            return -1;
        }
        int val = array[firstElement];
        array[firstElement] = 0;
        firstElement++;
        size--;
        return val;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = firstElement, j = 1; j <= size; i++, j++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }
}

class Main {
    public static void main(String[] args) {
        HeapUsingArray heapUsingArray = new HeapUsingArray();
        heapUsingArray.add(5);
        heapUsingArray.add(9);
        heapUsingArray.add(8);
        heapUsingArray.add(7);
        heapUsingArray.add(1);
        System.out.println(heapUsingArray);
        System.out.println(heapUsingArray.poll());
        System.out.println(heapUsingArray.poll());
        System.out.println(heapUsingArray.poll());
        System.out.println(heapUsingArray.poll());
        System.out.println(heapUsingArray.poll());
        System.out.println(heapUsingArray.poll());
        System.out.println(heapUsingArray.poll());
        System.out.println(heapUsingArray.poll());
        heapUsingArray.add(5);
        heapUsingArray.add(9);
        heapUsingArray.add(8);
        heapUsingArray.add(7);
        heapUsingArray.add(1);
        System.out.println("..."+heapUsingArray);

        System.out.println(heapUsingArray.poll());
        System.out.println(heapUsingArray.poll());
        System.out.println("..."+heapUsingArray);
        System.out.println(heapUsingArray.poll());
        System.out.println(heapUsingArray.poll());
        System.out.println(heapUsingArray.poll());
    }
}
