package tests.veb;

import core.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.veb.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTestWithWrongCredentials extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        //Принятие cookies
        loginPage = new LoginPage();
        loginPage.accertCookie();
    }

    @Test
    public void loginTestWithWrongCredentials() {
        //попытка входа с некорректным паролем
        loginPage.login("incorrectUser", "incorrectPassword");

        //Проверяем наличие ошибки
        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображаются");

        //Проверка текста сообщения об ошибке
        String expectedErrowMassage = "Пользователь с таким телефоном, почтой или логином не найден. Проверьте данные и попробуйте снова.";
        String actualMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrowMassage, actualMessage, "текст сообщения не совпадает");
    }
}
