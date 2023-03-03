package ru.job4j.tracker;

public class FindActionByName implements UserAction{
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Output console = new ConsoleOutput();
        console.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                console.println(item);
            }
        } else {
            console.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
