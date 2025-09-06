package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.AdminPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

// günaydın abi
// test stepleri geçiyor fakat yeşil değil turuncu
// cucumberda ilk assertions yapıyorum. bir şeyleri atlıyorum herhalde

public class DF008_kullaniciGirisiStepdefinitions {

    AdminPages adminPages = new AdminPages() ;
    private TestData testData ;
    Faker faker = new Faker();

    private static class TestData {
        String gecersizMail;
        String gecerliPassword;
        String gecerliMail ;
        String gecersisizPassword ;
    }

    @Before
    public void generateTestData(Scenario scenario) {
        testData = new TestData() ; // Nesne oluşturuluyor
        testData.gecersizMail = faker.lorem().characters(1)+ConfigReader.getProperty("adm");
        testData.gecerliPassword = ConfigReader.getProperty("adp") ;
        testData.gecerliMail = ConfigReader.getProperty("adm");
        testData.gecersisizPassword = faker.lorem().characters(2)+ConfigReader.getProperty("adp");
    }

    @Given("KK login sayfasina gider")
    public void kk_login_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        adminPages.signInButton.click();
        System.out.println("step:1 - Login sayfasına gidildi");

    }
    @Then("Gecersiz {string} girer")
    public void gecersiz_girer(String gecerliMail) {

        adminPages.mailBox.sendKeys(testData.gecerliMail);
        ReusableMethods.bekle(5);
        System.out.println("step:2 - gecerliMail  girildi: " + testData.gecerliMail);

    }
    @Then("password olarak {string} girer")
    public void password_olarak_girer(String gecerliPassword) {

        adminPages.passwordBox.sendKeys(testData.gecersisizPassword);
        ReusableMethods.bekle(5);
        System.out.println("step:3 - Geçerli password girildi");



    }
    @Then("signIn Butonuna basarak giris yapar")
    public void sign_in_butonuna_basarak_giris_yapar() {

        adminPages.loginPageSigInButton.click();
        ReusableMethods.bekle(5);
        System.out.println("step:4 - Sign In butonuna basıldı");

    }
    @Then("sisteme giris yapilamadigini test eder")
    public void sisteme_giris_yapilamadigini_test_eder() {

        Assertions.assertTrue(adminPages.loginPageSigInButton.isDisplayed(),"hata");
        System.out.println("step:5 - Sisteme giriş yapılamadığı doğrulandı");
    }
    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {


        System.out.println("step:6 - Sayfa kapatıldı");

    }
}
