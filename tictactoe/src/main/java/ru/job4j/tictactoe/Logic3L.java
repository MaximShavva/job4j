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
public class Logic3L {


    /**
     * Поле с крестиками-ноликами.
     */
    private final Figure3T[][] table;

    public Logic3L(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Проверяем направление, заданное прараметрами, есть ли там нужные фишки.
     *
     * @param predicate подставляем метод из Figure.
     * @param startX начало по Х проверяемой цепочки.
     * @param startY начало по Y проверяемой цепочки.
     * @param deltaX приращение по X.
     * @param deltaY приращение по Y.
     * @return если цепочка найдена - true.
     */
    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * @return выиграли крестики.
     */
    public boolean isWinnerX() {
        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0) ||
                this.fillBy(Figure3T::hasMarkX, 0, 1, 1, 0) ||
                this.fillBy(Figure3T::hasMarkX, 0, 2, 1, 0) ||
                this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkX, 1, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkX, 2, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkX, 0,0, 1, 1) ||
                this.fillBy(Figure3T::hasMarkX, this.table.length - 1 , 0, -1, 1);
    }

    /**
     * @return выиграли нолики.
     */
    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0) ||
                this.fillBy(Figure3T::hasMarkO, 0, 1, 1, 0) ||
                this.fillBy(Figure3T::hasMarkO, 0, 2, 1, 0) ||
                this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkO, 1, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkO, 2, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkO, 0,0, 1, 1) ||
                this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1);
    }

    /**
     * @return Есть ли на поле варианты для хода.
     * */
    public boolean hasGap() {
        return Arrays.stream(table)
                .flatMap(Arrays::stream)
                .anyMatch(figure -> !figure.hasMarkX() && !figure.hasMarkO());
    }
}