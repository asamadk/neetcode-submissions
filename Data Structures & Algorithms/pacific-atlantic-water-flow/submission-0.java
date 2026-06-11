class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROW = heights.length, COL = heights[0].length;
        boolean[][] pacificVisited = new boolean[ROW][COL];
        boolean[][] atlanticVisited = new boolean[ROW][COL];

        // Pacific queue
        Queue<int[]> pq = new LinkedList<>();
        for (int i=0;i<heights[0].length;i++) {
            pq.add(new int[]{0,i});
        }
        for (int i=1;i<heights.length;i++) {
            pq.add(new int[]{i,0});
        }

        bfs(heights, pq, pacificVisited);

        // Atlantic queue
        Queue<int[]> aq = new LinkedList<>();
        for (int i=0;i<heights.length;i++) {
            aq.add(new int[]{i,heights[i].length - 1});
        }
        for (int i=0;i<heights[0].length-1;i++) {
            aq.add(new int[]{heights.length-1,i});
        }

        bfs(heights, aq, atlanticVisited);

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<pacificVisited.length;i++) {
            for (int j=0;j<pacificVisited[i].length;j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);

                    result.add(tmp);
                }
            }
        }
        
        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> q, boolean[][] visited) {
        int ROW = heights.length, COL = heights[0].length;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            int currVal = heights[r][c];

            if (visited[r][c]) continue;
            visited[r][c] = true;

            if (r+1 < ROW && heights[r+1][c] >= currVal) {
                q.add(new int[]{r+1,c});
            }

            if (r-1 >= 0 && heights[r-1][c] >= currVal) {
                q.add(new int[]{r-1,c});
            }

            if (c+1 < COL && heights[r][c+1] >= currVal) {
                q.add(new int[]{r,c+1});
            }

            if (c-1 >= 0 && heights[r][c-1] >= currVal) {
                q.add(new int[]{r,c-1});
            }
        }
    }
}
