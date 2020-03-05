class Solution {
    public boolean isValidSudoku(char[][] board) {
        int column = board[0].length, row = board.length;
        int[][] test_row = new int[row][10];
        int[][] test_column = new int[column][10];
        int[][][] test_block = new int[column / 3][row / 3][10];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (board[i][j] == '.')
                    continue;
                test_column[i][board[i][j] - 48]++;
                test_row[j][board[i][j] - 48]++;
                test_block[i / 3][j / 3][board[i][j] - 48]++;
                if (test_column[i][board[i][j] - 48] == 2
                        || test_row[j][board[i][j] - 48] == 2
                        || test_block[i / 3][j / 3][board[i][j] - 48] == 2)
                    return false;
            }
        }
        return true;
    }
}