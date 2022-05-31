package itmo.commands;

import itmo.collection.MyTreeMap;
import itmo.spacemarine.SpaceMarine;

/**
 * remove from the collection all elements greater than the given
 */
public class RemoveGreaterCommand implements Command {
    private final SpaceMarine spaceMarine; //элемент, который он вводит
    private final MyTreeMap<Integer, SpaceMarine> myTreeMap; //все коллекция, в ней мы будем удалять элементы, превышающий заданный

    public RemoveGreaterCommand(SpaceMarine spaceMarine, MyTreeMap<Integer, SpaceMarine> myTreeMap) {
        this.spaceMarine = spaceMarine;
        this.myTreeMap = myTreeMap;
    }


    /**
     * get a set of keys, filter them by health and for the remaining objects removes the objects with that key
     */
    @Override
    public void execute() { // keySet - получаем множество ключей, фильтруем их по ключу и оставляет только то, что удоволитворяет условию: получаем объект по ключу из майтримепа get(key), от этого объекта вызываем функцию и сравниваем их.
        myTreeMap.keySet().stream().filter(key -> myTreeMap.get(key).compareTo(spaceMarine) > 0).forEach(key1 -> myTreeMap.remove(key1)); //для каждого оставшегося ключа из майтримепа удаляет объекты с таким ключом
    }
}
