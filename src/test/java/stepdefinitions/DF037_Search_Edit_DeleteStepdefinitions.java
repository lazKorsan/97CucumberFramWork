package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.AdminPages;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.net.ssl.SSLContext;

public class DF037_Search_Edit_DeleteStepdefinitions {
    AdminPages adminPages = new AdminPages() ;

    @Then("editInfoAdsenseAndDeleteSense")
    public void editinfoadsenseanddeletesense() {

        // EDİT butununa basar
        adminPages.petsAdsSenseEditbutton.click();

        // sayfayı bekletir zorunlu
        ReusableMethods.bekle(2); // zorunlu

        // sayfayı aşağı kaydırır
        ReusableMethods.scrollToBottom();// zorunlu

        // context butona basar
        adminPages.petsAdsensContesxtButton.click();

        // sayfayı aşağı kaydırır
        ReusableMethods.scrollToBottom(); // zorunlu

        // düzeltme metinini girer. daha sonra title ekleme yapılabilir
        adminPages.petsAdsensContextBox.sendKeys("HELLO HELLO "+ Keys.ENTER);

        // sayfayı aşağı kaydırır
        ReusableMethods.scrollToBottom(); // zorunlu

        // değişiklikleri kaydeder
        adminPages.petsAdsensSaveButton.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(adminPages.dashboardTables).perform();

        adminPages.petsAdsenseButton.click();
        adminPages.subPetAdsenseButton.click();

        // Adsense sayfasına gider. daha sonra dashboar ile alakalı iyileştirme yapılabilir
       // Driver.getDriver().get("https://qa.loyalfriendcare.com/en/Dashboard/AdSense");

        // reklamı silme tusuna basar
        adminPages.petsAdsenseDeleteButton.click();











    }
}
