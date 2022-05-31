package itmo.spacemarine.builders;

import itmo.io.Scannable;
import itmo.spacemarine.*;
import itmo.utils.MyException;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * class builder for space marine in general
 */
public class SpaceMarineBuilder {
    /**
     *object of spaceMarine
     */
    private final SpaceMarine spaceMarine;

    /**
     * constructor
     */
    public SpaceMarineBuilder() {
        spaceMarine = new SpaceMarine();
    }

    /**
     * @param scannable
     * @return
     * @throws MyException
     * build spaceMarine
     */
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

    /**
     * @param scannable
     * @throws MyException
     * find line in file. Now it is name
     */
    public void buildName(Scannable scannable) throws MyException {
        String name = scannable.readLine();
        spaceMarine.setName(name);
    }

    /**
     * @throws MyException
     * build id
     */
    public void buildId() throws MyException {
        Random random = new Random();
        int id = -1;
        while (id <= 0)
            id = random.nextInt();
        spaceMarine.setId(id);
    }

    /**
     * @throws MyException
     * set creationDate
     */
    public void buildCreationDate() throws MyException {
        spaceMarine.setCreationDate(LocalDateTime.now());
    }

    /**
     * @param scannable
     * @throws MyException
     * set health
     */
    public void buildHealth(Scannable scannable) throws MyException {
        String health = scannable.readLine();
        spaceMarine.setHealth(Double.parseDouble(health));
    }

    /**
     * @param scannable
     * set loyal
     */
    public void buildLoyal(Scannable scannable) {
        String loyal = scannable.readLine();
        spaceMarine.setLoyal(Boolean.parseBoolean(loyal));
    }

    /**
     * @param scannable
     * @throws MyException
     * set category
     */
    public void buildCategory(Scannable scannable) throws MyException {
        String category = scannable.readLine();
        spaceMarine.setCategory(AstartesCategory.valueOf(category));
    }

    /**
     * @param scannable
     * @throws MyException
     * set weapon
     */
    public void buildMeleeWeapon(Scannable scannable) throws MyException {
        String weapon = scannable.readLine();
        spaceMarine.setMeleeWeapon(MeleeWeapon.valueOf(weapon));
    }

    /**
     * @param scannable
     * @throws MyException
     * set chapter
     */
    public void buildChapter(Scannable scannable) throws MyException {
        Chapter chapter = new Chapter();

        String name = scannable.readLine();
        if (name.equals("")) {
            spaceMarine.setChapter(null);
            return;
        }
        chapter.setName(name);

        String marinesCount = scannable.readLine();
        if (marinesCount.equals("")) {
            chapter.setMarinesCount(null);
        } else {
            chapter.setMarinesCount(Long.parseLong(marinesCount));
        }

        String world = scannable.readLine();
        if (world.equals("")) {
            chapter.setWorld(null);
        } else {
            chapter.setWorld(world);
        }
    }

    /**
     * @param scannable
     * @throws MyException
     * set coordinater
     */
    public void buildCoordinates(Scannable scannable) throws MyException {
        Coordinates coordinates = new Coordinates();

        String xCoordinate = scannable.readLine();
        coordinates.setX(Long.parseLong(xCoordinate));

        String yCoordinate = scannable.readLine();
        coordinates.setY(Double.parseDouble(yCoordinate));

        spaceMarine.setCoordinates(coordinates);
    }
}
