package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.way.PawnWay;

/**
 * Класс "Белая Пешка" хранит свою позицию и определяет, как "ходит" эта фигура.
 *
 * @author Шавва Максим.
 * @version 2.
 * @since 08.04.2019г.
 */
public class PawnWhite extends PawnWay {
    /**
     * В конструкторе зазаём позицию Пешки на доске.
     */
    public PawnWhite(final Cell position) {
        super(position);
    }

    /**
     * Возвращает (создаёт) Чёрную пешку на новом месте.
     *
     * @param dest позиция пешки.
     */
    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }

}
