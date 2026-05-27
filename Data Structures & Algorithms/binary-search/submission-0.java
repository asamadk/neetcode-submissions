class Solution {
    public int search(int[] nums, int target) {
        return binary_search(0, nums.length - 1, nums, target);
    }

    private int binary_search(int l, int r, int[] nums, int target) {
        if (l > r) return -1;
        int pivot = l + (r - l) / 2;

        if (nums[pivot] == target) return pivot;

        return nums[pivot] < target ? binary_search(pivot + 1, r, nums, target)
                                    : binary_search(l, pivot - 1, nums, target);
    }
}
