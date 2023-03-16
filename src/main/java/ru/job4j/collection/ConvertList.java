package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] row : list) {
            for (int cell : row) {
                rsl.add(cell);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<int[]> list = List.of(new int[] {1, 2, 3}, new int[] {4, 6, 7});
        System.out.println(convert(list));
    }
}