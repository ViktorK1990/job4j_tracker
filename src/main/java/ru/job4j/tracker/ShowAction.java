package ru.job4j.tracker;

public class ShowAction implements UserAction{
    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Output console = new ConsoleOutput();
        console.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
               console.println(item);
            }
        } else {
            console.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
