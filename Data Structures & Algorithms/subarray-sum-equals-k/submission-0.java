class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, 1);

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;
            count += seen.getOrDefault(prefixSum - k, 0);
            seen.merge(prefixSum, 1, Integer::sum);
        }
        return count;
    }
}