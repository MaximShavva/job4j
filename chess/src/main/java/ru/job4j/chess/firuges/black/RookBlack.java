package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.way.RookWay;

/**
 * Класс "Чёрная Ладья" хранит свою позицию и определяет, как "ходит" эта фигура.
 *
 * @author Шавва Максим.
 * @version 2.
 * @since 08.04.2019г.
 */
public class RookBlack extends RookWay {
    /**
     * @param position задаём позицию ладьи на доске.
     */
    public RookBlack(Cell position) {
        super(position);
    }

    /**
     * Возвращает (создаёт) Чёрной ладьи на новом месте.
     *
     * @param dest позиция ладьи.
     */
    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
