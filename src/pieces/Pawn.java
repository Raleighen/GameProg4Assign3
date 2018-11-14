
package pieces;

import board.Board;
import java.io.Serializable;


public class Pawn extends Piece implements Serializable {
    private int move = 0;
    
    
    public Pawn(int x, int y, char c, String color) {
        super(x, y, c, color);
        c = 'P';
    }
    
    @Override
    public boolean canMoveTo(int x, int y, Board board) {
        if (move < 2) {
            switch (Colour.toLowerCase()){
                case "white":
                    if (board.getSquare(x,y).getPiece() == null && (x == this.x && y == this.y - 1) || (x == this.x && y == this.y - 2)) { //move up 2 spaces if it is move 0
                        move++;
                        return true;
                    } else if (canTake(x,y,board) != true){                       
                        return false;
                    }else{
                        return true;
                    }
               case "black":
                    if (board.getSquare(x,y).getPiece() == null && (x == this.x && y == this.y + 1) || (x == this.x && y == this.y + 2)) { //move up 2 spaces if it is move 0
                        move++;
                        return true;
                    } else if (canTake(x,y,board) == true){
                        return true;
                    }else{
                        return false;
                    }
               default:
                   return false;
            }
        } else {
            switch (Colour.toLowerCase()){
                case "white":
                    if (board.getSquare(x,y).getPiece() == null && (x == this.x && y == this.y - 1)) { //move up 2 spaces if it is move 0
                        move++;
                        return true;
                    } else if (canTake(x,y,board) == true){
                        return true;
                    }else{
                        return false;
                    }
                case "black":
                    if (board.getSquare(x,y).getPiece() == null && (x == this.x && y == this.y + 1)) { //move up 2 spaces if it is move 0
                        move++;
                        return true;
                    } else if (canTake(x,y,board) == true){
                        return true;
                    }else{
                        return false;
                    }
                default:
                    return false;
            }
        }
    }    

    @Override
    public boolean canTake(int x, int y, Board board)
    {
        switch (Colour.toLowerCase())
        {
            
            case "white":  return "black".equals(board.getSquare(x,y).getPiece().Colour) && (x == this.x -1 || x == this.x +1 && y == this.y - 1);
            
            case "black":  return "white".equals(board.getSquare(x,y).getPiece().Colour) && (x == this.x -1 || x == this.x +1 && y == this.y + 1);
            
            default:  return false;
                    
        }
    }
    
    @Override
    public void Threaten(Board board)
    {        
        switch (Colour.toLowerCase())
        {
            case "white": 
                board.getSquare(this.x +1,this.y -1).wt = board.getSquare(this.x +1,this.y -1).wt +1;
                board.getSquare(this.x -1,this.y -1).wt = board.getSquare(this.x -1,this.y -1).wt +1;
                
            case "black":
                board.getSquare(this.x +1,this.y +1).bt = board.getSquare(this.x +1,this.y +1).bt +1;
                board.getSquare(this.x -1,this.y +1).bt = board.getSquare(this.x -1,this.y +1).bt +1;
        }
    }
    
    @Override
    public void moveTo(int x, int y, Board board) {
        if (canMoveTo(x, y, board)) {
            this.x = x;
            this.y = y;
        } else {
            System.out.println("Error: Cannot move to requested spot.");
        }
    }
    
    
    
    //useless code section i would like to figure out how to remove to improve efficeny if we have the time and are completly done
    @Override
    public boolean Danger(Board board)
    {
        return false;
    }        
                 
    @Override
    public boolean lowCh(String place, int a, int b, int c,int d, Board board)
    {
        return true;
    }
    
    @Override
    public void setter(int a, int b)
    {
        
    }
}
