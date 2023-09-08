package com.aqa.RevenueService.StepObject;

import com.aqa.RevenueService.PageObject.LevyCalculatorPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.sleep;

public class LevyCalculatorSteps extends LevyCalculatorPage {

    @Step("1. Go to Calculators Page of RS.GE")
    public LevyCalculatorSteps goToCalculatorsPage() {
        sleep(200);
        while (!importTaxCalculatorBttn.isDisplayed()) {
            sleep(50);
            nextPageBttn.scrollIntoView(true);
            nextPageBttn.click();
        }

        importTaxCalculatorBttn.click();
        return this;
    }

    @Step("2. Select LevyCalculator Section")
    public LevyCalculatorSteps goToLevyCalculatorSection() {
        sleep(100);
        levyCalculatorSection.click();
        sleep(200);
        return this;
    }

    @Step("2.1 Select Moto Section")
    public LevyCalculatorSteps selectMoto() {
        sleep(100);
        motoTab.click();
        sleep(100);
        return this;
    }

    @Step("3. Select if car is Hybrid: {isHybrid}")
    public LevyCalculatorSteps selectIfCarIsHybrid(Boolean isHybrid) {
        if (!isHybrid) {
            return this;
        }
        hybrid.click();
        return this;
    }

    @Step("4. Select if car is SteeringWheel: {isSteeringwheel}")
    public LevyCalculatorSteps selectIfCarIsSteeringWheel(Boolean isSteeringwheel) {
        if (!isSteeringwheel) {
            return this;
        }
        steeringWheel.click();
        return this;
    }

    @Step("5. Set manufacture year: {year}")
    public LevyCalculatorSteps setYear(String year) {
        manufactureYear.setValue(year);
        return this;
    }

    @Step("5. Set manufacture year: {year}")
    public LevyCalculatorSteps setYearMoto(String year) {
        motoManufactureYear.setValue(year);
        return this;
    }

    @Step("6. Set engine size: {size}")
    public LevyCalculatorSteps setSize(String size) {
        engineSize.setValue(size);
        return this;
    }

    @Step("6. Set engine size: {size}")
    public LevyCalculatorSteps setSizeMoto(String size) {
        motoEngineSize.setValue(size);
        return this;
    }

    @Step("7. Calculate taxes")
    public LevyCalculatorSteps calculate() {
        calculateBttn.click();
        return this;
    }

    @Step("7. Calculate taxes")
    public LevyCalculatorSteps calculateMoto() {
        motoCalculateBttn.click();
        return this;
    }
}
