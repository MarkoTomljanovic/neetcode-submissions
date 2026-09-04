class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        SortedSet<Integer> set = new TreeSet<>();

        set.addAll(Arrays.stream(nums).boxed().toList());

        int max = 0;
        int cur = 1;
        for (Integer num : set) {
            if (set.contains(num + 1)) {
                cur++;
            } else {
                max = Math.max(max, cur);
                cur = 1;
            }
        }
        return Math.max(max, cur);
    }
}
