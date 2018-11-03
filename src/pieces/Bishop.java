
package pieces;

import java.io.Serializable;
import board.*;

public class Bishop extends Piece implements Serializable {
    
    int xt,yt;
    public Bishop(int x, int y, char c, String color) {
        super(x, y, c, color);
        c = 'B';
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        Board board = new Board();
        //this piece can only move diagonally any number of spaces
        
        if (x > this.x && y > this.y){ //move up to the right
            if(lowCh("uright",xt,yt,x,y) == true)
            {
            return true;
            }
            else
            {
                return false;
            }
        } else if (x > this.x && y < this.y){ //move down to the right
            if(lowCh("dright",xt,yt,x,y) == true)
            {
            return true;
            }
            else
            {
                return false;
            }
        } else if (x < this.x && y > this.y){ //move up to the left
            if (lowCh("uleft",xt,yt,x,y) == true)
            {
            return true;
            }
            else
            {
                return false;
            }
        } else if (x < this.x && y < this.y){ //move down to the left
            if (lowCh("dleft",xt,yt,x,y) == true)
            {
            return true;
            }
            else
            {
                return false;
            }
        } else {
            return false;
        }
    }
    @Override
    public void setter(int a, int b)
    {
    xt = a;
    yt = b;
    }
    //idea: create a for loop to check cheack tile the piece is moving to see if there is a piece already there
    @Override
    public boolean lowCh(String Place,int x1, int y1, int x2,int y2)
    {
        Board board = new Board();
                
        switch(Colour.toLowerCase())
        {
            
            //experiment to check to see if there is a piece in the way
            case "uright":       
            for(; x1==x2 && y1==y2; x1++,y1++)
            {
                if (board.getSquare(x1,y1).getPiece()==null)
                {
                return true;
                }
                else
                {
                    return false;
                }
            }
            case "uleft":
            for(; x1==x2 && y1==y2; x1--,y1++)
            {
                if (board.getSquare(x,y).getPiece()==null)
                {
                return true;
                }
                else
                {
                    return false;
                }
            }
            case "dright":
            for(; x1==x2 && y1==y2; x1++,y1--)
            {
                if (board.getSquare(x,y).getPiece()==null)
                {
                return true;
                }
                else
                {
                    return false;
                }
            }
            case "dleft":
            for(; x1==x2 && y1==y2; x1--,y1--)
            {
                if (board.getSquare(x,y).getPiece()==null)
                {
                return true;
                }
                else
                {
                    return false;
                }
            }
        
        default:
        return false;
        }
    }
    @Override
    public void moveTo(int x, int y) {
        if (canMoveTo(x, y)){
            this.x = x;
            this.y = y;
        } else {
            System.out.println("Error: Cannot move to requested spot.");
        }
    }
}
