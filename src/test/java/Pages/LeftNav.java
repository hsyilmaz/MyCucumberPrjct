package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent {

    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement setupOne;
    //css="a[class='nav-link ng-tns-c249-9 ng-star-inserted']>fa-icon+span"

    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement parameters;

    @FindBy(xpath = "//span[text()='Countries']")
    private WebElement countries;

    @FindBy(xpath = "//span[text()='States']")
    private WebElement states;

    @FindBy(xpath = "//span[text()='Citizenships']")
    private WebElement citizenship;

    @FindBy(xpath = "//span[text()='Nationalities']")
    private WebElement nationality;

    @FindBy(xpath = "//span[text()='Fees']")
    private WebElement fees;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[1]")
    private WebElement EntranceExam1;
    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    private WebElement setup2;
    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    private WebElement EntranceExam2;


    @FindBy(xpath = "//span[text()='Human Resources']")
    private WebElement humanRes;

    @FindBy(xpath = "//span[text()='Employees']")
    private WebElement employees;



    WebElement myElement;

    public void findAndClick(String strElement) {
        switch (strElement) {
            case "setupOne":
                myElement = setupOne;
                break;
            case "parameters":
                myElement = parameters;
                break;
            case "countries":
                myElement = countries;
                break;
            case "states":
                myElement = states;
                break;
            case "citizenship":
                myElement = citizenship;
                break;
            case "nationality":
                myElement = nationality;
                break;
            case "fees":
                myElement = fees;
                break;
            case "EntranceExam1":
                myElement = EntranceExam1;
                break;
            case "setup2":
                myElement = setup2;
                break;
            case "EntranceExam2":
                myElement = EntranceExam2;
                break;
            case "humanRes":
                myElement = humanRes;
                break;
            case "employees":
                myElement = employees;
                break;
        }
        clickFunction(myElement);
    }


}
