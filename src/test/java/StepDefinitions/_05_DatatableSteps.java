package StepDefinitions;

import Pages.DialogContent;
import Pages.FormContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import static Utilities.GWD.Bekle;

public class _05_DatatableSteps {

    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();
    FormContent fc = new FormContent();

    @When("Click on the element in the Left Nav")
    public void clickOnTheElementInTheLeftNav(DataTable elements) {
        List<String> listElement = elements.asList(String.class);

        for(int i=0;i<listElement.size();i++) {
            //   System.out.println("listElement = " + listElement.get(i));
            ln.findAndClick(listElement.get(i));
        }
    }
    @And("Click on the element in the Dialog")
    public void clickOnTheElementInTheDialog(DataTable elements) {
        List<String> listElement = elements.asList(String.class);

        for(int i=0;i<listElement.size();i++) {
            //   System.out.println("listElement = " + listElement.get(i));
            dc.findAndClick(listElement.get(i));
        }
    }
    @And("User sending the keys in Dialog content")
    public void userSendingTheKeysInDialogContent(DataTable elements) {
        List<List<String>> listElement = elements.asLists(String.class);

        for(int i=0;i<listElement.size();i++)
            dc.findAndSend(listElement.get(i).get(0), listElement.get(i).get(1));
        // listin ilk elemanına(weblement adına), ikinci elemanı yani değeri gönder
    }

    @When("Click on the element in the Form Content")
    public void clickOnTheElementInTheFormContent(DataTable elements) {
        List<String> listElement = elements.asList(String.class);

        for(int i=0;i<listElement.size();i++) {
//            if (listElement.get(i).equals("addEmp"))
            fc.findAndClick(listElement.get(i));
        }
    }
    @When("User sends the keys in the Form content")
    public void userSendsTheKeysInTheFormContent(DataTable elements){
    List<List<String>> listElement = elements.asLists(String.class);

        for(int i=0;i<listElement.size();i++)
            fc.findAndSend(listElement.get(i).get(0), listElement.get(i).get(1));
        // listin ilk elemanına(weblement adına), ikinci elemanı yani değeri gönder
    }
    @And("User delete item from the Dialog")
    public void userDeleteItemFromTheDialog(DataTable elements) {
        List<String>listElement = elements.asList(String.class);

        for(int i=0; i< listElement.size();i++){
            dc.SearchAndDelete(listElement.get(i));
        }
    }
}