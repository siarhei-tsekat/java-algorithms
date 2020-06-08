package design;

import java.util.HashMap;

/***
 * Design a logger system that receive stream of messages along with its
 * timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
 *
 * Given a message and a timestamp (in seconds granularity),
 * return true if the message should be printed in the given timestamp, otherwise returns false.
 *
 * It is possible that several messages arrive roughly at the same time.
 */

public class LoggerRateLimiter {
    HashMap<String, Integer> map = new HashMap<>();

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp - map.getOrDefault(message, -10) >= 10) {
            map.put(message, timestamp);
            return true;
        } else return false;
    }
}

class LogRunner {
    public static void main(String[] args) {
        LoggerRateLimiter logger = new LoggerRateLimiter();
        System.out.println("true: " + logger.shouldPrintMessage(1, "foo"));
        System.out.println("true: " + logger.shouldPrintMessage(2, "bar"));
        System.out.println("false: " + logger.shouldPrintMessage(3, "foo"));
        System.out.println("false: " + logger.shouldPrintMessage(8, "bar"));
        System.out.println("false: " + logger.shouldPrintMessage(10, "foo"));
        System.out.println("true: " + logger.shouldPrintMessage(11, "foo"));
    }
}
