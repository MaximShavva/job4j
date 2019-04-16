package ru.job4j.testtask.varb;

/**
 * Объединение 2-х отсортированных по возрастанию массивов типа int
 * в общий отсортированный массив.
 *
 * @author Шавва Максим.
 * @version 2.
 * @since 25.03.2019г.
 */
public class Merge {

    /**
     * @param first  Первый массив.
     * @param second Второй массив.
     * @return объединённый отсортированный массив.
     */
    public int[] joinArrays(int[] first, int[] second) {
        int[] joint = new int[first.length + second.length];
        int left = 0, right = 0;
        for (int i = 0; i < joint.length; i++) {
            if (left == first.length) {
                joint[i] = second[right++];
            } else if (right == second.length) {
                joint[i] = first[left++];
            } else if (first[left] <= second[right]) {
                joint[i] = first[left++];
            } else {
                joint[i] = second[right++];
            }
        }
        return joint;
    }
}
