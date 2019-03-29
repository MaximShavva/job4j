package ru.job4j.pseudo;

/**
 * @author Шавва Максим (masyam@mail.ru)
 * @version 1
 * @since 29.03.2019г.
 */
public class Square implements Shape {

    /**
     * Формируем квадрат из псевдографики.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++")
                .append(System.lineSeparator())
                .append("+  +")
                .append(System.lineSeparator())
                .append("+  +")
                .append(System.lineSeparator())
                .append("++++");
        return pic.toString();
    }
}
