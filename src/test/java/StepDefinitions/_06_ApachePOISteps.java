package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class _06_ApachePOISteps {
    DialogContent dc= new DialogContent();
    @When("User Creates citizenship with apachePOI")
    public void userCreatesCitizenshipWithApachePOI() {
        // excell den oku ve citizenship create et
        List<List<String>>table=
        ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx",
            "testCitizen",2); // I need only 2 column for columnCount.
        for(List<String>row:table)
        {
            dc.findAndClick("add_c");
            dc.findAndSend("name_c", row.get(0));
            dc.findAndSend("shortName", row.get(1));
            dc.findAndClick("save_c");
            dc.findAndContainsText("successMessage","successfully");
        }

    }
    @Then("User Deletes citizenship with apachePOI")
    public void userDeletesCitizenshipWithApachePOI() {
        // kaydettiklerini yine excelden oku ve sil
        List<List<String>>table=
                ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx",
                        "testCitizen",1);
        for(List<String>Rw:table)
        {
            System.out.println("satir = " + Rw);
            System.out.println("satir.get(0) = " + Rw.get(0));

            dc.SearchAndDelete(Rw.get(0));
            dc.findAndContainsText("successMessage","successfully");
        }

    }
//    public void scrollToUpElement(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.getDriver();
//        js.executeScript("arguments[0].setAttribute('style', 'top:0px')", element);
//        js.executeScript("arguments[0].scrollIntoView();", element);
//    }
}
