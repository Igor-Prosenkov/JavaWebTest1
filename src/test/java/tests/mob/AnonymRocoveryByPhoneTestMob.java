package tests.mob;

import core.base.MobileBaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.mobile.AnonimRecoveryPageMob;
import pages.mobile.LoginMobPage;
import pages.mobile.PhoneRecoveryPageMob;
import pages.veb.AnonimRecoveryPage;
import pages.veb.PhoneRecoveryPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnonymRocoveryByPhoneTestMob extends MobileBaseTest {

    public static LoginMobPage loginMobPage;
    private static AnonimRecoveryPageMob anonimRecoveryPageMob;
    private static PhoneRecoveryPageMob phoneRecoveryPageMob;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginMobPage = new LoginMobPage();
    }

    @Test
    public void AnonymRocoveryByPhoneTestMob() {
        //попытка входа с некорректными данными
        loginMobPage.login("incorrekt", "incorrekt");

        for (int i = 0; i < 2; i++) {
            loginMobPage.onlyPasswordMob("321");
        }

        loginMobPage.recoveryPopupMob();
        anonimRecoveryPageMob = new AnonimRecoveryPageMob();
        anonimRecoveryPageMob.clickRecoveryByPhoneButtonMob();

        phoneRecoveryPageMob = new PhoneRecoveryPageMob();
        phoneRecoveryPageMob.verifyPhoneRecoveryPageMob();
        String countryCode = phoneRecoveryPageMob.selectCountryByNameMob("australia");
        phoneRecoveryPageMob.clickGetCodeWithoutPhoneNumberMob();
        assertEquals("+61", countryCode,"Код страны не совпадает");
        phoneRecoveryPageMob.clickGetCodeWithoutPhoneNumberMob();
    }
}
