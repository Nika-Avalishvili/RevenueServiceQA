package com.aqa.RevenueService.calculator;

import com.aqa.RevenueService.DataObject.CalculatorsPageData;
import com.aqa.RevenueService.StepObject.TaxCalculatorSteps;
import com.aqa.RevenueService.Utils.ChromeRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class TaxCalculatorTest extends ChromeRunner {

    public TaxCalculatorSteps taxCalculatorSteps = new TaxCalculatorSteps();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Check if Tax Calculator works properly")
    public void testTaxCalculator() {
        taxCalculatorSteps.goToCalculatorsPage()
                .setProductCode(CalculatorsPageData.productCode)
                .setProductPrice(CalculatorsPageData.productPrice)
                .setTransportationExpenses(CalculatorsPageData.transportationExpenses)
                .setOtherExpenses(CalculatorsPageData.otherExpenses);

        float exciseBeforeCalculations = Float.parseFloat(taxCalculatorSteps.exciseTax.getText());
        float importBeforeCalculations = Float.parseFloat(taxCalculatorSteps.importTax.getText());
        float vatBeforeCalculations = Float.parseFloat(taxCalculatorSteps.valueAddedTax.getText());
        float totalBeforeCalculations = Float.parseFloat(taxCalculatorSteps.totalTax.getText());
        sleep(200);
        taxCalculatorSteps.calculate();

        sleep(100);
        float exciseAfterCalculations = Float.parseFloat(taxCalculatorSteps.exciseTax.getText());
        float importAfterCalculations = Float.parseFloat(taxCalculatorSteps.importTax.getText());
        float vatAfterCalculations = Float.parseFloat(taxCalculatorSteps.valueAddedTax.getText());
        float totalAfterCalculations = Float.parseFloat(taxCalculatorSteps.totalTax.getText());

        Assert.assertEquals(exciseBeforeCalculations, 0.0f, "Initially taxes should be Zero");
        Assert.assertEquals(importBeforeCalculations, 0.0f, "Initially taxes should be Zero");
        Assert.assertEquals(vatBeforeCalculations, 0.0f, "Initially taxes should be Zero");
        Assert.assertEquals(totalBeforeCalculations, 0.0f, "Initially taxes should be Zero");
        Assert.assertEquals(exciseAfterCalculations, 0.0f, "Taxes should be recalculated Correctly");
        Assert.assertEquals(importAfterCalculations, 960.0f, "Taxes should be recalculated Correctly");
        Assert.assertEquals(vatAfterCalculations, 1612.8f, "Taxes should be recalculated Correctly");
        Assert.assertEquals(totalAfterCalculations, 2572.8f, "Taxes should be recalculated Correctly");
    }
}
