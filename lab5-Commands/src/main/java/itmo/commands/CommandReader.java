package itmo.commands;

import itmo.collection.MyTreeMap;
import itmo.io.Scannable;
import itmo.spacemarine.SpaceMarine;
import itmo.spacemarine.builders.SpaceMarineBuilder;
import itmo.spacemarine.builders.SpaceMarineConsoleBuilder;
import itmo.utils.MyException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * class that helps to read commands
 */
public class CommandReader {

    /** collection*/
    private final MyTreeMap<Integer, SpaceMarine> myTreeMap;

    /** constructor*/
    public CommandReader(MyTreeMap<Integer, SpaceMarine> myTreeMap) {
        this.myTreeMap = myTreeMap;
    }

    /** splits a string into words by spaces and will return an array of words as a sheet*/
    public List<String> split(String input) { //разделяет строчку на слова по пробелам
        List<String> result = new ArrayList<>(Arrays.asList(input.split(" "))); //конкретную строчку разделяем на лист
        result.removeIf(word -> word.equals("")); //проверяем каждое слово из массива, если оно пустое = пробелу, то удаляем его
        return result; //вернет массив слов в виде листа
    }

    /**
     * @param scannable
     * @param isReadFromConsole
     * @return
     * @throws MyException
     */
    public Command readCommand(Scannable scannable, boolean isReadFromConsole) throws MyException {
        String commandString = scannable.readLine();
        List<String> words = split(commandString);
        if (words.isEmpty()) {
            throw new MyException("Нет команды, строчка номер " + scannable.getLine());
        }

        String command = words.get(0);

        switch (command) {
            case "help":
                return new HelpCommand();
            case "info":
                return new InfoCommand(myTreeMap);
            case "insert": {
                if (words.size() < 2)
                    throw new MyException("Нет аргумента");
                SpaceMarine spaceMarine;
                if (isReadFromConsole)
                    spaceMarine = new SpaceMarineConsoleBuilder().build(scannable);
                else
                    spaceMarine = new SpaceMarineBuilder().build(scannable);
                return new InsertCommand(Integer.parseInt(words.get(1)), spaceMarine, myTreeMap);
            }
            case "clear":
                return new ClearCommand(myTreeMap);
            case "show":
                return new ShowCommand(myTreeMap);
            case "remove_key": {
                if (words.size() < 2)
                    throw new MyException("Нет аргумента");
                return new RemoveKeyCommand(myTreeMap, Integer.parseInt(words.get(1))); //parseInt из строчки в число
            }
            case "print_ascending": {
                return new PrintAscendingCommand(myTreeMap);
            }
            case "save": {
                return new SaveCommand(myTreeMap);
            }
            case "update": {
                if (words.size() < 2)
                    throw new MyException("Нет аргумента");
                SpaceMarine spaceMarine;
                if (isReadFromConsole)
                    spaceMarine = new SpaceMarineConsoleBuilder().build(scannable);
                else
                    spaceMarine = new SpaceMarineBuilder().build(scannable);

                return new UpdateCommand(spaceMarine, myTreeMap, Integer.parseInt(words.get(1)));
            }
            case "execute_script": {
                if (words.size() < 2)
                    throw new MyException("Нет аргумента");
                return new ExecuteScriptCommand(myTreeMap, words.get(1));
            }
            case "remove_greater": {
                if (words.size() < 2)
                    throw new MyException("Нет аргумента");
                SpaceMarine spaceMarine;
                if (isReadFromConsole)
                    spaceMarine = new SpaceMarineConsoleBuilder().build(scannable);
                else
                    spaceMarine = new SpaceMarineBuilder().build(scannable);
                return new RemoveGreaterCommand(spaceMarine, myTreeMap);
            }
            case "replace_if_lowe": {
                if (words.size() < 2)
                    throw new MyException("Нет аргумента");
                SpaceMarine spaceMarine;
                if (isReadFromConsole)
                    spaceMarine = new SpaceMarineConsoleBuilder().build(scannable);
                else
                    spaceMarine = new SpaceMarineBuilder().build(scannable);
                return new ReplaceIfLoweCommand(spaceMarine, myTreeMap, Integer.parseInt(words.get(1)));
            }
            case "remove_greater_key": {
                if (words.size() < 2)
                    throw new MyException("Нет аргумента");
                SpaceMarine spaceMarine;
                if (isReadFromConsole)
                    spaceMarine = new SpaceMarineConsoleBuilder().build(scannable);
                else
                    spaceMarine = new SpaceMarineBuilder().build(scannable);
                return new RemoveGreaterKeyCommand(Integer.parseInt(words.get(1)), spaceMarine, myTreeMap);
            }
            case "filter_contains_name": {
                if (words.size() < 2)
                    throw new MyException("Нет аргумента");
                return new FilterContainsNameCommand(myTreeMap, words.get(1));
            }
            case "print_field_ascending_chapter": {
                return new PrintFieldAscendingChapterCommand(myTreeMap);
            }
            case "exit": {
                return new ExitCommand();
            }
            default:
                throw new MyException("Нет такой команды: " + command);
        }
    }

}
