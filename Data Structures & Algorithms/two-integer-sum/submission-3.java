class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            valueToIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int otherNumber = target - nums[i];
            if (valueToIndex.containsKey(otherNumber) && i != valueToIndex.get(otherNumber)) {
                int otherNumberIndex = valueToIndex.get(otherNumber);

                if (i < otherNumberIndex) {
                    result[0] = i;
                    result[1] = otherNumberIndex;
                } else {
                    result[1] = i;
                    result[0] = otherNumberIndex;
                }
                break;
            }
        }
        return result;
    }
}
