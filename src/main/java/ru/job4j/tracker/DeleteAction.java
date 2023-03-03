package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Output console = new ConsoleOutput();
        console.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)){
            console.println("Заявка удалена успешно.");
        }
        else {
            console.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
