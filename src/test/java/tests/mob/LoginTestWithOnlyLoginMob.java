package tests.mob;


import core.base.MobileBaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.mobile.LoginMobPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTestWithOnlyLoginMob extends MobileBaseTest {
    private static LoginMobPage loginMobPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginMobPage = new LoginMobPage();
    }

    @Test
    public void loginTestWithOnlyLoginMob(){
        loginMobPage.onlyLoginMob("vdsv1");

        //Проверяем наличие ошибки
        assertTrue(loginMobPage.isErrorMessageVisibleMob(), "Сообщение об ошибке входа не отображаются");

        //Проверка текста сообщения об ошибке
        String expectedErrowMassageMob = "Введите телефон, email или логин и пароль.";
        String actualMessage = loginMobPage.getErrorMessageTextMob();
        assertEquals(expectedErrowMassageMob, actualMessage, "текст сообщения не совпадает");

    }

}
