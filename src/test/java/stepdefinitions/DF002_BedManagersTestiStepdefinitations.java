package stepdefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.AdminPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class DF002_BedManagersTestiStepdefinitations {
    AdminPages adminPages = new AdminPages();

    @When("admin Yatak Olusturma Testi")
    public void admin_yatak_olusturma_testi() {

        // Kullanici ana sayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        // Kullanici Login sayfasina gider
        adminPages.signInButton.click();

        // Kullanici mail adresini girer
        adminPages.mailBox.sendKeys(ConfigReader.getProperty("adm"));

        // Kullanici sifresini girer
        adminPages.passwordBox.sendKeys(ConfigReader.getProperty("adp"));

        // Kullanici sigIn buttonuna basar
        adminPages.loginPageSigInButton.click();

        // Kullanıcı anasayfaya yonlendirilir ve account butona basar
        adminPages.accountButton.click();

        // Kullanıcı dasboar menü üzerine gelir
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(adminPages.dashboardTables).perform();

        // Kullanici dashboard uzerinde bulunan BedMnagersButton seçer
        adminPages.bedManagersButton.click();

        // Kullanıcı dropDownMenüden  menuden bedMangersButton seçer
        adminPages.subBedManagersButton.click();
        ReusableMethods.bekle(2);

        // admin yatak listelerinin olduğu sayfadadır
        adminPages.addBedManagersButton.click();
        ReusableMethods.bekle(4);



        // yatak düzenlemeye başlar

        // title girer
        adminPages.bedManagersTitleBox.sendKeys("PURRY Haven");

        // Admin oluşturmak istediği yatağın içeriğini girer
        adminPages.bedManagersContentBox.sendKeys("Safe Snug Cat Sanctuary");



        // admin sağ menüden departments menüsünü açar
        adminPages.selectDepartmentsButton.click();

        // admin açılır menüden departments ataması yapar
        adminPages.inputDepartmentsBox.sendKeys("Dental Care" +Keys.ENTER);

        // admin ilaçlar menüsünü açar
        adminPages.selectMedicinesButton.click();
        adminPages.inputMedicinesBox.sendKeys("Revolution (Selamectin)"+Keys.ENTER);

        // admin pricebox a geçerli tutarı girer
        adminPages.inputPriceBox.sendKeys("657"+Keys.ENTER);

        // admin yatağı kullanıma açar
        adminPages.radioButton.click();

        // admin yatağı son kullanıcının hizmetine sunar
        adminPages.bedManagersSaveButton.click();

        // admin hizmet tutarını fazla girdiğini fark eder ve edit sayfasına gider
        adminPages.bedManagersEditButton.click();

        adminPages.bedManagersContentBox.sendKeys("kitty cat"+Keys.ENTER);

        // Kullanıcı yatak değişikliğini kayt eder
        adminPages.bedManagersSaveButton.click();

        // TEKLİ SİLME İŞLEMİ YAPILIR
        adminPages.bedManagersDeleteButton.click();

        // admin page profil butona basılır
        adminPages.profileButton.click();

        // adminpage profilmenusunden logout butona basılır
        adminPages.logOutButton.click();

        // anasayfa signout butona basılır
        adminPages.signOutButton.click();

    }
}
