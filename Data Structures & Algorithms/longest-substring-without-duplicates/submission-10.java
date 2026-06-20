class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int l = 0;
        int len = 0;

        for(int r = 0; r<s.length(); r++){
                while(seen.contains(s.charAt(r))){
                    seen.remove(s.charAt(l));
                    l++;
                }
                 seen.add(s.charAt(r));
                len = Math.max(len,r-l+1);
        }
        return len;
    }
}
