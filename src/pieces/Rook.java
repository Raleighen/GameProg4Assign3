//Miranda Dorosz
package pieces;

public class Rook extends Piece{
    
    public Rook(int x, int y, char c, String color) {
        super(x, y, c, color);
        c = 'R';
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        if(x > this.x && y == this.y) { //move right
            return true;
        } else if (x < this.x && y == this.y) { //move left
            return true;
        } else if(y > this.y && x == this.x) { //move down
            return true;
        } else if(y < this.y && x == this.x) { //move up
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void moveTo(int x, int y) {
        if(canMoveTo(x, y)) {
            this.x = x;
            this.y = y;
        }
        else {
            System.out.println("Error: Cannot move to requested spot.");
        }
    }
    
}

/*
    Can move as far as it wants but only forward, back, or to the sides
    (no diagonals).
*/