class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i=0;i<numbers.length - 1;i++) {
          for (int j=i+1;j<numbers.length;j++) {
            int inum = numbers[i];
            int jnum = numbers[j];
            if (inum == jnum) {
                continue;
            }
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                result[0] = i+1;
                result[1] = j+1;
                break;
            }
          }  
        }

        return result;
    }
}
