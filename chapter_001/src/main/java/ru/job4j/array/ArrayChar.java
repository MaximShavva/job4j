package ru.job4j.array;

/**
 * Обертка над строкой.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 20.03.2019г.
 */
public class ArrayChar {
    private final char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет, что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        // проверить, что массив data имеет первые элементы, одинаковые с value
        if (data.length < value.length) {
            result = false;
        } else {
            for (int i = 0; i != value.length; i++) {
                if (value[i] != data[i]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
