package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList <String> arrayList = new ArrayList<>();
        arrayList.add("Petr");
        arrayList.add("Evgeniy");
        arrayList.add("Stanislav");
        for (Object index : arrayList){
            System.out.println(index);
        }
    }
}
