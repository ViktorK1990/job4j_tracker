package ru.job4j.queue;
import java.util.Comparator;
public class TaskByUrgencyDesc implements Comparator<Task>{
    @Override
    public int compare(Task task1, Task task2) {
        return Integer.compare(task2.urgency(), task1.urgency());
    }
}
