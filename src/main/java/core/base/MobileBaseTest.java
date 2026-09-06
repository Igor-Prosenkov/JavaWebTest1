package core.base;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class MobileBaseTest extends AbstractBaseTest{

    @Override
    protected void configure() {
        Configuration.browser = "chrome";
        //Настройка эмуляции мобильного устройства
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation",
                Map.of("deviceName", "iPhone XR") //Указываем устройство
        );

        //Применяем настройки ChromeOptions
        Configuration.browserCapabilities = chromeOptions;

    }
}
