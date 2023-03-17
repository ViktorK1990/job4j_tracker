package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap <String , String> map = new HashMap<>();
        map.put("Viktor@yandex", "Viktor");
        map.put("Roman@rambler", "Roman");
        for (Map.Entry <String, String > entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
