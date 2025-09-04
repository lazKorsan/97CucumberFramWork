package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AdminPages;
import utilities.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DF041_RandevuIncelemeStepdefinitions {
    private static final String REPORT_PATH = "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\reports\\";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    private static final String REPORTS_DIRECTORY = "reports/";
    AdminPages adminPages = new AdminPages();
    Actions actions = new Actions(Driver.getDriver()); //PERFORMA CLASSINDAN ALINDI

    @When("adminotorumuacar")
    public void adminotorumuacar() {
        // Kullanici ana sayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        ReusableMethods.bekle(3);

        // Kullanici Login sayfasina gider
        adminPages.signInButton.click();

        // Kullanici mail adresini girer
        adminPages.mailBox.sendKeys(ConfigReader.getProperty("adm"));

        // Kullanici sifresini girer
        adminPages.passwordBox.sendKeys(ConfigReader.getProperty("adp"));

        // Kullanici sigIn buttonuna basar
        adminPages.loginPageSigInButton.click();


    }

    // ARADAKİ YONETİM SAYFASINA GİDER US043 DEN KENDİSİ OTOMATİK GELDİ

    @Then("dashboardMenudenTicketSecer")
    public void dashboard_menuden_ticket_secer() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(adminPages.dashboardTables).perform();
        adminPages.ticketsButton.click();

        ReusableMethods.scrollToBottom();

     //   PageElementHighlighter.highlightElementsAndTakeScreenshot("");

        PageElementHighlighter.highlightElementsAndTakeScreenshot(
                Driver.getDriver(),
                new Object[][]{
                        {adminPages.topContainer, ""},
                      {adminPages.bottomContainer, ""}
                },
                new Object[][]{
                        {adminPages.bigConteiner, "Seçili Randevu"}
                },
                "about_page_screenshot"
        );

        ReusableMethods.bekle(3);

        MultiFunctionalScreenShoots.capturePageWithAnnotations(
                Driver.getDriver(),
                ConfigReader.getProperty("lfc"),
                new Object[][]{
                        {adminPages.topContainer, "Arama Sonucu"},
                        {adminPages.bottomContainer, "Urun Arama Sonucu"},
                       // {adminPages.departmentsTitle, "Ait olduğu Department"},
                      //  {adminPages.bedManagersSearchBox, "Aranan urun"}
                },
                new Object[][]{ // istenirse new obje ile altı yeşil çizili element eklenebilir
                        // formülü red kısmında olduğu gibi
                        // hatta else bloğunun içinde kullanılabilir
                         { adminPages.bigConteiner,"arama elementi"                                          },
                        // {},
                        // {},
                }

        );

        //< -- =========================================== -->
        // sayfanının Url ini doğru olarak koymayı unutma

        writeProductsToExcel(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/Dashboard/Messages",
                "//div[@class='card-header clearfix']",
                1
        );


        // Admin WebTablodaki yatakları Raporlar
        // Raporda Kullananılacak dosya adı
        String timestamp = LocalDateTime.now().format(DATE_FORMATTER);
        String fileName = "bedMangersReport" + timestamp + ".xlsx";
        String fullPath = REPORT_PATH + fileName;



        generateMedicineReport(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/Dashboard/Messages",
                "//div[@class='card-header clearfix']",
                fullPath
        );

        ExcelProductWriter.writeProductsToExcel(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/Dashboard/Messages",
                "//div[@class='card-header clearfix']",
                1
        );







    }

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
