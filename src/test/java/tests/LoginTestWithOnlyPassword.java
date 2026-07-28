package tests;


import core.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTestWithOnlyPassword extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
        loginPage.accertCookie();
    }

    @Test
    public void LoginTestWithOnlyPassword() {
        loginPage.onlyLogin("fgnfgn");
        //Проверяем наличие ошибки
        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображаются");

        //Проверка текста сообщения об ошибке
        String expectedErrowMassage = "Введите телефон, email или логин и пароль.";
        String actualMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrowMassage, actualMessage, "текст сообщения не совпадает");
    }
}
