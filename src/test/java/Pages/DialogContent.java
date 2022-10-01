package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DialogContent extends Parent {
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id = "mat-input-0")
    private WebElement username;

    @FindBy(id = "mat-input-1")
    private WebElement password;

    @FindBy(css = "button.consent-give")
    private WebElement cooky;

    @FindBy(css = "[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(css = "span.username.mr-12")
    private WebElement richField;


    @FindBy(xpath ="//ms-add-button/div/button")
    private WebElement add_c;
    //ms-add-button//button

    @FindBy(css="ms-text-field[formcontrolname='name']>input")
    private WebElement name_c;

    @FindBy(xpath="//ms-text-field[@formcontrolname='code']//input")
    private WebElement code_c;

    @FindBy(xpath="//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    private WebElement intCode;

    @FindBy(xpath="//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priority;

    @FindBy(xpath="span[class='mat-slide-toggle-bar']>input")
    private WebElement active;

    @FindBy(xpath="//ms-save-button//button[contains(@class,'mat-button-base ng-star-inserted')]")
    private WebElement save_c;

    @FindBy (xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessage;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    private WebElement alreadyExist;

    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeDialog;

    @FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix ng-tns-c74')]//input)[1]")
    private WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement deleteDialogBtn;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> nameList;


    WebElement myElement;

    public void findAndSend(String strElement, String value) {
        // 2.aşama burda string isimden weblemente ulaşıcam
        switch (strElement) {
            case "username":
                myElement = username; break;
            case "password":
                myElement = password; break;

            case "name_c": myElement = name_c; break;
            case "code_c": myElement = code_c; break;
            case "shortName": myElement = shortName; break;
            case "intCode": myElement = intCode; break;
            case "priority": myElement = priority; break;
            case "searchInput": myElement = searchInput; break;
        }
        sendKeysFunction(myElement,value);
    }

    public void findAndClick(String strElement) {
        // 2.aşama burda string isimden weblemente ulaşıcam
        switch (strElement) {

            case "cooky": myElement = cooky; break;
            case "loginButton": myElement = loginButton; break;

            case "add_c": myElement = add_c; break;
            case "save_c": myElement = save_c; break;
            case "closeDialog": myElement = closeDialog; break;
            case "searchButton": myElement = searchButton; break;
            case "deleteButton": myElement = deleteButton; break;
            case "deleteDialogBtn": myElement = deleteDialogBtn; break;
        }
        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text) {
        // 2.aşama burda string isimden weblemente ulaşıcam
        switch (strElement) {
            case "richField":
                myElement = richField; break;

            case "successMessage":
                myElement = successMessage; break;

            case "alreadyExist":
                myElement = alreadyExist; break;
        }
        verifyContainsText(myElement,text);
    }

    public void SearchAndDelete(String searchText){
        findAndSend("searchInput",searchText);/// aranacak kelimeyi gonder
        findAndClick("searchButton");  // arama butonuna bas

        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBe(By.cssSelector
                ("div[fxlayoutalign='center center'][class='control-full']"),"Search"));

//          GWD.Bekle(2);// son care
        findAndClick("deleteButton");  // silme butonuna bas
        findAndClick("deleteDialogBtn");  // dialog daki silme butonuna bas
    }

}
