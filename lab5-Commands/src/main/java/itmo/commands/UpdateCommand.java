package itmo.commands;

import itmo.collection.MyTreeMap;
import itmo.spacemarine.SpaceMarine;
import itmo.utils.MyException;

import java.util.Optional;

/**
 * update the value of the collection element whose id is equal to the given one
 */
public class UpdateCommand implements Command {
    private final SpaceMarine spaceMarine; //объект, который мы хотим исправить
    private final MyTreeMap<Integer, SpaceMarine> myTreeMap; //хранятся все объекты
    private final int id;

    public UpdateCommand(SpaceMarine spaceMarine, MyTreeMap<Integer, SpaceMarine> myTreeMap, Integer id) {
        this.spaceMarine = spaceMarine;
        this.myTreeMap = myTreeMap;
        this.id = id;
    }

    /**
     * @throws Exception
     * delete the old object, but keep its id and update the object
     */
    //1. ищем по всем ключам определенный, у элемента которого айди то, которое я передала
    @Override
    public void execute() throws Exception {
        Optional<Integer> any = myTreeMap.keySet().stream().filter(key -> myTreeMap.get(key).getId() == id).findAny(); //any - это объект, в котором хранится, optional проверяет, есть ли что-то в any
        if (!any.isPresent()) { //проверяем, не пустой ли объект
            throw new MyException("Не существует элемента с таким айди");
        }
        myTreeMap.remove(any.get()); //полностью удаляем объект старый
        spaceMarine.setId(id); // в переданном объекте обновляем значение на изначальное айди, а не оставляем то, что передал пользователь
        myTreeMap.put(any.get(), spaceMarine); //any.get() добавили гет, чтобы вернулся тип Integer, а не Optional
    }

}
