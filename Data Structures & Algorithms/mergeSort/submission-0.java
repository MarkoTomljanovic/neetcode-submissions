// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        if (pairs.size() < 2) {
            return pairs;
        }

        var mid = pairs.size() / 2;

        var left = mergeSort(pairs.subList(0, mid));
        var right = mergeSort(pairs.subList(mid, pairs.size()));

        return merge(left, right);
    }

    private List<Pair> merge(List<Pair> left, List<Pair> right) {
        List<Pair> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).key <= right.get(j).key) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        while (i < left.size()) {
            result.add(left.get(i++));
        }

        while (j < right.size()) {
            result.add(right.get(j++));
        }

        return result;
    }
}
