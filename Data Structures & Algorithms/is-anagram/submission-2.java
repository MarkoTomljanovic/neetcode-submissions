class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> cs = new HashMap<>();
        Map<Character, Integer> ct = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            cs.compute(s.charAt(i), (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v+1;
            });
            ct.compute(t.charAt(i), (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v+1;
            });
        }
        return cs.equals(ct);
    }
}
