class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagrams = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            int[] mask = new int[26];
            for(char c : strs[i].toCharArray()){
                mask[c - 'a']++;
            }
            anagrams.putIfAbsent(Arrays.toString(mask),new ArrayList<>());
            anagrams.get(Arrays.toString(mask)).add(strs[i]);
        }
        return new ArrayList<>(anagrams.values());
    }
}
