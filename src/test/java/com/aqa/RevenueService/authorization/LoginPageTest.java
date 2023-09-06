package com.aqa.RevenueService.authorization;

import com.aqa.RevenueService.DataObject.LoginPageData;
import com.aqa.RevenueService.StepObject.LoginPageSteps;
import com.aqa.RevenueService.Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends ChromeRunner {

    private LoginPageSteps loginPageSteps = new LoginPageSteps();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Check if the 'test' user has signed in successfully on the RS.GE")
    public void shouldSignInSuccessfully() {
        loginPageSteps.goToLoginPage().loginByTestUser();

        String actualUserName = loginPageSteps.userName
                .shouldBe(Condition.visible)
                .getText();
        String actualUserId = loginPageSteps.userId
                .shouldBe(Condition.visible)
                .getText();

        Assert.assertEquals(actualUserName, LoginPageData.userName);
        Assert.assertEquals(actualUserId, LoginPageData.userId);
    }
}
