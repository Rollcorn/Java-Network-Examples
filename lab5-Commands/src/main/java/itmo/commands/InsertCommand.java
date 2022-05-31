package itmo.commands;

import itmo.collection.MyTreeMap;
import itmo.spacemarine.SpaceMarine;

/**
 * add new element with given key
 */
public class InsertCommand implements Command {
    private final Integer key;
    private final SpaceMarine spaceMarine;
    private final MyTreeMap<Integer, SpaceMarine> myTreeMap;

    public InsertCommand(Integer key, SpaceMarine spaceMarine, MyTreeMap<Integer, SpaceMarine> myTreeMap) {
        this.key = key;
        this.spaceMarine = spaceMarine;
        this.myTreeMap = myTreeMap;
    }

    @Override
    public void execute() {
        myTreeMap.put(key, spaceMarine);
        //добавить новый элемент с заданным ключом
    }
}
