package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import pages.AdminPages;
import utilities.ReusableMethods;

public class DF038_AddAnewPetsAdsensStepdefinitions {

    AdminPages adminPages = new AdminPages() ;
    Faker faker =new Faker();

    @And("goesToPetsAdsensPage")
    public void goestopetsadsenspage() {

        adminPages.petsAdsenseButton.click();
        adminPages.subPetAdsenseButton.click();


    }


    @Then("addAnewPetsAdsens")
    public void addanewpetsadsens() {

        // petAdsens butona basarak reklam ekleme sayfasına gider
        adminPages.petsAdsensAddAdsensPage.click();

        // location ekler
       // adminPages.petsAdsenselocationBox.click();
        //adminPages.petsAdsenselocationBox.sendKeys("Wellness");

        String title = faker.lorem().characters(8);

        // title ekler
        adminPages.petsAdsensTitleBox.sendKeys(title);

        // gorunen ismi ekler
        String displayName = "aaa"+title;
        adminPages.petsAdsensDisplayNameBox.sendKeys("yavluKediler");

        // radioButtona tıklar
        adminPages.petsAdsensRadioButton.click();

        // sayfayi asagiya kaydirir
        ReusableMethods.scrollToBottom();

        // < -- ==================================================

        // yuklenecek resmin  url den mi yoksa image mi olduğunu seçer
        //adminPages.petsAdsensTypeBox.click();

        //adminPages.petAdsenseTypeBox.sendKeys("image");




        // yüklenecek resmi masa üstünden aldırmak için image seçiyor


        adminPages.petAdsenseAddPageImageButton.click();

        String httpsUzantisi = "https://www.";
        String siteAdi = faker.lorem().characters(7)+"com";
        String fotoUzantisi = "/tr-tr/fotograf/"+faker.lorem().characters(3)+faker.lorem().characters(6);
        String fotoURL = httpsUzantisi+siteAdi+fotoUzantisi;



        // yuklenecek resmin  masaustu yolunu girer
        //adminPages.petsAdsensUrlBox.sendKeys("C:\\Users\\"+faker.lorem().characters(5)+"\\OneDrive\\Desktop\\loyalfriendcare\\upload.png\\");
        adminPages.petsAdsensUrlBox.sendKeys(fotoURL);

        System.out.println(fotoURL);



        // sayfayı aşağıya kaydırır
        ReusableMethods.scrollToBottom();

        // context açılması için butona tıklar
        adminPages.petsAdsensContesxtButton.click();

        // sayfayı aşağıya kaydırır
        ReusableMethods.scrollToBottom();



        // context gire
        adminPages.petsAdsensContextBox.sendKeys("canDostları");
        ReusableMethods.bekle(2);

        ReusableMethods.scrollToBottom();

        adminPages.petsAdsensSaveButton.click();



    }
}
