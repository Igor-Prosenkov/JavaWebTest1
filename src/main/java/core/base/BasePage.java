package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    protected SelenideElement headerLogo = $("[name='logo-icon']");
    protected SelenideElement seachField =  $("[name='search-input']");
    protected SelenideElement Services =  $("[name='header-services-arrow']");
    protected SelenideElement accertCookieButton = $("[name='cookie-accept-btn']");

  @Step ("Метод для поиска по сайту")
    public void search(String query) {
        seachField.shouldBe(visible).setValue(query).pressEnter();
    }

    @Step ("клик по иконке")
    public void openServices() {
        Services.shouldBe(visible).click();
    }

    @Step ("Клик на логотип CC")
    public void ckickLogo(){
        headerLogo.shouldBe(visible).click();
    }

    @Step ("Принимаем куки")
    public void accertCookie(){
        accertCookieButton.shouldBe(visible).click();
    }
}
