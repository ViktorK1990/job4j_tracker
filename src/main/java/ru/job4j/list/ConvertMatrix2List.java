package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for(int[] row : array) {
            for(int cell : row) {
                list.add(cell);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {3, 2, 1}, {4, 5, 6}};
        ConvertMatrix2List list = new ConvertMatrix2List();
        System.out.println(list.toList(array));
    }
}