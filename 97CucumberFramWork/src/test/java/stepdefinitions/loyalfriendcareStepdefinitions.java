package stepdefinitions;

import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AdminPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class loyalfriendcareStepdefinitions {
    public static final DateTimeFormatter DATE_FORMATTER
            = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static final String REPORT_PATH = "/var/app/reports/";

    AdminPages adminPages = new AdminPages();

    @When("Kullanici admin girisi yapar")
    public void kullanici_admin_girisi_yapar(){

        // Kullanıcı ana sayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        // BANNER BANNER
        ReusableMethods.bekle(2);
        displayProgressBanner(
                Driver.getDriver(),
                "ana sayfadayız",
                "admin girişi",
                "Kullanıcı admin girişi yapar"
        );ReusableMethods.bekle(6);

        // kullanici signIn buttona basar
        adminPages.signInButton.click();

        // kullanici mail box mail adresi girer
        adminPages.mailBox.sendKeys(ConfigReader.getProperty("adm"));

        // kullanici sifresini girer
        adminPages.passwordBox.sendKeys(ConfigReader.getProperty("adp"));

        //
        adminPages.loginPageSigInButton.click();
        ReusableMethods.bekle(2);
        //
        adminPages.signOutButton.click();
    }






    //<--=========BANNER BANNER BAŞLIYOR ==================================-->



    public static void displayDynamicBanner(WebDriver driver, String bannerType,
                                            String mainTitle, String testName,
                                            String testDescription, int duration) {
        displayConsoleBanner(bannerType, mainTitle, testName, testDescription);
        displayBrowserBanner(driver, bannerType, mainTitle, testName, testDescription, duration);
    }

    /**
     * 🎯 Hızlı kullanım için overload method
     */
    public static void displayAdminTestBanner(WebDriver driver, String testName, String testDescription) {
        displayDynamicBanner(driver, "start", "ADMIN TESTİ BAŞLIYOR", testName, testDescription, 5000);
    }

    /**
     * 🎯 Test ilerleyişi için banner
     */
    public static void displayProgressBanner(WebDriver driver, String progressTitle, String testName, String stepDescription) {
        displayDynamicBanner(driver, "progress", progressTitle, testName, stepDescription, 5000); // EKRANDA NE KADAR KALACAĞINI AYARLA
    }

    /**
     * 🎯 Başarı banner'ı
     */
    public static void displaySuccessBanner(WebDriver driver, String successTitle, String testName) {
        displayDynamicBanner(driver, "success", successTitle, testName, "Test başarıyla tamamlandı", 4000);
    }

    /**
     * 🎯 Konsol banner'ı
     */
    private static void displayConsoleBanner(String bannerType, String mainTitle, String testName, String testDescription) {
        String icon = getBannerIcon(bannerType);
        String colorCode = getBannerColorCode(bannerType);

        String banner =
                "\n" + colorCode +
                        "==================================================\n" +
                        "               " + icon + " " + mainTitle + " \n" +
                        "==================================================\n" +
                        "⏰ Zaman: " + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()) + "\n" +
                        "🎯 Test: " + testName + "\n" +
                        "📝 Durum: " + testDescription + "\n" +
                        "🌐 URL: " + ConfigReader.getProperty("lfc") + "\n" +
                        "==================================================\n" +
                        "\u001B[0m"; // Reset color

        System.out.println(banner);
    }

    /**
     * 🎯 Tarayıcı banner'ı
     */
    private static void displayBrowserBanner(WebDriver driver, String bannerType,
                                             String mainTitle, String testName,
                                             String testDescription, int duration) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            String[] colors = getBannerColors(bannerType);
            String icon = getBannerIcon(bannerType);

            String script =
                    "// Önceki banner'ı temizle\n" +
                            "var oldBanner = document.getElementById('dynamicTestBanner');\n" +
                            "if (oldBanner) { oldBanner.remove(); }\n" +
                            "\n" +
                            "// Yeni banner oluştur\n" +
                            "var banner = document.createElement('div');\n" +
                            "banner.id = 'dynamicTestBanner';\n" +
                            "banner.style.position = 'fixed';\n" +
                            "banner.style.left = '50%';\n" +
                            "banner.style.top = '50%';\n" +
                            "banner.style.transform = 'translate(-50%, -50%)';\n" +
                            "banner.style.background = 'linear-gradient(135deg, ' + arguments[0] + ')';\n" +
                            "banner.style.color = 'white';\n" +
                            "banner.style.padding = '20px';\n" +
                            "banner.style.borderRadius = '15px';\n" +
                            "banner.style.zIndex = '9999';\n" +
                            "banner.style.boxShadow = '0 10px 30px rgba(0,0,0,0.3)';\n" +
                            "banner.style.fontFamily = 'Arial, sans-serif';\n" +
                            "banner.style.textAlign = 'center';\n" +
                            "banner.style.minWidth = '350px';\n" +
                            "banner.style.border = '3px solid ' + arguments[1];\n" +
                            "banner.style.animation = 'fadeIn 0.5s ease-in';\n" +
                            "\n" +
                            "// İçerik\n" +
                            "banner.innerHTML = '' +\n" +
                            "    '<div style=\"font-size: 28px; margin-bottom: 10px;\">' + arguments[2] + '</div>' +\n" +
                            "    '<h3 style=\"margin: 0 0 15px 0; font-size: 20px; font-weight: bold;\">' + arguments[3] + '</h3>' +\n" +
                            "    '<div style=\"font-size: 14px; margin-bottom: 8px; background: rgba(255,255,255,0.1); padding: 5px; border-radius: 5px;\"><strong>Test:</strong> ' + arguments[4] + '</div>' +\n" +
                            "    '<div style=\"font-size: 14px; margin-bottom: 8px;\"><strong>Açıklama:</strong> ' + arguments[5] + '</div>' +\n" +
                            "    '<div style=\"font-size: 11px; opacity: 0.8; margin-top: 15px; border-top: 1px solid rgba(255,255,255,0.2); padding-top: 10px;\">' + new Date().toLocaleString() + '</div>' +\n" +
                            "    '<div style=\"font-size: 10px; opacity: 0.6; margin-top: 5px;\">' + arguments[6] + ' ms sonra kapanacak...</div>';\n" +
                            "\n" +
                            "// CSS animation ekle\n" +
                            "var style = document.createElement('style');\n" +
                            "style.innerHTML = '@keyframes fadeIn { from { opacity: 0; transform: translate(-50%, -60%); } to { opacity: 1; transform: translate(-50%, -50%); } }';\n" +
                            "document.head.appendChild(style);\n" +
                            "\n" +
                            "// Sayfaya ekle\n" +
                            "document.body.appendChild(banner);\n" +
                            "\n" +
                            "// Belirtilen süre sonra kaldır\n" +
                            "setTimeout(function() {\n" +
                            "    banner.style.animation = 'fadeOut 0.5s ease-out';\n" +
                            "    setTimeout(function() { \n" +
                            "        if (banner.parentNode) { \n" +
                            "            banner.parentNode.removeChild(banner); \n" +
                            "        }\n" +
                            "    }, 500);\n" +
                            "}, arguments[6]);\n" +
                            "\n" +
                            "// Fade out animation için CSS\n" +
                            "var fadeOutStyle = document.createElement('style');\n" +
                            "fadeOutStyle.innerHTML = '@keyframes fadeOut { from { opacity: 1; transform: translate(-50%, -50%); } to { opacity: 0; transform: translate(-50%, -60%); } }';\n" +
                            "document.head.appendChild(fadeOutStyle);";

            js.executeScript(script, colors[0], colors[1], icon, mainTitle, testName, testDescription, duration);

        } catch (Exception e) {
            System.out.println("⚠️ Browser banner gösterilemedi: " + e.getMessage());
        }
    }

    /**
     * 🎯 Banner tipine göre icon belirle
     */
    private static String getBannerIcon(String bannerType) {
        switch (bannerType.toLowerCase()) {
            case "start": return "🚀";
            case "progress": return "⏳";
            case "success": return "✅";
            case "warning": return "⚠️";
            case "error": return "❌";
            default: return "🎯";
        }
    }

    /**
     * 🎯 Banner tipine göre renk belirle
     */
    private static String[] getBannerColors(String bannerType) {
        switch (bannerType.toLowerCase()) {
            case "start": return new String[]{"#667eea 0%, #764ba2 100%", "#ff6b6b"};
            case "progress": return new String[]{"#f093fb 0%, #f5576c 100%", "#ffd93d"};
            case "success": return new String[]{"#4facfe 0%, #00f2fe 100%", "#00b894"};
            case "warning": return new String[]{"#ff9a9e 0%, #fad0c4 100%", "#fdcb6e"};
            case "error": return new String[]{"#ff5858 0%, #f09819 100%", "#d63031"};
            default: return new String[]{"#667eea 0%, #764ba2 100%", "#ff6b6b"};
        }
    }

    /**
     * 🎯 Konsol renk kodu
     */
    private static String getBannerColorCode(String bannerType) {
        switch (bannerType.toLowerCase()) {
            case "start": return "\u001B[35m"; // Purple
            case "progress": return "\u001B[33m"; // Yellow
            case "success": return "\u001B[32m"; // Green
            case "warning": return "\u001B[33m"; // Yellow
            case "error": return "\u001B[31m"; // Red
            default: return "\u001B[36m"; // Cyan
        }
    }




    // < -- ======= BANNER BANNNER SONU ===== -- >




    // < -- ===== excelle listeyi çeker Method başlangıcı

    public static void writeProductsToExcel(WebDriver driver, String categoryUrl, String productLocator, int baslangicSatir) {
        try {
            driver.get(categoryUrl);
            List<WebElement> products = driver.findElements(By.xpath(productLocator));
            String dosyaYolu = "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\bedManagerList.xlsx";

            Workbook workbook;
            Sheet sheet;

            try {
                FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
                workbook = WorkbookFactory.create(fileInputStream);
                sheet = workbook.getSheetAt(0);
                fileInputStream.close();
            } catch (IOException e) {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("bedManagerList");
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("İlaç Adı");
                headerRow.createCell(1).setCellValue("Eklenme Tarihi");
            }

            Pattern datePattern = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");

            for(int i = 0; i < products.size(); i++) {
                String productText = products.get(i).getText();
                String ilacAdi = productText;
                String eklenmeTarihi = "";

                Matcher matcher = datePattern.matcher(productText);
                if (matcher.find()) {
                    eklenmeTarihi = matcher.group();
                    ilacAdi = productText.replace(eklenmeTarihi, "").replace("\n", "").trim();
                }

                Row row = sheet.getRow(baslangicSatir + i);
                if(row == null) {
                    row = sheet.createRow(baslangicSatir + i);
                }

                row.createCell(0).setCellValue(ilacAdi);
                row.createCell(1).setCellValue(eklenmeTarihi);
            }

            try (FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu)) {
                workbook.write(fileOutputStream);
            }

            workbook.close();
            System.out.println("Toplam " + products.size() + " ürün Excel'e kaydedildi.");

        } catch (IOException e) {
            System.err.println("Excel kaydetme hatası: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // < -- ===== excelle Liste çekme sonu  -- ===== >


    // < -- ===== excellReportBaslanici ===== -- >


    public static void generateMedicineReport(WebDriver driver, String categoryUrl,
                                              String productLocator, String filePath) {
        try {
            // 1. Ürün listesini çek
            driver.get(categoryUrl);
            List<WebElement> products = driver.findElements(By.xpath(productLocator));

            // 2. Yeni workbook oluştur
            Workbook workbook = new XSSFWorkbook();

            // 3. Stilleri oluştur
            CellStyle headerStyle = createHeaderStyle(workbook);
            CellStyle dateStyle = createDateStyle(workbook);
            CellStyle defaultStyle = createDefaultStyle(workbook);

            // 4. Sayfa oluştur
            Sheet sheet = workbook.createSheet("Yatak Listesi");

            // 5. Rapor başlıkları
            createReportHeaders(sheet, headerStyle);

            // 6. Rapor bilgileri
            addReportInfo(sheet, defaultStyle, products.size(), categoryUrl);

            // 7. İlaç verilerini yaz
            writeMedicineData(sheet, products, dateStyle, defaultStyle);

            // 8. Sütun genişliklerini ayarla
            autoSizeColumns(sheet);

            // 9. Dosyayı kaydet
            saveWorkbook(workbook, filePath);

            System.out.println("Rapor oluşturma tamamlandı: " + filePath);
            System.out.println("Toplam " + products.size() + " ilaç kaydedildi.");

        } catch (Exception e) {
            System.err.println("Rapor oluşturma hatası: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }

    private static CellStyle createDateStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        style.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
        style.setAlignment(HorizontalAlignment.CENTER);
        return style;
    }

    private static CellStyle createDefaultStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setWrapText(true);
        return style;
    }

    private static void createReportHeaders(Sheet sheet, CellStyle headerStyle) {
        Row headerRow = sheet.createRow(3);
        String[] headers = {"Sıra No", "İlaç Adı", "Eklenme Tarihi", "Durum", "Notlar"};

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }
    }

    private static void addReportInfo(Sheet sheet, CellStyle style, int productCount, String categoryUrl) {
        // Rapor başlığı
        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("LOYAL FRIEND CARE - YATAK LİSTESİ  RAPORU");
        titleCell.setCellStyle(style);

        // Rapor tarihi
        Row dateRow = sheet.createRow(1);
        dateRow.createCell(0).setCellValue("Rapor Tarihi: " +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));

        // Toplam ilaç sayısı
        Row countRow = sheet.createRow(1);
        countRow.createCell(2).setCellValue("Toplam İlaç: " + productCount);

        // URL bilgisi
        Row urlRow = sheet.createRow(2);
        urlRow.createCell(0).setCellValue("Kaynak: " + categoryUrl);
    }

    private static void writeMedicineData(Sheet sheet, List<WebElement> products,
                                          CellStyle dateStyle, CellStyle defaultStyle) {
        Pattern datePattern = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");
        int startRow = 4;

        for (int i = 0; i < products.size(); i++) {
            String productText = products.get(i).getText();
            String ilacAdi = productText;
            String eklenmeTarihi = "";
            String durum = "Aktif";

            // Tarihi ayır
            Matcher matcher = datePattern.matcher(productText);
            if (matcher.find()) {
                eklenmeTarihi = matcher.group();
                ilacAdi = productText.replace(eklenmeTarihi, "").replace("\n", "").trim();
            }

            // Satır oluştur
            Row row = sheet.createRow(startRow + i);

            // Sıra No
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(i + 1);
            cell0.setCellStyle(defaultStyle);

            // İlaç Adı
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(ilacAdi);
            cell1.setCellStyle(defaultStyle);

            // Eklenme Tarihi
            Cell cell2 = row.createCell(2);
            cell2.setCellValue(eklenmeTarihi);
            cell2.setCellStyle(dateStyle);

            // Durum
            Cell cell3 = row.createCell(3);
            cell3.setCellValue(durum);
            cell3.setCellStyle(defaultStyle);

            // Notlar (boş bırakılabilir)
            row.createCell(4).setCellValue("");
        }
    }

    private static void autoSizeColumns(Sheet sheet) {
        for (int i = 0; i < 5; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    private static void saveWorkbook(Workbook workbook, String filePath) throws IOException {
        // Klasörü kontrol et ve oluştur
        java.io.File directory = new java.io.File(filePath).getParentFile();
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            workbook.write(fileOutputStream);
            workbook.close();
        }
    }

    // Farklı isimlerle rapor oluşturmak için yardımcı method
    public static String generateCustomReport(WebDriver driver, String categoryUrl,
                                              String productLocator, String reportName) {
        String timestamp = LocalDateTime.now().format(DATE_FORMATTER);
        String fileName = reportName + "_" + timestamp + ".xlsx";
        String fullPath = REPORT_PATH + fileName;

        generateMedicineReport(driver, categoryUrl, productLocator, fullPath);
        return fullPath;
    }


    // < -- ===== excellReportSonu ===== -- >








}
