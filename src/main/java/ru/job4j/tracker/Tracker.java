package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;


    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] array = new Item[items.size()];
        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null) {
                array[count] = items.get(i);
                count++;
            }
        }
        return Arrays.copyOf(array, count);
    }

    public Item[] findByName(String key) {
        Item[] array = new Item[items.size()];
        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            if (key.equals(items.get(i).getName())) {
                array[count] = items.get(i);
                count++;
            }
        }
        return Arrays.copyOf(array, count);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;

    }
    public boolean replace(int id, Item item){
        int index = indexOf(id);
        boolean result = index != -1;
        if (result){
            item.setId(id);
            items.add(index, item);
        }
        return result;
    }

    public boolean delete(int id){
        int index = indexOf(id);
        boolean result = index != -1;
        if (result){
            items.remove(index);
        }
        return result;
    }

}