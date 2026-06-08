class Solution {
    class Pair {
        Integer first;
        Integer second;

        Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int max = 0;

        int row = grid.length, col = grid[0].length;

        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == 0) continue;
                int count = 0;
                grid[i][j] = 0;
                q.add(new Pair(i,j));

                while(!q.isEmpty()) {
                    Pair p = q.poll();
                    count++;

                    int r = p.first, c=p.second;
                    if (r+1 < row && grid[r+1][c] == 1) {
                        grid[r+1][c] = 0;
                        q.add(new Pair(r+1, c));
                    }

                    if (r-1 >= 0 && grid[r-1][c] == 1) {
                        grid[r-1][c] = 0;
                        q.add(new Pair(r-1,c));
                    }

                    if (c+1 < col && grid[r][c+1] == 1){
                        grid[r][c+1] = 0;
                        q.add(new Pair(r,c+1));
                    }

                    if (c-1 >= 0 && grid[r][c-1] == 1){
                        grid[r][c-1] = 0;
                        q.add(new Pair(r,c-1));
                    }
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}
