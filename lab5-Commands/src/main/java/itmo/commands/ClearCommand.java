package itmo.commands;

import itmo.collection.MyTreeMap;

/** clear the collection*/
public class ClearCommand implements Command {

    /** collection*/
    private final MyTreeMap<?, ?> myTreeMap;


    /**
     * @param myTreeMap collection
     */
    public ClearCommand(MyTreeMap<?, ?> myTreeMap) {
        this.myTreeMap = myTreeMap;
    }

    /**
     * executes command
     */
    @Override
    public void execute() {
        myTreeMap.clear();
    }
}
