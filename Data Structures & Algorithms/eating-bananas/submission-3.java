class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        int result = r;

        while (l <= r) {
            int k = (l + r) / 2;
            int hours = 0;

            for (int pile : piles) {
                hours += Math.ceil((double) pile / k);
            }

            if (hours <= h) {
                result = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return result;
    }
}
