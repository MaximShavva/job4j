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
        int last = array.length - 1;
        for (int i = 0; i < last; i++) {
            String item = array[i];
            for (int j = i + 1; j <= last; j++) {
                if (array[j].equals(item)) {
                    if (j == last) {
                        last--;
                    } else {
                        array[j] = array[last];
                        last--;
                    }
                }
            }
        }
        return Arrays.copyOf(array, last + 1);
    }
}
