package com.aqa.RevenueService.PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement
            eServicesBttn = $(By.id("headerSingInArrow")),
            testUsersSectionBttn = $(By.id("testUserContainer")),
            testUserBttn = $(By.id("testUserChoose")).$(By.tagName("p"), 0),
            userName = $(By.className("HeaderFullName")),
            userId = $(By.id("ctl00_HeaderTin"));
}
