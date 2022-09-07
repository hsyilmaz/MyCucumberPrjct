package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

public class _06_ApachePOISteps {
    DialogContent dc= new DialogContent();
    @When("User Creates citizenship with apachePOI")
    public void userCreatesCitizenshipWithApachePOI() {
        // excell den oku ve citizenship create et
        ArrayList< ArrayList<String> >tablo=
        ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx",
            "testCitizen",2); // I don't need 4 for columnCount.
        for(ArrayList<String>satir:tablo)
        {
            dc.findAndClick("add_c");
            dc.findAndSend("name_c", satir.get(0));
            dc.findAndSend("shortName", satir.get(1));
            dc.findAndClick("save_c");
            dc.findAndContainsText("successMessage","successfully");
        }

    }
    @Then("User Deletes citizenship with apachePOI")
    public void userDeletesCitizenshipWithApachePOI() {
        // kaydettiklerini yine excelden oku ve sil
        ArrayList<ArrayList<String>>tablo=
                ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx",
                        "testCitizen",1);
        for(ArrayList<String>satir:tablo)
        {
            System.out.println("satir = " + satir);
            System.out.println("satir.get(0) = " + satir.get(0));

            dc.SearchAndDelete(satir.get(0));
            dc.findAndContainsText("successMessage","successfully");
        }

    }
//    public void scrollToUpElement(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.getDriver();
//        js.executeScript("arguments[0].setAttribute('style', 'top:0px')", element);
//        js.executeScript("arguments[0].scrollIntoView();", element);
//    }
}
