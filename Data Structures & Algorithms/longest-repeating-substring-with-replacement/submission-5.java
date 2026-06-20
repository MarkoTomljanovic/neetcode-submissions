class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> freq = new HashMap<>();
        int l = 0;
        int result = 0;

        for(int r=0;r<s.length();r++){
            freq.putIfAbsent(s.charAt(r),0);
           int value = freq.get(s.charAt(r));
           value++;
           freq.put(s.charAt(r),value);

           int max = Collections.max(freq.values());

            if((r-l+1)-max>k){
                value = freq.get(s.charAt(l));
                value--;
                freq.put(s.charAt(l),value);
                 l++;
            }
            result = Math.max(result,r-l+1);
        }
        return result;
    }
}
