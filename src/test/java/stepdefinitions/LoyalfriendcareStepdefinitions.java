package stepdefinitions;

import io.cucumber.java.en.When;
import pages.AdminPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.PageElementHighlighter;

public class LoyalfriendcareStepdefinitions {
    AdminPages adminPages= new AdminPages();

    @When("Kullanici admin girisi yapar")
    public void kullanici_admin_girisi_yapar() {
        AdminPages adminPages= new AdminPages();


        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        PageElementHighlighter.highlightElementsAndTakeScreenshot(
                Driver.getDriver(),
                new Object[][]{
                        {adminPages.logoButton, "Ana Logo"},
                        {adminPages.searchButton, "Arama Butonu"}
                },
                new Object[][]{
                        {adminPages.signInButton, "İletişim Linki"}
                },
                "about_page_screenshot"
        );


    }
}
