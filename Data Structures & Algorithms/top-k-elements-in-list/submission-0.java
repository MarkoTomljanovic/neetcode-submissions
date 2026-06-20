class Solution {
    public int[] topKFrequent(int[] nums, int k) {
              Map<Integer, Integer> count = new HashMap<>();
        int[] result = new int[k];

        for (int num : nums) {
            count.putIfAbsent(num, 0);
            int sum = count.get(num);
            sum++;
            count.put(num, sum);
        }

        List<Integer>[] numOfOccurances = new List[nums.length + 1];
        for (int i = 0; i < numOfOccurances.length; i++) {
            numOfOccurances[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            numOfOccurances[value].add(key);
        }

        int counter = 0;
        for (int i = numOfOccurances.length - 1; i > 0; i--) {
            if (numOfOccurances[i].isEmpty()) {
                continue;
            }
            if (counter >= k) {
                break;
            }

            List<Integer> elements = numOfOccurances[i];
            for (Integer element : elements) {
                result[counter] = element;
                counter++;

            }
        }
        return result;
    }
}
