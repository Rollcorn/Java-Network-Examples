package itmo.commands;

import itmo.collection.MyTreeMap;
import itmo.spacemarine.Chapter;
import itmo.spacemarine.SpaceMarine;
import itmo.spacemarine.comparators.ChapterComparator;

import java.util.ArrayList;
import java.util.List;

/**
 * display the values of the chapter field of all elements in ascending order
 */
public class PrintFieldAscendingChapterCommand implements Command {

    private final MyTreeMap<Integer, SpaceMarine> myTreeMap;


    public PrintFieldAscendingChapterCommand(MyTreeMap<Integer, SpaceMarine> myTreeMap) {
        this.myTreeMap = myTreeMap;
    }

    /**
     * get chapters in the sheet, filter them and execute the command
     */
    @Override
    public void execute() {
        List<SpaceMarine> listOfSpaceMarine = myTreeMap.getValueList();
        List<Chapter> chapters = new ArrayList<>();

        listOfSpaceMarine.forEach(spaceMarine -> chapters.add(spaceMarine.getChapter()));

        chapters.sort(new ChapterComparator());
        chapters.forEach(chapter -> System.out.println(chapter.toString()));
    }
}
