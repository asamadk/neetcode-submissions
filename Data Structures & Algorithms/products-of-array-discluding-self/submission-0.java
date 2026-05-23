class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProd = new int[nums.length];
        int[] rightProd = new int[nums.length];

        for(int i=0;i<nums.length;i++) {
            if (i == 0) {
                leftProd[i] = 1;
                continue;
            }
            leftProd[i] = nums[i-1] * leftProd[i-1];
        }

        for (int i=nums.length-1;i>=0;i--) {
            if (i == nums.length-1) {
               rightProd[i] = 1; 
               continue;
            }
            rightProd[i] = nums[i+1] * rightProd[i + 1];
        }

        int[] result = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            result[i] = leftProd[i] * rightProd[i];
        }
        
        return result;
    }
}  
