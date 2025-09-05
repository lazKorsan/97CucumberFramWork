package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AdminPages;
import utilities.ConfigReader;
import utilities.Driver;

public class DF007_YeniKullaniciOlusturmakStepdefinitions {
    AdminPages adminPages = new AdminPages();
    Faker faker = new Faker();
    private TestData testData;

    private static class TestData {
        String username;
        String email;
        String password;
    }

    @Before
    public void generateTestData(Scenario scenario) {
        testData = new TestData(); // Nesne oluşturuluyor
        testData.username = faker.lorem().characters(8);
        testData.email = testData.username + "@gmail.com";
        testData.password = faker.lorem().characters(12) + "1zZ.";
    }

    @Given("ziyaretci register sayfasina gider")
    public void ziyaretci_register_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        adminPages.signUpButton.click();
    }

    @Then("userNameBoxa {string} girer")
    public void user_name_boxa_girer(String username) {
        adminPages.userNameBox.sendKeys(testData.username);
    }

    @Then("mailBoxa {string} girer")
    public void mail_boxa_girer(String email) {
        adminPages.mailBox.sendKeys(testData.email);
    }

    @Then("passwordBoxa {string} girer")
    public void password_boxa_girer(String password) {
        adminPages.passwordBox.sendKeys(testData.password);
    }

    @Then("comfirmPasswordBoxa {string} girer")
    public void comfirm_password_boxa_girer(String password) {
        adminPages.confirmPasswordBox.sendKeys(testData.password);
    }

    @Then("signinButona basarak kaydini tamalar")
    public void signin_butona_basarak_kaydini_tamalar() {
        adminPages.registerButton.click();
        System.out.println("Kayıt işlemi tamamlandı");
    }
}