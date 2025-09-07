package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class DF046_SauceDemoStepdefinitions {

    // %%%URUNLER-LİSTESİNDEN INDEX İLE ELEMAN SEÇMEK
    // %%%PRODUCTS-LİST  İNDEX İLE ELEMAN SEÇMEK

    SaucedemoPages saucedemoPages = new SaucedemoPages() ;





    @Given("kullanici saucedemo sitesinden alisveris yapar")
    public void kullaniciSaucedemoSitesindenAlisverisYapar() {
        Driver.getDriver().get(ConfigReader.getProperty("sdURL"));

        saucedemoPages.userNameBox.sendKeys(ConfigReader.getProperty("sdUN"));
        saucedemoPages.passwordBox.sendKeys(ConfigReader.getProperty("sdPW"));
        saucedemoPages.loginButton.click();

        ReusableMethods.bekle(7);
        String ilkUrunElementiText = saucedemoPages.IlkUrunElementiYazisi.getText();
        System.out.println(ilkUrunElementiText);

        // her hangi bir listedeki ilk elementi seçmek için
       //  String secilenUrunIsmi = saucedemoPages.urunlerListesi.get(0).getText();
        // herhangi bir listedeki ilk elemente tıklamak için
        // %%%URUNLER-LİSTESİNDEN INDEX İLE ELEMAN SEÇMEK
        // %%%PRODUCTS-LİST  İNDEX İLE ELEMAN SEÇMEK
        saucedemoPages.urunlerListesi.get(0).click();
        saucedemoPages.AddToCardButton.click();

        saucedemoPages.sepetElementi.click();
        String sepettekiUrunlarSayfasiIlkUrunElementiYazisi =
        saucedemoPages.sepettekiUrunlarSayfasiIlkUrunElementiYazisi.getText();
        System.out.println(sepettekiUrunlarSayfasiIlkUrunElementiYazisi);

        Assertions.assertEquals(ilkUrunElementiText,sepettekiUrunlarSayfasiIlkUrunElementiYazisi);





    }





    public static class SaucedemoPages {                                         // s1

        // < -- ======= Start Locater Area ===== -- >

        @FindBy(xpath = "//input[@id='user-name']")
        public WebElement userNameBox ;

        @FindBy(xpath = "//input[@id='password']")
        public WebElement passwordBox ;

        @FindBy(xpath = "//input[@id='login-button']")
        public WebElement loginButton ;

        @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
        public WebElement AddToCardButton ; // sadece ilk element

        @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
        public WebElement removeButton ; // sadece ilk element

        @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
        public WebElement IlkUrunElementiYazisi ;

        @FindBy(xpath = "//div[@class='inventory-item-name']")
        public List<WebElement> urunlerListesi ;

        @FindBy(xpath = "//div[@id='shopping_cart_container']")
        public WebElement sepetElementi ;

        @FindBy(xpath = "//div[@class='inventory_item_name']")
        public WebElement sepettekiUrunlarSayfasiIlkUrunElementiYazisi ;





        // < -- ===== End Lacater Area ===== -- >

        // < -- ===== Begin Definition Constructor  ===== -->
        public SaucedemoPages() {                                         //s4
            PageFactory.initElements(Driver.getDriver(), this);  //s5
        }                                                              // s6
        // < -- ===== End Definitions Constructor  ===== -- >
    }
}
