class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        int result = 0;

        for(int number : nums){
            numbers.add(number);
        }

        for(int number : numbers){
            if(!numbers.contains(number-1)){
                int length = 1;
                while(numbers.contains(number+length)){
                    length++;
                }
                result = Math.max(result,length);
            }
        }
        return result;
    }
}
