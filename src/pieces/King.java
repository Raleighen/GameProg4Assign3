//Miranda Dorosz
package pieces;

import java.io.Serializable;

public class King extends Piece implements Serializable {

    public King(int x, int y, char c, String color) {
        super(x, y, c, color);
        c = 'K';
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        //if piece wants to move diagonally || left/right || up/down
        if((this.x + 1 == x && this.y + 1 == y) || (this.x - 1 ==x && this.y - 1 == y)
        || ((this.x + 1 == x && this.y == y) || (this.x - 1 == x && this.y == y)) 
        || ((this.x == x && this.y + 1 == y) || (this.x == x && this.y - 1 == y))) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void moveTo(int x, int y) {
        //if the piece can move
        if(canMoveTo(x, y)) {
            this.x = x;
            this.y = y;
        } else {
                System.out.println("Error: Cannot move to requested spot.");
            }
        }
    }
    

/*
    Can only move 1 sq in any direction (including diagonals).
    Cannot move into check
*/