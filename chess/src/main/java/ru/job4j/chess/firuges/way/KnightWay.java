package ru.job4j.chess.firuges.way;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.FigureAbstract;
import ru.job4j.chess.firuges.ImpossibleMoveException;


/**
 * Расширяет класс FigureAbstract, переопределяя метод way() для фигуры Конь.
 *
 * @author Шавва Максим.
 * @version 2.1
 * @since 11.04.2019г.
 */
public abstract class KnightWay extends FigureAbstract {

    /**
     * @param position зазаём позицию коня на доске.
     */
    public KnightWay(Cell position) {
        super(position);
    }

    /**
     * Проверяет, что Конь может так двигаться.
     *
     * @param source клетка исходного положения.
     * @param dest   клетка конечного положения.
     * @return массив клеток, через которые двигается фигурка.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int vert = dest.y - source.y;
        int horiz = dest.x - source.x;
        if (vert == 0 || horiz == 0 || (Math.abs(vert) + Math.abs(horiz) != 3)) {
            throw new ImpossibleMoveException();
        }
        return new Cell[]{dest}; //путь не запоминаем, конь прыгает через фигуры.
    }
}