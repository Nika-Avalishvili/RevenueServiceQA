package com.aqa.RevenueService.PageObject;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByTagAndText;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TaxCalculatorPage {

    public SelenideElement
            importTaxCalculatorBttn = $(new ByTagAndText("p", "იმპორტის გადასახდელის კალკულატორი")),
            nextPageBttn = $(By.id("ic_keyboard_arrow_right_24px")),
            productCodeInput = $(By.id("txtCode1")),
            productPriceInput = $(By.id("txtPrice1")),
            transportationExpensesInput = $(By.id("txtTransport1")),
            otherExpensesInput = $(By.id("txtOther1")),
            importTax = $(By.id("Label1")),
            exciseTax = $(By.id("Label2")),
            valueAddedTax = $(By.id("Label3")),
            totalTax = $(By.id("Label4")),
            calculateBttn = $(By.id("Button1"));
}
