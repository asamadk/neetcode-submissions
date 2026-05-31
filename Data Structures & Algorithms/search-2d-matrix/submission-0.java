class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i=0;i<matrix.length;i++) {
            boolean found = searchRow(
                0, matrix[i].length - 1, target, matrix[i]
            );
            if (found) {
                return true;
            }
        }

        return false;
    }

    private boolean searchRow(int l, int r, int target, int[] row) {
        if (l > r) return false;

        int m = l + (r - l) / 2;
        if (row[m] == target) {
            return true;
        }

        return row[m] < target ? 
            searchRow(m+1,r,target,row) : 
            searchRow(l, m-1,target,row);
    }
}
