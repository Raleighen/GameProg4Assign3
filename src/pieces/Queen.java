//Miranda Dorosz
package pieces;

import board.Square;
import board.Board;

public class Queen extends Piece {
    int xt,yt;
    public Queen(int x, int y, char c, String color) {
        super(x, y, c, color);
        c = 'Q';
    }

    @Override   
    public boolean canMoveTo(int x, int y,Board board) {
        if(x > this.x && y == this.y) { //move right            
            if (lowCh("right",xt, yt, x, y,board))
            {               
                return canTake(xt+1,yt,board);
            }else{
                return false;
            }            
        } else if (x < this.x && y == this.y) { //move left
            if(lowCh("left",xt, yt, x,y,board))
            {
                return canTake(xt,yt-1,board);
            }else{
                return false;
            }
        } else if(y > this.y && x == this.x) { //move down
            if (lowCh("down",xt, yt,x,y,board))
            {
                return canTake(xt-1,yt,board);
            }else{
                return false;
            }
        } else if(y < this.y && x == this.x) { //move up
            if (lowCh("up",xt,yt,x,y,board))
            {
                return canTake(xt,yt+1,board);
            }else{
                 return false;
            }
        }   else if (x > this.x && y > this.y){ //move up to the right
            if(lowCh("uright",xt+1,yt+1,x,y,board) == true)
            {
                return canTake(x,y,board) == true;
            }else{
                return false;
            }
        } else if (x > this.x && y < this.y){ //move down to the right
            if(lowCh("dright",xt+1,yt-1,x,y,board) == true)
            {
                return canTake(x,y,board) == true;
            }else{
                return false;
            }
        } else if (x < this.x && y > this.y){ //move up to the left
            if (lowCh("uleft",xt-1,yt+1,x,y,board) == true)
            {
                return canTake(x,y,board) == true;
            }else{
                return false;
            }
        } else if (x < this.x && y < this.y){ //move down to the left
            if (lowCh("dleft",xt-1,yt-1,x,y,board) == true)
            {
                return canTake(x,y,board) == true;
            }else{
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
    
    @Override
    public boolean lowCh(String Place, int x1, int y1, int x2, int y2, Board board)
    {
        switch (Place)
        {
            case "right":
            for (; x1<=x2; x1++)
            {
                if (board.getSquare(x1,y1).getPiece()==null)
                {
                    if (x1==x2-1)
                    {
                        return true;
                    }
                }else{
                    return false;
                }
            }
            case "left":
            for(; x1>=x2; x1--)
            {
                if (board.getSquare(x1,y1).getPiece()==null)
                {
                    if (x1==x2+1)
                    {
                        return true;
                    }
                }else{
                    return false;
                }
            }
            case "down":
            for(; y1==y2; y--)
            {
                if (board.getSquare(x1,y1).getPiece()==null)
                {
                    if (y1==y2+1)
                    {
                        return true;
                    }
                }else{
                    return false;
                }
            }
            case "up":
            for (; y1==y2; y1++)
            {
                if (board.getSquare(x1,y1).getPiece()==null)
                {
                    if (y1==y2-1)
                    {
                        return true;
                    }
                }else{
                    return false;
                }
            }       
            case "uright": 
            for(; x1<=x2 && y1<=y2; x1++,y1++)
            {
                if (board.getSquare(x1,y1).getPiece()==null)
                {
                     if (x1==x2-1 && y1==y2-1)
                     {
                         return true;
                     }
                }else{
                    return false;
                }
            }
            case "uleft":
            for(; x1>=x2 && y1<=y2; x1--,y1++)
            {
                if (board.getSquare(x1,y1).getPiece()==null)
                {
                    if (x1==x2+1 && y1==y2-1)
                    {
                        return true;
                    }
                }else{
                    return false;
                }
            }
            case "dright":
            for(; x1<=x2 && y1>=y2; x1++,y1--)
            {
                if (board.getSquare(x1,y1).getPiece()==null)
                {
                    if (x1==x2-1 && y1==y2+1)
                    {
                        return true;
                    }
                }else{
                    return false;
                }
            }
            case "dleft":
            for(; x1>=x2 && y1>=y2; x1--,y1--)
            {
                if (board.getSquare(x1,y1).getPiece()==null)
                {
                    if (x1==x2+1 && y1==y2+2)
                    {
                        return true;
                    }
                }else{   
                    return false;
                }
            }
            default: return false;
        }
    }
    
    @Override
    public boolean canTake(int x, int y,Board board)
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
    public void Threaten()
    {        
    
    }    
    
    @Override
    public void moveTo(int x, int y,Board board) {
        if (canMoveTo(x, y,board)) {
            this.x = x;
            this.y = y;
        } else {
            System.out.println("Error: Cannot move to requested spot.");
        }
    }
}
/*
    Can move in 1 direction as far as possible as long as it does 
    not move through any of her own pieces.
 */
