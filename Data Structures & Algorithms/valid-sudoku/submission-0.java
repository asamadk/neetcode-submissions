class Solution {
    public boolean isValidSudoku(char[][] board) {
        Boolean validRow = isValidRow(board);
        if (!validRow) {return validRow;}
        
        Boolean validCol = isValidColumn(board);
        if (!validCol) {return validCol;}
        
        Boolean validSubBox = isValidSub(board);
        if (!validSubBox) {return validSubBox;}

        return true;
    }

    private boolean isValidSub(char[][] board) {
        // Iterating main board by skipping 3
        for (int boxRow=0;boxRow<9;boxRow+=3) {
            for (int boxCol=0;boxCol<9;boxCol+=3) {
                
                HashSet<Integer> set = new HashSet<>();
                // Iterating sub box
                for (int row=0;row<3;row++) {
                    for (int col=0;col <3;col++) {

                        char cell = board[boxRow + row][boxCol + col];

                        if (cell == '.') {
                            continue;
                        }

                        int count = cell - '0';
                        if (set.contains(count)) {
                            return false;
                        }
                        set.add(count);
                    }
                }

            }
        }

        return true;
    }

    private boolean isValidColumn(char[][] board) {
        for (int col=0;col<9;col++) {
            Integer[] freq = new Integer[10];
            HashSet<Integer> set = new HashSet<>();
            for (int row=0;row<9;row++) {
                if (board[row][col] == '.') {
                    continue;
                }
                int count = board[row][col] - '0';
                if (set.contains(count)) {
                    return false;
                }
                set.add(count);
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] board) {
        for (int i=0;i<board.length;i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j=0;j<board[i].length;j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int count = board[i][j] - '0';
                if (set.contains(count)) {
                    return false;
                }
                set.add(count);
            }
        }

        return true;
    }
}
