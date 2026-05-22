class Solution {
    public int trap(int[] height) {
        Integer[] leftMax = new Integer[height.length];
        Integer[] rightMax = new Integer[height.length];

        int maxCount = 0;
        for (int i=0;i<height.length;i++) {
            leftMax[i] = maxCount;
            if (height[i] > maxCount) {
                maxCount = height[i];
            }
        }

        maxCount = 0;
        for (int i=height.length-1;i>=0;i--) {
            rightMax[i] = maxCount;
            if (height[i] > maxCount) {
                maxCount = height[i];
            }
        }

        int result = 0;
        for (int i=0;i<height.length;i++) {
            int minVal = Math.min(leftMax[i],rightMax[i]);
            int count = minVal - height[i];
            if (count > 0) {
                result += count;
            }
        }
        return result;
    }
}
