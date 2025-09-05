package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AdminPages;
import utilities.Driver;
import utilities.ExcelProductWriter;
import utilities.ReusableMethods;

public class DF033_MedicinesListEditDeleteStepdefinitions {
    AdminPages adminPages = new AdminPages() ;

    @And("goesToMedicinePages")
    public void goestomedicinepages() {

        adminPages.medicinesButton.click();
        adminPages.subMedicinesButton.click();



    }

    @And("takeAlistMedicines")
    public void takealistmedicines() {
        ExcelProductWriter.writeProductsToExcel(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/Dashboard/Instagrams",
                "//td[@class='v-align-middle semi-bold']",
                1
        );
        // diğer örneklerdeki excell locatrera bak mutlaka onun gibi birşeydir be abi

    adminPages.searchBox.sendKeys("Rimadyl");

    ReusableMethods.bekle(5);

    adminPages.searchBox.clear();

    Driver.getDriver().navigate().refresh();



    }

    @Then("changeMedicinesInfo")
    public void changemedicinesinfo() {

        adminPages.medicinePagesEditButtons.click();

        adminPages.medicinesPageContextBox.sendKeys("sodyumBenzoat");

        ReusableMethods.scrollToBottom();

        adminPages.medicinePagesSaveButtons.click();

        ReusableMethods.bekle(5);

        adminPages.medicinesPagesDeleteButton.click();




    }



}

