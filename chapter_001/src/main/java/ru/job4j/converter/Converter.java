package ru.job4j.converter;

/**
 * Конвертер валюты.
 *
 * @author Максим Шавва (masyam@mail.ru).
 * @version 1.
 * @since 18.03.2019г.
 */
public class Converter {
    /**
     * рублей за евро.
     */
    private final int euro = 70;
    /**
     * рублей за доллар.
     */
    private final int dollar = 60;

    /**
     * Конвертируем рубли в евро.
     *
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / euro;
    }

    /**
     * Конвертируем рубли в доллары.
     *
     * @param value рубли.
     * @return Доллары.
     */
    public int rubleToDollar(int value) {
        return value / dollar;
    }

    /**
     * Конвертируем доллары в рубли.
     *
     * @param value рубли.
     * @return Доллары.
     */
    public int dollarToRuble(int value) {
        return value * dollar;
    }

    /**
     * Конвертируем евро в рубли.
     *
     * @param value рубли.
     * @return Доллары.
     */
    public int euroToRuble(int value) {
        return value * euro;
    }
}
