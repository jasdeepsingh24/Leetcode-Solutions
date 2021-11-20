/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */

// @lc code=start
class Twitter {

    List<tweet> tweets;
    HashMap<Integer, user> users;

    public Twitter() {
        tweets = new ArrayList<>();
        users = new HashMap<Integer, user>();
    }

    public void postTweet(int userId, int tweetId) {
        tweet t = new tweet(userId, tweetId);
        tweets.add(t);
    }

    public List<Integer> getNewsFeed(int userId) {
        int i = 0;
        List<Integer> feed = new ArrayList<>();
        // if(!users.containsKey(userId))
        // return feed;
        // HashSet<Integer> f=users.get(userId).followers;
        for (int j = tweets.size() - 1; j >= 0; j--) {
            if (i == 10)
                break;
            tweet t = tweets.get(j);
            if (t.userId == userId || (users.containsKey(userId) && users.get(userId).followers.contains(t.userId))) {
                feed.add(t.tweetId);
                i++;
            }

        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {

        if (users.containsKey(followerId)) {
            user u = users.get(followerId);
            u.followers.add(followeeId);
        } else {
            user u = new user();
            u.userId = followerId;
            u.followers = new HashSet<Integer>();
            u.followers.add(followeeId);
            users.put(u.userId, u);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId)) {
            user u = users.get(followerId);
            u.followers.remove(followeeId);
        }
    }

    class tweet {
        int userId;
        int tweetId;

        tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }

    class user {
        int userId;
        HashSet<Integer> followers;

    }
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end
