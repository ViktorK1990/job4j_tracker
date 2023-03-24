package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByPriorityAndName() {
        Comparator<Job> cmpPriorityName = new JobSortByPriority().thenComparing(new JobSortByName());
        int rsl = cmpPriorityName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByPriorityAndName() {
        Comparator<Job> cmpDescPriorityName = new JobDescByPriority().thenComparing(new JobSortByName());
        int rsl = cmpDescPriorityName.compare(
                new Job ("Impl task", 0),
                new Job ("Fix bug", 0)
        );
        assertThat(rsl).isNotNegative();
    }
}