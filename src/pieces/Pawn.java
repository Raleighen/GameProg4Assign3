
package pieces;

import board.Board;
import java.io.Serializable;


public class Pawn extends Piece implements Serializable {
    private int move = 0;
    
    public Pawn(int x, int y, char c, String color) {
        super(x, y, c, color);
        c = 'P';
    }
    
    @Override
    public boolean canMoveTo(int x, int y) {
        
        if (move < 2) {
            switch (Colour.toLowerCase()){
                case "white":
                    if ((x == this.x && y == this.y - 1) || (x == this.x && y == this.y - 2)) { //move up 2 spaces if it is move 0
                        move++;
                        return true;
                    } else {
                        return false;
                    }
               case "black":
                    if ((x == this.x && y == this.y + 1) || (x == this.x && y == this.y + 2)) { //move up 2 spaces if it is move 0
                        move++;
                        return true;
                    } else {
                        return false;
                    }
               default:
                   return false;
            }
        } else {
            switch (Colour.toLowerCase()){
                case "white":
                    if ((x == this.x && y == this.y - 1)) { //move up 2 spaces if it is move 0
                        move++;
                        return true;
                    } else {
                        return false;
                    }
                case "black":
                    if ((x == this.x && y == this.y + 1)) { //move up 2 spaces if it is move 0
                        move++;
                        return true;
                    } else {
                        return false;
                    }
                default:
                    return false;
            }
        }
    }

    @Override
    public void moveTo(int x, int y) {
        if (canMoveTo(x, y)) {
            this.x = x;
            this.y = y;
        } else {
            System.out.println("Error: Cannot move to requested spot.");
        }
    }
}
