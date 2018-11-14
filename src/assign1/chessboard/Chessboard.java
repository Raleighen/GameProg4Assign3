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
        int WKingx = 4,WKingy = 7, BKingx = 4, BKingy = 0;
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


                    
                if(pieceChosen.getChar() == 'B' || pieceChosen.getChar() == 'R' || pieceChosen.getChar() == 'Q') {
                    pieceChosen.setter (x1,y1);
                    if (pieceChosen.canMoveTo(x2, y2, board))
                    {
                    board.setSquareP(x1, y1, null);
                    Scary(board);
                    //next call the isThreat() from the kings to see if they are in check now.
                    //if they are the move should be invalid and should reset with the setSquare being the same location as before.  
                        if ("white".equals(col) && board.getSquare(WKingx, WKingy).getPiece().Danger(board) == true || "black".equals(col) && board.getSquare(BKingx,BKingy).getPiece().Danger(board) == true)
                        {
                        board.CheckSqu(x2, y2); // this will kill any piece that is at the location.
                        pieceChosen.moveTo(x2, y2, board);
                        board.setSquareP(x2, y2, pieceChosen);
                        Scary(board);
                        play2 = false;
                        }else{
                        board.setSquareP(x1, y1, pieceChosen);
                        System.out.println("your king would be in check");
                        }
                    }else{
                        System.out.println("error on move");
                    }
                }
                else if(pieceChosen.getChar() == 'K'){
                    if (pieceChosen.canMoveTo(x2, y2, board))
                    {
                    board.setSquare(x1, y1, null);
                    Scary(board);
                        if ("white".equals(col) && board.getSquare(WKingx, WKingy).getPiece().Danger(board) == true || "black".equals(col) && board.getSquare(BKingx,BKingy).getPiece().Danger(board) == true)
                        {
                        board.CheckSqu(x2, y2); // this will kill any piece that is at the location.
                        pieceChosen.moveTo(x2, y2, board);
                        board.setSquareP(x2, y2, pieceChosen);
                        Scary(board);
                        switch (pieceChosen.getColour().toLowerCase())
                        {
                        case "white": WKingx = x2; WKingy = y2;
                    
                        case "black": BKingx = x2; BKingy = y2;
                        }
                        play2 = false;
                        }else{
                        board.setSquareP(x1, y1, pieceChosen);
                        System.out.println("your king would be in check");
                        }                   
                    }
                    else
                    {
                        System.out.println("error on move");
                    }
                    
                }
                //incase we need it again
                 //&& pieceChosen.getChar() != 'Q' || pieceChosen.getChar() == 'B' || pieceChosen.getChar() == 'R'
                else if (pieceChosen.canMoveTo(x2, y2, board)) {
                    board.setSquareP(x1, y1, null);
                    Scary(board);
                        if ("white".equals(col) && board.getSquare(WKingx, WKingy).getPiece().Danger(board) == true || "black".equals(col) && board.getSquare(BKingx,BKingy).getPiece().Danger(board) == true)
                        {
                        board.CheckSqu(x2, y2); // this will kill any piece that is at the location.
                        pieceChosen.moveTo(x2, y2, board);
                        board.setSquareP(x2, y2, pieceChosen);
                        Scary(board);
                        play2 = false;
                        }else{
                        board.setSquareP(x1, y1, pieceChosen);
                        System.out.println("your king would be in check");
                        }                         
                } else {
                    System.out.println("Invalid movement");
                }
                //need to now create a checkmate checker to finish it off.
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
    //idea is that it will loop and call threat for each piece.   
    public static void Scary(Board board)
    {
       Clean(board);
       for (int a = 0;board.allsi.size()>= a;a++)                   
       {                        
        //will need to activate it at a good time
        board.allsi.get(a).Threaten(board);
       }
    }
    public static void Clean(Board board) //cleaner
    {
        for (int i = 0; i<7; i++)
        {
            for (int j = 0; j<7; j++)
            {
                board.getSquare(i,j).wt = 0;
                board.getSquare(i, j).bt = 0;
            }
        }
    }
}
