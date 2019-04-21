package ru.job4j.bank;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        UserTest.class,
        AccountTest.class,
        BankTest.class
})

public class JunitTestSuite {
}