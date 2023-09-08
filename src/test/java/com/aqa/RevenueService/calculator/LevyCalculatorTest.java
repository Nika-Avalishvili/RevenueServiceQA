package com.aqa.RevenueService.calculator;

import com.aqa.RevenueService.DataObject.CalculatorsPageData;
import com.aqa.RevenueService.StepObject.LevyCalculatorSteps;
import com.aqa.RevenueService.Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LevyCalculatorTest extends ChromeRunner {

    public LevyCalculatorSteps levyCalculatorSteps = new LevyCalculatorSteps();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Check if Levy Calculator for CARs works properly")
    public void testLevyCalculatorForCars() {
        levyCalculatorSteps.exciseTax.shouldNot(Condition.visible);
        levyCalculatorSteps.customFee.shouldNot(Condition.visible);
        levyCalculatorSteps.total.shouldNot(Condition.visible);

        levyCalculatorSteps.goToCalculatorsPage()
                .goToLevyCalculatorSection()
                .selectIfCarIsHybrid(CalculatorsPageData.hybrid)
                .selectIfCarIsSteeringWheel(CalculatorsPageData.isSteeringWheel)
                .setYear(CalculatorsPageData.year)
                .setSize(CalculatorsPageData.engineSize)
                .calculate();

        levyCalculatorSteps.exciseTax.shouldBe(Condition.visible);
        levyCalculatorSteps.customFee.shouldBe(Condition.visible);
        levyCalculatorSteps.total.shouldBe(Condition.visible);

        float exciseTax = Float.parseFloat(levyCalculatorSteps.exciseTax.getText());
        float customFee = Float.parseFloat(levyCalculatorSteps.customFee.getText());
        float total = Float.parseFloat(levyCalculatorSteps.total.getText());

        Assert.assertEquals(exciseTax + customFee, total, "Total amount should be calculated correctly");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Check if Levy Calculator for MOTOs works properly")
    public void testLevyCalculatorForMoto() {
        levyCalculatorSteps.goToCalculatorsPage()
                .goToLevyCalculatorSection()
                .selectMoto()
                .setYearMoto(CalculatorsPageData.year)
                .setSizeMoto(CalculatorsPageData.engineSizeMoto)
                .calculateMoto();

        levyCalculatorSteps.motoExciseTax.shouldBe(Condition.visible);

        float exciseTaxBefore = Float.parseFloat(levyCalculatorSteps.motoExciseTax.getText());

        levyCalculatorSteps
                .setYearMoto(Integer.parseInt(CalculatorsPageData.year) - 5 + "")
                .setSizeMoto(Integer.parseInt(CalculatorsPageData.engineSizeMoto) + 10 + "")
                .calculateMoto();

        float exciseTaxAfter = Float.parseFloat(levyCalculatorSteps.motoExciseTax.getText());

        Assert.assertTrue(exciseTaxBefore > 0.0f, "Excise amount should be positive number");
        Assert.assertTrue(exciseTaxBefore <= exciseTaxAfter, "Excise amount after recalculation should be greater than previous amount");
    }
}
