package pages.mobile;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PhoneRecoveryPageMob extends MobileBaseTest {

    private SelenideElement phoneNumberMob = $("[data-test-id='phone-input']");
    private SelenideElement selectCountyMob = $("[name='country-select-btn']");
    private SelenideElement submitPhoneFormMob = $("[name='phone-submit-btn']");
    private SelenideElement phoneErrorMob = $("[data-test-id='phone-error']");
    private SelenideElement elementsCollectionMob = $("custom-select-option");


    {
        verifyPhoneRecoveryPageMob();
    }

    @Step("Проверяем наличие эл-тов на странице восстановления по номеру телефона")
    public void verifyPhoneRecoveryPageMob() {
        phoneNumberMob.shouldBe(visible);
        selectCountyMob.shouldBe(visible);
        submitPhoneFormMob.shouldBe(visible);
    }

    @Step("Выбираем страну: {countryName}")
    public String selectCountryByNameMob(String countryName) {
        selectCountyMob.shouldBe(visible).click();
        //находим нужную страну по названию
        SelenideElement countryItem = $(String.format(".custom-select-option[data-test-id='country-%s'",
                countryName.toLowerCase().replace(" ", "")));
        String countryCode = countryItem.getAttribute("data-value");
        countryItem.click();
        return countryCode;
    }

    @Step ("Кликаем по кнопке получить код и получаем ошибку")
    public void clickGetCodeWithoutPhoneNumberMob() {
        submitPhoneFormMob.shouldBe(visible).click();
        phoneErrorMob.shouldBe(visible);
    }

}
