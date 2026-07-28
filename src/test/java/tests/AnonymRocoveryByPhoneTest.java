package tests;

import core.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AnonimRecoveryPage;
import pages.LoginPage;
import pages.PhoneRecoveryPage;

import static com.codeborne.selenide.Selenide.open;

public class AnonymRocoveryByPhoneTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonimRecoveryPage anonimRecoveryPage;
    private static PhoneRecoveryPage phoneRecoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void AnonymRocoveryByPhoneTest() {
        //попытка входа с некорректными данными
        loginPage.login("incorrekt","incorrekt");

        for (int i =0; i < 2; i++) {
          loginPage.onlyPassword("321");
        }

        loginPage.recoveryPopup();
        anonimRecoveryPage = new AnonimRecoveryPage();
        anonimRecoveryPage.clickRecoveryByPhoneButton();

        phoneRecoveryPage = new PhoneRecoveryPage();

}
}
