package itmo.commands;

import itmo.Main;
import itmo.collection.MyTreeMap;
import itmo.collection.serializers.MyTreeMapSerializer;
import itmo.spacemarine.SpaceMarine;

/**
 * save collection to file
 */
public class SaveCommand implements Command {
    private final MyTreeMap<Integer, SpaceMarine> myTreeMap;

    public SaveCommand(MyTreeMap<Integer, SpaceMarine> myTreeMap) {
        this.myTreeMap = myTreeMap;
    }

    /**
     * @throws Exception
     * execute through serializer
     */
    @Override
    public void execute() throws Exception {
        MyTreeMapSerializer serializer = new MyTreeMapSerializer(myTreeMap);
        serializer.serialize(Main.FILENAME);
    }
}
