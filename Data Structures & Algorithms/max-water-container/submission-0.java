class Solution {
    public int maxArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = heights.length - 1;
        while (i < j) {
            int total = area(heights, i, j);
            if (total > max) {
                max = total;
            }

            if (heights[i] <= heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    private int area(int[] heights, int i, int j){
        int minHeight = Math.min(heights[i],heights[j]);
        return minHeight * (j-i);
    }
}
