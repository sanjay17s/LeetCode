package BackTracking;

class NQueens {
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        int[] sum = new int[1]; // Array to hold the sum
        nqueens(board, 0, new int[n], sum);
        return sum[0];
    }

    private void nqueens(int[][] board, int column, int[] arr, int[] sum) {
        if (column == board.length) {
            sum[0]++; // Update the sum
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, column, board, arr)) {
                board[row][column] = 1;
                arr[row] = 1;
                nqueens(board, column + 1, arr, sum);
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
