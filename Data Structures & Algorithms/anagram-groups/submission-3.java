class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> ans = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];

            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            
            String countAsString = Arrays.toString(count);
            
            ans.putIfAbsent(countAsString, new ArrayList<>());
            ans.get(countAsString).add(str);
        }
        return new ArrayList<>(ans.values());
    }
}
