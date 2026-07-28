package pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MailRecoveryPage extends BasePage {
    private SelenideElement emailInput = $("[data-test-id='email-input']");
    private SelenideElement submitEmailForm = $("[data-test-id='email-submit-btn']");

    {
        verefyMailRecoveryPage();
    }

    public void verefyMailRecoveryPage() {
        emailInput.shouldBe(visible);
        submitEmailForm.shouldBe(visible);
    }

}
