package com.aqa.RevenueService.PageObject;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByTagAndText;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class WaybillsPage extends LoginPage {

    public SelenideElement
            menuBttn = $(By.className("txt-menu")),
            waybillsSectionBttn = $(new ByTagAndText("p", "ზედნადები")),
            popUpWindow = $(new ByText("დახურვა")),
            newWaybill = $(By.id("tlNewWaybill1")),
            waybillTypeInput = $(By.id("rsPopup_popWaybillDetails")).$(By.tagName("select")),
            vendorIdInput = $(By.id("Buyer_Tin_inputID")),
            productIdInput = $(By.id("good_bar_code_inputID")),
            productNameInput = $(By.id("good_name_inputID")),
            productUnitInput = $(By.id("good_unit_id")),
            productQuantityInput = $(By.id("good_quantity")),
            productUnitPriceInput = $(By.id("good_price")),
            taxationTypeInput = $(By.id("good_vat_type")),
            addProductBttn = $(By.id("btnAddGood")),
            waybillComment = $(By.id("Comment_inputID")),
            activateBttb = $(By.id("btnClose")),
            gridFilterByDescription = $(By.id("rsGrid_grdWaybills_v2"))
                    .$(By.tagName("table"))
                    .$(By.tagName("thead"))
                    .$(By.tagName("tr"), 1)
                    .$(By.tagName("td"), 62)
                    .$(By.tagName("input")),
            totalNumberOfFilteredWaybills = $(By.id("rsGrid_grdWaybills_v2"))
                    .$(By.className("rsGridBottom"))
                    .$(By.className("rsGridPagerleft"))
                    .$(By.tagName("span"))
                    .$(By.tagName("b"), 0),
            receivedWaybillsSection = $(By.id("tabWaybillsReceived")).$(new ByTagAndText("l", "მიღებული")),
            gridSizeSelector = $(By.id("rsGrid_grdWaybills_v2")).$(".rsGridMaxRows");

}
