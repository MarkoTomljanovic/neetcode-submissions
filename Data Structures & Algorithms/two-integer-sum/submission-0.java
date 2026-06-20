class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numPerIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int number = nums[i];

            if(numPerIndex.containsKey(target - number)){
                return new int[]{numPerIndex.get(target - number), i};
            }
            numPerIndex.put(number, i);
        }
        return new int[] {};
    }
}
