class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int[][] neighbors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        int mins = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];

                for (int[] neighbor : neighbors) {
                    int dr = neighbor[0];
                    int dc = neighbor[1];

                    if (r + dr < 0 || r + dr == rows || c + dc < 0 || c + dc == columns
                        || grid[r + dr][c + dc] != 1) {
                        continue;
                    }
                    grid[r + dr][c + dc] = 2;
                    q.offer(new int[] {r + dr, c + dc});
                }
            }

            if (!q.isEmpty()) {
                mins++;
            }
        }

        int numOfFresh = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    numOfFresh++;
                }
            }
        }

        return numOfFresh == 0 ? mins : -1;
    }
}
