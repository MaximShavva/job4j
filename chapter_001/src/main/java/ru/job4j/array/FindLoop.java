package ru.job4j.array;

/**
 * Классический поиск перебором.
 *
  @author Шавва Максим.
 * @version 1.
 * @since 20.03.2019г.
 */
public class FindLoop {

    /**
     * @param data массив, в котором ищем.
     * @param el элемент, который ищем.
     * @return индекс найденного элемента.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}