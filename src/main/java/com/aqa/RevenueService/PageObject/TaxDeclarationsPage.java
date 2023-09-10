package com.aqa.RevenueService.PageObject;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByTagAndText;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TaxDeclarationsPage {

    public SelenideElement
            eServicesBttn = $(By.id("headerSingInArrow")),
            testUsersSectionBttn = $(By.id("testUserContainer")),
            testUserBttn = $(By.id("testUserChoose")).$(By.tagName("p"), 0),
            menuBttn = $(By.className("txt-menu")),
            taxDeclaratioBttn = $(new ByTagAndText("p", "დეკლარაციები")),
            monthlyDeclaratioBttn = $(By.id("hka1")).$(new ByTagAndText("a", "ყოველთვიური")),
            valueAddedTaxDeclarationSection = $(new ByTagAndText("td", "დღგ")),
            draftVATDeclaration = $(new ByTagAndText("td", "შენახული")),
            newVATDeclaration = $(new ByTagAndText("div", "ახალი დეკლარაცია")),
            removeVATDeclarationDraft = $(By.className("must_remove"), 0).$(By.className("t"), 9).$(By.tagName("img")),
            openVATDeclaration = $(By.className("must_remove"), 0).$(By.className("t"), 11),
            valueAddedTaxDeclarationHeader = $(new ByTagAndText("li", "დამატებული ღირებულების გადასახადის დეკლარაცია")),
            salesAmountInput = $(By.id("control_300_1")),
            barterAmountInput = $(By.id("control_300_7")),
            otherTaxableAmountInput = $(By.id("control_300_8")),
            vatForSales = $(By.id("control_300_1_5")),
            vatForBarter = $(By.id("control_300_7_5")),
            vatForotherTaxableOperations = $(By.id("control_300_8_5")),
            reverseVATPage = $(By.className("tab_ittems_holder")).$(new ByTagAndText("li", "2")),
            turnoverAmountForReverseVATInput = $(By.id("control_301_1")),
            reverseVAT = $(By.id("control_301_15")),
            lastPage = $(By.className("tab_ittems_holder")).$(new ByTagAndText("li", "შედეგი")),
            finalizeBttn = $(new ByTagAndText("div", "შემდეგ")),
            totalVAT = $(By.id("control_303_17")),
            sendVATDeclarationBttn = $(new ByTagAndText("div", "გადაგზავნა"));
}
