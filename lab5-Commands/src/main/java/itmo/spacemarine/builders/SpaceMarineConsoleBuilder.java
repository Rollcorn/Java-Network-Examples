package itmo.spacemarine.builders;

import itmo.io.Scannable;
import itmo.spacemarine.*;
import itmo.utils.MyException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

/**
 * same as SpaceMarineBuilder but though console. So, we can communicate with uset by it
 */
public class SpaceMarineConsoleBuilder { // билдер нужен, чтобы при неправильном вводе параметров, мы говорили пользователю, что он сделал неправильно
    private final SpaceMarine spaceMarine;

    public SpaceMarineConsoleBuilder() {
        spaceMarine = new SpaceMarine();
    }

    public SpaceMarine build(Scannable scannable) throws MyException {
        buildName(scannable);
        buildId();
        buildCreationDate();
        buildHealth(scannable);
        buildLoyal(scannable);
        buildCategory(scannable);
        buildMeleeWeapon(scannable);
        buildChapter(scannable);
        buildCoordinates(scannable);
        return spaceMarine;
    }

    public void buildName(Scannable scannable) {
        System.out.println("Введите имя корабля 👉👈");
        String name = scannable.readLine(); //забрали сторчку из scannable, а он из консоли
        try {
            spaceMarine.setName(name);
        } catch (Exception e) {
            System.out.println("Упс, вы неправильно ввели имя: " + e.getMessage());
            this.buildName(scannable);
        }
    }

    public void buildId() throws MyException {
        Random random = new Random();
        int id = -1;
        while (id <= 0)
            id = random.nextInt();
        spaceMarine.setId(id);
    }

    public void buildCreationDate() throws MyException {
        spaceMarine.setCreationDate(LocalDateTime.now()); // Мы хотим поставить время рандомно, а не пользователем. MyException мы не прописываем, потому что вряд ли выскочит ошибка
    }

    public void buildHealth(Scannable scannable) {
        System.out.println("Введите значения здоровья");
        String health = scannable.readLine();
        try {
            spaceMarine.setHealth(Double.parseDouble(health));
        } catch (Exception e) {
            System.out.println("Упс, вы неправильно ввели уровень здоровья: " + e.getMessage());
            this.buildHealth(scannable);
        }
    }

    public void buildLoyal(Scannable scannable) {
        System.out.println("Вы преданный?");
        String loyal = scannable.readLine();
        try {
            spaceMarine.setLoyal(Boolean.parseBoolean(loyal));
        } catch (Exception e) {
            System.out.println("Упс, вы не в том формате ответили на вопрос: " + e.getMessage());
            this.buildLoyal(scannable);
        }
    }

    public void buildCategory(Scannable scannable) {
        System.out.println("Введите категорию из предложенных: " + Arrays.toString(AstartesCategory.values()));
        String category = scannable.readLine();
        try {
            spaceMarine.setCategory(AstartesCategory.valueOf(category));
        } catch (Exception e) {
            System.out.println("Упс, вы неправильно ввели категорию" + e.getMessage());
            this.buildCategory(scannable);
        }
    }

    public void buildMeleeWeapon(Scannable scannable) {
        System.out.println("Введите оружие из предложенных: " + Arrays.toString(MeleeWeapon.values()));
        String weapon = scannable.readLine();
        try {
            spaceMarine.setMeleeWeapon(MeleeWeapon.valueOf(weapon));
        } catch (Exception e) {
            System.out.println("Упс, вы неправильно ввели оружие" + e.getMessage());
            this.buildMeleeWeapon(scannable);
        }
    }

    public void buildChapter(Scannable scannable) throws MyException {
        Chapter chapter = new Chapter();

        System.out.println("Введите название");
        String name = scannable.readLine();
        if (name.equals("")) {
            spaceMarine.setChapter(null);
            return;
        }
        try {
            chapter.setName(name);
        } catch (Exception e) {
            System.out.println("Упс, вы неправильно ввели имя " + e.getMessage());
            this.buildChapter(scannable);
        }

        System.out.println("Введите число кораблей");
        String marinesCount = scannable.readLine();
        if (marinesCount.equals("")) {
            chapter.setMarinesCount(null);
        } else {
            try {
                chapter.setMarinesCount(Long.parseLong(marinesCount));
            } catch (Exception e) {
                System.out.println("Упс, вы неправильно ввели число кораблей " + e.getMessage());
                this.buildChapter(scannable);
            }
        }

        System.out.println("Введите мир");
        String world = scannable.readLine();
        if (world.equals("")) {
            chapter.setWorld(null);
        } else {
            try {
                chapter.setWorld(world);
            } catch (Exception e) {
                System.out.println("Упс, вы неправильно ввели мир " + e.getMessage());
                this.buildChapter(scannable);
            }
        }
        spaceMarine.setChapter(chapter);
    }

    public void buildCoordinates(Scannable scannable) throws MyException {
        Coordinates coordinates = new Coordinates();

        System.out.println("Введите координату X");
        String xCoordinate = scannable.readLine();
        try {
            coordinates.setX(Long.parseLong(xCoordinate));
        } catch (Exception e) {
            System.out.println("Упс, вы неправильно координату X " + e.getMessage());
            this.buildCoordinates(scannable);
        }

        System.out.println("Введите координату Y");
        String yCoordinate = scannable.readLine();
        try {
            coordinates.setY(Double.parseDouble(yCoordinate));
        } catch (Exception e) {
            System.out.println("Упс, вы неправильно координату Y: " + e.getMessage());
            this.buildCoordinates(scannable);
        }

        spaceMarine.setCoordinates(coordinates);
    }

}
