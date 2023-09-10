package com.aqa.RevenueService.StepObject;

import com.aqa.RevenueService.PageObject.TaxDeclarationsPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.sleep;

public class TaxDeclarationsPageSteps extends TaxDeclarationsPage {

    @Step("1. Go to the e-Services Page of RS.GE")
    public TaxDeclarationsPageSteps goToLoginPage() {
        eServicesBttn.click();
        return this;
    }

    @Step("2. Authorize by testUser")
    public TaxDeclarationsPageSteps loginByTestUser() {
        testUsersSectionBttn.click();
        testUserBttn.click();
        sleep(200);
        return this;
    }

    @Step("3. Go to Manu Page")
    public TaxDeclarationsPageSteps goToMenu() {
        sleep(100);
        menuBttn.click();
        sleep(200);
        return this;
    }

    @Step("4. Go to Tax Declarations Page")
    public TaxDeclarationsPageSteps goToTaxDeclarationsPage() {
        sleep(100);
        taxDeclaratioBttn.click();
        sleep(300);
        return this;
    }

    @Step("5. Select Monthly Declarations Section")
    public TaxDeclarationsPageSteps selectMonthlyDeclarations() {
        sleep(300);
        monthlyDeclaratioBttn.click();
        sleep(100);
        return this;
    }

    @Step("6. Select VAT Section")
    public TaxDeclarationsPageSteps selectVATDeclarations() {
        sleep(200);
        valueAddedTaxDeclarationSection.click();
        sleep(100);
        return this;
    }

    @Step("7. Create New VAT Declaration")
    public TaxDeclarationsPageSteps createVATDeclaration() {
        if (draftVATDeclaration.is(Condition.visible)) {
            removeVATDeclarationDraft.click();
        }
        sleep(100);
        newVATDeclaration.click();
        sleep(200);
        return this;
    }

    @Step("8. Open New VAT Declaration")
    public TaxDeclarationsPageSteps openVATDeclaration() {
        sleep(300);
        openVATDeclaration.click();
        sleep(100);
        return this;
    }

    @Step("9. Set taxable amounts: sales - {salesAmount} GEL, barter - {barterAmount} GEL, other - {otherAmount} GEL;")
    public TaxDeclarationsPageSteps setTaxableAmounts(String salesAmount,
                                                      String barterAmount,
                                                      String otherAmount) {
        sleep(300);
        salesAmountInput.setValue(salesAmount);
        barterAmountInput.setValue(barterAmount);
        otherTaxableAmountInput.setValue(otherAmount).pressTab();
        sleep(200);
        return this;
    }

    @Step("10. Go to ReverseVAT Page")
    public TaxDeclarationsPageSteps goToReverseVATPage() {
        reverseVATPage.click();
        sleep(200);
        return this;
    }

    @Step("11. Set Turnover Amount for Reverse VAT - {turnover}")
    public TaxDeclarationsPageSteps setTurnoverForReverseVAT(String turnover) {
        sleep(200);
        turnoverAmountForReverseVATInput.setValue(turnover).pressTab();
        sleep(100);
        return this;
    }

    @Step("12. Go to Final Page of VAT Declaration")
    public TaxDeclarationsPageSteps goToFinalPage() {
        sleep(100);
        lastPage.click();
        sleep(100);
        return this;
    }

}
