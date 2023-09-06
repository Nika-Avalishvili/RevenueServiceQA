package com.aqa.RevenueService.Utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;

public class ChromeRunner {

    public WebDriver driver;

    @BeforeTest(description = "Browser configurations setup")
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1512x982";
        driver = WebDriverManager.chromedriver().create();

        open("https://rs.ge/");
    }

    @AfterTest(description = "Clean up cache and close browser")
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }

}
