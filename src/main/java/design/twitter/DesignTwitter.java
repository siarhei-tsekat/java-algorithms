package design.twitter;


import java.util.*;

import static design.twitter.Tests.*;

public class DesignTwitter {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
}

class UserMap {
    List<Tweet>[] offsets = new ArrayList[501];

    public void put(int userId, int tweetId) {
        get(userId).add(new Tweet(Twitter.count++, tweetId));
    }

    public List<Tweet> get(Integer user) {
        if(offsets[user]==null) offsets[user]= new ArrayList<>();
        return offsets[user];
    }
}

class FollowerMap {
    Set<Integer>[] folowers = new HashSet[501];

    public Set<Integer> get(int userId) {
        if (folowers[userId] == null) folowers[userId] =  new HashSet<>();
        return folowers[userId];
    }

    public int size() {
        return folowers.length;
    }
}

class Twitter {
    public static int count = 0;

    public Twitter() {
        count = 0;
    }

    UserMap usertweetMap = new UserMap();
    FollowerMap userFollowMap = new FollowerMap();

    public void postTweet(int userId, int tweetId) {
        usertweetMap.put(userId, tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>(userFollowMap.size(), (tw1, tw2) -> tw2.nano - tw1.nano);
        pq.addAll(usertweetMap.get(userId));

        for (Integer user : userFollowMap.get(userId)) {

            List<Tweet> tweetsInner = usertweetMap.get(user);

            for (int i = tweetsInner.size() - 1, j = 0; i >= 0 && j < 10; i--, j++) {
                pq.add(tweetsInner.get(i));
            }
        }

        return getRecent(pq);
    }

    private List<Integer> getRecent(PriorityQueue<Tweet> pq) {
        int limit = 10;
        List<Integer> res = new ArrayList<>();

        while (!pq.isEmpty() && limit-- > 0) {
            res.add(pq.poll().postid);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followeeId != followerId) userFollowMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId) userFollowMap.get(followerId).remove((Integer) followeeId);
    }

}

class Tweet {
    int nano = 0;
    int postid = 0;

    public Tweet(int nano, int postid) {
        this.postid = postid;
        this.nano = nano;
    }
}

class Tests {
    public static void test7() {
        Twitter twitter = new Twitter();

        Commands file = new Commands();
        List<List<Integer>> result = file.loadResult();
        List<String> commands = file.loadCommands();
        List<String> data = file.loadData();
        int[] item = new int[]{0};
        for (int i = 0; i < commands.size(); i++) {
            String comm = commands.get(i);
            String dat = data.get(i);
            runCommand(twitter, comm, dat, result, item);
        }
    }

    public static void test6() {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 4);
        assert Arrays.asList(4).equals(twitter.getNewsFeed(1));

        twitter.postTweet(2, 5);
        assert Arrays.asList(5).equals(twitter.getNewsFeed(2));

        twitter.unfollow(1, 2);
        assert Arrays.asList(4).equals(twitter.getNewsFeed(1));
    }

    public static void test5() {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 5);
        assert Arrays.asList(5).equals(twitter.getNewsFeed(1));

        twitter.unfollow(1, 1);
        assert Arrays.asList(5).equals(twitter.getNewsFeed(1));
    }

    public static void test4() {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 5);
        assert Arrays.asList(5).equals(twitter.getNewsFeed(1));

        twitter.follow(1, 1);
        assert Arrays.asList(5).equals(twitter.getNewsFeed(1));
    }

    public static void test3() {
        Twitter twitter = new Twitter();

        twitter.follow(1, 5);
        assert Arrays.asList().equals(twitter.getNewsFeed(1));
    }

    public static void test2() {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 1);
        assert Arrays.asList(1).equals(twitter.getNewsFeed(1));

        twitter.follow(2, 1);
        assert Arrays.asList(1).equals(twitter.getNewsFeed(2));

        twitter.unfollow(2, 1);
        assert Arrays.asList().equals(twitter.getNewsFeed(2));

    }

    public static void test1() {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 15);
        assert Arrays.asList(15).equals(twitter.getNewsFeed(1));

        twitter.postTweet(2, 26);
        assert Arrays.asList(26).equals(twitter.getNewsFeed(2));

        twitter.follow(1, 2);
        assert Arrays.asList(26, 15).equals(twitter.getNewsFeed(1));

        twitter.unfollow(1, 2);
        assert Arrays.asList(15).equals(twitter.getNewsFeed(1));
    }

    public static void runCommand(Twitter twitter, String comm, String dat, List<List<Integer>> result, int[] item) {
        switch (comm) {
            case "Twitter":
                break;
            case "postTweet":
                int[] postData = getPostData(dat);
                twitter.postTweet(postData[0], postData[1]);
                break;
            case "unfollow":
                int[] unfollowData = getUnfollowData(dat);
                twitter.unfollow(unfollowData[0], unfollowData[1]);
                break;
            case "follow":
                int[] followData = getFollowData(dat);
                twitter.follow(followData[0], followData[1]);
                break;
            case "getNewsFeed":
                List<Integer> list = result.get(item[0]++);
                List<Integer> newsFeed = twitter.getNewsFeed(getNewsFeedData(dat));
                if (!list.equals(newsFeed)) {
//                    List<Tweet> all = twitter.getAll(getNewsFeedData(dat));
//                    all.forEach(System.out::println);

                    System.out.print("result: " + list);
                    System.out.println("  === " + newsFeed);
                }

                break;
        }
    }

    public static int getNewsFeedData(String dat) {
        int second = Integer.parseInt(dat.substring(1, dat.length() - 1));
        return second;
    }

    public static int[] getFollowData(String dat) {
        int comma = dat.indexOf(",");
        int first = Integer.parseInt(dat.substring(1, comma));
        int second = Integer.parseInt(dat.substring(comma + 1, dat.length() - 1));
        return new int[]{first, second};
    }

    public static int[] getUnfollowData(String dat) {
        int comma = dat.indexOf(",");
        int first = Integer.parseInt(dat.substring(1, comma));
        int second = Integer.parseInt(dat.substring(comma + 1, dat.length() - 1));
        return new int[]{first, second};
    }

    public static int[] getPostData(String dat) {
        int comma = dat.indexOf(",");
        int first = Integer.parseInt(dat.substring(1, comma));
        int second = Integer.parseInt(dat.substring(comma + 1, dat.length() - 1));
        return new int[]{first, second};
    }
}
