package ru.job4j.tracker;

public class FindActionById implements UserAction{
    @Override
    public String name() {
        return "=== Find item by id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Output console = new ConsoleOutput();
        console.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            console.println(item);
        } else {
            console.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
