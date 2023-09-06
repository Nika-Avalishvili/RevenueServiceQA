package com.aqa.RevenueService.StepObject;

import com.aqa.RevenueService.PageObject.WaybillsPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.sleep;

public class IssuedWaybillsSteps extends WaybillsPage {

    @Step("1. Go to the e-Services Page of RS.GE")
    public IssuedWaybillsSteps goToLoginPage() {
        eServicesBttn.click();
        return this;
    }

    @Step("2. Authorize by testUser")
    public IssuedWaybillsSteps loginByTestUser() {
        testUsersSectionBttn.click();
        testUserBttn.click();
        return this;
    }

    @Step("3. Go to Manu Page")
    public IssuedWaybillsSteps goToMenu() {
        menuBttn.click();
        sleep(100);
        return this;
    }

    @Step("4. Go to Waybills Grid Page")
    public IssuedWaybillsSteps goToWaybillsPage() {
        waybillsSectionBttn.click();
        closePopUp();
        return this;
    }

    @Step("5. Initiate New Waybill")
    public IssuedWaybillsSteps initiateNewWaybill() {
        sleep(200);
        newWaybill.click();
        return this;
    }

    @Step("6. Select Waybill Type: {waybillType}")
    public IssuedWaybillsSteps selectWaybillType(String waybillType) {
        sleep(200);
        waybillTypeInput.selectOption(waybillType);
        sleep(500);
        return this;
    }

    @Step("7. Set Vendor ID: {vendorId}")
    public IssuedWaybillsSteps setVendorId(String vendorId) {
        sleep(500);
        vendorIdInput.setValue(vendorId);
        vendorIdInput.pressEnter();
        sleep(200);
        return this;
    }

    @Step("8. Set Product ID: {productId}")
    public IssuedWaybillsSteps setProductId(String productId) {
        productIdInput.setValue(productId).pressTab();
        sleep(100);
        return this;
    }

    @Step("9. Set Product Name: {productName}")
    public IssuedWaybillsSteps setProductName(String productName) {
        productNameInput.setValue(productName);
        return this;
    }

    @Step("10. Set Product Unit: {productUnit}")
    public IssuedWaybillsSteps selectProductUnit(String productUnit) {
        productUnitInput.selectOption(productUnit);
        return this;
    }

    @Step("11. Set Product Quantity: {productQuantity}")
    public IssuedWaybillsSteps setProductQuantity(String productQuantity) {
        productQuantityInput.setValue(productQuantity);
        return this;
    }

    @Step("12. Set Product Price: {productPrice}")
    public IssuedWaybillsSteps setProductPrice(String productPrice) {
        productUnitPriceInput.setValue(productPrice);
        return this;
    }

    @Step("13. Select Taxation Type: {taxationType}")
    public IssuedWaybillsSteps selectTaxationType(String taxationType) {
        taxationTypeInput.selectOption(taxationType);
        return this;
    }

    @Step("14. Add Product in Waybill Product's List")
    public IssuedWaybillsSteps addProduct() {
        addProductBttn.click();
        return this;
    }

    @Step("15. Write Comment: {comment}")
    public IssuedWaybillsSteps writeComment(String comment) {
        waybillComment.setValue(comment);
        waybillComment.pressTab();
        return this;
    }

    @Step("16. Activate Waybill")
    public IssuedWaybillsSteps activateWaybill() {
        activateBttb.click();
        sleep(100);
        while (activateBttb.is(Condition.disabled)){
            activateBttb.pressEnter();
        }
        return this;
    }

    private void closePopUp(){
        if (popUpWindow.is(Condition.visible)){
            popUpWindow.click();
        }
    }
}
