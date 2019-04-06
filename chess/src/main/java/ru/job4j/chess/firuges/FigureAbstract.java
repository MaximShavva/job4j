package ru.job4j.chess.firuges;

/**
 * Абстрактный класс частично реализует методы интерфейса Figure.
 * Служит осносой для построения классов из пакета way.
 *
 * @author Шавва Максим.
 * @version 1.1
 * @since 11.04.2019г.
 */
public abstract class FigureAbstract implements Figure {
    /**
     * Текущая позиция фигуры на доске.
     */
    private final Cell position;

    /**
     * В конструкторе зазаём позицию фигуры на доске.
     */
    public FigureAbstract(final Cell position) {
        this.position = position;
    }

    /**
     * Возвращает позицию фигуры на доске.
     */
    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * @param x - координата
     * @param y - координата
     * @return ячейка с координатами x, y
     */
    public static Cell findBy(int x, int y) {
        Cell cell = null;
        for (Cell c : Cell.values()) {
            if (c.x == x && c.y == y) {
                cell = c;
                break;
            }
        }
        return cell;
    }
}