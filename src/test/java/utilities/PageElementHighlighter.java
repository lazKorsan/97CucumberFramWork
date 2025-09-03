package utilities;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AdminPages;
import pages.HeaderPages;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class PageElementHighlighter {

    //  %%%QRM  %%%REDBORDERM  %%%GREENBORDERM ARATABİLİRSİNİZ
    // 24-25-26 çalışmazssa 23 kullan sıkıntıısz
     private static final String SCREENSHOT_DIR = "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\";
   // private static final String SCREENSHOT_DIR = System.getProperty("user.home") +
     //       File.separator + "Desktop" + File.separator + "loyalfriendcare" +
       //     File.separator + "gelen png" + File.separator;




    public static void highlightElementsAndTakeScreenshot(WebDriver driver, Object[][] redElements, Object[][] greenElements, String screenshotName) {
        try {
            // Sayfanın yüklendiğinden emin ol
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                    webDriver -> ((JavascriptExecutor) webDriver)
                            .executeScript("return document.readyState").equals("complete"));

            // Tüm elementleri bul ve highlight et
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Map<WebElement, String> highlightedElements = new HashMap<>();

            // Kırmızı çerçeve için elementleri işle
            if (redElements != null) {
                for (Object[] elementData : redElements) {
                    WebElement element = (WebElement) elementData[0];
                    String elementName = (String) elementData[1];
                    highlightElement(js, element, elementName, "red");
                    highlightedElements.put(element, elementName);
                }
            }

            // Yeşil çerçeve için elementleri işle
            if (greenElements != null) {
                for (Object[] elementData : greenElements) {
                    WebElement element = (WebElement) elementData[0];
                    String elementName = (String) elementData[1];
                    highlightElement(js, element, elementName, "green");
                    highlightedElements.put(element, elementName);
                }
            }

            // Kısa bekleme (render için)
            Thread.sleep(1000);

            // URL'yi al
            String pageUrl = driver.getCurrentUrl();

            // Ekran görüntüsü al ve işle
            takeScreenshotWithHighlights(driver, screenshotName, highlightedElements, pageUrl);

            // Highlight'ları temizle
            for (WebElement element : highlightedElements.keySet()) {
                js.executeScript(
                        "arguments[0].style = arguments[0].getAttribute('data-original-style') || '';" +
                                "arguments[0].removeAttribute('data-original-style');",
                        element
                );
            }

            // Label'ları temizle
            js.executeScript(
                    "var labels = document.querySelectorAll('div[style*=\"background: red\"], div[style*=\"background: green\"]');" +
                            "labels.forEach(function(label) { label.parentNode.removeChild(label); });"
            );

        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void highlightElement(JavascriptExecutor js, WebElement element, String elementName, String color) {
        if (element.isDisplayed()) {
            // Orijinal style'ı sakla
            String originalStyle = element.getAttribute("style");
            js.executeScript(
                    "arguments[0].setAttribute('data-original-style', arguments[1]);",
                    element, originalStyle
            );

            // Çerçeve ve label ekle
            js.executeScript(
                    "arguments[0].style.border = '3px solid " + color + " !important';" +
                            "arguments[0].style.background = 'rgba(" + (color.equals("red") ? "255,0,0,0.1" : "0,255,0,0.1") + ") !important';" +
                            "arguments[0].style.padding = '2px !important';" +
                            "var label = document.createElement('div');" +
                            "label.innerHTML = '🔍 ' + arguments[1];" +
                            "label.style.position = 'absolute';" +
                            "label.style.background = '" + color + "';" +
                            "label.style.color = 'white';" +
                            "label.style.padding = '2px 8px';" +
                            "label.style.fontSize = '12px';" +
                            "label.style.fontWeight = 'bold';" +
                            "label.style.borderRadius = '3px';" +
                            "label.style.zIndex = '10000';" +
                            "label.style.whiteSpace = 'nowrap';" +
                            "var rect = arguments[0].getBoundingClientRect();" +
                            "label.style.top = (rect.bottom + window.scrollY + 5) + 'px';" +
                            "label.style.left = (rect.left + window.scrollX) + 'px';" +
                            "document.body.appendChild(label);",
                    element, elementName
            );
        }
    }

    private static void takeScreenshotWithHighlights(WebDriver driver, String fileName, Map<WebElement, String> elements, String pageUrl) {
        try {
            // Tarayıcıyı maksimize et
            driver.manage().window().maximize();

            // Selenium screenshot al
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(screenshot);

            // Graphics2D için çevirim
            Graphics2D g2d = image.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            // URL'yi sağ ortaya yaz
            g2d.setFont(new Font("SansSerif", Font.BOLD, 16));
            g2d.setColor(Color.BLACK);
            FontMetrics fm = g2d.getFontMetrics();
            int urlWidth = fm.stringWidth(pageUrl);
            int urlHeight = fm.getHeight();
            int urlX = image.getWidth() - urlWidth - 20; // Sağ kenardan 20 piksel içeride
            int urlY = image.getHeight() / 2; // Ortada
            g2d.drawString(pageUrl, urlX, urlY);

            // QR kodu oluştur ve ekle
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(pageUrl, BarcodeFormat.QR_CODE, 100, 100);
            BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            g2d.drawImage(qrImage, urlX, urlY + 10, 100, 100, null);

            g2d.dispose();
            // Dosyaya kaydet
            File outputFile = new File(SCREENSHOT_DIR + fileName + "_highlighted.png");
            FileUtils.forceMkdirParent(outputFile);
            ImageIO.write(image, "png", outputFile);

            System.out.println("Screenshot kaydedildi: " + outputFile.getAbsolutePath());

        } catch (Exception e) {
            System.out.println("Screenshot alınamadı: " + e.getMessage());
        }
    }

    @Test
    public void methodCagirmaTesti(){
        // DİKKAT BU TEST BU KONUMDA ÇALIŞMAZ . // ÇÜNKÜ CUCUMBER DAYIZ .

        //  %%%QRU  %%%REDBORDERU  %%%GREENBORDERU ARATABİLİRSİNİZ
        // DİKKAT BU TEST BU KONUMDA ÇALIŞMAZ

        // ALTTAKİ SATIRLARDAN KODUN ÇAĞIRILMASINI GÖREBİLİRSİNİZ
        // PROJE İÇİNDE ARATMAK İÇİN
        //  %%%QRU  %%%REDBORDERU  %%%GREENBORDERU ARATABİLİRSİNİZ
        // KODUN İŞLEVİ PAGE OBJECT MODELE UYUGUN OLARAK
        // ELEMENTLERİ KIRMIZI VE YEŞİL ÇERÇEVE İÇİNE ALMAK
        // ALTINA DESCRİPTION VERMEK
        // SAYFANIN QR KODUNU EKLEMEK
        AdminPages adminPages = new AdminPages();
        HeaderPages headerPages = new HeaderPages();
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        PageElementHighlighter.highlightElementsAndTakeScreenshot(
                Driver.getDriver(),
                new Object[][]{
                        {headerPages.logoButton, "Ana Logo"},
                        {headerPages.searchButton, "Arama Butonu"}
                },
                new Object[][]{
                        {headerPages.signInButton, "İletişim Linki"}
                },
                "about_page_screenshot"
        );
    }
}