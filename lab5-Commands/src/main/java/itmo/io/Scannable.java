package itmo.io;

/**
 * interface that helps to read from any place
 */
public interface Scannable {
    String readLine();

    boolean hasNext();

    void close();

    int getLine();
}
