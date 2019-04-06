package ru.job4j.chess.firuges.way;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.FigureAbstract;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 * Расширяет класс FigureAbstract, переопределяя метод way() для фигуры Король.
 *
 * @author Шавва Максим.
 * @version 2.1
 * @since 11.04.2019г.
 */
public abstract class KingWay extends FigureAbstract {
    /**
     * @param position зазаём позицию короля на доске.
     */
    public KingWay(Cell position) {
        super(position);
    }

    /**
     * Проверяет, что король может так двигаться.
     *
     * @param source клетка исходного положения.
     * @param dest   клетка конечного положения.
     * @return массив клеток, через которые двигается фигурка.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int vert = dest.y - source.y;
        int horiz = dest.x - source.x;
        if ((vert == 0 && horiz == 0) || Math.abs(vert) >= 2 || Math.abs(horiz) >= 2) {
            throw new ImpossibleMoveException();
        }
        return new Cell[]{dest};
    }
}
