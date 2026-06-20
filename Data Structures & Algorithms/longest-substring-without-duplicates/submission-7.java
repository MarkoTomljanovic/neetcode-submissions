class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int len = 0;
        int l = 0;
        int r = l+1;
        Set<Character> seen = new HashSet<>();
        char[] chars = s.toCharArray();
        seen.add(chars[l]);
        len = Math.max(len, seen.size());

        while(l<r&&r<chars.length){
            if(!seen.contains(chars[r])){
                seen.add(chars[r]);
                len = Math.max(len,seen.size());
                r++;
            }else{
                seen.clear();
                l++;
                r=l+1;
                seen.add(chars[l]);
            }
        }
        return len;
    }
}
