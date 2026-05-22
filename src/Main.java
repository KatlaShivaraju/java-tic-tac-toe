import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TicTacToe game =
                new TicTacToe();

        boolean gameOver = false;

        while(!gameOver) {

            BoardPrinter.print(
                    game.getBoard()
            );

            System.out.println(
                    "Player "
                            + game.getCurrentPlayer()
                            + " enter row and col:"
            );

            int row = sc.nextInt();
            int col = sc.nextInt();

            boolean valid =
                    game.makeMove(row, col);

            if(!valid) {
                System.out.println(
                        "Invalid move!"
                );
                continue;
            }

            if(game.hasWon()) {

                BoardPrinter.print(
                        game.getBoard()
                );

                System.out.println(
                        "Player "
                                + game.getCurrentPlayer()
                                + " won!"
                );

                gameOver = true;
            }

            else if(game.isTie()) {

                BoardPrinter.print(
                        game.getBoard()
                );

                System.out.println(
                        "Game Tie!"
                );

                gameOver = true;
            }

            else {
                game.switchPlayer();
            }
        }

        sc.close();
    }
}