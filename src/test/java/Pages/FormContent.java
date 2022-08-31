package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormContent extends Parent {
    public FormContent() {

        PageFactory.initElements(GWD.getDriver(), this);
    }
    @FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[1]")
    private WebElement AcademicPeriod;
    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement AcademicPeriod_v;
    @FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[3]")
    private WebElement GradeLevel;
    @FindBy(xpath = "(//mat-option[@role='option']/span)[3]")
    private WebElement GradeLevel_v;


    @FindBy(xpath = "//ms-add-button[@tooltip='EMPLOYEE.TITLE.ADD']//button")
    private  WebElement addEmp;
    @FindBy(xpath = "(//ms-text-field//input)[1]")
    private WebElement nameEmp;  ///send
    @FindBy(xpath = "(//ms-text-field//input)[2]")
    private WebElement surnameEmp;   ///send
    @FindBy(xpath = "(//mat-form-field//input)[6]")
    private WebElement employeeID;  /// send
    @FindBy(xpath = "(//mat-select[@role='combobox']/div/div)[1]")
    private WebElement genderEmp;
    @FindBy (xpath = "(//mat-option//span)[2]")
    private WebElement male;

    @FindBy(xpath = "(//mat-select/div/div)[3]")
    private WebElement typeEmp;
    @FindBy(xpath = "(//div[@role='listbox']//mat-option)[2]")
    private WebElement superV;

    @FindBy(xpath = "(//mat-select[@role='combobox']/div/div)[9]")
    private WebElement qualifyEmp;
    @FindBy(xpath = "(//mat-select[@role='combobox']/div/div)[9]/span/span[text()='Bachelor']")
    private WebElement bachelor;

    @FindBy(xpath = "(//mat-select/div/div)[11]")
    private WebElement docTypeEmp;
    @FindBy(xpath = "(//mat-select/div/div)[11]/span/span[text()='Passport']")
    private WebElement passport;

    @FindBy(xpath = "(//mat-form-field/div/div/div//input)[9]")
    private WebElement docNumEmp;  /// send
    @FindBy(xpath = "(//mat-form-field/div/div/div//input)[10]")
    private WebElement perIdEmp;   /// send

    @FindBy(xpath = "//mat-chip-list/div//input")
    private WebElement schDeptEmp; ///send


    @FindBy(xpath = "(//div[@role='tab'])[2]/div")
    private WebElement contactAdr;
    @FindBy(xpath="(//mat-form-field/div)[13]/div/div/input")
    private WebElement country;  //send


    WebElement myElement;

    public void findAndClick(String strElement) {
        // 2.aşama burda string isimden weblemente ulaşıcam
        switch (strElement) {

            case "addEmp":
                myElement = addEmp;break;
            case "AcademicPeriod":
                myElement = AcademicPeriod;break;
            case "AcademicPeriod_v":
                myElement = AcademicPeriod_v;break;
            case "GradeLevel":
                myElement = GradeLevel;break;
            case "GradeLevel_v":
                myElement = GradeLevel_v;break;


            case "genderEmp":
                myElement = genderEmp;break;
            case "male":
                myElement = male;break;
            case "typeEmp":
                myElement = typeEmp;break;
            case "superV":
                myElement = superV;break;
            case "qualifyEmp":
                myElement = qualifyEmp;break;
            case "bachelor":
                myElement = bachelor;break;
            case "docTypeEmp":
                myElement = docTypeEmp;break;
            case "passport":
                myElement = passport;break;
            case "contactAdr":
                myElement = contactAdr;break;
        }
        clickFunction(myElement);
    }

    public void findAndSend(String strElement, String value) {
        switch(strElement){
            case "nameEmp":
                myElement = nameEmp;break;
            case "surnameEmp":
                myElement = surnameEmp;break;
            case "employeeID":
                myElement = employeeID;break;
            case "docNumEmp":
                myElement = docNumEmp;break;
            case "perIdEmp":
                myElement = perIdEmp;break;
            case "schDeptEmp":
                myElement = schDeptEmp;break;
            case "country":
                myElement= country;break;
        }
        sendKeysFunction(myElement, value);
    }

}

//        if (myElement == AcademicPeriod || myElement == GradeLevel)
//            GWD.stay(1);

