package design.shortestRemainingProcessingTime;

import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task implements Comparable<Task>, Runnable {
    private int id;
    private int time;

    public Task(int id, int time) {
        this.id = id;
        this.time = time;
    }

    public void run() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }

        System.out.print(Thread.currentThread().getName() + " === ");
        System.out.println(id + ": performed");
    }

    @Override
    public int compareTo(Task that) {
        return Integer.compare(that.time, this.time);
    }
}

class Processor {

    PriorityQueue<Task> queue = new PriorityQueue<>();
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

    public void consume(Task task) {
        queue.add(task);
        executor.submit(queue.poll());
    }

    public void end() {
        executor.shutdown();
    }
}

class Runner {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.consume(new Task(1, 5000));
        processor.consume(new Task(2, 2000));
        processor.consume(new Task(3, 3000));
        processor.end();
    }
}


