class Solution {
    public String encode(List<String> strs) {
        String result = "";

        for (String str : strs) {
            result = result + str.length() + "#" + str;
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> results = new ArrayList<>();

        while (!str.isEmpty()) {
            int indexOfDelimiter = str.indexOf("#");
            Integer size = Integer.valueOf(str.substring(0, indexOfDelimiter));

            results.add(str.substring(indexOfDelimiter + 1, indexOfDelimiter + size + 1));
            str = str.substring(indexOfDelimiter + size + 1);
        }
        return results;
    }
}
