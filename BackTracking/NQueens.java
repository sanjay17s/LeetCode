import java.util.*;

class Nqueens {
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> res = new ArrayList<>();
        nqueens(board, 0, new int[n], res);
        return res;
    }

    private void nqueens(int[][] board, int column, int[] arr, List<List<String>> res) {
        if (column == board.length) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    sb.append(board[i][j] == 1 ? 'Q' : '.');
                }
                solution.add(sb.toString());
            }
            res.add(solution);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, column, board, arr)) {
                board[row][column] = 1;
                arr[row] = 1;
                nqueens(board, column + 1, arr, res);
                board[row][column] = 0;
                arr[row] = 0;
            }
        }
    }

    private boolean isSafe(int i, int j, int[][] board, int[] arr) {
        if (arr[i] == 1 )
            return false;
        for (int k = i, l = j; k >= 0 && l >= 0; k--, l--) {
            if (board[k][l] == 1)
                return false;
        }
        for (int k = i, l = j; k < board.length && l >= 0; k++, l--) {
            if (board[k][l] == 1)
                return false;
        }
        return true;
    }
}
