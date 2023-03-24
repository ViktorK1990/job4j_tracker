package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] numLeftArray = left.split(". ", 2);
        String[] numRightArray = right.split(". ", 2);
        int numLeft = Integer.parseInt(numLeftArray[0]);
        int numRight = Integer.parseInt(numRightArray[0]);
        return Integer.compare(numLeft, numRight) ;
    }
}