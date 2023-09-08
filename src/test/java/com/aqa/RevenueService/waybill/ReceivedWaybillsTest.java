package com.aqa.RevenueService.waybill;

import com.aqa.RevenueService.StepObject.ReceivedWaybillsSteps;
import com.aqa.RevenueService.Utils.ChromeRunner;
import com.codeborne.selenide.selector.ByTagAndText;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertEquals;

public class ReceivedWaybillsTest extends ChromeRunner {

    private final ReceivedWaybillsSteps receivedWaybillsSteps = new ReceivedWaybillsSteps();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check if waybills grid shows correct number of waybills")
    public void shouldShowCorrectNumberOfWaybills() {
        receivedWaybillsSteps.
                goToLoginPage()
                .loginByTestUser()
                .goToMenu()
                .goToWaybillsPage()
                .goToReceivedWaybillsSection();

        int type1BeforeResizing = $$(new ByTagAndText("td", "ჩვეულებრივი")).size();
        int type2BeforeResizing = $$(new ByTagAndText("td", "ხე-ტყე")).size();
        int beforeResizing = type1BeforeResizing + type2BeforeResizing;

        receivedWaybillsSteps.changeGridSize("200");

        int type1AfterResizing = $$(new ByTagAndText("td", "ჩვეულებრივი")).size();
        int type2AfterResizing = $$(new ByTagAndText("td", "ხე-ტყე")).size();
        int afterResizing = type1AfterResizing + type2AfterResizing;

        assertEquals(beforeResizing, 10, "Grid should show correct number of waybills");
        assertEquals(afterResizing, 200, "Grid should show correct number of waybills");
    }

}
