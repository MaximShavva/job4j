package ru.job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Логика игры крестики-нолики следующая:
 * Победил тот, кто выстроил линию из 3 фишек в ряд.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 29.04.2019г.
 */

public class Logic3T {

    /**
     * Поле с крестиками-ноликами.
     */
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * @return выиграли крестики.
     */
    public boolean isWinnerX() {
        return findChain(Figure3T::hasMarkX);
    }

    /**
     * @return выиграли нолики.
     */
    public boolean isWinnerO() {
        return findChain(Figure3T::hasMarkO);
    }

    /**
     * Ищем цепочку из 3 фишек.
     *
     * @param mark Передаём в ссылку на нужный метод из класса Figure3T
     * @return если нашли цепочку - true.
     */
    private boolean findChain(Predicate<Figure3T> mark) {
        var result = false;
        label:
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (mark.test(table[i][j])) {
                    if (withinBound(i, j, 1, 0, mark)
                            || withinBound(i, j, 0, 1, mark)
                            || withinBound(i, j, 1, 1, mark)
                            || withinBound(i, j, 1, -1, mark)) {
                        result = true;
                        break label;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Проверяем границы и содержимое в клетках +-дельта.
     *
     * @param i    строка клетки, от которой проверяем фишку.
     * @param j    столбец клетки, от которой проверяем фишку.
     * @param dx   приращение по строке.
     * @param dy   приращение по столбцу.
     * @param mark подставляем метод из Figure.
     * @return результат: есть ли цепочка в заданном направлении.
     */
    private boolean withinBound(int i, int j, int dx, int dy, Predicate<Figure3T> mark) {
        var border = table.length;
        return (j + Math.abs(dy)) != border && (j - Math.abs(dy)) != -1
                && (i + dx) != border && (i - dx) != -1
                && mark.test(table[i + dx][j + dy])
                && mark.test(table[i - dx][j - dy]);
    }

    /**
     * @return Есть ли на поле варианты для хода.
     */
    public boolean hasGap() {
        return Arrays.stream(table)
                .flatMap(Arrays::stream)
                .anyMatch(figure -> !figure.hasMarkX() && !figure.hasMarkO());
    }
}