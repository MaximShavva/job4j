package ru.job4j.testtask;

import java.util.function.BiPredicate;

/**
 * Объединение 2-х отсортированных массивов в общий отсортированный массив.
 * При этом выполняются проверки:
 * - на неотсортированность массивов.
 * - на несовпадение направлений сортировок.
 *
 * @author Шавва Максим.
 * @version 1.1
 * @since 27.03.2019г.
 */
public class JointArray {

    /**
     * @param first  Первый отсортированный массив.
     * @param second Второй отсортированный массив.
     */
    public int[] arraysJoining(int[] first, int[] second) {
        int sort = canJoined(first, second);
        switch (sort) {
            case 1:
                return joining(first, second, (left, right) -> left <= right);
            case -1:
                return joining(first, second, (left, right) -> left >= right);
            default:
                return new int[0];
        }
    }

    /**
     * @param first   Первый массив.
     * @param second  Второй массив.
     * @param predict Анонимный класс с методом test() сравнения 2х параметров.
     * @return объединённый отсортированный массив.
     */
    private int[] joining(int[] first, int[] second, BiPredicate<Integer, Integer> predict) {
        int[] joint = new int[first.length + second.length];
        int left = 0, right = 0;
        for (int i = 0; i < joint.length; i++) {
            if (left == first.length || (right != second.length && predict.test(second[right], first[left]))) {
                joint[i] = second[right++];
            } else if (right == second.length || predict.test(first[left], second[right])) {
                joint[i] = first[left++];
            }
        }
        return joint;
    }

    /**
     * @param first  - первый массив.
     * @param second - второй массив.
     * @return как будем объединять (1 - по возрастанию, -1 - по убыванию).
     */
    private int canJoined(int[] first, int[] second) {
        int vector = 0;
        int left = verifyIfSorted(first);
        int right = verifyIfSorted(second);
        if ((left == 1 && right == 1)
                || (left == 2 && right == 2)
                || (left == 2 && right == 1)
                || (left == 1 && right == 2)) {
            vector = 1;
        }
        if ((left == -1 && right == -1)
                || (left == 2 && right == -1)
                || (left == -1 && right == 2)) {
            vector = -1;
        }
        return vector;
    }

    /**
     * @param array проверим, как этот массив отсортирован
     * @return 1 - по возрастанию, или все элементы равны, или длина < 2.
     * 2 - содержит одинаковые элементы.
     * 0 - не отсортирован.
     * -1 - по убыванию.
     */
    private int verifyIfSorted(int[] array) {
        int sorted = 0;
        if (array.length > 1) {
            boolean inc = increase(array);
            boolean dec = decrease(array);
            if (inc && !dec) {
                sorted = 1;
            }
            if (!inc && dec) {
                sorted = -1;
            }
            if (inc && dec) {
                sorted = 2;
            }
        } else {
            sorted = 1;
        }
        return sorted;
    }

    /**
     * @param array проверяемый на возрастание массив.
     * @return если возрастающая сортировка - true
     */
    private boolean increase(int[] array) {
        boolean increasing = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                increasing = false;
                break;
            }
        }
        return increasing;
    }

    /**
     * @param array проверяемый на убывание массив.
     * @return если убывающая сортировка - true
     */
    private boolean decrease(int[] array) {
        boolean decreasing = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                decreasing = false;
                break;
            }
        }
        return decreasing;
    }
}
