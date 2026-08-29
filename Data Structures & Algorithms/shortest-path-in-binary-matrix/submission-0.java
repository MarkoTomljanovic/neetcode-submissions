class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }

        int rows = grid.length;
        int columns = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][columns];

        q.offer(new int[] {0, 0});
        visited[0][0] = true;

        int length = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];

                if (r == rows - 1 && c == columns - 1) {
                    return length;
                }

                int[][] directions = {
                    {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

                for (int[] direction : directions) {
                    int dr = direction[0];
                    int dc = direction[1];

                    if (r + dr < 0 || c + dc < 0 || r + dr == rows || c + dc == columns
                        || visited[r + dr][c + dc] || grid[r + dr][c + dc] == 1) {
                        continue;
                    }
                    q.offer(new int[] {r + dr, c + dc});
                    visited[r + dr][c + dc] = true;
                }
            }
            length++;
        }

        return -1;
    }
}