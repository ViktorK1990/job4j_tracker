package ru.job4j.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>();
        autos.add("Lada");
        autos.add("Bmw");
        autos.add("Volvo");
        autos.add("Toyota");
        for(String elements : autos) {
            System.out.println(elements);
        }


    }
}