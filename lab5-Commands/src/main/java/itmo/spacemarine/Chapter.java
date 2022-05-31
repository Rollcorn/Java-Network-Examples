package itmo.spacemarine;

import itmo.utils.MyException;

/**
 * chapter class
 */
public class Chapter implements Comparable<Chapter> {
    /**
     * chapter name
     */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /**
     * counts of spaceMarine
     */
    private Long marinesCount; //Поле может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 1000
    /**
     * name of the world
     */
    private String world; //Поле может быть null

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     * @throws MyException
     * check name and return it
     */
    public void setName(String name) throws MyException {
        if (name == null || name.equals("")) {
            throw new MyException("Поле не может быть пусто");
        }
        this.name = name;
    }

    /**
     * @return marinesCount
     */
    public Long getMarinesCount() {
        return marinesCount;
    }

    /**
     * @param marinesCount
     * @throws MyException
     * check marinesCount and return it
     */
    public void setMarinesCount(Long marinesCount) throws MyException {
        if (marinesCount != null && (marinesCount <= 0 || marinesCount > 1000)) {
            throw new MyException("Неправильно введено число кораблей");
        }

        this.marinesCount = marinesCount;
    }

    /**
     * @return name of the world
     */
    public String getWorld() {
        return world;
    }

    /**
     * @param world
     * set world
     */
    public void setWorld(String world) {
        this.world = world;
    }

    /**
     * @return string of name, marinesCounr and world
     */
    @Override
    public String toString() {
        return "Name: " + name +
                "\nMarinesCount: " + marinesCount +
                "\nWorld: " + world;
    }

    /**
     * @param o
     * @return
     * we can compare chapters by marineCounr
     */
    @Override
    public int compareTo(Chapter o) {
        if (o == null) {
            return 1;
        }
        return marinesCount.compareTo(o.marinesCount);
    }
}
