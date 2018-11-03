package assign1.chessboard;

import board.*;
import pieces.*;
import java.io.IOException;
import java.util.Scanner;

/*
    Game Programming 4 | GAME 204
    Assignment 2: Saving and Loading
    
    Miranda Dorosz, Peter Russo, Marcus Di Domizio

 */
public class Chessboard {

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        String col = null, scan;
        SaveSystem saveS = new SaveSystem();
        boolean game = true, play1 = true, play2 = true;
        Board board = new Board();
        Piece pieceChosen = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome. Enter 'load' to load a previous game. Enter 'new' to start a new game. Enter 'end' at any time to exit the game.");
        scan = sc.next();

        if (scan.equalsIgnoreCase("load")) {
            System.out.println("Loading Game...");
            board.loadBoard(saveS);
            col = saveS.cLoad();
        } else if (scan.equalsIgnoreCase("new")) {
            System.out.println("New Game starting.");
            col = "white";
        } else {
            System.out.println("Ending Game, thank you for playing.");
        }

        while (game) {
            System.out.println("\nChoose your piece, Player " + col);
            while (play1) {
                System.out.println("X coordinate: ");
                scan = sc.next();
                if (scan.equalsIgnoreCase("end")) {
                    board.saveBoard();
                    saveS.cSave(col);
                    System.out.println("Ending Game, thank you for playing.");
                    System.exit(0);
                } else {
                    try {
                        x1 = Integer.parseInt(scan);
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input, please enter an integer or 'end'.");
                    }
                }

                System.out.println("Y coordinate: ");
                scan = sc.next();
                if (scan.equalsIgnoreCase("end")) {
                    board.saveBoard();
                    saveS.cSave(col);
                    System.out.println("Ending Game, thank you for playing.");
                    System.exit(0);
                } else {
                    try {
                        y1 = Integer.parseInt(scan);
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input, please enter an integer or 'end'.");
                    }
                }

                if (board.getSquare(x1, y1).getPiece() == null) {
                    System.out.println("No piece there.");
                } else {
                    pieceChosen = board.getSquare(x1, y1).getPiece();

                    if (pieceChosen.getColour().equalsIgnoreCase(col)) {
                        System.out.println("You have selected " + pieceChosen.getChar());
                        play1 = false;
                    } else {
                        System.out.println("Wrong color.");
                    }
                }
            }
            System.out.println("Where would you like to move to?");
            while (play2) {
                System.out.println("X coordinate: ");
                scan = sc.next();
                if (scan.equalsIgnoreCase("end")) {
                    board.saveBoard();
                    saveS.cSave(col);
                    System.out.println("Ending Game, thank you for playing.");
                    System.exit(0);
                } else {
                    try {
                        x2 = Integer.parseInt(scan);
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input, please enter an integer or 'end'.");
                    }
                }
                System.out.println("Y coordinate: ");
                scan = sc.next();
                if (scan.equalsIgnoreCase("end")) {
                    board.saveBoard();
                    saveS.cSave(col);
                    System.out.println("Ending Game, thank you for playing.");
                    System.exit(0);
                } else {
                    try {
                        y2 = Integer.parseInt(scan);
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input, please enter an integer or 'end'.");
                    }
                }

                if (pieceChosen.getChar() == 'Q') {
                    Queen pieceChosenQ = new Queen(x1, y1, 'Q', col);
                    if (pieceChosenQ.canMoveTo(x2, y2, board)) {
                        board.CheckSqu(x2, y2);
                        board.setSquareP(x1, y1, null);
                        pieceChosen.moveTo(x2, y2);
                        board.setSquareP(x2, y2, pieceChosen);
                        play2 = false;
                    } else {
                        System.out.println("Invalid movement Q");
                    }
                    
                } else if(pieceChosen.getChar() == 'B') {
                    pieceChosen.setter (x1,y1);
                    if (pieceChosen.canMoveTo(x2, y2))
                    {
                    board.setSquareP(x1, y1, null);
                    board.CheckSqu(x2, y2);
                    pieceChosen.moveTo(x2, y2);
                    board.setSquareP(x2, y2, pieceChosen);
                    play2 = false;        
                    }
                    else
                    {
                        System.out.println("error on bishop move");
                    }
                }
                    else if (pieceChosen.canMoveTo(x2, y2) && pieceChosen.getChar() != 'Q') {
                    board.setSquareP(x1, y1, null);
                    board.CheckSqu(x2, y2);
                    pieceChosen.moveTo(x2, y2);
                    board.setSquareP(x2, y2, pieceChosen);
                    play2 = false;
                } else {
                    System.out.println("Invalid movement");
                }
            }
            switch (col) {
                case "white":
                    col = "black";
                    play1 = true;
                    play2 = true;
                    break;
                case "black":
                    col = "white";
                    play1 = true;
                    play2 = true;
                    break;
                default:
                    break;
            }
        }
    }
}
