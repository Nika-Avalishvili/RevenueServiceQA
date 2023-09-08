package com.aqa.RevenueService.StepObject;

import com.aqa.RevenueService.PageObject.WaybillsPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.sleep;

public class ReceivedWaybillsSteps extends WaybillsPage {

    @Step("1. Go to the e-Services Page of RS.GE")
    public ReceivedWaybillsSteps goToLoginPage() {
        sleep(100);
        eServicesBttn.click();
        sleep(100);
        return this;
    }

    @Step("2. Authorize by testUser")
    public ReceivedWaybillsSteps loginByTestUser() {
        testUsersSectionBttn.click();
        testUserBttn.click();
        return this;
    }

    @Step("3. Go to Manu Page")
    public ReceivedWaybillsSteps goToMenu() {
        menuBttn.click();
        sleep(100);
        return this;
    }

    @Step("4. Go to Waybills Grid Page")
    public ReceivedWaybillsSteps goToWaybillsPage() {
        waybillsSectionBttn.click();
        closePopUp();
        return this;
    }

    @Step("5. Go to Received Waybills Section")
    public ReceivedWaybillsSteps goToReceivedWaybillsSection() {
        receivedWaybillsSection.hover().click();
        sleep(100);
        return this;
    }

    @Step("6. Change grid size to: {greedSize}")
    public ReceivedWaybillsSteps changeGridSize(String greedSize) {
        sleep(100);
        gridSizeSelector.selectOption(greedSize);
        sleep(200);
        return this;
    }

    private void closePopUp(){
        if (popUpWindow.is(Condition.visible)){
            popUpWindow.click();
        }
    }
}
