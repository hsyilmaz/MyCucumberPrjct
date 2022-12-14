package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _11_JDBC_Steps {
    @Then("Send The query to the database {string} and control match")
    public void sendTheQueryToTheDatabaseAndControlMatch(String query) {

            //DBden gerekli listeyi alıcam
            List<List<String>> dbList= DBUtility.getListData(query);
            System.out.println("dbList = " + dbList);   // 0.satırın 0. elamanı     id = (1)
                                                        // 0.satirin 1. elemani   name= (Arizona)

            //UI dan yani ekrandan isimleri alıcam
            DialogContent dc=new DialogContent();

            List<WebElement> uiList= dc.waitVisibleListAllElement(dc.nameList);
            for(WebElement e: uiList)
                System.out.println("e.getText() = " + e.getText());

            //comparison
            for(int i=0;i< dbList.size();i++)
                Assert.assertEquals("Hatalı durum",dbList.get(i).get(1), uiList.get(i).getText());
        }
    }

