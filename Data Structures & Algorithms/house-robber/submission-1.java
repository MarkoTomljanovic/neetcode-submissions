class Solution {
    public int rob(int[] nums) {
        return dfs(nums, 0, new int[nums.length]);
    }

    private int dfs(int[] nums, int i, int[] cache) {
        if (i >= nums.length) {
            return 0;
        }

        if (cache[i] != 0) {
            return cache[i];
        }

        int a = dfs(nums, i + 1, cache);

        int b = nums[i] + dfs(nums, i + 2, cache);

        int best = Math.max(a, b);
        cache[i] = best;
        return best;
    }
}
