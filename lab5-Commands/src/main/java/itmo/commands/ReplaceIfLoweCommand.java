package itmo.commands;

import itmo.collection.MyTreeMap;
import itmo.spacemarine.SpaceMarine;

/**
 * replace value by key if new value is less than old
 */
public class ReplaceIfLoweCommand implements Command {
    private final SpaceMarine spaceMarine;
    private final MyTreeMap<Integer, SpaceMarine> myTreeMap;
    private final Integer key; //ключ старого объекта

    public ReplaceIfLoweCommand(SpaceMarine spaceMarine, MyTreeMap<Integer, SpaceMarine> myTreeMap, Integer key) {
        this.spaceMarine = spaceMarine;
        this.myTreeMap = myTreeMap;
        this.key = key;
    }


    @Override
    public void execute() {
        SpaceMarine spaceMarine01 = myTreeMap.get(key); //получаем старый объект по ключу
        if (spaceMarine.compareTo(spaceMarine01) < 0) {
            myTreeMap.replace(key, spaceMarine);
        }
    }
}
