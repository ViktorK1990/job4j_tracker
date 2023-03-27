package ru.job4j.function;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
public class SearchFolder {
    public static List<Folder> filter (List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder f : list) {
            if (pred.test(f)) {
                rsl.add(f);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Folder> list = List.of(new Folder("Folder1", 100), new Folder("Folder2", 200),
                new Folder("Folder3", 3));
        filter(list, f -> f.getSize() > 90);


    }
}
