package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.AdminPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Locale;

public class DF045_YeniKullaniciOlusturmaStepdefinitions {

    private AdminPages adminPages;
    private Faker faker;
    private TestData testData;

    // Test verilerini tutan POJO
    private static class TestData {
        String username;
        String email;
        String password;
    }

    @Before(order = 1)
    public void setupDriver() {
        Driver.getDriver(); // Driver başlatma
    }

    @Before(order = 2)
    public void generateTestData(Scenario scenario) {
        faker = new Faker(new Locale("tr-TR")); // Türkçe veri üretimi
        adminPages = new AdminPages();
        testData = new TestData();

        // Dinamik veri üretimi
        testData.username = faker.name().username().replaceAll("[^a-zA-Z0-9]", "");
        testData.email = faker.internet().emailAddress();
        testData.password = faker.internet().password(10, 16, true, true) + "A1!";

        // Senaryo ismini logla
        System.out.println("Çalışan Senaryo: " + scenario.getName());
    }

    @Given("Register sayfasina gidilir")
    public void register_sayfasina_gidilir() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        adminPages.signUpButton.click();

    }

    @When("Gecerli kullanıcı adı girilir")
    public void gecerli_kullanici_adi_girilir() {

        adminPages.userNameBox.sendKeys(testData.username);

        System.out.println(1);
    }

    @When("Gecerli e-posta adresi girilir")
    public void gecerli_e_posta_adresi_girilir() {
        adminPages.mailBox.sendKeys(testData.email);
        System.out.println(2);
    }

    @When("Gecerli şifre girilir ve dogrulama yapilir")
    public void gecerli_sifre_girilir_ve_dogrulama_yapilir() {
        String password = testData.password;
        System.out.println(3 );
        adminPages.passwordBox.sendKeys(password);
        System.out.println(4);
        adminPages.confirmPasswordBox.sendKeys(password);
        System.out.println(5);

        // Şifre karmaşıklık kontrolü
        if(!password.matches("^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9]).{10,}$")) {
            throw new RuntimeException("Geçersiz şifre formatı: " + password);
        }
    }

    @Then("Kayit tamamlanir")
    public void kayit_tamamlanir() {
        adminPages.registerButton.click();
        //ReusableMethods.waitForClickability(adminPages.registerButton, 5).click();
       // ReusableMethods.verifyElementDisplayed(adminPages.successMessage);
        System.out.println(6);
    }

    @Then("Hesaptan cikis yapilir")
    public void hesaptan_cikis_yapilir() {
        ReusableMethods.waitForClickability(adminPages.signOutButton, 5).click();
        System.out.println(7);
    }

    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}
