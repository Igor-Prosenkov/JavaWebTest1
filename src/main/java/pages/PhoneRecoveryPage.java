package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PhoneRecoveryPage extends LoginPage{
    private SelenideElement phoneNumber = $("[data-test-id='phone-input']");
    private SelenideElement selectCounty = $("[data-test-id='phone-input']");
    private SelenideElement submitPhoneForm = $("[name='phone-submit-btn']");

    {
        verifyPhoneRecoveryPage();
    }

    @Step("Проверяем наличие эл-тов на странице восстановления по номеру телефона")
    public void verifyPhoneRecoveryPage() {
        phoneNumber.shouldBe(visible);
        selectCounty.shouldBe(visible);
        submitPhoneForm.shouldBe(visible);
    }


}
