class Solution {
    public int orangesRotting(int[][] grid) {
        int ROW = grid.length, COL = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;

        for (int i=0;i<ROW;i++) {
            for (int j=0;j<COL;j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
                if (grid[i][j] == 1) freshCount++;
            }
        }
        
        if (freshCount == 0) return 0;
        int minutes = bfs(grid, q);

        return isFreshLeft(grid) ? -1 : minutes;
    }

    private boolean isFreshLeft(int[][] grid) {
        int ROW = grid.length, COL = grid[0].length;
        for (int i=0;i<ROW;i++) {
            for (int j=0;j<COL;j++) {
                if (grid[i][j] == 1) return true;
            }
        }

        return false;
    }

    private int bfs(int[][] grid, Queue<int[]> q) {
        int count = 0;
        int ROW = grid.length, COL = grid[0].length;

        while(!q.isEmpty()) {
            int qSize = q.size();
            for (int i=0;i<qSize;i++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];

                String v = r+"_"+c;

                if (r+1 < ROW && grid[r+1][c] == 1) {
                    q.add(new int[]{r+1,c});
                    grid[r+1][c] = 2;
                }

                if (r-1 >= 0 && grid[r-1][c] == 1) {
                    q.add(new int[]{r-1,c});
                    grid[r-1][c] = 2;
                }

                if (c + 1 < COL && grid[r][c+1] == 1) {
                    q.add(new int[]{r,c+1});
                    grid[r][c+1] = 2;
                }

                if (c-1 >= 0 && grid[r][c-1] == 1) {
                    q.add(new int[]{r, c-1});
                    grid[r][c-1] = 2;
                }
            }

            count++;
        }

        return count - 1;
    }
}
