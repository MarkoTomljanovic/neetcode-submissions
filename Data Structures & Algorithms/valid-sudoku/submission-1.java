class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> squares = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            cols.put(i, new HashSet<>());
            rows.put(i, new HashSet<>());
            squares.put(i, new HashSet<>());
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char value = board[r][c];
                if (value == '.') {
                    continue;
                }

                if (cols.get(c).contains(value) ||
                        rows.get(r).contains(value) ||
                        squares.get((r / 3) * 3 + c / 3).contains(value)) {
                    return false;
                }
                cols.get(c).add(value);
                rows.get(r).add(value);
                squares.get((r / 3) * 3 + c / 3).add(value);
            }
        }
        return true;
    }
}
