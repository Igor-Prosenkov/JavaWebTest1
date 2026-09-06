package pages.mobile;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MailRecoveryPageMob extends MobileBaseTest {

    private SelenideElement emailInputMob = $("[data-test-id='email-input']");
    private SelenideElement submitEmailFormVob = $("[data-test-id='email-submit-btn']");

    {
        verefyMailRecoveryPageMob();
    }

    public void verefyMailRecoveryPageMob() {
        emailInputMob.shouldBe(visible);
        submitEmailFormVob.shouldBe(visible);
    }

}
