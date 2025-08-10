import java.util.Scanner;

public class TicTacToe{
    
    
    static void printBoard2(char[] board){
        System.out.println("  " + board[0] + "  " +  board[1] + "  " + board[2]);
        System.out.println();
        System.out.println("  " + board[3] + "  " +  board[4] + "  " + board[5]);
        System.out.println();
        System.out.println("  " + board[6] + "  " +  board[7] + "  " + board[8]);
    }
    
    static boolean isInValidMove(char[] board, int move){
        return (board[move-1] == 'X' || board[move-1] == 'O');
    }
    
    
    static boolean isGameOver(char[] board, char currentPlayer){
        
        return (
        // Check the rows
        (board[0] + board[1] + board[2]) == (currentPlayer * 3) ||
        (board[3] + board[4] + board[5]) == (currentPlayer * 3) || 
        (board[6] + board[7] + board[8]) == (currentPlayer * 3) ||
        
        // Check the Columns
        (board[0] + board[3] + board[6]) == (currentPlayer * 3) ||
        (board[1] + board[4] + board[7]) == (currentPlayer * 3) ||
        (board[2] + board[5] + board[8]) == (currentPlayer * 3) ||
        
        // Check the diagonals
        (board[0] + board[4] + board[8]) == (currentPlayer * 3) ||
        (board[2] + board[4] + board[6]) == (currentPlayer * 3)
        );
    }
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        
        char currentPlayer = 'X';
        int noOfSquaresPlayed = 0;
        boolean quitByWin = false;
        
        char[] board = {
            '1', '2', '3', 
            '4', '5', '6',
            '7', '8', '9'};
        
        while (noOfSquaresPlayed < 9){
            printBoard2(board);
            
            System.out.print("\n Choose your Square " + currentPlayer + " : ");
            int playersChoice = scan.nextInt();
            System.out.println();
            
            if(isInValidMove(board, playersChoice)){
                System.out.println(" Invalid Move -> Try Again \n");
                continue;
            }
            
            board[playersChoice-1] = currentPlayer;
            
            if(isGameOver(board, currentPlayer)){
                System.out.println("\n Player " + currentPlayer + " win the round \n");
                printBoard2(board);
                quitByWin = true;
                break;
            }
            
            currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
            noOfSquaresPlayed++;
        }
        if(!quitByWin)System.out.println(" \n-------- GAME DRAW -------"); 
    }
}