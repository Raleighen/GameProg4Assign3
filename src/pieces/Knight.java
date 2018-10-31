
package pieces;

import java.io.Serializable;

public class Knight extends Piece implements Serializable {
    public Knight(int x, int y, char c, String color) {
        super(x, y, c, color);
        c = 'N';
    }

    @Override
    public boolean canMoveTo(int x, int y) {
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
    public void moveTo(int x, int y) {
        if (canMoveTo(x, y)){
            this.x = x;
            this.y = y;
        } else {
            System.out.println("Error: Cannot move to requested spot.");
        }
    }
}
