class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> freqs = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            freqs.putIfAbsent(Arrays.toString(count), new ArrayList<>());
            freqs.get(Arrays.toString(count)).add(str);
        }
        return new ArrayList<>(freqs.values());
    }
}
