package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void bekle(int saniye)  {

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    // verilen Webelement'lerden olusan bir listedeki
    // herbir webelement'i ele alip
    // web element uzerindeki yaziyi, olusturacagimiz bir listeye ekleyip,
    // tum elementler elden gectikten sonra
    // String'lerden olusan listeyi DONDUREN bir method olusturun

    public static List<String> stringListeDonustur (List<WebElement> webElementList){

        List<String> stringList = new ArrayList<>();

        for (WebElement eachElement:webElementList){
            stringList.add(eachElement.getText());

        }

        return stringList;

    }

    public static void urlIleWindowGecisi(WebDriver driver, String hedefUrl){

        Set<String> acikOlanTumWindowlarinWhdSeti = driver.getWindowHandles();

        for (String eachWhd :acikOlanTumWindowlarinWhdSeti){

            driver.switchTo().window(eachWhd);

            String actualUrl = driver.getCurrentUrl();

            if (hedefUrl.equals(actualUrl)){
                break;
            }

        }
    }

    public static void titleIleWindowGecisi(WebDriver driver, String hedefTitle){

        Set<String> acikOlanTumWindowlarinWhdSeti = driver.getWindowHandles();

        for (String eachWhd :acikOlanTumWindowlarinWhdSeti){

            driver.switchTo().window(eachWhd);

            String actualTitle = driver.getTitle();

            if (hedefTitle.equals(actualTitle)){
                break;
            }

        }
    }

    public static void tumSayfaResimCek(WebDriver driver){
        // 1.adim : TakesScreenshot objesi olustur
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim : screenshot'i kaydedecegimiz dosyayi (File) olusturun
        File file = new File("target/screenshots/tumSayfaScreenshot.jpg");

        // 3.adim : screenshot'i alip gecici bir dosyaya kaydedin
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim : geciciresim dosyasini, asil kaydetmek istedigimiz file'a kopyalayalim

        try {
            FileUtils.copyFile(geciciResim,file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tumSayfaResimCek(WebDriver driver, String raporIsmi){

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 1.adim : TakesScreenshot objesi olustur
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim : screenshot'i kaydedecegimiz dosyayi (File) olusturun
        File file = new File("target/screenshots/"+ raporIsmi + ".jpg");

        // 3.adim : screenshot'i alip gecici bir dosyaya kaydedin
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim : geciciresim dosyasini, asil kaydetmek istedigimiz file'a kopyalayalim

        try {
            FileUtils.copyFile(geciciResim,file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tumSayfaResimCekTarihli(WebDriver driver){

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        // resimlerin ayni isimde olup birbiri yerine kaydedilmesini engellemek icin
        // resim dosyasina tarih etiketi ekleyelim

        // tumSayfaScreenshot_290525_190923

        LocalDateTime localDateTime = LocalDateTime.now();
        // istedigimiz formati olusturalim _290525_190923
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("_ddMMyy_HHmmss");

        String tarihEtiketi = localDateTime.format(istenenFormat);


        // 1.adim : TakesScreenshot objesi olustur
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim : screenshot'i kaydedecegimiz dosyayi (File) olusturun
        File file = new File("target/screenshots/tumSayfaSs"+tarihEtiketi+".jpg");

        // 3.adim : screenshot'i alip gecici bir dosyaya kaydedin
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim : geciciresim dosyasini, asil kaydetmek istedigimiz file'a kopyalayalim

        try {
            FileUtils.copyFile(geciciResim,file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tumSayfaResimCekTarihli(WebDriver driver, String raporIsmi){

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        // istedigimiz formati olusturalim _290525_190923
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("_ddMMyy_HHmmss");

        String tarihEtiketi = localDateTime.format(istenenFormat);



        // 1.adim : TakesScreenshot objesi olustur
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim : screenshot'i kaydedecegimiz dosyayi (File) olusturun
        File file = new File("target/screenshots/"+ raporIsmi + tarihEtiketi + ".jpg");

        // 3.adim : screenshot'i alip gecici bir dosyaya kaydedin
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim : geciciresim dosyasini, asil kaydetmek istedigimiz file'a kopyalayalim

        try {
            FileUtils.copyFile(geciciResim,file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void webElementResimCek(WebElement hedefElement){
        // 1.adim : screenshot alacaginiz webelementi locate edip, kaydedin
        //          biz arama sonuc yazisi elementini zaten locate edip kaydetmistik

        // 2.adim : screenshot'i kaydedecegimiz dosyayi(File) olusturun
        String dosyaYolu = "target/screenshots/istenenWebElement.jpg";
        File asilResim = new File(dosyaYolu);

        // 3.adim : webElement'i kullanarak screenshot alip
        //          gecici bir dosyaya(File) kaydedin
        File geciciResim = hedefElement.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici resmi asil resme kopyalayin
        try {
            FileUtils.copyFile(geciciResim,asilResim);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void webElementResimCek(WebElement hedefElement, String resimIsmi){
        // 1.adim : screenshot alacaginiz webelementi locate edip, kaydedin
        //          biz arama sonuc yazisi elementini zaten locate edip kaydetmistik

        // 2.adim : screenshot'i kaydedecegimiz dosyayi(File) olusturun
        String dosyaYolu = "target/screenshots/"+resimIsmi+".jpg";
        File asilResim = new File(dosyaYolu);

        // 3.adim : webElement'i kullanarak screenshot alip
        //          gecici bir dosyaya(File) kaydedin
        File geciciResim = hedefElement.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici resmi asil resme kopyalayin
        try {
            FileUtils.copyFile(geciciResim,asilResim);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void webElementTarihliResimCek(WebElement hedefElement){

        LocalDateTime localDateTime = LocalDateTime.now();
        // istedigimiz formati olusturalim _290525_190923
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("_ddMMyy_HHmmss");

        String tarihEtiketi = localDateTime.format(istenenFormat);

        // 1.adim : screenshot alacaginiz webelementi locate edip, kaydedin
        //          biz arama sonuc yazisi elementini zaten locate edip kaydetmistik

        // 2.adim : screenshot'i kaydedecegimiz dosyayi(File) olusturun
        String dosyaYolu = "target/screenshots/istenenWebElement"+tarihEtiketi+".jpg";
        File asilResim = new File(dosyaYolu);

        // 3.adim : webElement'i kullanarak screenshot alip
        //          gecici bir dosyaya(File) kaydedin
        File geciciResim = hedefElement.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici resmi asil resme kopyalayin
        try {
            FileUtils.copyFile(geciciResim,asilResim);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void webElementTarihliResimCek(WebElement hedefElement, String resimIsmi){

        LocalDateTime localDateTime = LocalDateTime.now();
        // istedigimiz formati olusturalim _290525_190923
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("_ddMMyy_HHmmss");

        String tarihEtiketi = localDateTime.format(istenenFormat);


        // 1.adim : screenshot alacaginiz webelementi locate edip, kaydedin

        // 2.adim : screenshot'i kaydedecegimiz dosyayi(File) olusturun
        String dosyaYolu = "target/screenshots/"+resimIsmi+tarihEtiketi+".jpg";
        File asilResim = new File(dosyaYolu);

        // 3.adim : webElement'i kullanarak screenshot alip
        //          gecici bir dosyaya(File) kaydedin
        File geciciResim = hedefElement.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici resmi asil resme kopyalayin
        try {
            FileUtils.copyFile(geciciResim,asilResim);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String raporaResimEkle(String testIsmi) throws IOException {

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String date = localDateTime.format(format); // _241219_080623

        // 1.adim tss objesi olusturalim
        //   ve takesScreenshot objesi ile gecici resmi kaydedelim
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File geciciDosya = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // Asil resmi kaydedecegimiz dosya yolunu olusturup
        // bu dosya yolu ile resmi kaydedecegimiz asil dosyayi olusturalim
        String dosyaYolu = System.getProperty("user.dir") + "/test-output/Screenshots/" + testIsmi + date + ".jpg";
        File asilResimDosyasi = new File(dosyaYolu);
        // gecici dosyayi asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciDosya, asilResimDosyasi);
        return dosyaYolu;
    }

    // 1. Temel Scroll Metodu
    public static void scrollToElement(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
        //<===============cagrılması ===========================>
        //ReusableMethods.scrollToElement(practiceexpandtestingPage.oneTimePasswordButtons);
        //<=====================================================>

    }

    // 2. Scroll + Beklemeli Versiyon
    public static void scrollToElementWithWait(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        //<-- scrollToElementWithWait Methodunun Cagırılması -->
        //ReusableMethods.scrollToElementWithWait(practiceexpandtestingPage.oneTimePasswordButtons,300);
        // <-- =================================== -->
    }

    // 3. Sayfa Sonuna Scroll
    public static void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // <-- scrollBottom methodunun Cagırılması -->
        //ReusableMethods.scrollToBottom();
        // <-- =================================== -->
    }


    // < - ===== elementlerin ve sayfanının görünür olması ile ilgili methodlar-- >
    // < -- vvvvv====================methodlar başlangıcı vvvvvvvvvvv============ -->



    // 1️⃣ WAIT FOR VISIBILITY
    /**
     * Elementin görünür olmasını bekler
     * @param element : Beklenecek WebElement
     * @param timeout : Maksimum bekleme süresi (saniye)
     * @return WebElement : Bulunan element
     * @throws TimeoutException : Element görünür olmazsa
     */
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(element));
    }

    // 2️⃣ WAIT FOR CLICKABILITY
    /**
     * Elementin tıklanabilir olmasını bekler
     * @param element : Beklenecek WebElement
     * @param timeout : Maksimum bekleme süresi (saniye)
     * @return WebElement : Tıklanabilir element
     * @throws TimeoutException : Element tıklanabilir olmazsa
     */
    public static WebElement waitForClickability(WebElement element, int timeout) {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    // 3️⃣ VERIFY ELEMENT DISPLAYED
    /**
     * Elementin görüntülendiğini doğrular
     * @param element : Kontrol edilecek WebElement
     * @param timeout : Maksimum bekleme süresi (saniye)
     * @return boolean : Görüntülenme durumu
     */
    public static boolean verifyElementDisplayed(WebElement element, int timeout) {
        try {
            waitForVisibility(element, timeout);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // 🚀 OPSİYONEL: Varsayılan Timeout'lu Overload Metodlar
    public static WebElement waitForVisibility(WebElement element) {
        return waitForVisibility(element, 10); // Varsayılan 10 sn
    }

    public static WebElement waitForClickability(WebElement element) {
        return waitForClickability(element, 10); // Varsayılan 10 sn
    }

    public static boolean verifyElementDisplayed(WebElement element) {
        return verifyElementDisplayed(element, 10); // Varsayılan 10 sn
    }


    // < -- element görünürlüğü ilgili methodlar sonu ====== -->


}
