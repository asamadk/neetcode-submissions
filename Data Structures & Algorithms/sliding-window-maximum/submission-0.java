class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> resultList = new ArrayList<>();

        for (int i=0;i<=nums.length - k;i++) {
            int max = Integer.MIN_VALUE;
            for (int j=i;j<(i + k);j++) {
                if (max < nums[j]) {
                    max = nums[j];
                }
            }
            resultList.add(max);
        }

        int[] result = new int[resultList.size()];
        for (int i=0;i<resultList.size();i++){
            result[i] = resultList.get(i);
        }

        return result;
    }
}
