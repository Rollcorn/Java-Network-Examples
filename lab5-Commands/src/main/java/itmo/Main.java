package itmo;

import itmo.collection.MyTreeMap;
import itmo.collection.deserializers.MyTreeMapDeserializer;
import itmo.commands.CommandReader;
import itmo.io.ConsoleScan;
import itmo.io.Scannable;
import itmo.spacemarine.SpaceMarine;

public class Main {

    /**
     * file name
     */
    public static String FILENAME;

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Ой ой ой, не могу найти имя файла");
            System.exit(1);
        }
        FILENAME = args[0];
        MyTreeMap<Integer, SpaceMarine> myTreeMap = new MyTreeMap<>();

        try {
            myTreeMap = new MyTreeMapDeserializer().deserialize(FILENAME);
        } catch (Exception e) {
            System.out.println("Не повучивось достать из файлика ((((");
        }

        CommandReader commandReader = new CommandReader(myTreeMap);
        Scannable scannable = new ConsoleScan();



        while (true) {
            try {
                System.out.println("Введи в меня команду... пж...:");
                commandReader.readCommand(scannable, true).execute();
            } catch (Exception e) {
                System.out.println("Упсссс, что-то явно пошло не так ((. " + e.getMessage());
            }
        }
    }
}
