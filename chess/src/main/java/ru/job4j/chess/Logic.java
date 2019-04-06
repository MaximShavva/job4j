package ru.job4j.chess;

import ru.job4j.chess.firuges.*;

/**
 * Класс содержит массив фигур и логику их ходов по шахматной доске.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @author Maxim Shavva (masyam@mail.ru)
 * @version 1
 * @since 08.04.2019
 */
public class Logic {

    /**
     * Массив фигур на доске.
     */
    private final Figure[] figures = new Figure[32];

    /**
     * Индекс куда будет писаться следующая фигурка.
     */
    private int index = 0;

    /**
     * Добавляет фигуру в массив.
     *
     * @param figure фигура, которую надо добавить.
     */
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * Вся логика шахматного хода хода.
     * Проверяем:
     *  - что фигурка есть на исходном поле,
     *  - что фигурка может так двигаться,
     *  - что на пути нет других фигур(не для коня),
     *  - на клетке назначения нет никакой фигуры(пока).
     */
    public void move(Cell source, Cell dest)
            throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException();
        }
        Cell[] steps = this.figures[index].way(source, dest);
        if (isOccupied(steps)) {
            throw new OccupiedWayException();
        }
        this.figures[index] = this.figures[index].copy(dest);
    }

    /**
     * Проверяем, свободен ли путь для движения фигуры.
     */
    private boolean isOccupied(Cell[] steps) {
        boolean occupied = false;
        for (Cell cell: steps) {
            if (findBy(cell) != -1) {
                occupied = true;
                break;
            }
        }
        return occupied;
    }

    /**
     * Очищает массив фигур, обнуляет index.
     */
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    /**
     * @param cell передаём ячейку на шахматном поле, чтобы проверить, какая фигура там стоит.
     * @return возвращаем индекс вигуры в массиве фигур, которая находится на ячейке cell.
     */
    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}