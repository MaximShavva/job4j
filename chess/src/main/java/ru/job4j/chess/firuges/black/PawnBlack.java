package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.way.PawnWay;

/**
 * Класс "Чёрная Пешка" хранит свою позицию и определяет, как "ходит" эта фигура.
 *
 * @author Шавва Максим.
 * @version 2.
 * @since 08.04.2019г.
 */
public class PawnBlack extends PawnWay {
    /**
     * В конструкторе зазаём позицию Пешки на доске.
     */
    public PawnBlack(final Cell position) {
        super(position);
    }

    /**
     * Возвращает (создаёт) Чёрную пешку на новом месте.
     *
     * @param dest позиция пешки.
     */
    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}