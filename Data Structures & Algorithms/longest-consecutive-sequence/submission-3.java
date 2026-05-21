class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++) {
             set.add(nums[i]);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (Integer s: set) {
             heap.add(s);
        }

        if (heap.size() == 1) {
            return 1;
        }

        int maxResult = Integer.MIN_VALUE;
        int result = 0;
        int lastPoll = Integer.MIN_VALUE;
        while(heap.size() > 0) {
            Integer val = heap.poll();
            if (lastPoll == Integer.MIN_VALUE) {
                result++;
                lastPoll = val;
                continue;
            }
            if (val-lastPoll == 1) {
                result++;
            } else {
                result = 1;
            }

            lastPoll = val;

            if (result > maxResult) {
                maxResult = result;
            }
        }

        return maxResult;
    }
}
