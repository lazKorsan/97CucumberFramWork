package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AdminPages;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class DF034_MedicineEditAndDeleteStepdefinitions {

    AdminPages adminPages = new AdminPages();



    @Then("goesToAddMedicinesPages")
    public void goestoaddmedicinespages() {

        adminPages.medicinePagesAddMedicineButton.click();


    }

    @And("createMedicinesAndChangeInfoThenDelete")
    public void createmedicinesandchangeinfothendelete() {

        adminPages.medicineTitleBox.sendKeys("FİPROVET DROP");

        String medicinesContentTextIcerik = "anti Ctenocephalides";

        adminPages.medicinesContentText.sendKeys(medicinesContentTextIcerik);

       // WebElement fileInput = Driver.getDriver().findElement(By.xpath("//input[@type='file']"));
       // ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].style.display='block';", fileInput);
       // fileInput.sendKeys("C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\uploadImage.png");
        ReusableMethods.bekle(1);

        System.out.println(11);


        // upLoadFilesButton.sendKeys(filePath);
        adminPages.medicinePagesSaveButton.click();  // saatır 64
        ReusableMethods.bekle(2);

        adminPages.medicinePagesEditButtons.click();

       // adminPages.medicinesContentText.sendKeys("123");

        adminPages.medicinePagesSaveButton.click();

        adminPages.medicinesPagesDeleteButton.click();















    }

}
