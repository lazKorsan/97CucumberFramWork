package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.io.FileInputStream;
import java.io.IOException;

public class DF010_ExcelldenAramaTestiStepdefinitions {

    private String satirdakiUrunIsmi;
    private int minUrunMiktari;
    private int bulunanUrunSayisi;

    @Given("Kullanici loyalfriendcare ana Sayfasini acar")
    public void kullanici_loyalfriendcare_ana_sayfasini_acar() {
        Driver.getDriver().get("https://www.loyalfriendcare.com");
    }

    @And("urunler excellindeki {string} numarali satirdaki urun ismini ve min. miktarini kaydeder")
    public void urunlerExcellindekiNumaraliSatirdakiUrunIsminiVeMinMiktariniKaydeder(String satirNumarasi) {
        try {
            // Excel dosya yolunu belirtin
            String excelDosyaYolu = "\"C:\\Users\\Hp\\OneDrive\\Desktop\\urunler.ods\"";
            FileInputStream fis = new FileInputStream(excelDosyaYolu);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0); // İlk sayfa

            int satirNo = Integer.parseInt(satirNumarasi);
            Row row = sheet.getRow(satirNo);

            // Excel'den ürün adı ve min miktarı oku
            Cell urunAdiHucresi = row.getCell(0); // A sütunu
            Cell minMiktarHucresi = row.getCell(1); // B sütunu

            satirdakiUrunIsmi = urunAdiHucresi.getStringCellValue();
            minUrunMiktari = (int) minMiktarHucresi.getNumericCellValue();

            System.out.println("Excel'den okunan: " + satirdakiUrunIsmi + " - Min Miktar: " + minUrunMiktari);

            workbook.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
            Assertions.fail("Excel dosyası okunamadı: " + e.getMessage());
        }
    }

    @And("aranan urunleri loyalfriendcare sayfasinda aratir ve urun sayisini kaydeder")
    public void arananUrunleriLoyalfriendcareSayfasindaAratirVeUrunSayisiniKaydeder() {
        try {
            // Arama kutusunu bul ve ürünü ara
            WebElement aramaKutusu = Driver.getDriver().findElement(By.name("search"));
            aramaKutusu.clear();
            aramaKutusu.sendKeys(satirdakiUrunIsmi + Keys.ENTER);

            // Ürün sonuçlarını bekle (kısa bir bekleme süresi)
            Thread.sleep(2000);

            // Ürün sonuçlarını say
            java.util.List<WebElement> urunler = Driver.getDriver().findElements(By.cssSelector(".product-item"));
            bulunanUrunSayisi = urunler.size();

            System.out.println("Bulunan ürün sayısı: " + bulunanUrunSayisi);

        } catch (Exception e) {
            e.printStackTrace();
            bulunanUrunSayisi = 0;
        }
    }

    @Then("bulunan urun sayisinin kayitli min. miktardan fazla yada esit oldugunu test eder")
    public void bulunanUrunSayisininKayitliMinMiktardanFazlaYadaEsitOldugunuTestEder() {
        Assertions.assertTrue(
                bulunanUrunSayisi >= minUrunMiktari);
    }
}