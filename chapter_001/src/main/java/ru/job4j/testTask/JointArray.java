package ru.job4j.testTask;

import java.util.function.BiPredicate;

/**
 * Объединение 2-х отсортированных массивов в общий отсортированный массив.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 24.03.2019г.
 */
public class JointArray {

    /**
     * @param first  Первый отсортированный массив.
     * @param second Второй отсортированный массив.
     */
    public int[] arraysJoining(int[] first, int[] second) {
        int doSort = canJoined(first, second);
        switch (doSort) {
            case 1:
                return joining(first, second, (firstItem, secondItem) -> firstItem <= secondItem);
            case -1:
                return joining(first, second, (firstItem, secondItem) -> firstItem >= secondItem);
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
        int firstLength = first.length;
        int secondLength = second.length;
        int[] joint = new int[firstLength + secondLength];
        int firstCursor = 0, secondCursor = 0;
        for (int i = 0; i < joint.length; i++) {
            if (firstCursor == firstLength) {
                joint[i] = second[secondCursor];
                secondCursor++;
            } else if (secondCursor == secondLength) {
                joint[i] = first[firstCursor];
                firstCursor++;
            } else {
                if (predict.test(first[firstCursor], second[secondCursor])) {
                    joint[i] = first[firstCursor];
                    firstCursor++;
                } else {
                    joint[i] = second[secondCursor];
                    secondCursor++;
                }
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
        int sortedFirst = verifyIfSorted(first);
        int sortedSecond = verifyIfSorted(second);
        if (sortedFirst == 1 && sortedSecond == 1) vector = 1;
        if (sortedFirst == -1 && sortedSecond == -1) vector = -1;
        if (sortedFirst == 2 && sortedSecond == 2) vector = 1;
        if (sortedFirst == 2 && sortedSecond == 1) vector = 1;
        if (sortedFirst == 2 && sortedSecond == -1) vector = -1;
        if (sortedFirst == 1 && sortedSecond == 2) vector = 1;
        if (sortedFirst == -1 && sortedSecond == 2) vector = -1;
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
            if (inc && !dec) sorted = 1;
            if (!inc && dec) sorted = -1;
            if (!inc && !dec) sorted = 0;
            if (inc && dec) sorted = 2;
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
