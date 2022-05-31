package itmo.commands;

import itmo.collection.MyTreeMap;
import itmo.spacemarine.SpaceMarine;
import itmo.spacemarine.comparators.SpaceMarineComparator;

import java.util.List;

/**
 * display the elements of the collection in ascending order
 */
public class PrintAscendingCommand implements Command {
    private final MyTreeMap<Integer, SpaceMarine> myTreeMap;


    public PrintAscendingCommand(MyTreeMap<Integer, SpaceMarine> myTreeMap) {
        this.myTreeMap = myTreeMap;

    }

    /**
     * get elements in the sheet, filter them and execute the command
     */
    @Override
    public void execute() {
        List<SpaceMarine> listOfSpaceMarine = myTreeMap.getValueList(); //получаем все элементы и записываем их в лист
        listOfSpaceMarine.sort(new SpaceMarineComparator()); // sort требует объект типа компаратор
        listOfSpaceMarine.forEach(spaceMarine -> System.out.println(spaceMarine.toString()));
    }
}
