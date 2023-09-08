package com.aqa.RevenueService.StepObject;

import com.aqa.RevenueService.PageObject.TaxCalculatorPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.sleep;

public class TaxCalculatorSteps extends TaxCalculatorPage {

    @Step("1. Go to Calculators Page of RS.GE")
    public TaxCalculatorSteps goToCalculatorsPage() {
        sleep(200);
        while (!importTaxCalculatorBttn.isDisplayed()) {
            sleep(150);
            nextPageBttn.scrollIntoView(true);
            nextPageBttn.click();
        }

        importTaxCalculatorBttn.click();
        return this;
    }

    @Step("2. Set Product Code: {productCode}")
    public TaxCalculatorSteps setProductCode(String productCode) {
        productCodeInput.setValue(productCode);
        return this;
    }

    @Step("3. Set Product Price: {productPrice}")
    public TaxCalculatorSteps setProductPrice(String productPrice) {
        productPriceInput.setValue(productPrice);
        return this;
    }

    @Step("4. Set Transportation Expense Amount: {transportationExpenses}")
    public TaxCalculatorSteps setTransportationExpenses(String transportationExpenses) {
        transportationExpensesInput.setValue(transportationExpenses);
        return this;
    }

    @Step("5. Set Other Expenses: {otherExpenses}")
    public TaxCalculatorSteps setOtherExpenses(String otherExpenses) {
        otherExpensesInput.setValue(otherExpenses);
        return this;
    }

    @Step("6. Calculate Taxes")
    public TaxCalculatorSteps calculate() {
        calculateBttn.click();
        sleep(200);
        return this;
    }

}
