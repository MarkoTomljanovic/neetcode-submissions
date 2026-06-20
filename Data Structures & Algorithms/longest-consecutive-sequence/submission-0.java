class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for(int number : nums){
            numbers.add(number);
        }

        int length = 0;
        for(int number : numbers){
            if(!numbers.contains(number -1)){
               int increment = 1;

                while(numbers.contains(number+increment)){
                    increment++;
                }
                length = Math.max(increment, length);
            }
        }
        return length;
    }
}
