package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import pages.AdminPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.PageElementHighlighter;
import utilities.ReusableMethods;

public class DF043_AdminBilgiDuzenlemeStepdefinitions {
    AdminPages adminPages = new AdminPages();

    @When("AdminOturumAcar")
    public void admin_oturum_acar() {
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


    }

    @When("yonetimpanelinegider")
    public void yonetimpanelinegider() {

        // Kullanıcı anasayfaya yonlendirilir ve account butona basar
        adminPages.accountButton.click();

        // Kullanıcı dasboar menü üzerine gelir
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(adminPages.dashboardTables).perform();

    }

    @Then("profileButtondanBilgiDuzenlemeSayfasinaGider")
    public void profile_buttondan_bilgi_duzenleme_sayfasina_gider() {
        // admin Sayfasında sağust kısımda bulunan profil butona tiklar
        adminPages.profileButton.click();
        ReusableMethods.bekle(2);

        // acilan dropDownMenüden editProfile seçeneğini tıklar
        adminPages.editProfileButton.click();
    }
    @Then("hataMesajininEkranAlintisiniAlir")
    public void hata_mesajinin_ekran_alintisini_alir() {

        PageElementHighlighter.highlightElementsAndTakeScreenshot(
                Driver.getDriver(),
                new Object[][]{
                        {adminPages.errorContainerWebelement, "Bilgi Duzenleme Sayfasi Açilmiyor"},
                     //   {headerPages.searchButton, "Arama Butonu"}
                },
                new Object[][]{
                      //  {headerPages.signInButton, "İletişim Linki"}
                        {adminPages.error404,"hata ticket"}
                },
                "Hatalı Sayfa "
        );

        //WebElement errorMassage = Driver.getDriver().findElement("//div[@class='error-container text-center']");

    }

    @Then("otorumuKapatir")
    public void otorumu_kapatir() {

        // navigate ile bir önceki sayfaya döner
        Driver.getDriver().navigate().back();

        // sağ ustteki profilmenusu seçer
        adminPages.profileButton.click();

        // acilir DropDownMenuden logout seçer
        adminPages.logOutButton.click();
        ReusableMethods.bekle(4);

        // anasayfaya gelir

        // ana sayfadan SıgnOut Butona BASAR
        adminPages.signOutButton.click();



    }
}
