package tests;

import core.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class TestQrCodeVisibilityAfterSwitch extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
        loginPage.accertCookie();
    }

    @Test
    public void testQrCodeVisibilityAfterSwitch(){
        loginPage.openQrCodeAndAssertVisible();
    }

}
