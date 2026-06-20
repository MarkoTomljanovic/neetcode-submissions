class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<String, Integer> countS = new HashMap<>();
        Map<String, Integer> countT = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            char cs = s.charAt(i);
            countS.putIfAbsent(String.valueOf(cs),0);
            int freqS = countS.get(String.valueOf(cs));
            countS.put(String.valueOf(cs), ++freqS);

            char ct = t.charAt(i);
            countT.putIfAbsent(String.valueOf(ct),0);
            int freqT = countT.get(String.valueOf(ct));
            countT.put(String.valueOf(ct), ++freqT);
        }

        for (Map.Entry<String, Integer> entry : countS.entrySet()){
                String character = entry.getKey();
                Integer freqS = entry.getValue();

                Integer freqT = countT.get(character);

                if(!Objects.equals(freqS, freqT)){
                    return false;
                }
        }
        return true;
    }
}
