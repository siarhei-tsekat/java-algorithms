package design.LFU;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@Fork(value = 1, warmups = 2)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 1)
@Measurement(iterations = 3)
public class PeformanceTest {

//    @Benchmark
    public void addOne() {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
    }

//    @Benchmark
    public void addThree() {
        LFUCache cache = new LFUCache(200);

        for (int i = 0; i < 200; i++) {
            cache.put(i, i);
        }

        cache.put(1000, 1000);
        cache.put(200, 200);
        cache.put(300, 300);
        cache.put(3, 3);
        cache.get(1);
        cache.put(3, 3);
        cache.put(3, 3);
        cache.get(1);
        cache.put(3, 3);
        cache.put(3, 3);
        cache.put(3, 3);
        cache.get(2);
        cache.put(3, 3);
        cache.get(3);
        cache.get(3);


    }
}


