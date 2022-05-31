package itmo.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * execute file history
 */
public class ExecuteFilesHistory {

    private static final List<File> files = new ArrayList<>();

    public static void add(File file) {
        files.add(file);
    }

    /**
     * @param file
     * @return
     * compare file paths
     */
    public static boolean contains(File file) {
        return files.stream().anyMatch(file1 -> file1.getAbsolutePath().equals(file.getAbsolutePath())); //если файл уже есть, то будет рекурсия. Плэтому сравниваем пути файлов
    }

    /**
     * @param file
     * delete files with the same paths
     */
    public static void remove(File file) {
        files.removeIf(file1 -> file1.getAbsolutePath().equals(file.getAbsolutePath())); //удаляем файл с таким же путем
    }
}
