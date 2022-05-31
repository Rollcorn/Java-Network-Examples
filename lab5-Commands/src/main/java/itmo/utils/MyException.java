package itmo.utils;

/**
 * catch exceptions
 */
public class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super(message); //в классе родители есть конструктор, который присваивает значение сообщению
    }
}
