package ru.job4j;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Класс запускает Тесты из пакета ru.job4j.chess, объявленные в JunitTestSuite.class
 *
 * @since 8.04.2019г.
 */
public class TestRunner {
    /**
     * Печатаем в консоль результат выполнения тестов.
     *
     * @param args
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(JunitTestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}