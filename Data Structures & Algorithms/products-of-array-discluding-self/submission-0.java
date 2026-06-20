class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        var pref = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = pref;
            pref = pref * nums[i];
        }

        pref = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = pref * result[i];
            pref = pref * nums[i];

        }
        return result;
    }
}  
