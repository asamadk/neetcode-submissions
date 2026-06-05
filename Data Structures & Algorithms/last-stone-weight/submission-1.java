class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        for (int i : stones) {
            q.add(i);
        }

        while(!q.isEmpty()) {
            int x = q.poll();
            if (q.isEmpty()) {
                return x;
            }
            int y = q.poll();
            if (x < y) {
                q.add(y-x);
            }
            if (y < x) {
                q.add(x-y);
            }
        }

        return !q.isEmpty() ? q.poll() : 0;
    }
}
