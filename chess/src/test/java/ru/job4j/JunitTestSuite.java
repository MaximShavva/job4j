package ru.job4j;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.job4j.chess.LogicTest;
import ru.job4j.chess.WayTests;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        LogicTest.class,
        WayTests.class
})

/**
 * Класс запускает Тесты из пакета ru.job4j.chess.
 *
 * @since 8.04.2019г.
 */
public class JunitTestSuite {
}