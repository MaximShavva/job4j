package ru.job4j.array;

import java.util.Arrays;

/**
 * Удаление дубликатов из массива строк.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 20.03.2019г.
 */
public class ArrayDuplicate {

    /**
     * @param array Массив, из которого надо удалить дубликаты.
     * @return Очищеный от дубликатов массив.
     */
    public String[] remove(String[] array) {
        int lastIndex = array.length - 1;
        for (int i = 0; i < lastIndex; i++) {
            String item = array[i];
            for (int j = i + 1; j <= lastIndex; j++) {
                if (array[j].equals(item)) {
                    if (j == lastIndex) {
                        lastIndex--;
                    } else {
                        array[j] = array[lastIndex];
                        lastIndex--;
                    }
                }
            }
        }
        return Arrays.copyOf(array, lastIndex + 1);
    }
}
