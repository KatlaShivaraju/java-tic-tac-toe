import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        char[][] board=new char[3][3];
        for(int i=0;i< board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=' ';
            }
        }
        int moves=0;
        char Player='X';
        boolean gameOver=false;
        Scanner sc=new Scanner(System.in);
        while(!gameOver){
            printBoard(board);
            System.out.println("Player "+Player+" enter : ");
            int row=sc.nextInt();
            int col=sc.nextInt();
            if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                System.out.println("Invalid position. Enter values between 0 and 2.");
            }
             else if(board[row][col]==' '){
                board[row][col]=Player;
                moves++;
                gameOver=hasWon(board,Player);
                if(gameOver){
                    printBoard(board);
                    System.out.println("Player "+Player+" has won");
                }
                else if(moves==9){
                    printBoard(board);
                    System.out.println("Game is tie");
                    gameOver=true;
                }
                else{
                    Player=(Player=='X')?'O':'X';
                }
            }
            else{
                System.out.println("Invalid enter Try again");
            }
        }
//        printBoard(board);
        sc.close();
    }
    public static void printBoard(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);

                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();

            if (i < 2) {
                System.out.println("--|---|--");
            }
        }
    }
    public static boolean hasWon(char[][]board,char Player){
        // check all the row
        for(int row=0;row< board.length;row++){
            if(board[row][0]==Player && board[row][1]==Player && board[row][2]==Player){
                return true;
            }
        }
        // check all the col
        for(int col=0;col< board[0].length;col++){
            if(board[0][col]==Player && board[1][col]==Player && board[2][col]==Player){
                return true;
            }
        }
        // check the diagonals
        if(board[0][0]==Player && board[1][1]==Player && board[2][2]==Player){
            return true;
        }
        if(board[0][2]==Player && board[1][1]==Player && board[2][0]==Player){
            return true;
        }
        return false;
    }
}