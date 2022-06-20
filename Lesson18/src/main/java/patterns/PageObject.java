package patterns;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


// Page Object - взято выпадающее при наведении меню "Услуги и цены"
public class PageObject {
    public SelenideElement servicesAndProductsTab() {
        return $(By.id("menu-item-317"));
    }
}
