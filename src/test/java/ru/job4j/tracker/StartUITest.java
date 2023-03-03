package ru.job4j.tracker;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.nullValue;

class StartUITest {
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }
    @Test
    public void whenReplaceItem() {
        Item item = new Item("New Item");
        Tracker tracker = new Tracker();
        tracker.add(item);
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "Replaced Item","1"});
        UserAction[] action = {
                new EditAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, action);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Replaced Item");

    }
    @Test
    public void whenDeleteItem() {
        Item item = new Item("New Item");
        Tracker tracker = new Tracker();
        tracker.add(item);
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] action = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, action);
        assertThat(tracker.findById(item.getId())).isNull();
    }
}