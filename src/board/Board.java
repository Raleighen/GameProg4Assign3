package board;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import pieces.*;


public class Board implements Serializable {

    protected int x;
    protected int y;
    Square gameBoard[][] = new Square[8][8];
    public ArrayList<Piece> allsi = new ArrayList<>();

    //constructor
    public Board() {
        //creates an 8x8 game board with alternating white and black squares
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                //Start Rook
                if ((i == 0 && j == 0) || (i == 7 && j == 0)) { 
                    Piece rook = new Rook(i, j, 'R', "black");                   
                    initSquare(i, j, rook);
                    allsi.add (rook);  
                } else if((i == 0 && j == 7) || (i == 7 && j == 7)) {
                    Piece rook = new Rook(i, j, 'R', "white");
                    initSquare(i, j, rook); //End Rook
                    allsi.add (rook);  
                } 
                //Start Knight
                else if((i == 1 && j == 0) || (i == 6 && j == 0)) {
                    Piece knight = new Knight(i, j, 'N', "black");
                    initSquare(i, j, knight);
                    allsi.add (knight);  
                } else if((i == 1 && j == 7) || (i == 6 && j == 7)) {
                    Piece knight = new Knight(i, j, 'N', "white");
                    initSquare(i, j, knight); //End Knight
                    allsi.add (knight);
                }
                //Start Bishop
                else if ((i == 2 && j == 0) || (i == 5 && j == 0)) {
                    Piece bishop = new Bishop(i, j, 'B', "black");
                    initSquare(i, j, bishop);
                    allsi.add (bishop);
                } else if ((i == 2 && j == 7) || (i == 5 && j == 7)) {
                    Piece bishop = new Bishop(i, j, 'B', "white");
                    initSquare(i, j, bishop); //End Bishop
                    allsi.add (bishop);
                }
                //Start Queen
                else if(i == 3 && j == 0) {
                    Piece queen = new Queen(i, j, 'Q', "black");
                    initSquare(i, j, queen);
                    allsi.add (queen);
                } else if (i == 3 && j == 7) {
                    Piece queen = new Queen(i, j, 'Q', "white");
                    initSquare(i, j, queen); //End Queen
                    allsi.add (queen);
                }
                //Start King
                else if(i == 4 && j == 0) {
                    Piece king = new King(i, j, 'K', "black");
                    initSquare(i, j, king);
                    allsi.add (king);
                } else if(i == 4 && j == 7) {
                    Piece king = new King(i, j, 'K', "white");
                    initSquare(i, j, king); //End King
                    allsi.add (king);
                }
                //Start Pawn
                else if (j == 1) { 
                    Piece pawn = new Pawn(i, j, 'P', "black");
                    initSquare(i, j, pawn);
                    allsi.add (pawn);
                } else if (j == 6) {
                    Piece pawn = new Pawn(i, j, 'P', "white");
                    initSquare(i, j, pawn); //End Pawn
                    allsi.add (pawn);
                }
                //Start empty spaces
                else {
                    initSquare(i, j, null);
                    
                }
            }
        }
    }
    
    public void loadBoard(SaveSystem saveS) throws IOException, ClassNotFoundException {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                File file = new File(i + "," + j + "square.ser");
                setSquare(i, j, saveS.sLoad(file));
            }
        }
    }
    
    public void saveBoard() throws IOException {
        SaveSystem saveS = new SaveSystem();
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                File file = new File(i + "," + j + "square.ser");
                saveS.sSave(file, gameBoard[i][j]);
            }
        }
    }

    //logic for initializing squares based on even/odd
    private void initSquare(int i, int j, Piece piece) {
            this.gameBoard[i][j] = new Square(i, j, piece);
    }
    
    //used to get what is at this location
    public Square getSquare(int x, int y) {
        return gameBoard[x][y];
    }
    public void remSquare(int x, int y) {
        initSquare(x, y, null);
    }
    
    public void setSquareP(int x, int y, Piece piece) {
        this.gameBoard[x][y].setSquare(x, y, piece);
    }
    
    //method for setting when loading
    public void setSquare(int x, int y, Square square) {
        this.gameBoard[x][y].setSquare(square);
    }
    
    // for checking to see if a piece is taken and then saying what was taken
    public void CheckSqu (int x, int y)
    {
        getSquare(x,y);
        if (getSquare(x,y).getPiece() != null)
        {
            System.out.println("You have taken" + getSquare(x,y).getPiece());
            allsi.remove(getSquare(x,y).getPiece());
        }
    }
}
