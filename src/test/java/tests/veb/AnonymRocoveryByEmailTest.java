package tests.veb;

import core.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.veb.AnonimRecoveryPage;
import pages.veb.LoginPage;
import pages.veb.MailRecoveryPage;

import static com.codeborne.selenide.Selenide.open;

public class AnonymRocoveryByEmailTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonimRecoveryPage anonimRecoveryPage;
    public static MailRecoveryPage mailRecoveryPage;

    @BeforeEach
    public void prepare(){
       open(baseUrl);
       loginPage = new LoginPage();
    }

    @Test
    public void AnonymRocoveryByEmailTest() {
        //попытка входа с некорректными данными
        loginPage.login("incorrekt","incorrekt");

        for (int i =0; i < 2; i++) {
            loginPage.onlyPassword("321");
        }
        loginPage.recoveryPopup();
        anonimRecoveryPage = new AnonimRecoveryPage();
        anonimRecoveryPage.clickRecoveryByMailButton();

        mailRecoveryPage = new MailRecoveryPage();
        mailRecoveryPage.verefyMailRecoveryPage();
    }

}
