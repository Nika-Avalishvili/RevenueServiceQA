package com.aqa.RevenueService.StepObject;

import com.aqa.RevenueService.PageObject.LoginPage;
import io.qameta.allure.Step;

public class LoginPageSteps extends LoginPage {

    @Step("1. Go to the e-Services Page of RS.GE")
    public LoginPageSteps goToLoginPage() {
        eServicesBttn.click();
        return this;
    }

    @Step("2. Authorize by testUser")
    public LoginPageSteps loginByTestUser() {
        testUsersSectionBttn.click();
        testUserBttn.click();
        return this;
    }

}
