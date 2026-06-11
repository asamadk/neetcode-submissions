class Solution {
    public void solve(char[][] board) {
        int ROW = board.length, COL = board[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if ((i == 0 || i == ROW - 1 || j == 0 || j == COL - 1)
                    && board[i][j] == 'O') {
                    q.add(new int[] {i, j});
                    System.out.println(i + " " + j);
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (board[r][c] == 'E') continue;
            board[r][c] = 'E';

            if (r+1 < ROW && board[r+1][c] == 'O') {
                q.add(new int[]{r+1,c});
            }

            if (r-1 >= 0 && board[r-1][c] == 'O') {
                q.add(new int[]{r-1,c});
            }

            if (c+1 < COL && board[r][c+1] == 'O') {
                q.add(new int[]{r,c+1});
            }

            if (c-1 >= 0 && board[r][c-1] == 'O') {
                q.add(new int[]{r,c-1});
            }
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
