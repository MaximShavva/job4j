package ru.job4j.tracker;

/**
 * Класс является "обёрткой" для классов, реализующих Input.
 *
 * @author Шавва Максим.
 * @version 2
 * @since 01.04.2019г.
 */
public class ValidateInput implements Input {

    /**
     * Воспользуемся шаблоном "Декоратор"
     * Добавим переменную input, методы которой перепишем.
     */
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    /**
     * @param question Вопрос, который нужно вывести на консоль.
     * @return вернём строку, введённую с клавиатуры пользователем.
     */
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    /**
     * Переопределим ask так, чтобы он отлавливал неверный ввод пользователя
     * в переданном методе input.ask.
     *
     * @param question Диалоговый вопрос пользователю
     * @param range    Массив номеров пунктов меню
     * @return выбранный пункт меню.
     */
    @Override
    public int ask(String question, int[] range) {
        int result = range.length - 1;
        boolean fault = true;
        do {
            try {
                result = this.input.ask(question, range);
                fault = false;
            } catch (MenuOutException moe) {
                System.out.println(moe.getMessage());
            }
        } while (fault);
        return result;
    }
}