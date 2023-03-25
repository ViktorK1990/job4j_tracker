package ru.job4j.queue;

import java.util.Comparator;

public class TaskByPositionAsc implements Comparator<Task> {

    @Override
    public int compare(Task task1, Task task2) {
        return task1.position().compareTo(task2.position());
    }
}
