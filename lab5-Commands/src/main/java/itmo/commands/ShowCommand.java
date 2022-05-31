package itmo.commands;

import itmo.collection.MyTreeMap;

/**
 * print to standard output all elements of the collection in string representation
 */
public class ShowCommand implements Command {
    private final MyTreeMap<?, ?> myTreeMap;

    public ShowCommand(MyTreeMap<?, ?> myTreeMap) {
        this.myTreeMap = myTreeMap;
    }

    /**
     * output each key value
     */
    @Override
    public void execute() {
        myTreeMap.forEach((key, value) -> System.out.println("Key: " + key + "\nElement: " + value.toString())); //выводим каждое ключ значение(где ключ мы сами задаем, а значение это сам объект) с помощью лямбда
    }
}
