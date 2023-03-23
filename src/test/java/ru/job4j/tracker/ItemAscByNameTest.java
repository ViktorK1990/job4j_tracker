package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class ItemAscByNameTest {

    @Test
    void whenCompareItemAsc() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Boris"));
        items.add(new Item("Anna"));
        items.add(new Item("Viktor"));
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Anna"));
        expected.add(new Item("Boris"));
        expected.add(new Item("Viktor"));
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenCompareItemDesc() {
        List <Item> items = new ArrayList<>();
        items.add(new Item("Boris"));
        items.add(new Item("Anna"));
        items.add(new Item("Viktor"));
        Collections.sort(items, new ItemDescByName());
        List <Item> expected = new ArrayList<>();
        expected.add(new Item("Viktor"));
        expected.add(new Item("Boris"));
        expected.add(new Item("Anna"));
        assertThat(items).isEqualTo(expected);
    }
}