class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }

        int l=1, r = max;
        int res = r;

        while (l <= r) {
            int m = (l+r)/2;
            long total = 0;

            for (int i = 0; i < piles.length; i++) {
                total += (int) Math.ceil((double)piles[i] / m);
            }

            if (total <= h) {
                res = m;
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return res;
    }
}
