class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ('1' == grid[i][j]) {
                    dfs(grid, i, j, rows, cols);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int r, int c, int rows, int cols) {
        if (r < 0 || r == rows || c < 0 || c == cols || '0' == grid[r][c]) {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r + 1, c, rows, cols);
        dfs(grid, r - 1, c, rows, cols);
        dfs(grid, r, c + 1, rows, cols);
        dfs(grid, r, c - 1, rows, cols);
    }
}
