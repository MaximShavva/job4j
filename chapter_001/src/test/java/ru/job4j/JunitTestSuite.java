package ru.job4j;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.job4j.array.*;
import ru.job4j.calculator.*;
import ru.job4j.condition.*;
import ru.job4j.loop.*;
import ru.job4j.testtask.*;
import ru.job4j.converter.ConverterTest;
import ru.job4j.testtask.vara.JointTest;
import ru.job4j.testtask.varb.MergeTest;
import ru.job4j.testtask.varc.FusionTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ArrayCharTest.class,
        ArrayDuplicateTest.class,
        BubbleSortTest.class,
        CheckTest.class,
        FindLoopTest.class,
        MatrixCheckTest.class,
        MatrixTest.class,
        SquareTest.class,
        TurnTest.class,
        CalculatorTest.class,
        FitTest.class,
        DummyBotTest.class,
        MaxTest.class,
        MultiMaxTest.class,
        PointTest.class,
        TriangleTest.class,
        ConverterTest.class,
        BoardTest.class,
        CounterTest.class,
        FactorialTest.class,
        PaintTest.class,
        JointArrayTest.class,
        MergeArraysTest.class,
        JointTest.class,
        MergeTest.class,
        FusionTest.class

})

/**
 * Класс запускает Тесты из пакета ru.job4j.chess.
 *
 * @since 16.04.2019г.
 */
public class JunitTestSuite {
}