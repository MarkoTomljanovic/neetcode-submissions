class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int columns = image[0].length;
        int startingColor = image[sr][sc];
        boolean[][] visited = new boolean[rows][columns];

        dfs(image, sr, sc, color, rows, columns, startingColor, visited);

        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int rows, int columns,
        int startingColor, boolean[][] visited) {
        if (r < 0 || c < 0 || r == rows || c == columns) {
            return;
        }

        if (visited[r][c] || image[r][c] != startingColor) {
            return;
        }

        visited[r][c] = true;
        image[r][c] = color;
        dfs(image, r + 1, c, color, rows, columns, startingColor, visited);
        dfs(image, r - 1, c, color, rows, columns, startingColor, visited);
        dfs(image, r, c + 1, color, rows, columns, startingColor, visited);
        dfs(image, r, c - 1, color, rows, columns, startingColor, visited);
    }
}