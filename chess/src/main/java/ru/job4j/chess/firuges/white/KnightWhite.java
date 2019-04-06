package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.FigureAbstract;
import ru.job4j.chess.firuges.way.KnightWay;

/**
 * Класс "Белый Конь" хранит свою позицию и определяет, как "ходит" эта фигура.
 *
 * @author Шавва Максим.
 * @version 2.
 * @since 08.04.2019г.
 */
public class KnightWhite extends KnightWay {
    /**
     * В конструкторе зазаём позицию Коня на доске.
     */
    public KnightWhite(final Cell position) {
        super(position);
    }

    /**
     * Возвращает (создаёт) Белого коня на новом месте.
     *
     * @param dest позиция коня.
     */
    @Override
    public Figure copy(Cell dest) {
        return new KnightWhite(dest);
    }
}