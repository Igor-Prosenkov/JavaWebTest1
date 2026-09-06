package tests.mob;

import core.base.MobileBaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.mobile.AnonimRecoveryPageMob;
import pages.mobile.LoginMobPage;
import pages.mobile.MailRecoveryPageMob;

import static com.codeborne.selenide.Selenide.open;

public class AnonymRocoveryByEmailTestMob extends MobileBaseTest {
    private static LoginMobPage loginMobPage;
    private static AnonimRecoveryPageMob anonimRecoveryPageMob;
    public static MailRecoveryPageMob mailRecoveryPageMob;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginMobPage = new LoginMobPage();
    }
        @Test
        public void AnonymRocoveryByEmailTestMob() {
        //попытка входа с некорректными данными
        loginMobPage.login("incorrekt","incorrekt");

        for (int i =0; i < 2; i++) {
            loginMobPage.onlyPasswordMob("321");
        }
        loginMobPage.recoveryPopupMob();
        anonimRecoveryPageMob = new AnonimRecoveryPageMob();
        anonimRecoveryPageMob.clickRecoveryByMailButtonMob();

        mailRecoveryPageMob = new MailRecoveryPageMob();
        mailRecoveryPageMob.verefyMailRecoveryPageMob();
    }
}
