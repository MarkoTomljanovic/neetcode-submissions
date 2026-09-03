class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        Map<Integer, Integer> freqs = new HashMap<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums) {
            freqs.merge(num, 1, Integer::sum);
        }

        maxHeap.addAll(freqs.values());

        for (int i = 0; i < k; i++) {
            int f = maxHeap.poll();
            Integer toRemove = null;
            for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
                Integer element = entry.getKey();
                Integer elementFrequency = entry.getValue();
                toRemove = element;

                if (f == elementFrequency) {
                    result[i] = element;
                    break;
                }
            }
            freqs.remove(toRemove);
        }
        return result;
    }
}
