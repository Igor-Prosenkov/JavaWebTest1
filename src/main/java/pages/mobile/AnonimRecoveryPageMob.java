package pages.mobile;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonimRecoveryPageMob extends MobileBaseTest {

    private SelenideElement recoveryByPhoneButtonMob = $("[name='recovery-phone-btn']");
    private SelenideElement recoveryByMailButtonMob = $("[name='recovery-email-btn']");
    private SelenideElement goToSupportButtonMob = $("[name='support-contact-btn']");
    private SelenideElement clouseSupportChatMob = $("[name='support-dialog-close']");


    {
        verifyPageElements();
    }

    @Step("Проверяем наличие всех элементов на странице восстановления пароля")
    public void verifyPageElements(){
        recoveryByPhoneButtonMob.shouldBe(visible);
        recoveryByMailButtonMob.shouldBe(visible);
        goToSupportButtonMob.shouldBe(visible);
    }

    @Step("Кликаем по кнопке восстановления по телефону")
    public void clickRecoveryByPhoneButtonMob() {
        recoveryByPhoneButtonMob.shouldBe(visible).click();
    }

    @Step("Кликаем по кнопке восстановления по имейлу")
    public void clickRecoveryByMailButtonMob(){
        recoveryByMailButtonMob.shouldBe(visible).click();
    }

    @Step("Кликаем по кнопке связи с поддержкой и закрываем окно чата")
    public void clickToSupportButtonMob() {
        goToSupportButtonMob.shouldBe(visible).click();
        clouseSupportChatMob.shouldBe(visible).click();
    }


}
