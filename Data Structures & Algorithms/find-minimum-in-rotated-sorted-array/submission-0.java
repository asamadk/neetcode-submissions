class Solution {
    public int findMin(int[] nums) {
        int l =0;
        int r = nums.length - 1;

        if (nums[l] < nums[r]) {
            return nums[l];
        }

        while (l < r) {
            if (nums[l+1] > nums[l]) {
                l++;
            } else {
                return nums[l+1];
            }

            if (nums[r-1] < nums[r]) {
                r--;
            } else {
                return nums[r];
            }
        }

        return Math.min(nums[r],nums[l]);
    }
}
