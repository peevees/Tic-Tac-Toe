import java.util.Scanner;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //NOTES
        /*
        
        Create Bot
        
        */
        //--------------------------------------------------------------------//
        /*                     Input and Start of Program                     */
        Scanner scan = new Scanner(System.in);        
        System.out.println("Welcome to Tic-Tac-Toe");
        /*                   Create player 1 object                           */
        System.out.println("Please input Player 1's name!");
        String name1 = scan.nextLine();
        player player1 = new player(name1);
        String p1Name = player1.getName();
        System.out.println("player 1's name is: " + p1Name);
        System.out.println("\n" + p1Name 
                + ", Do you want to be Cross (X) or Nought (O)");
        /*  Ask player1 for what piece they want and auto assign player2´s    */
        boolean checkPiece = true;
        while(checkPiece){
            String piece = scan.nextLine();
            if(piece.toLowerCase().contains("cross") | 
                    piece.toLowerCase().contains("x"))
            {
                player1.setPiece(" X ");
                checkPiece = false;
            }else if(piece.toLowerCase().contains("nought") | 
                    piece.toLowerCase().contains("o") ){
                player1.setPiece(" O ");
                checkPiece = false;
            }else{
                System.out.println("Please only input Cross or Nought");
            }
        }
        /*                      Create player 2  object                       */
        System.out.println("\n" + "Please input Player 2's name!");
        String name2 = scan.nextLine();
        player player2 = new player(name2);
        String p2Name = player2.getName();
        System.out.println("player 2's name is: " + p2Name);
        String p1Pi = player1.getPiece();
        if(p1Pi == " X ")
            {
                player2.setPiece(" O ");
            }else{
                player2.setPiece(" X ");
            }
        /*               User input check for gameboard size                  */
        Boolean checksize = true;
        int s = 0;
        System.out.println("Please input board size in one integer, " 
                + "mind that the board size will determine " 
                + "how many pieces you need in a row to win");
        while(checksize){
            String size = scan.next();
            try{
                s = Integer.parseInt(size);
                if(3 > s){
                    System.out.println("size must be greater than or "
                            + "equal to 3");
                }else{
                    checksize = false; // ends loop
                }
            }
            catch(NumberFormatException e){
                System.out.println("size must be an integer: " + e);
                checksize = true;
            }
        }
        /*                 Create gameboard with inputted size                */
        System.out.println("\n" + "Board size is: " + s + " * " + s);
        board gameBoard = new board(s, s);
        System.out.println();
        /*                     Display Stats for players                      */
        player1.printStats(1); //prints stats of player 1
        String p1P = player1.getPiece();
        System.out.println();
        player2.printStats(2);
        String p2P = player2.getPiece();
        System.out.println();
        /*                      Gameboard drawing                             */
        gameBoard.coordinateCells();
        gameBoard.draw();
        gameBoard.clearCells();
        System.out.println();
        /*                         the Game loop                                 */
        boolean playing = true;
        boolean gameOn = true;
        while(playing){
            while(gameOn){
                boolean player1Move = true;
                boolean player2Move = true;
                while(player1Move){
                    int[] player1Moves = player1.playerMove();
                    int r = player1Moves[0]; // save moves in variables
                    int c = player1Moves[1];
                    if(gameBoard.setArray(player1Moves, p1P) != true){
                        System.out.println();
                        gameBoard.draw();
                        System.out.println();
                    }else{
                    System.out.println();
                    gameBoard.draw();
                    System.out.println();
                    switch (gameBoard.gameCondition(r, c, p1P)) {
                        case 1://win
                            gameBoard.draw();
                            int Score = player1.getScore();
                            player1.setScore(Score +1);
                            player1Move = false;
                            player2Move = false;
                            gameOn = false;
                            break;
                        case 2://draw
                            gameBoard.draw();
                            player1Move = false;
                            player2Move = false;
                            gameOn = false;
                            break;
                        default://game continues
                            player1Move = false;
                            break;
                        }
                    }
                }
                while(player2Move){
                    int[] player2Moves = player2.playerMove();
                    int r = player2Moves[0];
                    int c = player2Moves[1];
                    if(gameBoard.setArray(player2Moves, p2P) != true){
                        System.out.println();
                        gameBoard.draw();
                        System.out.println();
                    }else{
                        System.out.println();
                        gameBoard.draw();
                        System.out.println();
                        switch (gameBoard.gameCondition(r, c, p2P)) {
                            case 1://win
                                int Score = player2.getScore();
                                player2.setScore(Score +1);
                                player2Move = false;
                                gameOn = false;
                                break;
                            case 2://draw
                                player2Move = false;
                                gameOn = false;
                                break;
                            default://game continues
                                player2Move = false;
                                break;
                        }
                    }
                }
            }
        /*                           play again?                              */
            System.out.println("Play again?");
            String ans = scan.next();
            switch(ans.toLowerCase()){
                case "y":
                    playing = true;
                    gameOn = true;
                    System.out.println();
                    player1.printStats(1);
                    System.out.println();
                    player2.printStats(2);
                    System.out.println();
                    gameBoard.setmoveCount(0);
                    gameBoard.clearCells();
                    gameBoard.draw();
                    System.out.println();
                    break;
                case "n":
                    playing = false;
                    gameOn = false;
                    System.out.println();
                    player1.printStats(1);
                    System.out.println();
                    player2.printStats(2);
                    System.out.println();
                    break;
                default:
                    System.out.println("please only input the letters: y for yes or n for no");
                    playing = true;
                    gameOn = false;
                    break;
            }
        }
        /*                              end                                   */
    }
}