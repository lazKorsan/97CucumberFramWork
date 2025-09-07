package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import pages.AdminPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Locale;

public class DF008_NegatifTestCoklu {

    // %%%TRY-CATCH KULLANİMİ ÇOKLU NEGATİF TESTTE
    // KAZARA SİSTEME GİRİŞ YAPACAK OLURSA TESTİN YOLUNA DEVAM ETMESİ İÇİN
    AdminPages adminPages = new AdminPages() ;
    private TestData testData;
    Faker faker = new Faker() ;

    private static class TestData {

        String email;
        String password;
    }

    @Before(order = 1)
    public void setupDriver() {
        Driver.getDriver(); // Driver başlatma
    }

    @Before(order = 2)
    public void generateTestData(Scenario scenario) {
        faker = new Faker(); // Türkçe veri üretimi
        adminPages = new AdminPages();
        testData = new TestData();

        // Dinamik veri üretimi
        testData.email = faker.internet().emailAddress();
        testData.password = faker.internet().password(10, 16, true, true) + "A1!";

        // Senaryo ismini logla
        System.out.println("Çalışan Senaryo: " + scenario.getName());
    }



    @Given("Kullanici loyalfriendcare ana Sayfasini acar")
    public void kullanici_loyalfriendcare_ana_sayfasini_acar() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

    }
    @Given("login sayfasina gider")
    public void login_sayfasina_gider() {
        adminPages.signInButton.click();



    }
    @Then("mailNBox kutusuna {string} girer")
    public void mail_n_box_kutusuna_girer(String gecersizMail) {

        adminPages.mailBox.sendKeys(testData.email);
        ReusableMethods.bekle(5);



    }
    @Then("passwordBox kutusuna {string} girer")
    public void password_box_kutusuna_girer(String gecersizPassword) {
        adminPages.passwordBox.sendKeys(testData.password);
        ReusableMethods.bekle(5);

    }
    @Then("signIn Buttona tiklar")
    public void sign_in_buttona_tiklar() {
        adminPages.loginPageSigInButton.click();

    }
    @Then("Kullanici girisi yapilamadigini dogrular")
    public void kullanici_girisi_yapilamadigini_dogrular() {

        // %%%TRY-CATCH KULLANİMİ ÇOKLU NEGATİF TESTTE
        // KAZARA SİSTEME GİRİŞ YAPACAK OLURSA TESTİN YOLUNA DEVAM ETMESİ İÇİN

        try {
            Assertions.assertTrue(adminPages.loginPageSigInButton.isDisplayed(),
                    "Giriş başarısız olmalıydı!");
        } catch (NoSuchElementException e) {     // noSuchElement EXCEPTİON seleniumdan gelecek



            // throw new RuntimeException(e); bu satırın yerine
            adminPages.signOutButton.click();
            Assertions.assertTrue(adminPages.loginPageSigInButton.isDisplayed(),
                    "Giriş başarısız olmalıydı!");
        }

    }

}
