class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> resultSet = new HashSet<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++) {
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    resultSet.add(tmp);
                }

                if (sum > 0) {
                    right--;
                } else if (sum <= 0) {
                    left++;
                }
            }
        }

        return new ArrayList<>(resultSet);
    }
}
