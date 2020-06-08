package design.LFU;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests {

    @Test
    public void test() {
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        Assert.assertEquals(cache.get(1), 1);

        cache.put(3, 3);

        Assert.assertEquals(cache.get(2), -1);
        Assert.assertEquals(cache.get(3), 3);

        cache.put(4, 4);

        Assert.assertEquals(cache.get(1), -1);
        Assert.assertEquals(cache.get(3), 3);
        Assert.assertEquals(cache.get(4), 4);
    }

    @Test
    public void test2() {
        LFUCache cache = new LFUCache(2);

        cache.put(3, 1);
        cache.put(2, 1);
        cache.put(2, 2);
        cache.put(4, 4);

        Assert.assertEquals(cache.get(2), 2);
    }

    @Test
    public void test3() {
        LFUCache cache = new LFUCache(2);

        cache.put(2, 1);
        cache.put(1, 1);

        Assert.assertEquals(cache.get(2), 1);
        cache.put(4, 1);
        Assert.assertEquals(cache.get(1), -1);
        Assert.assertEquals(cache.get(2), 1);
    }

    @Test
    public void test4() {
        LFUCache cache = new LFUCache(2);

        Assert.assertEquals(cache.get(2), -1);
        cache.put(2, 6);
        Assert.assertEquals(cache.get(1), -1);

        cache.put(1, 5);
        cache.put(1, 2);

        Assert.assertEquals(cache.get(1), 2);
        Assert.assertEquals(cache.get(2), 6);
    }
}
