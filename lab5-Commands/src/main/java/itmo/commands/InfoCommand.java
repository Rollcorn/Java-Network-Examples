package itmo.commands;

import itmo.collection.MyTreeMap;

/**
 * print information about the collection to standard output
 */
public class InfoCommand implements Command {
    private final MyTreeMap<?, ?> myTreeMap; // тип может быть любой, экземпляр класса myTreeMap

    public InfoCommand(MyTreeMap<?, ?> myTreeMap) { //  в конструктор передаю объект типа MyTreeMap с названием myTreeMap
        this.myTreeMap = myTreeMap; //из 6 строчки приравниваем араметр 7 строчки
    }

    @Override
    public void execute() {
        System.out.println("Тип коллекции: " + myTreeMap.getClass().getSuperclass().getSimpleName());
        System.out.println("Количество элементов: " + myTreeMap.size());
        System.out.println("Дата инициализации: " + myTreeMap.getCreationDate());
    }
}
