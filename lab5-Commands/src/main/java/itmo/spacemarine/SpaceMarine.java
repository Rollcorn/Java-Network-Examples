package itmo.spacemarine;

import com.fasterxml.jackson.annotation.JsonFormat;
import itmo.utils.MyException;

import java.time.LocalDateTime;

/**
 * Class SpaceMarin
 * add comparable to compare elements from SpaceMarine
 */
public class SpaceMarine implements Comparable<SpaceMarine> { //добавили Comparable, чтобы сравнивать два экземпляра класса SpaceMarine
    /** id spaceMarine*/
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    /** name of spaceMarine*/
    private String name; //Поле не может быть null, Строка не может быть пустой
    /** coordinates of spaceMarine*/
    private Coordinates coordinates; //Поле не может быть null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    /** creation time of file*/
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    /** health spaceMarine*/
    private double health; //Значение поля должно быть больше 0
    /** loyal of spaceMarine*/
    private boolean loyal;
    /** astertes Category of spaceMarine*/
    private AstartesCategory category; //Поле не может быть null
    /** caterory of weapon spaceMarine*/
    private MeleeWeapon meleeWeapon; //Поле не может быть null
    /** chapter of spaceMarine*/
    private Chapter chapter; //Поле может быть null

    /**
     * @return get id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     * @throws MyException
     * set id
     */
    public void setId(int id) throws MyException {

        if (id <= 0) {
            throw new MyException("Айди должен быть больше 0");
        }

        this.id = id;

    }

    /**
     * @return get name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     * set name
     * @throws MyException
     */
    public void setName(String name) throws MyException {

        if (name == null || name.equals("")) {
            throw new MyException("Имя не должно быть пустым");
        }

        this.name = name;
    }

    /**
     * @return coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) throws MyException {
        if (coordinates == null) {
            throw new MyException("Координаты не должны быть пустыми");
        }
        this.coordinates = coordinates;
    }

    /**
     * @return creation Date
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) throws MyException {
        if (creationDate == null) {
            throw new MyException("Дата не должна быть пустой");
        }
        this.creationDate = creationDate;
    }

    /**
     * @return health
     */
    public double getHealth() {
        return health;
    }

    /**
     * @param health
     * @throws MyException
     * set Health
     */
    public void setHealth(double health) throws MyException {
        if (health <= 0) {
            throw new MyException("Здоровье должно быть больше 0");
        }
        this.health = health;
    }

    /**
     * @return true or false loyal
     */
    public boolean isLoyal() {
        return loyal;
    }

    public void setLoyal(boolean loyal) {

        this.loyal = loyal;
    }

    /**
     * @return category
     */
    public AstartesCategory getCategory() {
        return category;
    }

    public void setCategory(AstartesCategory category) throws MyException {
        if (category == null) {
            throw new MyException("Категория не должна быть пустой");
        }
        this.category = category;
    }

    /**
     * @return get weapon
     */
    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public void setMeleeWeapon(MeleeWeapon meleeWeapon) throws MyException {
        if (meleeWeapon == null) {
            throw new MyException("Оружие не должно быть пустым");
        }
        this.meleeWeapon = meleeWeapon;
    }

    /**
     * @return chapter
     */
    public Chapter getChapter() {
        return chapter;
    }

    /**
     * @param chapter set chapter
     */
    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    /**
     * prints all data in a line
     */
    @Override
    public String toString() {
        return "Id: " + id +
                "\nName: " + name +
                "\nCoordinates: " + coordinates +
                "\nCreation date: " + creationDate +
                "\nHealth: " + health +
                "\nIs loyal: " + loyal +
                "\nCategory: " + category +
                "\nWeapon: " + meleeWeapon +
                "\nChapter: " + chapter;
    }

    /**
     * @param o
     * compare objects
     */
    @Override
    public int compareTo(SpaceMarine o) {
        if (o == null) { //сравниваем существующий объект, который точно не null. Если объект о null, то первый больше второго, поэтому возвращаем 1
            return 1;
        }
        return Double.compare(health, o.health); //здесь сравниваем здоровье, меньше -1, равно 0, больше 1
    }
}
