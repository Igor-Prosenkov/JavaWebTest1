package pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PhoneRecoveryPage extends BasePage {
    private SelenideElement phoneNumber = $("[data-test-id='phone-input']");
    private SelenideElement selectCounty = $("[name='country-select-btn']");
    private SelenideElement submitPhoneForm = $("[name='phone-submit-btn']");
    private SelenideElement phoneError = $("[data-test-id='phone-error']");
    private SelenideElement elementsCollection = $("custom-select-option");


    {
        verifyPhoneRecoveryPage();
    }

    @Step("Проверяем наличие эл-тов на странице восстановления по номеру телефона")
    public void verifyPhoneRecoveryPage() {
        phoneNumber.shouldBe(visible);
        selectCounty.shouldBe(visible);
        submitPhoneForm.shouldBe(visible);
    }

    @Step("Выбираем страну: {countryName}")
    public String selectCountryByName(String countryName) {
        selectCounty.shouldBe(visible).click();
        //находим нужную страну по названию
        SelenideElement countryItem = $(String.format(".custom-select-option[data-test-id='country-%s'",
                countryName.toLowerCase().replace(" ", "")));
        String countryCode = countryItem.getAttribute("data-value");
        countryItem.click();
        return countryCode;
    }

    @Step ("Кликаем по кнопке получить код и получаем ошибку")
    public void clickGetCodeWithoutPhoneNumber() {
        submitPhoneForm.shouldBe(visible).click();
        phoneError.shouldBe(visible);
    }


}
