package homeWork;

import ch.qos.logback.classic.LoggerContext;
import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;
import patterns.PageElement;
import patterns.PageObject;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class UiTests {
    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    loggerContext.stop();

    //Logger logger = LoggerFactory.getLogger(UiTests.class);

    @Test
    @Tag("googleSearch")
    void task1() {
        // Arrange
        open("https://www.google.ru/"); // открываем Гугл
//        logger.debug("Логер уровня дебаг");
//        logger.info("Логер уровня инфффо");
//        logger.warn("Осторожно!");

        // Act
        $x("//input[contains(@title,'Поиск')]") // в поле ввода вставлем "performance lab", нажимем Enter
                .shouldBe(visible)
                .setValue("performance lab")
                .pressEnter();
        // Assert
        $x("//a[contains(@href,'https://www.performance-lab.ru')]") // находим сайт компании, кликаем по ссылке
                .shouldBe(visible).click();
        Selenide.sleep(2000);
    }

    @Test
    @Tag("buttonColor")
    void task2() {
        // Arrange
        PageObject pageObject = new PageObject();
        PageElement pageElement = new PageElement();
        open("https://www.performance-lab.ru/");

        // Act
        pageObject.servicesAndProductsTab().shouldBe(visible)
                .hover(); // наводим на меню "Услуги и цены"

        pageElement.siteTesting()
                .shouldBe(visible)
                .click(); // в открывшемся меню находим "Тестирование сайта", переходим по ссылке

        switchTo().window(1); //переключаем на 2-ю вкладку

        String value = $$x("//a[contains(@role, 'button')]")
                .get(0)
                .shouldBe(visible)
                .getCssValue("background-color"); // находим кнопку и берем ее цвет

        // Assert
        assertEquals("rgba(79, 173, 255, 1)", value);
    }


    @Test
    @Tag("formIsOpen")
    void task3() {
        // Arrange
        PageObject pageObject = new PageObject();
        PageElement pageElement = new PageElement();
        open("https://www.performance-lab.ru/");

        // Act
        pageObject.servicesAndProductsTab().shouldBe(visible)
                .hover(); // наводим на меню "Услуги и цены"

        pageElement.automationTesting()
                .shouldBe(visible)
                .click(); // в открывшемся меню находим "Автоматизация тестирования", переходим по ссылке

        $x("//h3[contains(text(), 'Примеры выполненных проектов')]")
                .scrollTo(); // скрол к тексту "примеры выполненных проектов"

        $x("//img[contains(@alt, 'автоматизация тестирования')]")
                .click(); // нашли картинку под текстом "автоматизация тестирования", кликнули

        // Assert
            // 1 способ: проверить что форма видна
        $(By.id("hubspot-Modal-form-Brochur")).shouldBe(visible);

            // 2 способ : проверить у формы отсутствует класс closed (
        //$(By.id("hubspot-Modal-form-Brochur")).shouldNotHave(cssClass("closed"));

        Selenide.sleep(2000);
    }
}