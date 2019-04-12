package ru.job4j.search;

import java.util.LinkedList;
import java.util.ListIterator;


/**
 * Класс представляет собой очередь с приоритетом.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 12.04.2019г.
 */
public class PriorityQueue {
    /**
     * Список задач, расставленных по приоритету.
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     *
     * @param task задача
     */
    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.add(task);
            return;
        }
        ListIterator<Task> iter = tasks.listIterator();
        while (iter.hasNext()) {
            Task item = iter.next();
            if (task.getPriority() >= item.getPriority() ) {
                if (iter.hasNext()) continue;
                else iter.add(task);
            } else {
                iter.set(task);
                iter.add(item);
                break;
            }
        }
    }

    /**
     * Метод "снимает" задание с головы списка.
     *
     * @return Task
     */
    public Task take() {
        return this.tasks.poll();
    }
}