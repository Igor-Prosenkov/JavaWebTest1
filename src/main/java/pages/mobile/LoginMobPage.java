package pages.mobile;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginMobPage extends MobileBaseTest {
    private SelenideElement loginField = $("[name='login-phone-email']");
    private SelenideElement passwordField = $("[name='login-password']");
    private SelenideElement loginButton = $("[name='login-submit-btn']");
    private SelenideElement forgotPasswordLink = $("[name='forgot-password-link']");
    private SelenideElement registrationButton = $("[name='hero-register-btn']");
    private SelenideElement qrButton = $("[data-test-id='tab-qr']");
    private SelenideElement qrPuctureButton = $("[fill='currentColor']");

    //локатор ошибки при входе
    private SelenideElement errorMessage = $("[data-test-id='login-error']");

    //локатор для кнопки восстановить профиль
    private SelenideElement  RecoveryPopup = $("[data-test-id='lockout-recover-btn']");
    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        loginField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        qrButton.shouldBe(visible);
    }

    @Step ("Проверяем сообщения об ошибке входа")
    public Boolean isErrorMessageVisibleMob() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step ("Проверяем текст сообщения об ошибке входа")
    public String getErrorMessageTextMob() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step ("Вход на сайт с логином {username} и {password}")
    public void login(String username, String password) {
        loginField.shouldBe(visible).click();
        loginField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step ("Вход на сайт только с логином{username}")
    public void onlyLoginMob(String username){
        loginField.shouldBe(visible).click();
        loginField.shouldBe(visible).setValue(username);
        loginButton.shouldBe(visible).click();
    }

    @Step ("Вход на сайт только с паролем {password}")
    public void onlyPasswordMob(String password) {
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step ("переход на страницу регистрации")
    public void openRegisterPageMob(){
        registrationButton.shouldBe(visible).click();
    }

    @Step("Переход на страницу восстановления пароля")
    public void openForgotPasswordPageMob() {
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step ("Переход на страницу восстановления пароля после 3-х неудачных попыток")
    public void recoveryPopupMob() {
        RecoveryPopup.shouldBe(visible).click();
    }

    @Step ("переключение на qr-код  и проверка его отображения")
    public void openQrCodeAndAssertVisibleMob(){
        qrButton.shouldBe(visible).click();
        qrPuctureButton.shouldBe(visible);
    }
}


