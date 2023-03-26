package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Fl {
    public static void main(String[] args) {
        Comparator<String> comparator = String::compareTo;
        Comparator<String> comparatorDesc = (left, right) -> Integer.compare(right.length(), left.length());
        String[] array = {"Viktor", "Varvara", "Margarita", "Tatyana", "Vladimir" , "Valentina", "Nina"};
        Arrays.sort(array, comparator);
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, comparatorDesc);
        System.out.println(Arrays.toString(array));

    }
}