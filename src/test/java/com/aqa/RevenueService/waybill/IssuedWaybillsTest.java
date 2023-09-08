package com.aqa.RevenueService.waybill;

import com.aqa.RevenueService.DataObject.WaybillsPageData;
import com.aqa.RevenueService.StepObject.IssuedWaybillsSteps;
import com.aqa.RevenueService.Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class IssuedWaybillsTest extends ChromeRunner {

    private final IssuedWaybillsSteps issuedWaybillsSteps = new IssuedWaybillsSteps();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check if new waybill has issued successfully")
    public void shouldIssueNewWaybill() {
        issuedWaybillsSteps
                .goToLoginPage()
                .loginByTestUser()
                .goToMenu()
                .goToWaybillsPage();

        Integer initialNumOfWaybills = numberOfWaybills();
        Selenide.executeJavaScript("window.scrollTo(0, 0);");

        issuedWaybillsSteps.initiateNewWaybill()
                .selectWaybillType(WaybillsPageData.waybillType)
                .setVendorId(WaybillsPageData.vendorId)
                .setProductId(WaybillsPageData.productId)
                .setProductName(WaybillsPageData.product)
                .selectProductUnit(WaybillsPageData.unit)
                .setProductPrice(WaybillsPageData.unitPrice)
                .setProductQuantity(WaybillsPageData.quantity)
                .selectTaxationType(WaybillsPageData.taxation)
                .addProduct()
                .writeComment(WaybillsPageData.comment)
                .activateWaybill();

        sleep(100);
        issuedWaybillsSteps.waybillsSectionBttn.shouldBe(Condition.visible);

        Integer finalNumberOfInvoices = numberOfWaybills();

        Assert.assertEquals(finalNumberOfInvoices, initialNumOfWaybills + 1, "New waybill has successfully added in the grid!");
    }

    private Integer numberOfWaybills() {
        issuedWaybillsSteps.gridFilterByDescription.scrollIntoView(true).pressEscape();
        issuedWaybillsSteps.gridFilterByDescription.setValue(WaybillsPageData.comment).pressEnter();
        issuedWaybillsSteps.totalNumberOfFilteredWaybills.scrollIntoView(true);
        sleep(100);
        return Integer.parseInt(issuedWaybillsSteps
                .totalNumberOfFilteredWaybills.getText());
    }

}
