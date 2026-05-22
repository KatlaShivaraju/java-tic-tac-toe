public class TicTacToe {

    private char[][] board;
    private char currentPlayer;
    private int moves;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        moves = 0;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean makeMove(int row, int col) {

        if(row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }

        if(board[row][col] != ' ') {
            return false;
        }

        board[row][col] = currentPlayer;
        moves++;

        return true;
    }

    public boolean hasWon() {
        char p = currentPlayer;

        for(int row = 0; row < 3; row++) {
            if(board[row][0] == p &&
                    board[row][1] == p &&
                    board[row][2] == p)
                return true;
        }

        for(int col = 0; col < 3; col++) {
            if(board[0][col] == p &&
                    board[1][col] == p &&
                    board[2][col] == p)
                return true;
        }

        return (board[0][0] == p &&
                board[1][1] == p &&
                board[2][2] == p)

                ||

                (board[0][2] == p &&
                        board[1][1] == p &&
                        board[2][0] == p);
    }

    public boolean isTie() {
        return moves == 9;
    }

    public void switchPlayer() {
        currentPlayer =
                (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }
}
