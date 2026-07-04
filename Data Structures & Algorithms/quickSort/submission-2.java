// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        return sort(pairs, 0, pairs.size() - 1);
    }

    public List<Pair> sort(List<Pair> pairs, int s, int e) {
        if (e - s + 1 <= 1) {
            return pairs;
        }

        var left = s;
        var pivot = pairs.get(e);

        for (int i = s; i < e; i++) {
            if (pairs.get(i).key < pivot.key) {
                var tmp = pairs.get(left);
                pairs.set(left, pairs.get(i));
                pairs.set(i, tmp);

                left++;
            }
        }
        pairs.set(e, pairs.get(left));
        pairs.set(left, pivot);

        sort(pairs, s, left - 1);
        sort(pairs, left + 1, e);

        return pairs;
    }
}
