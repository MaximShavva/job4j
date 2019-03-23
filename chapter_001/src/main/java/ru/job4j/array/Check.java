package ru.job4j.array;

/**
 * Выполняет проверку элементов массива на одинаковость.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 20.03.2019г.
 */
public class Check {

    /**
     * @param data массив, который проверяем на одинаковость элементов.
     * @return Выдаём заключение: true/false.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        boolean current = data[0];
        for (boolean item : data) {
            if (current != item) {
                result = false;
                break;
            }
        }
        return result;
    }
}