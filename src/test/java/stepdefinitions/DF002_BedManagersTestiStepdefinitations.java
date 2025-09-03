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
        ReusableMethods.bekle(2);

        // admin yatak düzenleme sayfasındadır
        adminPages.addBedManagersButton.click();

        // yatak düzenlemeye başlar

        // title a gerekli değerleri girr
        adminPages.bedManagersTitleBox.sendKeys("MERKABA");

        // content içeriğine gerekli değerleri girer
        adminPages.petsContentBox.sendKeys("merhabalar kedi dostları");

        // sağ tarafdaki menüye geçe

        // departments tuşuna basar ve dropDown menüyü açar
        adminPages.selectDepartmentsButton.click();

        // dropDown menüye department seçimi gönderir
        adminPages.inputDepartmentsBox.sendKeys("Dental Care"+ Keys.ENTER);

        // ilac secimini yapar
        adminPages.selectMedicinesButton.click();
        adminPages.inputMedicinesBox.sendKeys("Revolution (Selamectin)"+Keys.ENTER);

        // ücret bilgisi girer
        adminPages.inputPriceBox.sendKeys("657");

        // fotğrafın görünür olmasına izin verir radyo butondan
        adminPages.radioButton.click();

        // yatak yayınlanmak ıcın save edilir

        adminPages.saveButton.click();









    }
}
