class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] sorted = quickSort(points, 0, points.length - 1);

        return Arrays.copyOfRange(sorted, 0, k);
    }

    public int[][] quickSort(int[][] points, int s, int e) {
        if (s >= e) {
            return points;
        }

        int left = s;
        int[] pivot = points[e];

        int pivotDistance = distance(pivot[0], pivot[1]);

        for (int i = s; i < e; i++) {
            int[] current = points[i];
            int currentDistance = distance(current[0], current[1]);

            if (currentDistance < pivotDistance) {
                int[] tmp = points[left];
                points[left] = points[i];
                points[i] = tmp;
                left++;
            }
        }

        int[] tmp = points[left];
        points[e] = tmp;
        points[left] = pivot;

        quickSort(points, s, left - 1);
        quickSort(points, left + 1, e);

        return points;
    }

    public int distance(int x, int y) {
        return x * x + y * y;
    }
}
