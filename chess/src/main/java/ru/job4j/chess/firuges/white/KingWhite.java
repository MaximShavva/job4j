package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.way.KingWay;

/**
 * Класс "Белый Король" хранит свою позицию и определяет, как "ходит" эта фигура.
 *
 * @author Шавва Максим.
 * @version 2.
 * @since 08.04.2019г.
 */
public class KingWhite extends KingWay {
    /**
     * @param position зазаём позицию короля на доске.
     */
    public KingWhite(Cell position) {
        super(position);
    }

    /**
     * Возвращает (создаёт) Чёрного короля на новом месте.
     *
     * @param dest позиция короля.
     */
    @Override
    public Figure copy(Cell dest) {
        return new KingWhite(dest);
    }
}
