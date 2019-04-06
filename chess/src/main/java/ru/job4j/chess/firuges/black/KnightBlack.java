package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.FigureAbstract;
import ru.job4j.chess.firuges.way.KnightWay;

/**
 * Класс "Чёрный Конь" хранит свою позицию и определяет, как "ходит" эта фигура.
 *
 * @author Шавва Максим.
 * @version 2.
 * @since 08.04.2019г.
 */
public class KnightBlack extends KnightWay {
    /**
     * В конструкторе зазаём позицию Коня на доске.
     */
    public KnightBlack(final Cell position) {
        super(position);
    }

    /**
     * Возвращает (создаёт) Чёрного коня на новом месте.
     *
     * @param dest позиция коня.
     */
    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
