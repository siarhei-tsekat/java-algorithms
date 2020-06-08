package array;

public class DietPlanPerformance {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        Calculator calc = new Calculator(k, lower, upper);
        for (int i = 0; i < calories.length; i++) {
            calc.calculate(calories[i]);
        }
        return calc.getRes();
    }
}

class Calculator {
    int capacity;
    int lower;
    int upper;

    int[] array;
    int first = 0;
    int summ = 0;
    int total = 0;
    int size = 0;

    Calculator(int capacity, int lower, int upper) {
        this.capacity = capacity;
        this.lower = lower;
        this.upper = upper;
        array = new int[capacity];
    }

    public void calculate(int value) {
        if (size + 1 < capacity) {
            enQueue(value);
        } else if (size + 1 == capacity) {
            enQueue(value);
            cacl();
            deQueue();
        }

    }

    public void cacl() {
        if (summ < lower) total--;
        if (summ > upper) total++;
    }

    public void enQueue(int value) {
        summ += value;
        array[(first + size) % capacity] = value;
        size++;
    }

    public void deQueue() {
        summ -= array[first];
        first = (first + 1) % capacity;
        size--;
    }

    public int getRes() {
        return total;
    }
}
