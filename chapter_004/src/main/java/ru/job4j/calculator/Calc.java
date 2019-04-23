package ru.job4j.calculator;

/**
 * Класс содержит метод по выводу таблицы умножения.
 * Нужный ункционал задаётся Функциональным интерфейсом.
 * В дальнейшем этот интерфейс будет заменён лямбда-функцией.
 */
public class Calc {

    public interface Operation {
        double calc(int left, int right);
    }

    /**
     * @param start начальное значение.
     * @param finish кунечное значение.
     * @param value число, для которого будет выполняться функция.
     * @param op Функциональный интерфейс с функцией calc.
     */
    public void multiple(int start, int finish, int value, Operation op) {
        for (int index = start; index != finish; index++) {
            System.out.println(op.calc(value, index));
        }
    }

    public static void main(String[] args) {
        Calc calc = new Calc();
        calc.multiple(0, 10, 2,
                new Operation() {
                    public double calc(int left, int right) {
                        return left * right;
                    }
                });
    }
}