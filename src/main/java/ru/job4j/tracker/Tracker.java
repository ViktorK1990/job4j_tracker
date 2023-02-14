package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int i = 0; i < this.size; i++) {
            Item item = items[i];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] array = new Item[items.length];
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            if (items[i] != null) {
                array[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(array, count);
    }

    public Item[] findByName(String key) {
        Item[] array = new Item[items.length];
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            if (key.equals(items[i].getName())) {
                array[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(array, count);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;

    }
    public boolean replace(int id, Item item){
        boolean result = false;
        int index = indexOf(id);
        if (index != -1){
            item.setId(id);
            items[index] = item;
            result = true;
        }
        return result;
    }

    public boolean delete(int id){
        boolean result = false;
        int index = indexOf(id);
        if (index != -1){
            items[index] = null;
            System.arraycopy(items, index+1, items, index, this.size);
            items[size -1] = null;
            size --;
            result = true;
        }
        return result;
    }

}