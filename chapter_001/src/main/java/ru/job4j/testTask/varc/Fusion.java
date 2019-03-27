package ru.job4j.testTask.varc;

/**
 * Объединение 2-х отсортированных по возрастанию массивов типа int
 * в общий отсортированный массив.
 *
 * @author Шавва Максим.
 * @version 3.
 * @since 27.03.2019г.
 */
public class Fusion {

    /**
     * @param first  Первый массив.
     * @param second Второй массив.
     * @return объединённый отсортированный массив.
     */
    public int[] joinArrays(int[] first, int[] second) {
        int[] joint = new int[first.length + second.length];
        int left = 0, right = 0;
        for (int i = 0; i < joint.length; i++) {
            if (left == first.length || (right != second.length && first[left] > second[right])) {
                joint[i] = second[right++];
            } else if (right == second.length || first[left] <= second[right]) {
                joint[i] = first[left++];
            }
        }
        return joint;
    }
}