public class board {//class
    //Notes
    /*
    
    Create:
    
    */
    
    //------------------------------------------------------------------------//
    /*                          Variable Declaration                          */
    protected int Rows;
    protected int Cols;
    protected String content = "   ";
    protected String[][] cells;
    protected boolean checkMove = true;
    protected int inaRow;
    protected int moveCount;
    /*                              Constructor                               */
    public board(int rows, int columns){
        this.Rows = rows;
        this.Cols = columns;
        this.inaRow = rows;
        cells = new String[Rows][Cols];
        System.out.println("you need " + inaRow + " in a row to win");
    }
    /*                         set move count                                 */
    public void setmoveCount(int count){
        this.moveCount = count;
    }
    /*                  Method to fill array with spaces                      */
    public void clearCells(){
        for (int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells.length; j++){
                cells[i][j] = content;
            }
        }
    }
    /*                  Method to fill array with its own indexes             */
    public void coordinateCells(){
        for (int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells.length; j++){
                cells[i][j] = (Integer.toString(i) + "," + Integer.toString(j));
            }
        }
    }
    /*                            set array                                   */
    public boolean setArray(int[] move, String piece){
        int[] moves = move;
        String Piece = piece;
        if(cells.length -1 < moves[0] || cells.length -1 < moves[1] || 
                moves[0] < 0 || moves[1] < 0){
            System.out.println("Move must be inside board measurements"  + "\n");
            return false;
        }else if(cells[move[0]][move[1]].equals(" X ") || 
                cells[move[0]][move[1]].equals(" O ")){
            System.out.println("Cell occupied, please choose another place" + "\n");
            return false;
        }else{
            cells[move[0]][move[1]] = Piece;
        }
        return true;
    }
    /*                     check win and draw conditions                      */
    public int gameCondition(int r, int c, String piece){
        moveCount++;
        //check row
        for(int i = 0; i < inaRow; i++){
            if(cells[r][i] !=piece){
                break;
            }else if(i == inaRow-1){
            //report win
                System.out.println("Win by " + cells.length + " in a row");
                return 1;
            }
        }
        //check column
        for(int j = 0; j < inaRow; j++){
            if(cells[j][c] != piece){
                break;
            }else if(j == inaRow-1){
                //report win
                System.out.println("Win by " + cells.length + " in a column");
                return 1;
            }
        }
        //check diagonal
        if(r == c){
            //diagonal
            for(int k = 0; k < inaRow;k++){
                if(cells[k][k] != piece){
                    break;
                }else if(k == inaRow-1){
                    //report win
                    System.out.println("Win by " + cells.length + " in diagonal");
                    return 1;
                }
            }
        }
        //check anti-diagonal
        if((r + c) == (inaRow - 1)){
            for(int l = 0; l < inaRow; l++){
                if(cells[l][(inaRow-1)-l] != piece){
                    break;
                }else if(l == inaRow-1){
                    //report win
                    System.out.println("Win by " + cells.length + " in anti-diagonal");
                    return 1;
                }
            }
        }
        //check draw
        if(moveCount ==((cells.length*cells.length))){
            //report draw
            System.out.println("draw");
            return 2;
        }
        return 0;
    }
    /* Method to Draw the board depending on the cells array for the places 
                                                           for Crosses Noughts*/
    public void draw(){
        for(int row=0; row < Rows; row++){
            for(int col = 0; col < Cols; col++){
                System.out.print(cells[row][col]); //<-- here the content in the cells is printed
                if (col < Cols - 1){
                    System.out.print("|"); //vertical line
                }
            }
            System.out.println();
            if(row < Rows - 1){
                for(int k = 0; k < (Cols*4 -1); k++){// horizontal line of 4 dashes except the last one which is only 3 dashes
                    System.out.print("-");
                }
                System.out.println(); // adds a new empty line after every horizontal line
            }
        }
    }
    /*                                 END                                    */
}
