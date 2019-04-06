package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.way.QueenWay;

/**
 * Класс "Чёрный Ферзь" хранит свою позицию и определяет, как "ходит" эта фигура.
 *
 * @author Шавва Максим.
 * @version 2.
 * @since 08.04.2019г.
 */
public class QueenBlack extends QueenWay {
    /**
     * @param position зазаём позицию ферзя на доске.
     */
    public QueenBlack(Cell position) {
        super(position);
    }

    /**
     * Возвращает (создаёт) Чёрного ферзя на новом месте.
     *
     * @param dest позиция ферзя.
     */
    @Override
    public Figure copy(Cell dest) {
        return new QueenBlack(dest);
    }
}
