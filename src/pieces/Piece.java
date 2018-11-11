
package pieces;

import board.*;
import java.io.Serializable;

public abstract class Piece implements Serializable {
    protected int x, y;
    protected char c;
    protected String Colour;
    
    abstract public boolean canMoveTo(int x, int y, Board board);
    abstract public boolean canTake(int x, int y, Board board);
    abstract public void moveTo(int x, int y, Board board);
    abstract public boolean lowCh(String ex,int x1,int y1, int x2, int y2, Board board);
    abstract public void setter(int x, int y);
    abstract public void Threaten(Board board);
    
    
    
    public Piece(int x, int y, char c, String colour) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.Colour = colour;
    }    
    
    public String getColour()
    {
        return Colour;
    }
    
    public char getChar() {
        return c;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
}
