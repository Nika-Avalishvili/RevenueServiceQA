package com.aqa.RevenueService.declaration;

import com.aqa.RevenueService.DataObject.TaxDeclarationPageData;
import com.aqa.RevenueService.StepObject.TaxDeclarationsPageSteps;
import com.aqa.RevenueService.Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class ValueAddedTaxDeclarationTest extends ChromeRunner {

    public final TaxDeclarationsPageSteps taxDeclarationsPageSteps = new TaxDeclarationsPageSteps();


    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Check If Tax Declarations Feature Works Properly")
    public void testVATDeclarations() {
        taxDeclarationsPageSteps.goToLoginPage()
                .loginByTestUser()
                .goToMenu()
                .goToTaxDeclarationsPage()
                .selectMonthlyDeclarations()
                .selectVATDeclarations()
                .createVATDeclaration()
                .openVATDeclaration();

        taxDeclarationsPageSteps.valueAddedTaxDeclarationHeader.shouldBe(Condition.visible);

        float initialSalesVAT = Float.parseFloat(taxDeclarationsPageSteps.vatForSales.getValue());
        float initialBarterVAT = Float.parseFloat(taxDeclarationsPageSteps.vatForBarter.getValue());
        float initialOtherVAT = Float.parseFloat(taxDeclarationsPageSteps.vatForotherTaxableOperations.getValue());

        taxDeclarationsPageSteps.setTaxableAmounts(TaxDeclarationPageData.salesAmount,
                TaxDeclarationPageData.barterAmount,
                TaxDeclarationPageData.otherAmount);

        sleep(200);
        float finalSalesVAT = Float.parseFloat(taxDeclarationsPageSteps.vatForSales.getValue());
        float finalBarterVAT = Float.parseFloat(taxDeclarationsPageSteps.vatForBarter.getValue());
        float finalOtherVAT = Float.parseFloat(taxDeclarationsPageSteps.vatForotherTaxableOperations.getValue());

        taxDeclarationsPageSteps.goToReverseVATPage();
        taxDeclarationsPageSteps.reverseVAT.shouldBe(Condition.visible);
        sleep(100);

        float initialReverseVAT = Float.parseFloat(taxDeclarationsPageSteps.reverseVAT.getValue());
        sleep(100);

        taxDeclarationsPageSteps.setTurnoverForReverseVAT(TaxDeclarationPageData.turnoverAmountForReverseVAT);
        float finalReverseVAT = Float.parseFloat(taxDeclarationsPageSteps.reverseVAT.getValue());
        float sum = finalSalesVAT + finalBarterVAT + finalOtherVAT + finalReverseVAT;

        taxDeclarationsPageSteps.goToFinalPage();
        int totalTaxAmount = Integer.parseInt(taxDeclarationsPageSteps.totalVAT.scrollIntoView(true).getValue());
        int expectedTotalTaxAmount = (int)
                (( Float.parseFloat(TaxDeclarationPageData.salesAmount)
                        + Float.parseFloat(TaxDeclarationPageData.barterAmount)
                        + Float.parseFloat(TaxDeclarationPageData.otherAmount)
                        + Float.parseFloat(TaxDeclarationPageData.turnoverAmountForReverseVAT)) * 0.18f);

        Assert.assertEquals(initialSalesVAT, 0.0f, "Initially tax amounts must be ZERO");
        Assert.assertEquals(initialBarterVAT, 0.0f, "Initially tax amounts must be ZERO");
        Assert.assertEquals(initialOtherVAT, 0.0f, "Initially tax amounts must be ZERO");
        Assert.assertEquals(initialReverseVAT, 0.0f, "Initially tax amounts must be ZERO");
        Assert.assertEquals(sum, totalTaxAmount, "Total Amount Calculations Must Be Correct!");
        Assert.assertEquals(totalTaxAmount,expectedTotalTaxAmount, "Total Amount Calculations Must Be Correct!");
    }
}
