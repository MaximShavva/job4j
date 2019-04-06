package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.way.BishopWay;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Класс "Чёрный Слон" хранит свою позицию и определяет, как "ходит" эта фигура.
 *
 * @author Шавва Максим.
 * @version 2.
 * @since 08.04.2019г.
 */
public class BishopBlack extends BishopWay {
    /**
     * В конструкторе зазаём позицию чёрного слона на доске.
     */
    public BishopBlack(final Cell position) {
        super(position);
    }

    /**
     * Возвращает (создаёт) фигуру чёрного слона на новом месте.
     *
     * @param dest позиция для фигуры.
     */
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}