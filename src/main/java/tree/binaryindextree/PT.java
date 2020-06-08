package tree.binaryindextree;

import org.openjdk.jmh.annotations.*;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

@Fork(value = 1, warmups = 2)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 1)
@Measurement(iterations = 3)
public class PT {

    @Benchmark
    public void sumOfTree() {
        int[] nums = {1, 3, 5};
        NumArray numArray = new NumArray(nums);

        Assert.assertEquals(numArray.sumRange(0, 2), 9);

        numArray.update(1, 2);
        Assert.assertEquals(numArray.sumRange(0, 2), 8);
    }
}

class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}
