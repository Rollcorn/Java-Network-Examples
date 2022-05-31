package itmo.commands;

import itmo.collection.MyTreeMap;
import itmo.io.FIleScan;
import itmo.io.Scannable;
import itmo.spacemarine.SpaceMarine;
import itmo.utils.ExecuteFilesHistory;
import itmo.utils.MyException;

import java.io.File;

/**
 * read and execute a script from the specified file
 */
public class ExecuteScriptCommand implements Command {

    private final MyTreeMap<Integer, SpaceMarine> myTreeMap;
    private final String filename;

    public ExecuteScriptCommand(MyTreeMap<Integer, SpaceMarine> myTreeMap, String filename) {
        this.myTreeMap = myTreeMap;
        this.filename = filename;
    }

    /**
     * execute read from file
     * @throws Exception
     */
    @Override
    public void execute() throws Exception {
        File file = new File(filename);
        if (!file.canRead())
            throw new MyException("Не могу прочитать из файлика(((");
        if (ExecuteFilesHistory.contains(file))
            throw new MyException("С днем рекурсии!");
        ExecuteFilesHistory.add(file);
        CommandReader commandReader = new CommandReader(myTreeMap);
        Scannable scannable = new FIleScan(filename);
        while (scannable.hasNext()) { // тут трай кетч, чтобы команды при ошибке продолжались читать
            try {
                commandReader.readCommand(scannable, false).execute();
            } catch (Exception e) {
                System.out.println("Ой упс, ошибочка на строчке " + scannable.getLine() + " в файле " + filename + ": " + e.getMessage());
            }
        }
        ExecuteFilesHistory.remove(file);
    }
}