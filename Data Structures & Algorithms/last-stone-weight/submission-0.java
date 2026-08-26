class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();
        for (int stone : stones) {
            stoneList.add(stone);
        }

        while (stoneList.size() > 1) {
            Collections.sort(stoneList);

            int y = stoneList.remove(stoneList.size() - 1);
            int x = stoneList.remove(stoneList.size() - 1);

            if (x < y) {
                stoneList.add(y - x);
            }
        }

        return stoneList.isEmpty() ? 0 : stoneList.getFirst();
    }
}
