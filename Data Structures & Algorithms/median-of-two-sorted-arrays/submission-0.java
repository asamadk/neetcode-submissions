class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int l = m + n;

        if (n == 0 && m == 0) {
            return -0.5;
        }

        int[] nums = new int[l];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < l) {
            if (i < n && j < m && nums1[i] < nums2[j]) {
                nums[k] = nums1[i];
                i++;
                k++;
            } else if (i < n && j < m){
                nums[k] = nums2[j];
                j++;
                k++;
            } else {
                break;
            }
        }

        while (k < l && i < n) {
            nums[k] = nums1[i];
            i++;
            k++;
        }

        while (k < l && j < m) {
            nums[k] = nums2[j];
            j++;
            k++;
        }

        if ((l % 2) == 0) {
            int m1 =  l/2;
            int m2 = m1-1;

            return (double)(nums[m1]+nums[m2])/(double)2;
        } else {
            return nums[l/2];
        }
    }
}
