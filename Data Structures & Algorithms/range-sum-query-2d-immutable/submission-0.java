class NumMatrix {
    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        this.prefix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 1; r <= matrix.length; r++) {
            for (int c = 1; c <= matrix[0].length; c++) {
                int left = prefix[r][c - 1];
                int above = prefix[r - 1][c];
                int diagonal = prefix[r - 1][c - 1];

                prefix[r][c] = matrix[r - 1][c - 1] + left + above - diagonal;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int above = prefix[row1][col2 + 1];
        int left = prefix[row2 + 1][col1];

        return prefix[row2 + 1][col2 + 1] - above - left + prefix[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */