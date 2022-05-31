package itmo.spacemarine.comparators;

import itmo.spacemarine.SpaceMarine;

import java.util.Comparator;

/**
 * compare spaceMarine by health
 */
public class SpaceMarineComparator implements Comparator<SpaceMarine> { //когда мы хотим сравнить два объекта, мы сначала идем в компаратор, проверяем объекты на нул. Если они не нул, то можем вызвать комперабал

    @Override
    public int compare(SpaceMarine o1, SpaceMarine o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        return o1.compareTo(o2);
    }
}
