class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = rows * columns - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int row = mid / columns;
            int col = mid % columns;

            if (target < matrix[row][col]) {
                right = mid - 1;
            } else if (target > matrix[row][col]) {
                left = mid + 1;
            } else {
                return matrix[row][col] == target;
            }
        }
        return false;
    }
}
