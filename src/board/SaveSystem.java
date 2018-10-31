package board;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveSystem {

    public SaveSystem() {
    }

    public void save(Board _board, String color) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream("board.ser")))) {
            out.writeObject(_board);
        }
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream("color.ser")))) {
            out.writeObject(color);
        }
        System.out.println("Game saved.");
        System.exit(0);
    }
    
    public void cSave(String color) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream("color.ser")))) {
            out.writeObject(color);
        }
    }
    
    public void sSave(File file, Square _square) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(file)))) {
            out.writeObject(_square);
        }
    }

    public String cLoad() throws IOException, ClassNotFoundException, FileNotFoundException {
        String color;
        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream("color.ser")))) {
            color = (String) in.readObject();
        }
        return color;
    }
    
    public Square sLoad(File file) throws IOException, ClassNotFoundException {
        Square _square;
        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(file)))) {
            _square = (Square) in.readObject();
        }
        return _square;
    }
}
