package ru.job4j.tracker;

import java.util.Arrays;

/**
 * Класс реализует интерфейс Input и эмулирует ввод данных пользователем.
 *
 * @author Шавва Максим.
 * @version 2
 * @since 01.04.2019г.
 */
public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. Если пользователь
     * хочет выбрать добавление новой заявки ему нужно ввести:
     * 0 - выбор пункта меня "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * 6 - выйти из трекера.
     */
    private final String[] value;

    /**
     * Поле считает количество вызовов метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * Давайте рассмотрим, как работает этот метод.
     * у нас есть объект в котором содержатся заранее продуманные ответы.
     * При последовательном вызове метода ask нам надо возвращать соответствующие данные.
     * Как если бы мы симулировали поведение пользователя.
     * Для этого при каждом вызове метода ask мы увеличиваем счетчик и
     * при следующем вызове он вернет нам новое значение.
     *
     * @param question не используется.
     * @return ответы формируются из заранее заданной последовательности.
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    /**
     * @param question Любой вопрос (не учитывается)
     * @param range    Правильные номера меню.
     * @return "Введённый" пункт меню (в тестах не проверяем).
     */
    @Override
    public int ask(String question, int[] range) {
        String answer = ask(question);
        validation(answer, range);
        return Integer.valueOf(answer);
    }

    /**
     * Валидация введённого пользователем значения.
     *
     * @param answer Строковый ответ пользоватея.
     * @param range  Массив номеров пунктов меню.
     */
    private void validation(String answer, int[] range) {
        if (!answer.matches("[0-9]+")) {
            throw new MenuOutException("Некорректный номер. Попробуй ещё раз.");
        }
        if (!Arrays.toString(range).contains(answer)) {
            throw new MenuOutException("Ты ввел(а) неправильный пункт меню!");
        }
    }
}