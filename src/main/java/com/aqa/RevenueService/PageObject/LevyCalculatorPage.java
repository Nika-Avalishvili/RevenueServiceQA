package com.aqa.RevenueService.PageObject;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByTagAndText;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LevyCalculatorPage {

    public SelenideElement
            importTaxCalculatorBttn = $(new ByTagAndText("p", "იმპორტის გადასახდელის კალკულატორი")),
            nextPageBttn = $(By.id("ic_keyboard_arrow_right_24px")),
            levyCalculatorSection = $(new ByTagAndText("a", "ავტო/მოტო განბაჟების გამომთვლელი")),
            motoTab = $(By.id("MotoTab")),
            hybrid = $(By.id("hybrid")),
            electric = $(By.id("electric")),
            steeringWheel = $(By.id("steeringwheel")),
            manufactureYear = $(By.id("amount")),
            motoManufactureYear = $(By.id("Motoamount")),
            motoEngineSize = $(By.id("Motoenginesize")),
            engineSize = $(By.id("enginesize")),
            calculateBttn = $(By.id("CalculateBtn")),
            motoCalculateBttn = $(By.id("MotoCalculateBtn")),
            exciseTax = $(By.id("Aqcizi")),
            motoExciseTax = $(By.id("MotoAqcizi")),
            customFee = $(By.id("Sabgad")),
            total = $(By.id("sum"));

}
