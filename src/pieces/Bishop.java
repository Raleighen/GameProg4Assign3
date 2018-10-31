
package pieces;

import java.io.Serializable;

public class Bishop extends Piece implements Serializable {
    public Bishop(int x, int y, char c, String color) {
        super(x, y, c, color);
        c = 'B';
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        //this piece can only move diagonally any number of spaces
        
        if (x > this.x && y > this.y){ //move up to the right
            return true;
        } else if (x > this.x && y < this.y){ //move down to the right
            return true;
        } else if (x < this.x && y > this.y){ //move up to the left
            return true;
        } else if (x < this.x && y < this.y){ //move down to the right
            return true;
        } else {
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
