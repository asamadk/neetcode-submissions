class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Integer index = 0;

        Deque<Integer> deck = new ArrayDeque<>();

        for (int i=0;i<n;i++) {
            boolean isQEpty = deck.isEmpty();
            
            // Remove out of bound indice
            if (!isQEpty && deck.peekFirst() < i-k+1) {
                deck.pollFirst();
            }

            // Remove smaller indice
            while (!deck.isEmpty() && nums[deck.peekLast()] <= nums[i]) {
                deck.pollLast();
            }

            // Add current indice
            deck.offerLast(i);

            if (i >= k-1) {
                result[index] = nums[deck.peekFirst()];
                index++;
            }
        }

        return result;
    }
}
