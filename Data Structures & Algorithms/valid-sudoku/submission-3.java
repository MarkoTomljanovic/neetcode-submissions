class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> duplicates = new HashSet<>();
            int boxRow = (i / 3) * 3;
            int boxColumn = (i % 3) * 3;

            for (int j = 0; j < 9; j++) {
                int r = boxRow + (j / 3);
                int c = boxColumn + (j % 3);
                char ch = board[r][c];

                if (ch == '.') {
                    continue;
                }
                if (!duplicates.add(ch)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            Set<Character> duplicates = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];

                if (ch == '.') {
                    continue;
                }
                if (!duplicates.add(ch)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            Set<Character> duplicates = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                char ch = board[j][i];

                if (ch == '.') {
                    continue;
                }
                if (!duplicates.add(ch)) {
                    return false;
                }
            }
        }

        return true;
    }
}
