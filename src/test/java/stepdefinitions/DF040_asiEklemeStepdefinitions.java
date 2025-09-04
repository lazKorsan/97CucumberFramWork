package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminPages;
import utilities.Driver;
import utilities.ExcelProductWriter;

public class DF040_asiEklemeStepdefinitions {
    AdminPages adminPages = new AdminPages();

    @When("goesToVaccinationsPage")
    public void asi_ekleme_sayfasinagider() {

        // Kullanıcı acılır DashBoard menuden vaccinations  sekmesini açar
        adminPages.vaccinationsButton.click();

        // açılır sayfada asilari listeler
        ExcelProductWriter.writeProductsToExcel(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/Dashboard/Galleries",
                "//td[@class='v-align-middle semi-bold']",
                1
        );



    }


    @When("addNewVaccinations")
    public void add_new_vaccinations() {

        // asi ekleme butonuna basar
        adminPages.addVaccinationsButton.click();

        // title box a aşı adını girer
        adminPages.petsTitleBoxVaccinations.sendKeys("Feline Viral Rhinotracheitis ");

        // context box amacını girer
        adminPages.petsContentBoxVaccinations.sendKeys("Üst solunum yolu enfeksiyonları");

        // ası ucretini girer
        adminPages.petsPriceVaccinations.sendKeys("1");

        // resmi yukler
        //adminPages.uploadPngVaccinations.sendKeys("\"C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\upload.png\"");

        // asiyi kayt eder
        adminPages.saveVaccinationsButton.click();


    }

    @Then("sayfadancikisyapar")
    public void sayfadancikisyapar() {

        // admin sayfasından cıkıs işlemlerini yapar

        // profil menusune basarak dropdown menuyu açar
        adminPages.profileButton.click();

        // dropdown menuden logout butonuna basar
        adminPages.logOutButton.click();

        // ana sayfay yönlendirili

        // signOut butona basarak sistemden çıkış yapar
        adminPages.signOutButton.click();
    }


}
