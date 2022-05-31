package itmo.spacemarine.comparators;

import itmo.spacemarine.Chapter;

import java.util.Comparator;

/**
 * compare chapters by marinesCount
 */
public class ChapterComparator implements Comparator<Chapter> {

    @Override
    public int compare(Chapter o1, Chapter o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        return o1.compareTo(o2);
    }
}
