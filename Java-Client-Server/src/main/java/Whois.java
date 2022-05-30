import java.net.*;
import java.io.*;

class Whois {
    public static void main(String args[]) throws Exception {
        int с;
        // создать сокетное соединение с
        // веб-сайтом internic.net через порт 43
        try ( Socket s = new Socket ( "whois. internic. net", 43) ) {
            // получить потоки ввода-вывода
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            // сформировать строку запроса
            String str = (args.length == 0 ? "OraclePressBooks.com" : args[0])
                    + "\n";
            //преобразовать строку запроса в байты
            byte buf[] = str.getBytes();
            //послать запрос
            out.write(buf);
            // прочитать ответ и вывести его на экран
            while ((с = in.read()) != -1)
                System.out.print((char) с);

        }
        // Теперь сокет закрыт
    }
}