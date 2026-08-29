class Solution {
    public int climbStairs(int n) {
        return dp(n, new HashMap<>());
    }
    private int dp(int n, Map<Integer, Integer> cache) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n, dp(n - 1,cache) + dp(n - 2,cache));
        return cache.get(n);
    }
}
