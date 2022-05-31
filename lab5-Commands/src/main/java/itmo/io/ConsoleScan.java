package itmo.io;

import java.util.Scanner;

/**
 * scan from console
 */
public class ConsoleScan implements Scannable {

    private final Scanner scanner;
    private int lines = 0;

    public ConsoleScan() {
        this.scanner = new Scanner(System.in);
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
