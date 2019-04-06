package ru.job4j.chess.firuges.way;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.FigureAbstract;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 * Расширяет класс FigureAbstract, переопределяя метод way() для фигуры Пешка.
 *
 * @author Шавва Максим.
 * @version 2.1
 * @since 11.04.2019г.
 */
public abstract class PawnWay extends FigureAbstract {
    /**
     * В конструкторе зазаём позицию Пешки на доске.
     */
    public PawnWay(Cell position) {
        super(position);
    }

    /**
     * Проверяет, что Пешка может так двигаться.
     *
     * @param source клетка исходного положения.
     * @param dest   клетка конечного положения.
     * @return массив клеток, через которые двигается фигурка.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int direct = "PawnWhite".equals(this.getClass().getSimpleName()) ? -1 : 1;
        if (dest.y != source.y - direct || source.x != dest.x) {
            throw new ImpossibleMoveException();
        }
        return new Cell[]{dest};
    }
}