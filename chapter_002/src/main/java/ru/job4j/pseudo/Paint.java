package ru.job4j.pseudo;

/**
 * Класс реализует паттерн "Стратегия", когда поведение метода draw выносится
 * в классы Triangle и Square.
 *
 * @author Шавва Максим (masyam@mail.ru)
 * @version 1
 * @since 29.03.2019г.
 */
public class Paint {

    /**
     * Рисуем фигуру.
     * @param shape передаём объект фигуры.
     * */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}