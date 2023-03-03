package ru.job4j.tracker;

public class CreateAction implements UserAction{
    @Override
    public String name() {
        return "=== Add new item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Output console = new ConsoleOutput();
        console.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        console.println("Добавленная заявка: " + item);
        return true;
    }
}
