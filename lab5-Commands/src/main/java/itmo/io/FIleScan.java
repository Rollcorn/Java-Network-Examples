package itmo.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * scan from file
 */
public class FIleScan implements Scannable {
    private final Scanner scanner;
    private int lines = 0;

    public FIleScan(String filename) throws FileNotFoundException {
        this.scanner = new Scanner(new File(filename));
    }

    @Override
    public String readLine() {
        if (!hasNext())
            System.exit(1);
        ++lines;
        return scanner.nextLine();
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }

    @Override
    public int getLine() {
        return lines;
    }
}
