class Solution {
    private int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        int ROW = grid.length, COL = grid[0].length;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] != INF) {
                    continue;
                }

                Queue<int[]> q = new LinkedList<>();
                q.add(new int[] {i, j});
                int count = 0;
                Set<String> visited = new HashSet<>();

                while (!q.isEmpty()) {
                    int size = q.size();
                    boolean exit = false;

                    for (int x = 0; x < size; x++) {
                        int[] cur = q.poll();
                        int r = cur[0], c = cur[1];

                        if (r < 0 || r >= ROW || c < 0 || c >= COL)
                            continue;

                        if (grid[r][c] == -1)
                            continue;

                        if (visited.contains(r + "_" + c))
                            continue;

                        visited.add(r + "_" + c);
                        if (grid[r][c] == 0) {
                            exit = true;
                            break;
                        }

                        q.add(new int[] {r + 1, c});
                        q.add(new int[] {r - 1, c});
                        q.add(new int[] {r, c + 1});
                        q.add(new int[] {r, c - 1});
                    }

                    if (exit) break;
                    count++;
                }

                grid[i][j] = count;
            }
        }
    }
}
