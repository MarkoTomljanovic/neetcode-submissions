class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int curNumOfIslands = dfs(grid, i, j, rows, cols);
                count = Math.max(count, curNumOfIslands);
            }
        }
        return count;
    }
    private int dfs(int[][] grid, int r, int c, int rows, int cols) {
        if (r < 0 || r == rows || c < 0 || c == cols || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        int count = 1;

        count += dfs(grid, r + 1, c, rows, cols);
        count += dfs(grid, r - 1, c, rows, cols);
        count += dfs(grid, r, c + 1, rows, cols);
        count += dfs(grid, r, c - 1, rows, cols);

        return count;
    }
}
