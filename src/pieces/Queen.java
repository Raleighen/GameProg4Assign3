//Miranda Dorosz
package pieces;

import board.Square;
import board.Board;

public class Queen extends Piece {

    public Queen(int x, int y, char c, String color) {
        super(x, y, c, color);
        c = 'Q';
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        //Queen needs to use the canMoveTo with the Board parameter.
        System.out.println("When calling for a queen piece, please also include the Board parameter.");
        return false;
    }
    
    public boolean canMoveTo(int x, int y, Board board) {
        if (x > this.x && y == this.y) { //move right
            for (int i = this.x; i < x; i++) {
                //check if there is a piece between this and the destination
                if (board.getSquare(i, this.y).getPiece() != null) {
                    //if yes, move to the piece or say invalid?
                    return false;
                } else { //if no, return true
                    return true;
                }
            }
        } else if (x < this.x && y == this.y) { //move left
            for (int i = this.x; i > x; i--) {
                if (board.getSquare(i, this.y).getPiece() != null) {
                    return false;
                } else {
                    return true;
                }
            }
        } else if (x == this.x && y < this.y) { //move up
            for (int i = this.y; i < y; i++) {
                if (board.getSquare(this.x, i).getPiece() != null) {
                    return false;
                } else {
                    return true;
                }
            }
        } else if (x == this.x && y > this.y) { //move down
            for (int i = this.y; i > y; i--) {
                if (board.getSquare(this.x, i).getPiece() != null) {
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }
    @Override
    public void setter(int a, int b)
    {
        
    }
    @Override
    public boolean lowCh(String Place, int x1, int y1, int x2, int y2)
    {
        return false;
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
/*
    Can move in 1 direction as far as possible as long as it does 
    not move through any of her own pieces.
 */
