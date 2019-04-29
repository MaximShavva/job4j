package ru.job4j.tictactoe;

import javafx.scene.shape.Rectangle;

/**
 * Класс содержит маркеры наличия крестика или нолика на клетке.
 */
public class Figure3T extends Rectangle {

    /**
     * Наличия крестика на клетке.
     */
    private boolean markX = false;

    /**
     * Наличия крестика на клетке.
     */
    private boolean markO = false;

    public Figure3T() {
    }

    public Figure3T(boolean markX, boolean markO) {
        this.markX = markX;
        this.markO = markO;
    }

    /**
     * Помечаем клетку крестиком или ноликом.
     */
    public void take(boolean markX) {
            this.markX = markX;
            this.markO = !markX;
    }

    /**
     * Есть ли на клетке крестик.
     */
    public boolean hasMarkX() {
        return this.markX;
    }

    /**
     * Есть ли на клетке нолик.
     */
    public boolean hasMarkO() {
        return this.markO;
    }
}