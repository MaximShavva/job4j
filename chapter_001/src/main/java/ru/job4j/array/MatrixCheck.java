package ru.job4j.array;

/**
 * Квадратный массив заполнен true или false по диагоналям.
 *
 * @author Шавва Максим (masyam@mail.ru).
 * @version 1.
 * @since 20.03.2019.
 */
public class MatrixCheck {

    /**
     * @param data двумерный массив для проверки диагоналей на однородность.
     * @return однородны диагонали или нет.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int size = data.length - 1;
        int reference;
        if (size % 2 == 0) {
            reference = 0;
        } else {
            reference = size;
        }
        for (int i = 0; i <= size; i++) {
            if (data[0][0] != data[i][i] || data[0][reference] != data[i][size - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}