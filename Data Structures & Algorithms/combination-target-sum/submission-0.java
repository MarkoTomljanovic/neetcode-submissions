class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        explore(nums, target, result, combination, 0);

        return result;
    }

    public void explore(
        int[] nums, int target, List<List<Integer>> result, List<Integer> combination, int i) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (i >= nums.length || target < 0) {
            return;
        }

        combination.add(nums[i]);
        explore(nums, target - nums[i], result, combination, i);

        combination.remove(combination.size() - 1);
        explore(nums, target, result, combination, i + 1);
    }
}
