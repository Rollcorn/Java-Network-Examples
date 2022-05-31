package itmo.commands;

import itmo.collection.MyTreeMap;
import itmo.spacemarine.SpaceMarine;

/**
 * remove from the collection all elements whose key is greater than the given one
 */
public class RemoveGreaterKeyCommand implements Command {
    private final Integer key;
    private final SpaceMarine spaceMarine;
    private final MyTreeMap<Integer, SpaceMarine> myTreeMap;

    public RemoveGreaterKeyCommand(Integer key, SpaceMarine spaceMarine, MyTreeMap<Integer, SpaceMarine> myTreeMap) {
        this.key = key;
        this.spaceMarine = spaceMarine;
        this.myTreeMap = myTreeMap;
    }

    /**
     * like the previous method, but filters by keys
     */
    @Override
    public void execute() { // как предыдущий метод, только фильтруем относительно ключей
        myTreeMap.keySet().stream().filter(key1 -> key1.compareTo(key) > 0).forEach(key1 -> myTreeMap.remove(key1));
    }
}
