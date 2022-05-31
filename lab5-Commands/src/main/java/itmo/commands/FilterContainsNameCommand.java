package itmo.commands;

import itmo.collection.MyTreeMap;
import itmo.spacemarine.SpaceMarine;


/**
 * display elements whose name field value contains the given substring
 */
public class FilterContainsNameCommand implements Command {
    //вывести элементы, значение поля name которых содержит заданную подстроку
    private final MyTreeMap<Integer, SpaceMarine> myTreeMap;
    private final String name;

    public FilterContainsNameCommand(MyTreeMap<Integer, SpaceMarine> myTreeMap, String name) {
        this.myTreeMap = myTreeMap;
        this.name = name;
    }

    /**
     * execute command and filter elements
     */
    @Override
    public void execute() { // получаем все элементы, фильтруем их: оставляем там только те спейсмарины, имя которых равно переданному
        myTreeMap.getValueList()
                .stream()
                .filter(spaceMarine -> spaceMarine.getName().equals(name))
                .forEach(System.out::println);
    }
}
