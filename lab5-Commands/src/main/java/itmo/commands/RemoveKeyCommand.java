package itmo.commands;

import itmo.collection.MyTreeMap;

/**
 * remove an element from a collection by its key
 */
public class RemoveKeyCommand implements Command {
    private final MyTreeMap<Integer, ?> myTreeMap;
    private final Integer key;

    public RemoveKeyCommand(MyTreeMap<Integer, ?> myTreeMap, Integer key) {
        this.myTreeMap = myTreeMap;
        this.key = key;
    }

    @Override
    public void execute() {
        myTreeMap.remove(key);
    }
}
