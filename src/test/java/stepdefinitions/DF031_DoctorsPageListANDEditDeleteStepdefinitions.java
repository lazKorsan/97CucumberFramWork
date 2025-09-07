package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AdminPages;
import utilities.*;

public class DF031_DoctorsPageListANDEditDeleteStepdefinitions {



    AdminPages adminPages = new AdminPages() ;

    @Then("goesToDoctorsPage")
    public void goestodoctorspage() {

        // dashboard menüden doctors buttonu seçer
        adminPages.doctorsButton.click();

        // açılır dropdown menuden doctors butonu seçer
        adminPages.subDoctorsButton.click();


    }


    @And("takeAlistDoctors")
    public void takealistdoctors() {


        ExcelProductWriter.writeProductsToExcel(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/Dashboard/Clients",
                "//td[@class='v-align-middle semi-bold']",
                1
        );

        ExcellProductReporter.generateCustomReport(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/Dashboard/Clients",
                "//td[@class='v-align-middle semi-bold']",
                "DOCTORS"

        );



    }

    @And("goesToCreateDoctorsPage")
    public void goestocreatedoctorspage() {

        WebElement addDoctorsButton = Driver.getDriver().findElement(By.xpath("//a[@class='btn btn-tag btn-success btn-tag-rounded']"));
        addDoctorsButton.click();
    }

    @And("createNewDoctor")
    public void createnewdoctor() {

        adminPages.creatDoctorsPageTitleBox.sendKeys("Doc.Asım BizimDoctor");
        adminPages.createDoctorsPageContentBox.sendKeys("hayvan dostu doktor ");

        adminPages.createDoctorsPageSaveButton.click();



    }

    @And("editInfoDoctor")
    public void editinfodoctor() {


        adminPages.doctorsPageEditInfoButton.click();


       adminPages.creatDoctorsPageTitleBox.clear();
       adminPages.creatDoctorsPageTitleBox.sendKeys("Dr.Osman Canyilmaz ");



        ReusableMethods.scrollToBottom();

        adminPages.createDoctorsPageSaveButton.click();


    }

    @Then("deleteNewDoctor")
    public void deletenewdoctor() {

        adminPages.doctorsPagesDeleteButton.click();
    }


}
