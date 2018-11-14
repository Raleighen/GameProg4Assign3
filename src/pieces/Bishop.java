
package pieces;

import java.io.Serializable;
import board.*;

public class Bishop extends Piece implements Serializable {
    
    int xt,yt;
    int tempx, tempy;
    public Bishop(int x, int y, char c, String color) {
        super(x, y, c, color);
        c = 'B';
    }

    @Override
    public boolean canMoveTo(int x, int y, Board board) {
        //this piece can only move diagonally any number of spaces
        
        if (x > this.x && y > this.y){ //move up to the right
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
    
    //idea: create a for loop to check cheack tile the piece is moving to see if there is a piece already there
    @Override
    public boolean lowCh(String Place,int x1, int y1, int x2,int y2, Board board)
    {
        switch(Place.toLowerCase())
        {           
            //experiment to check to see if there is a piece in the way
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
        default:
        return false;
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
    public void Threaten(Board board)
    {
        
        switch (Colour.toLowerCase())
        {
            case "white":
                tempx = this.x;
                tempy = this.y;
                    while(board.getSquare(tempx,tempy).getPiece() == null && tempx <= 7 && tempy <= 7)
                    {
                        board.getSquare(tempx,tempy).wt = board.getSquare(tempx,tempy).wt +1; 
                        tempx = tempx +1;
                        tempy = tempy +1;
                    }
                tempx = this.x;
                tempy = this.y;
                    while(board.getSquare(tempx,tempy).getPiece() == null && tempx >= 0 && tempy <= 7)
                    {
                       board.getSquare(tempx,tempy).wt = board.getSquare(tempx,tempy).wt +1; 
                       tempx = tempx -1;
                       tempy = tempy +1;
                    }
                tempx = this.x;
                tempy = this.y;
                    while(board.getSquare(tempx,tempy).getPiece() == null && tempx <= 7 && tempy >= 0)
                    {
                         board.getSquare(tempx,tempy).wt = board.getSquare(tempx,tempy).wt +1;
                         tempx = tempx +1;
                         tempy = tempy -1;
                    }
                tempx = this.x;
                tempy = this.y;
                    while(board.getSquare(tempx,tempy).getPiece() == null && tempx >= 0 && tempy >= 0)
                    {
                      board.getSquare(tempx,tempy).wt = board.getSquare(tempx,tempy).wt +1;
                      tempx = tempx -1;
                      tempy = tempy -1;
                    }               
            case "black":
                tempx = this.x;
                tempy = this.y;
                    while(board.getSquare(tempx,tempy).getPiece() == null && tempx <= 7 && tempy <= 7)
                    {
                    board.getSquare(tempx,tempy).bt = board.getSquare(tempx,tempy).bt +1; 
                    tempx = tempx +1;
                    tempy = tempy +1;
                    }
                tempx = this.x;
                tempy = this.y;
                    while(board.getSquare(tempx,tempy).getPiece() == null && tempx <=7 && tempy >= 0)
                    {
                       board.getSquare(tempx,tempy).bt = board.getSquare(tempx,tempy).bt +1; 
                       tempx = tempx +1;
                       tempy = tempy -1;
                    }
                tempx = this.x;
                tempy = this.y;
                    while(board.getSquare(tempx,tempy).getPiece() == null && tempx >= 0 && tempy <= 7)
                    {
                         board.getSquare(tempx,tempy).bt = board.getSquare(tempx,tempy).bt +1;
                         tempx = tempx -1;
                         tempy = tempy +1;
                    }
                tempx = this.x;
                tempy = this.y;
                    while(board.getSquare(tempx,tempy).getPiece() == null && tempx >= 0 && tempy >= 0)
                    {
                      board.getSquare(tempx,tempy).bt = board.getSquare(tempx,tempy).bt +1;  
                      tempx = tempx -1;
                      tempy = tempy -1;
                    }    
        }
    }
    
    
    @Override
    public void moveTo(int x, int y,Board board) {
        if (canMoveTo(x, y,board)){
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
    
}
