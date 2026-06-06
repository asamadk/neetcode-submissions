class Solution {
    List<List<Integer>> result;
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        this.nums = nums;
        List<Integer> current = new ArrayList<>();
        backtrack(0, current);
        return result;
    }

    private void backtrack(int index, List<Integer> current) {
        if (index == this.nums.length) {
            this.result.add(new ArrayList<>(current));
            return;
        }

        current.add(this.nums[index]);
        backtrack(index+1, current);

        current.remove(current.size() - 1);
        backtrack(index+1, current);
    }
}
