class Solution {
    public void solve(char[][] board) {
        int ROW = board.length, COL = board[0].length;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if ((i == 0 || i == ROW - 1 || j == 0 || j == COL - 1) && board[i][j] == 'O') {
                    // RUN DFS
                    dfs(board, i, j);
                }
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

    private void dfs(char[][] board, int row, int col) {
        int ROW = board.length, COL = board[0].length;

        // Gurad rails
        if (row < 0 || row >= ROW || col < 0 || col >= COL)
            return;

        board[row][col] = 'E';

        if (row+1 < ROW && board[row + 1][col] == 'O') {
            dfs(board, row + 1, col);
        }

        if (row-1 >= 0 && board[row - 1][col] == 'O') {
            dfs(board, row - 1, col);
        }

        if (col+1 < COL && board[row][col + 1] == 'O') {
            dfs(board, row, col + 1);
        }

        if (col-1 >= 0 && board[row][col - 1] == 'O') {
            dfs(board, row, col - 1);
        }
    }
}
