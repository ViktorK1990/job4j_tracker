package ru.job4j.tracker;
public class StartUI {
    private final Output out;
    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] userActions) {
        boolean run = true;
        while (run) {
            showMenu(userActions);
            int select = input.askInt("Select : ");
            UserAction action = userActions[select];
            run = action.execute(input, tracker);
        }

    }

    private void showMenu(UserAction[] userAction) {
            out.println("Menu:");
        for (int i = 0; i < userAction.length; i++) {
            out.println(i + ". " + userAction[i].name());
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] userActions = {
                new CreateAction(out), new EditAction(out), new FindActionById(out),
                new FindActionByName(out), new DeleteAction(out), new ShowAllAction(out), new ExitAction(out)
        };
        new StartUI(out).init(input, tracker, userActions);
    }
}