package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.nullValue;

class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Item item = new Item("New Item");
        Tracker tracker = new Tracker();
        tracker.add(item);
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "Replaced Item", "1"});
        UserAction[] action = {
                new EditAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, action);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Replaced Item");

    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Item item = new Item("New Item");
        Tracker tracker = new Tracker();
        tracker.add(item);
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] action = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, action);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new EditAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. === Edit item ===" + ln
                        + "1. === Exit ===" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. === Edit item ===" + ln
                        + "1. === Exit ===" + ln
                        + "=== Exit program ===" + ln
        );
    }

    @Test
    public void whenShowAllItemTestOutIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. === Show all items ===" + ln
                        + "1. === Exit ===" + ln
                        + "=== Show all items ===" + ln
                        + "Хранилище еще не содержит заявок" + ln
                        + "Menu:" + ln
                        + "0. === Show all items ===" + ln
                        + "1. === Exit ===" + ln
                        + "=== Exit program ===" + ln
        );
    }

    @Test
    public void whenFindByNameActionIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getName()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindActionByName(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. === Find items by name ===" + ln
                        + "1. === Exit ===" + ln
                        + "=== Find items by name ===" + ln
                        + item + ln
                        + "Menu:" + ln
                        + "0. === Find items by name ===" + ln
                        + "1. === Exit ===" + ln
                        + "=== Exit program ===" +ln
        );
    }
    @Test
    public void whenFindByIdActionIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindActionById(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. === Find item by id ===" + ln
                        + "1. === Exit ===" + ln
                        + "=== Find item by id ===" + ln
                        + item + ln
                        + "Menu:" + ln
                        + "0. === Find item by id ===" + ln
                        + "1. === Exit ===" + ln
                        + "=== Exit program ===" +ln
        );
    }
}