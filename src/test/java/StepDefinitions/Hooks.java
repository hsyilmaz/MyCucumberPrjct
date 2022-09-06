package StepDefinitions;

import Utilities.ExcelUtility;
import Utilities.GWD;
import com.aventstack.extentreports.service.ExtentTestManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    @Before
    public void before()
    {
        System.out.println("Scenario started");
    }

    @After
    public void after(Scenario scenario)
    {
        System.out.println("Scenario ended");
        System.out.println("scenario result="+ scenario.getStatus());
        System.out.println("scenario isFailed ? = "+ scenario.isFailed());

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");

        ExcelUtility.writeExcel("src/test/java/ApachePOI/resource/ScenarioStatus.xlsx",
                scenario, GWD.threadBrowserName.get(), date.format(formatter));

        if (scenario.isFailed()){
            // klasöre    // ekran görüntüsü al senaryo hatalı ise
            TakesScreenshot screenshot = (TakesScreenshot) GWD.getDriver();
            File ekranDosyasi = screenshot.getScreenshotAs(OutputType.FILE);

            //Extend Reporta ekleniyor  EXTEND report olmadığında burası kaldırılmalı !!! yoksa browserlar KAPANMAZ
            ExtentTestManager.getTest().addScreenCaptureFromBase64String(getBase64Screenshot());

            try {
                FileUtils.copyFile(ekranDosyasi,
                new File("target/FailedScreenShots/"+ scenario.getId()+date.format(formatter)+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        GWD.quitDriver();
    }
    public String getBase64Screenshot()
    {
        return ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

}