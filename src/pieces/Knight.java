
package pieces;

import board.Board;
import java.io.Serializable;

public class Knight extends Piece implements Serializable {
    public Knight(int x, int y, char c, String color) {
        super(x, y, c, color);
        c = 'N';
    }

    @Override
    public boolean canMoveTo(int x, int y, Board board) {
        if (y == this.y + 2 && x == this.x + 1){ //move up 2 and the right 1
            return true;
        } else if (y == this.y + 2 && x == this.x - 1) { //move up 2 and left 1
            return true;
        } else if (x == this.x + 2 && y == this.y + 1) { //move right 2 and up 1
            return true;
        } else if (x == this.x + 2 && y == this.y - 1) { //move right 2 and down 1
            return true;
        } else if (y == this.y - 2 && x == this.x + 1) { //move down 2 and right 1
            return true;
        } else if (y == this.y - 2 && x == this.x - 1) { //move down 2 and left 1
            return true;
        } else if (x == this.x - 2 && y == this.y - 1) { //move left 2 and down 1
            return true;
        } else if (x == this.x - 2 && y == this.y + 1) { //move left 2 and up 1
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean canTake(int x, int y, Board board)
    {
        if (board.getSquare(x, y).getPiece() == null)
        {
            return true;
        }else{
        switch (Colour.toLowerCase())
        {
            case "white":  return "black".equals(board.getSquare(x,y).getPiece().Colour);
        
            case "black":  return "white".equals(board.getSquare(x,y).getPiece().Colour);
            
            default:  return false;                    
        }
      }
    }
    
    
    //idea for the future of a simplified version of the Threaten system
    //issue:  cannot create a system in which it will insert the +1 to the correct colour
    public void Scary(Board board)
    {
            board.getSquare(this.x +1,this.y -1).wt = board.getSquare(this.x +1,this.y -1).wt +1;
        
    }
    
    @Override
    public void Threaten(Board board)
    {
        switch (Colour.toLowerCase())
        {
            case "white": 
                    board.getSquare(this.x +1,this.y +2).wt = board.getSquare(this.x +1,this.y +2).wt +1;
                    board.getSquare(this.x -1,this.y +2).wt = board.getSquare(this.x -1,this.y +2).wt +1;
                    board.getSquare(this.x +2,this.y +1).wt = board.getSquare(this.x +2,this.y +1).wt +1;
                    board.getSquare(this.x +2,this.y -1).wt = board.getSquare(this.x +2,this.y -1).wt +1;
                    board.getSquare(this.x +1,this.y -2).wt = board.getSquare(this.x +1,this.y -2).wt +1;
                    board.getSquare(this.x -1,this.y -2).wt = board.getSquare(this.x -1,this.y -2).wt +1;
                    board.getSquare(this.x -2,this.y +1).wt = board.getSquare(this.x -2,this.y +1).wt +1;
                    board.getSquare(this.x -2,this.y -1).wt = board.getSquare(this.x -2,this.y -1).wt +1;                    
            case "black": 
                    board.getSquare(this.x +1,this.y +2).bt = board.getSquare(this.x +1,this.y +2).bt +1;
                    board.getSquare(this.x -1,this.y +2).bt = board.getSquare(this.x -1,this.y +2).bt +1;
                    board.getSquare(this.x +2,this.y +1).bt = board.getSquare(this.x +2,this.y +1).bt +1;
                    board.getSquare(this.x +2,this.y -1).bt = board.getSquare(this.x +2,this.y -1).bt +1;
                    board.getSquare(this.x +1,this.y -2).bt = board.getSquare(this.x +1,this.y -2).bt +1;
                    board.getSquare(this.x -1,this.y -2).bt = board.getSquare(this.x -1,this.y -2).bt +1;
                    board.getSquare(this.x -2,this.y +1).bt = board.getSquare(this.x -2,this.y +1).bt +1;
                    board.getSquare(this.x -2,this.y -1).bt = board.getSquare(this.x -2,this.y -1).bt +1; 
        }
    }
    
    @Override
    public void moveTo(int x, int y, Board board) {
        if (canMoveTo(x, y, board)){
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
