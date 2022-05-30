//Продемонстрировать применение класса HttpURLConnection
import java.net.*;
import java.io.*;
import java.util.*;
class HttpURLDemo
{
    public static void main(String args[]) throws Exception {
        URL hp = new URL("http://www.google.com");
        HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();

        // вывести метод запроса
        System.out.println("Meтoд запроса: "
                + hpCon.getRequestMethod());
        // вывести код ответа
        System.out.println("Koд ответа: "
                + hpCon.getResponseCode());
        // вывести ответное сообщение
        System.out.println("Oтвeтнoe сообщение: " + hpCon.getResponseMessage());

        // получить список полей и множество
        //ключей из заголовка
        Map<String, List<String>> hdrMap =
                hpCon.getHeaderFields();
        Set<String> hdrField = hdrMap.keySet();
        System.out.println("\nДaлee следует заголовок:");

        // вывести все ключи и значения из заголовка
        for (String k : hdrField) {
            System.out.println("Kлюч: " + k + "\n\tЗначение: "
                    + hdrMap.get(k) );
        }
    }
}
