class Solution {
    int max;
    int count;

    public int maxAreaOfIsland(int[][] grid) {
        this.max = 0;
        int row = grid.length, col = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                this.count = 0;
                dfs(grid, i, j);
                max = Math.max(max, count);
            }
        }

        return max;
    }

    private void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        if (grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;
        this.count++;

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
