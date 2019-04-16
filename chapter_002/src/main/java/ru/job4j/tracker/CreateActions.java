package ru.job4j.tracker;

/**
 * Абстрактная фабрика объектов.
 * Объявлены методы по созданию UserAction-generic объектов.
 *
 * @author Шавва Максим.
 * @version 1
 * @since 03.04.2019г.
 */
public interface CreateActions {
    UserAction addItemCreate(int position);

    UserAction showItemsCreate(int position);

    UserAction updateItemCreate(int position);

    UserAction deleteItemCreate(int position);

    UserAction findItemByIdCreate(int position);

    UserAction findItemsByNameCreate(int position);

    UserAction exitProgramCreate(int position);
}
