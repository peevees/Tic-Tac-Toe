import java.util.Scanner;

public class player {//class
    //Notes
    /*
    
    
    
    */
    //------------------------------------------------------------------------//
    /*                       variable declaration                             */
    protected Scanner scan = new Scanner(System.in);
    protected String playerName;
    protected String Piece;
    protected int Score;
    protected int playerNumber;
    /*                              Player name                               */
    public player(String playerName){//constructor
        this.playerName = playerName;
    }
    public void printName() {//method
        System.out.println(playerName);
    }
    public String getName() {//method
        return playerName;
    }
    /*                            Stats                                       */
    public void printStats(int playerNumber){
        System.out.println("player " + playerNumber);
        System.out.println("Name: " + playerName);
        System.out.println("Piece:" + Piece);
        System.out.println("Wins: " + Score);
    }
    /*                              piece                                     */
    public void printPiece() {//method
        System.out.println(Piece);
    }
    public String getPiece() {//method
        return Piece;
    }
    public void setPiece(String piece) {//method
        this.Piece = piece;
    }
    /*                             Score                                      */
    public void printScore() {//method
        System.out.println("Score: " + Score);
    }
    public int getScore() {//method
        return Score;
    }
    public void setScore(int score) {//method
        this.Score = score;
    }
    /*                               Player move                              */
    public int[] playerMove(){
        boolean checkMove = true;
        int r = 0;
        int c = 0;
        System.out.println(playerName + ", with piece: " + Piece + ", enter your move");
        while(checkMove){//checks if movement is an intger
            System.out.println("Please input Row integer");
            String row = scan.next();
            System.out.println("Please input Columnn integer");
            String col = scan.next();
            try{
                r = Integer.parseInt(row);
                c = Integer.parseInt(col);
                checkMove = false;
            }
            catch(NumberFormatException e){
                System.out.println("Move must be an integer: " + e);
                checkMove = true;
            }
        }
        int rowcols[] = new int[2];
        rowcols[0] = r;
        rowcols[1] = c;
        return rowcols;
    }
    /*                             END                                        */
}