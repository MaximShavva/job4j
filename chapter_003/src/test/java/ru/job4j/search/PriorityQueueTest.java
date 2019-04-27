package ru.job4j.search;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирует очередь с приоритетом PriorityQueue.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 12.04.2019г.
 */
public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        List.of(new Task("low", 5),
                new Task("low", 7),
                new Task("urgent", 1),
                new Task("middle", 3),
                new Task("middle", 2),
                new Task("middle", 3))
                .forEach(queue::put);
        List<Task> result = new LinkedList<>();
        while (queue.getSize() != 0) {
            result.add(queue.take());
        }
        assertThat(result, is(List.of(
                new Task("urgent", 1),
                new Task("middle", 2),
                new Task("middle", 3),
                new Task("middle", 3),
                new Task("low", 5),
                new Task("low", 7)
        )));
    }
}