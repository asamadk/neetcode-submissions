class Solution {
    int target;
    int[] nums;
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        this.result = new ArrayList<>();

        List<Integer> cur = new ArrayList<>();
        dfs(0, cur, 0);

        return this.result;
    }

    private void dfs(int i, List<Integer> cur, int total) {
        if (total == this.target) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if (i >= this.nums.length || total > this.target) return;

        cur.add(this.nums[i]);
        dfs(i, cur, total + this.nums[i]);

        cur.remove(cur.size() - 1);
        dfs(i+1, cur, total);
    }
}
