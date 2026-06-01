class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m+1;
            } else {
                r = m;
            }
        }

        int mid = l;
        int res = binarySearch(0,mid-1, target,nums);
        if (res != -1) {
            return res;
        }

        res = binarySearch(mid, nums.length-1,target,nums);
        return res;
    }

    public int binarySearch(int left, int right, int target, int[] nums) {
        while ( left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
