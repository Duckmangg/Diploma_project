package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.Sql;

import static com.codeborne.selenide.Selenide.open;

public class TestUI {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @AfterEach
    void cleanDataBases() {Sql.dropDataBase();}

    @BeforeEach
    void setUpSutUrl() {
        open(System.getProperty("sut.url"));
    }
}
