package ru.job4j.tracker;
public class StartUI {

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
        Output console = new ConsoleOutput();
        for (int i = 0; i < userAction.length; i++) {
            console.println(i + ". " + userAction[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] userActions = {
                new CreateAction(), new EditAction(), new FindActionById(),
                new FindActionByName(), new DeleteAction(), new ShowAction(), new ExitAction()
        };
        new StartUI().init(input, tracker, userActions);
    }
}