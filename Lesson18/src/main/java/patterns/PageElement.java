package patterns;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;

// Page Elements - взяты ссылки из выпадающего меню "Услуги и цены"

public class PageElement {
        public SelenideElement siteTesting() {
            return $$x("//a[contains(text(),'Тестирование сайта')]").get(1);
        }

        public SelenideElement automationTesting() {
            return $$x("//a[contains(text(),'Автоматизация тестирования')]").get(2);
        }
}

