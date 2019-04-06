package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.way.RookWay;

/**
 * Класс "Белая Ладья" хранит свою позицию и определяет, как "ходит" эта фигура.
 *
 * @author Шавва Максим.
 * @version 2.
 * @since 08.04.2019г.
 */
public class RookWhite extends RookWay {
    /**
     * @param position задаём позицию ладьи на доске.
     */
    public RookWhite(Cell position) {
        super(position);
    }

    /**
     * Возвращает (создаёт) Чёрной ладьи на новом месте.
     *
     * @param dest позиция ладьи.
     */
    @Override
    public Figure copy(Cell dest) {
        return new RookWhite(dest);
    }
}