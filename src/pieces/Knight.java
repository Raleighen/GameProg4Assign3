
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
    public boolean lowCh(String place, int a, int b, int c,int d, Board board)
    {
        return true;
    }
    @Override
    public void setter(int a, int b)
    {
        
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
    
    @Override
    public void Threaten(Board board)
    {
        switch (Colour.toLowerCase())
        {
            case "white":
                
            case "black":
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
}
