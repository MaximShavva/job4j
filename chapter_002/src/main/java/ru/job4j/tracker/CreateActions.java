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
    UserAction AddItemCreate(int position);
    UserAction ShowItemsCreate(int position);
    UserAction UpdateItemCreate(int position);
    UserAction DeleteItemCreate(int position);
    UserAction FindItemByIdCreate(int position);
    UserAction FindItemsByNameCreate(int position);
    UserAction ExitProgramCreate(int position);
}
