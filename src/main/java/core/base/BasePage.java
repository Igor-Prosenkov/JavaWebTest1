package core.base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    protected SelenideElement headerLogo = $("[tsid='toolbar_logo']");
    protected SelenideElement seachField =  $("[name='st.query']");
    protected SelenideElement vkServices =  $("[data-l='t,vk_ecosystem]");

   //Метод для поиска по сайту
    public void search(String query) {
        seachField.shouldBe(visible).setValue(query).pressEnter();
    }

    //клик по иконке
    public void openVkservices() {
        vkServices.shouldBe(visible).click();
    }

    //Клик на логотип ОК
    public void ckickLogo(){
        headerLogo.shouldBe(visible).click();
    }
}
