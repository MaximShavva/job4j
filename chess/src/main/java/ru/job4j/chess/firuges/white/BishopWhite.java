package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.way.BishopWay;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Класс "Белый Слон" хранит свою позицию и определяет, как "ходит" эта фигура.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 08.04.2019г.
 */
public class BishopWhite extends BishopWay {
    /**
     * В конструкторе зазаём позицию белого слона на доске.
     */
    public BishopWhite(final Cell position) {
        super(position);
    }

    /**
     * Возвращает (создаёт) фигуру белого слона на новом месте.
     *
     * @param dest позиция для фигуры.
     */
    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}