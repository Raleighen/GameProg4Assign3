//Miranda Dorosz
package pieces;

import board.Board;
import java.io.Serializable;

public class King extends Piece implements Serializable {

    public King(int x, int y, char c, String color) {
        super(x, y, c, color);
        c = 'K';
    }

    @Override
    public boolean canMoveTo(int x, int y, Board board) {
        //if piece wants to move diagonally || left/right || up/down
        if((this.x + 1 == x && this.y + 1 == y ) || (this.x - 1 ==x && this.y - 1 == y)
        || ((this.x + 1 == x && this.y == y) || (this.x - 1 == x && this.y == y)) 
        || ((this.x == x && this.y + 1 == y) || (this.x == x && this.y - 1 == y))) {
            
            switch (Colour.toLowerCase())
            {
                case "white": 
                    if (board.getSquare(x, y).bt == 0)
                    {
                        return true;
                    }
                    else
                    {
                        System.out.println("your king would be in check");
                        return false;
                        
                    }
                case "black":
                    if (board.getSquare(x, y).wt == 0)
                    {
                        return true;
                    }
                    else
                    {
                        System.out.println("your king would be in check");
                        return false;
                    }
                default: return false;
            }
        }
        else {
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
    
    @Override
    public void Threaten(Board board)
    {
        switch (Colour.toLowerCase())
        {
            case "white":
                    board.getSquare(this.x,this.y +1).wt = board.getSquare(this.x,this.y +1).wt +1;
                    board.getSquare(this.x +1,this.y +1).wt = board.getSquare(this.x +1,this.y +1).wt +1;
                    board.getSquare(this.x +1,this.y).wt = board.getSquare(this.x +1,this.y).wt +1;
                    board.getSquare(this.x +1,this.y -1).wt = board.getSquare(this.x +1,this.y -1).wt +1;
                    board.getSquare(this.x,this.y -1).wt = board.getSquare(this.x,this.y -1).wt +1;
                    board.getSquare(this.x -1,this.y -1).wt = board.getSquare(this.x -1,this.y -1).wt +1;
                    board.getSquare(this.x -1,this.y).wt = board.getSquare(this.x -1,this.y).wt +1;
                    board.getSquare(this.x -1,this.y +1).wt = board.getSquare(this.x -1,this.y +1).wt +1; 
            case "black":    
                    board.getSquare(this.x,this.y +1).bt = board.getSquare(this.x,this.y +1).bt +1;
                    board.getSquare(this.x +1,this.y +1).bt = board.getSquare(this.x +1,this.y +1).bt +1;
                    board.getSquare(this.x +1,this.y).bt = board.getSquare(this.x +1,this.y).bt +1;
                    board.getSquare(this.x +1,this.y -1).bt = board.getSquare(this.x +1,this.y -1).bt +1;
                    board.getSquare(this.x,this.y -1).bt = board.getSquare(this.x,this.y -1).bt +1;
                    board.getSquare(this.x -1,this.y -1).bt = board.getSquare(this.x -1,this.y -1).bt +1;
                    board.getSquare(this.x -1,this.y).bt = board.getSquare(this.x -1,this.y).bt +1;
                    board.getSquare(this.x -1,this.y +1).bt = board.getSquare(this.x -1,this.y +1).bt +1; 
        }
    }
    
    @Override
    public void moveTo(int x, int y,Board board) {
        //if the piece can move
        if(canMoveTo(x, y, board)) {
            this.x = x;
            this.y = y;
        } else {
                System.out.println("Error: Cannot move to requested spot.");
            }
        } 
    
    @Override
    public boolean Danger(Board board)
    {
        switch (Colour.toLowerCase())
        {
            case "white": if(board.getSquare(this.x, this.y).bt == 0);// create bt check here
                
            case "black": if(board.getSquare(this.x, this.y).wt == 0);// create wt check here
                
            default: System.out.println("error in king danger"); return false;
        }
    }
    
    
    
    
   //useless code section i would like to figure out how to remove to improve efficeny if we have the time and are completly done
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
/*
    Can only move 1 sq in any direction (including diagonals).
    Cannot move into check
*/