package pages.veb;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonimRecoveryPage extends BasePage {

    private SelenideElement recoveryByPhoneButton = $("[name='recovery-phone-btn']");
    private SelenideElement recoveryByMailButton = $("[name='recovery-email-btn']");
    private SelenideElement goToSupportButton = $("[name='support-contact-btn']");
    private SelenideElement clouseSupportChat = $("[name='support-dialog-close']");


    {
        verifyPageElements();
    }

    @Step("Проверяем наличие всех элементов на странице восстановления пароля")
    public void verifyPageElements(){
        recoveryByPhoneButton.shouldBe(visible);
        recoveryByMailButton.shouldBe(visible);
        goToSupportButton.shouldBe(visible);
    }

    @Step("Кликаем по кнопке восстановления по телефону")
    public void clickRecoveryByPhoneButton() {
        recoveryByPhoneButton.shouldBe(visible).click();
    }

    @Step("Кликаем по кнопке восстановления по имейлу")
    public void clickRecoveryByMailButton(){
        recoveryByMailButton.shouldBe(visible).click();
    }

    @Step("Кликаем по кнопке связи с поддержкой и закрываем окно чата")
    public void clickToSupportButton() {
        goToSupportButton.shouldBe(visible).click();
        clouseSupportChat.shouldBe(visible).click();
    }
}
