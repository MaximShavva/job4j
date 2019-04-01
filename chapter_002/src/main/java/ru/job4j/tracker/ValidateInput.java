package ru.job4j.tracker;

/**
 * Класс расширяет ConsoleInput.
 *
 * @author Шавва Максим.
 * @version 1
 * @since 01.04.2019г.
 */
public class ValidateInput extends ConsoleInput {

    /**
     * Переопределим ask так, чтобы он отлавливал неверный ввод пользователя.
     *
     * @param question Диалоговый вопрос пользователю
     * @param range Массив номеров пунктов меню
     * @return выбранный пункт меню.
     */
    @Override
    public int ask(String question, int[] range) {
        int result = range.length - 1;
        boolean fault = true;
        do {
            try {
                result = super.ask(question, range);
                fault = false;
            } catch (MenuOutException moe) {
                System.out.println(moe.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Не корректный номер. Попробуй ещё раз.");
            }
        } while (fault);
        return result;
    }
}
