package core.base;

import com.codeborne.selenide.Configuration;

public class BaseTest extends AbstractBaseTest{
    protected static String baseUrl;

    @Override
    protected void configure() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

}
