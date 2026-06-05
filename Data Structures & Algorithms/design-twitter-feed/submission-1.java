class Twitter {

    class Pair {
        int time;
        int tweetId;

        Pair(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }
    }

    Integer time;
    Map<Integer, List<Pair>> tweets;
    Map<Integer, Set<Integer>> follows;

    public Twitter() {
        this.time = 0;
        this.tweets = new HashMap<>();
        this.follows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        this.tweets.putIfAbsent(userId, new ArrayList<>());
        this.tweets.get(userId).add(new Pair(this.time, tweetId));
        this.time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Pair> feed = new ArrayList<>(
            this.tweets.getOrDefault(userId, new ArrayList<>())
        );
        Set<Integer> ids = this.follows.getOrDefault(userId, new HashSet<>());
        for (Integer id: ids) {
            feed.addAll(
                this.tweets.getOrDefault(id, new ArrayList<>())
            );
        }

        feed.sort((a,b) -> Integer.compare(b.time, a.time));
        List<Integer> res = new ArrayList<>();

        for (int i=0;i<Math.min(10,feed.size());i++) {
            res.add(feed.get(i).tweetId);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            this.follows.putIfAbsent(followerId, new HashSet<>());
            this.follows.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        this.follows.getOrDefault(followerId, new HashSet<>())
            .remove(followeeId);
    }
}
