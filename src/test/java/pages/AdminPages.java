package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminPages {

    public AdminPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // < -- =========== ADMİN DASHBOARD PAGES ================= -- >

    @FindBy(xpath = "(//div[@class='card social-card share col2 m-t-30 m-b-30 m-r-30'])[7]")
    public WebElement bigConteiner ;

    @FindBy(xpath = "(//div[@class='card-header clearfix'])[7]")
    public WebElement topContainer ;

    @FindBy(xpath = "(//div[@class='card-description '])[7]")
    public WebElement bottomContainer ;

    @FindBy(xpath = "//div[@class='card-header clearfix']")
    public WebElement listeElementi ;





    @FindBy(xpath = "//div[@class='error-container text-center']")
    public WebElement errorMassage ;

    @FindBy(xpath = "/html/body/div/div/h1")
    public WebElement error404;

    @FindBy(xpath = "//input[@placeholder='ex: Pets Title']")
    public WebElement petsTitleBoxVaccinations ;

    @FindBy(xpath = "//input[@placeholder='ex:Content Pets']")
    public WebElement petsContentBoxVaccinations ;

    @FindBy(xpath = "//input[@id='price']")
    public WebElement petsPriceVaccinations ;

    @FindBy(xpath = "//div[@class='dz-default dz-message']")
    public WebElement uploadPngVaccinations ;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveVaccinationsButton ;

    // < -- petsAdsense sayfası LOCATER ları -- >

    @FindBy(xpath = "btn btn-tag btn-success btn-tag-rounded")
    public WebElement petAddsensButton ; // sayfanın ustundeki buton

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement petsAdsenselocationBox ;

    @FindBy(xpath = "//input[@placeholder='ex: This Title Pets']")
    public WebElement petsAdsensTitleBox;

    @FindBy(xpath = "//input[@placeholder='ex:  Your Display Name']")
    public WebElement petsAdsensDisplayNameBox ;

    @FindBy(xpath = "//*[@class='switchery switchery-default']")
    public WebElement petsAdsensRadioButton ;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement petsAdsensTypeBox ;

    @FindBy(xpath = "(//button[@class='btn btn-primary btn-sm  btn-rounded m-r-10'])[1]")
    public WebElement petAdsenseAddPageImageButton ;

    @FindBy(xpath = "//input[@placeholder='ex:  Your Url Image']")
    public WebElement petsAdsensUrlBox;

    @FindBy(xpath = "(//button[@class='btn btn-primary btn-sm  btn-rounded m-r-10'])[2]")
    public WebElement petsAdsensContesxtButton ;

    @FindBy(xpath = "//div[@class='note-editable']")
    public WebElement petsAdsensContextBox;

    @FindBy(xpath = "//a[@class='btn btn-tag btn-success btn-tag-rounded']")
    public WebElement petsAdsensAddAdsensPage;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement petsAdsensSaveButton ;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement petAdsenseTypeBox ;








    @FindBy(xpath = "//input[@type='text']") //17
    public WebElement searchBox ;

    @FindBy(xpath = "(//a[@class='btn_add'])[1]")
    public WebElement signInButton ;

    // < -- === header  sıgnUp buttonu ile sıgnOutButtonu Lacaterları aynı
    @FindBy(xpath = "//*[@id=\"top_menu\"]/li[2]/a")  // 8
    public WebElement signUpButton ;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement mailBox ;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox ;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-cons m-t-10']")
    public WebElement loginPageSignInButton ;

    @FindBy(xpath = "//input[@id='checkbox1']")
    public WebElement rememberMeButton ;


    @FindBy(xpath = "//*[@id=\"name\"]") // 9
    public WebElement userNameBox ;

    @FindBy(xpath = "//*[@id=\"password\"]") //11
    public WebElement passwordBoxRegister ;

    @FindBy(xpath = "//*[@id=\"password-confirm\"]") //12
    public WebElement confirmPasswordBox ;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/form/button") //13
    public WebElement registerButton ;


    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/en/password/reset']")
    public WebElement forgotPasswordButton ;

    // < -- === header  sıgnUp buttonu ile sıgnOutButtonu Lacaterları aynı
   // @FindBy(xpath = "(//a[@class='btn_add'])[2]")   // 8
   // public WebElement signOutButton ;


    // < -- === KOD İÇİNDE FAZLALIK OLMASIN DİYE === -- >
    // < -- === FARKLI ATTİRİBUTE LERLE XPATH TEKRAR ALINDI === -- >


    @FindBy(xpath = "(//a[@class='btn_add'])[1]")
    public WebElement accountButton ;

    // < -- === header  sıgnUp buttonu ile sıgnOutButtonu Lacaterları aynı
    @FindBy(xpath = "//*[@id=\"top_menu\"]/li[2]/a")   // 8
    public WebElement signOutButton ;

    // < - === ADMİN PAGE DASHBOARD LOCATER
    @FindBy(xpath = "//div[@class='sidebar-header']")
    public WebElement dashBoard ;

    // < -- dashboard Table locaters butun kutuyu kırmızıya almak için
    @FindBy(xpath = "//div[@class='scroll-wrapper menu-items']")
    public WebElement dashboardTables;

    // < -- === ROLES BUTTON

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Roles']")
    public WebElement dbRolesButton;

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Roles']")
    public WebElement subRolesButton;

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Roles/create']")
    public WebElement createRolesButtons;

    // < -- === USERS BUTTONS

    @FindBy(xpath = "//span[text()='Users']")
    public WebElement dbUsersButton; //1

    @FindBy(xpath = "//*[@href='https://qa.loyalfriendcare.com/Dashboard/Users']")
    public WebElement subUsersButton; //2
    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Users/create']")
    public WebElement createUsersButton; //3

    // < -- === DEPARTMENTS BUTTONS
    // < -- === KULLANIMDA HEADER BUTTONS İLE ÇAKIŞIP ÇAKIŞMADIĞI KONTROL EDİLECEK

    @FindBy(xpath = "//span[@class='title']")  // ***
    public WebElement departmentsButton; //4  // BUTTON İSMİ HEADER DA KULLANILIYOR

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Categories']")
    public WebElement subDepartmentsButtons; //5

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Categories/create']")
    public WebElement createDepartmentsButton; //6

    // < -- === DOCTORS BUTTONS
    @FindBy(xpath = "//span[text()='Doctors']") // ***
    public WebElement doctorsButton; //7 // BUTTON İSMİ HEADER DA KULLANILIYOR

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Clients']")
    public WebElement subDoctorsButton; //8

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Clients/create']")
    public WebElement createDoctorsButton; //9

    // < -- === PATH ADSENS BUTTONS

    @FindBy(xpath = "//span[text()='Pets adsense']")
    public WebElement petsAdsenseButton; //10

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/AdSense']")
    public WebElement subPetAdsenseButton; //11

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/AdSense/create']")
    public WebElement createPetAdSenseButton; //12

    // < -- === MEDİCİNES BUTTONS

    @FindBy(xpath = "//span[text()='Medicines']") //***
    public WebElement medicinesButton; //13 // BUTTON İSMİ HEADER DA KULLANILIYOR

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Instagrams']")
    public WebElement subMedicinesButton; //14

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Instagrams/create']")
    public WebElement createMedicinesButtons; //15



    // < -- === TİCKET BUTTONS

    @FindBy(xpath = "//span[text()='Tickets']")
    public WebElement ticketsButton; //16

    // < -- === VACCİNATİONS BUTTONS

    @FindBy(xpath = "//span[text()='Vaccinations']") // ***
    public WebElement vaccinationsButton; //17 // BUTTON İSMİ HEADER DA KULLANILIYOR

    @FindBy(xpath = "//*[@class='btn btn-tag btn-success btn-tag-rounded']")
    public WebElement addVaccinationsButton ;

    @FindBy(xpath = "(//input[@id='Title_en'])")
    public WebElement petsTitleBox ;

    @FindBy(xpath = "//input[@id='body_en']")
    public WebElement petsContentBox ;

    @FindBy(xpath = "//input[@id='price']")
    public WebElement petPriceBox ;

    @FindBy(xpath = "//*[@class='btn btn-success btn-cons btn-animated from-left fa fa-save pull-right']")
    public WebElement saveButton ; //btn btn-success btn-cons btn-animated from-left fa fa-save pull-right

    @FindBy(xpath = "(//button[@class='btn btn-danger btn-cons btn-animated from-top fa  fa-remove'])[1]")
    public WebElement deleteVaccinationsButton ;




    // < -- ==============^^^================================ -- >
    // < -- === KOD BLOĞUNDA ÇOK FAZLA PAGES EKLEMEMEK İÇİM === -- >
    // < -- === BURADAKİ LOCATERS LFCPages İLE AYNI === --->
    // < -- === ADMİN SAYFASINA GİRİŞ VE ÇIKIŞ LOCATERS === -- >

    // < -- === ADMİN PAGES HEADER PROFİL BUTTONLARI

    // < -- ===adminPage  Header profileButton
    @FindBy(xpath = "//div[@class='dropdown pull-right d-lg-block d-none']")
    public WebElement profileButton ;

    // < -- === adminPage Header profil dropDownMenü
    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement settingsButton;

    // < -- === adminPage Header profil dropDownMenü
    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement editProfileButton ;

    // < -- === adminPage Header profil dropDownMenü
    @FindBy(xpath = "//*[@class='pull-left']")
    public WebElement logOutButton;

    // < - === ADMİN_PAGE --> HEADER_PROFİLE --> EDİT_PROFİLE --> NEXT_PAGE
    @FindBy(xpath = "//div[@class='error-container text-center']")
    public WebElement errorContainerWebelement  ;

    // < -- === ADMİN_PAGE -->ADSENSE --> LOCATE === -->

    @FindBy(xpath = "//span[@title='Home']")
    public WebElement addForumLocationButtons ; //

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement addForumFieldBox; //input[@class='select2-search__field']

    @FindBy(xpath = "//input[@placeholder='ex: This Title Pets']")
    public WebElement addForumPetTitle ; //

    @FindBy(xpath = "//input[@placeholder='ex:  Your Display Name']")
    public WebElement addForumDisplayName ;

    @FindBy(xpath = "//*[@class='switchery switchery-default']")
    public WebElement addForumRadioButton ;

    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[2]")
    public WebElement addForumTypeButton ;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement addForumTypeBox ;

    @FindBy(xpath = "//div[@id='headingTwo']")
    public WebElement addForumImageButton ;

    @FindBy(xpath = "(//button[@class='btn btn-primary btn-sm  btn-rounded m-r-10'])[2]")
    public WebElement addForumAdSenseButton ;



    @FindBy(xpath = "//input[@placeholder='ex:  Your Url Image']")
    public WebElement addForumImageUrlBox ;

    @FindBy(xpath = "//button[@class='btn btn-success btn-cons btn-animated from-left fa fa-save pull-right mb-30']")
    public WebElement addForumSaveButton ;

    @FindBy(xpath = "//div[@class='note-editable']")
    public WebElement addForumTextBox ;

    // < -- === adense PAGES dedelete Pages === -- >

    @FindBy(xpath = "(//button[@class='btn btn-danger btn-cons btn-animated from-top fa fa-remove'])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//*[@class='btn btn-complete btn-cons btn-animated from-left fa fa-edit']")
    public  WebElement editButton ;

    // < -- Admin Pages BedManagers locaters

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Posts']")
    public WebElement subBedManagersButton ;

    @FindBy(xpath = "//span[text()='Bed managers']")
    public WebElement bedManagersButton ;

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/en/Dashboard/Posts/create']")
    public WebElement addBedManagersButton ;

    @FindBy(xpath = "//input[@placeholder='ex:  The title for your Bed managers']")
    public WebElement bedManagersTitleBox ;

    @FindBy(xpath = "//div[@class='note-editable']")
    public WebElement bedManagersContentBox ;

    @FindBy(xpath = "//button[@class='btn btn-success btn-cons btn-animated from-left fa fa-save pull-right']")
    public WebElement bedManagersSaveButton ;

    // < -- ADMİNPAGE==>BEDMANAGERS==>SUBmanagers==>
    // -- ===== sayfanın sağındaki menu için locateler

    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[1]")
    public WebElement selectDepartmentsButton ;

    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    public WebElement inputDepartmentsBox ;


    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div/div[2]/div[1]/div[2]/div[2]/span/span[1]/span")
    public WebElement selectDoctorsButton ;

    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    public WebElement inputDoctorsBox;

    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[3]")
    public WebElement selectMedicinesButton ;

    @FindBy(xpath = "(//input[@class='select2-search__field'])[1]")
    public WebElement inputMedicinesBox;

    @FindBy(xpath = "//input[@placeholder='Bed managers Price']")
    public WebElement inputPriceBox ;

    @FindBy(xpath = "(//div[@class='dz-default dz-message'])[1]")
    public WebElement dragAndDropZone ;

    @FindBy(xpath = "//*[@class='switchery switchery-default']")
    public WebElement radioButton ;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement bedManagersSavButton;

    @FindBy(xpath = "//div[@class='dataTables_info']")
    public WebElement bEdCapacity ;

    @FindBy (xpath = "//a[@class='btn btn-complete btn-cons btn-animated from-left fa fa-edit']")
    public WebElement bedManagersEditButton ;

    @FindBy(xpath = "(//button[@class='btn btn-danger btn-cons btn-animated from-top fa  fa-remove'])[1]")
    public WebElement bedManagersDeleteButton ;


    // < -- ===== admin sayfası içindeki arama kutusunun locati
    @FindBy(xpath = "//input[@id='search-table']")
    public WebElement bedManagersSearchBox;

    // < -- admin page arama sonucu çıkan tek satrılık webtablonun locati
    @FindBy(xpath = "//tr[@class='odd']")
    public WebElement StockInfoRow;


    // < -- bedMangers urun Listesi sayfası urunresmi kutusunun locati
    @FindBy(xpath = "//tr[@role='row' and contains(@class, 'odd')]/td[1]")
    public WebElement urunImage ;

    // < -- bedmanegers urun listesi sayfası uruntitle kutusu resmi
    @FindBy(xpath = "//tr[@role='row' and contains(@class, 'odd')]/td[2]")
    public WebElement urunTitle ;

    // <-- bedmanagers ururnlistesi sayfası deparmentstitle kutusu
    @FindBy(xpath = "//tr[@role='row' and contains(@class, 'odd')]/td[3]")
    public WebElement departmentsTitle ;


    // < -- === HEADER LOCATERS === -- >

    @FindBy(xpath = "//*[@class='logo_normal']")  //1
    public WebElement logoButton ;

    @FindBy(xpath = "(//a[@href='https://qa.loyalfriendcare.com'])[5]")  //2
    public WebElement homeButton ;


    @FindBy(xpath = "(//a[@href='https://qa.loyalfriendcare.com/about'])[2]")  // 3
    public WebElement aboutUsButton ;





    // giriş yapıldıktan sonra kullanılacak locaters




    // < -- ===adminPage  Header profileButton


    // < -- === adminPage Header profil dropDownMenü


    // <-- register sayfası loceters



    // < -- loginPage Locaters
    // SıgnInButtons
    @FindBy(xpath = "/html/body/div/div[2]/div/form/button") //14
    public WebElement loginPageSigInButton ;

    // mailBoxButton    register sayfası ile aynı

    // passwordBoxButton  register sayfası ile aynı


    // < -- =====forgot/reset  page Locaters========== -- >

    @FindBy(xpath = "(//*[@class='nav-link'])[1]")
    public WebElement passwordResetPageLoginButton ;

    @FindBy (xpath = "(//*[@class='nav-link'])[2]")
    public WebElement passwordResetPageRegisterButton ;

    // mailBox locater  sigIn sayfasındaki mailBox ile aynı

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement sendPassWordLinkButton ;



    // <-- ==========Arama Kutusu ==============  -->
    // < -- ==== LOCATER VALUE "//input[@type='text']"
    // < -- === OLURSA ADMİN SAYFASINDA İŞLİYOR
    // ADMİNDE İŞLEMEZ  : //*[@name='search']
    //< -- ====^^^^^^==== -- >

    @FindBy(xpath = "//*[@class='container'][1]") //18
    public WebElement titleContainer ;

    @FindBy(xpath = "//img[@class='img-fluid']") //19
    public WebElement searchResult ;

    @FindBy(xpath = "//input[@value='Search']") //19
    public WebElement searchButton ;

    @FindBy(xpath = "//div[@class='detail_title_1']/preceding-sibling::h1")  //20
    public WebElement searchResultElementi ;

    //<-- ========== Body locaters ============ -->
    // < -- === BÜTÜN BODY KISMINDA EKLENEN BUTTONLAR İÇİN === -->
    // < -- === LOCATE KAYMASINI ENGELLEYİCİ XPATH LER === -- >

    @FindBy(xpath = "//*[normalize-space(text())='Wellness']") //21
    public WebElement wellnessButton;

    @FindBy(xpath = "//*[normalize-space(text())='Dental Care']") //22
    public WebElement dentalCareButton ;

    @FindBy(xpath = "//*[normalize-space(text())='Anaesthesia']") //23
    public WebElement anaesthesiaButton ;

    @FindBy(xpath = "//*[normalize-space(text())='Dermatology']") // 24
    public WebElement dermatologyButton ;

    @FindBy(xpath = "//*[normalize-space(text())='Diagnostics']") //25
    public WebElement diagnosticsButton ;

    @FindBy(xpath = "(//*[text()='Vaccinations'])[3]") //26
    public WebElement bodyvaccinationsButton;

    @FindBy(xpath = "//*[normalize-space(text())='Pain Control']") //27
    public WebElement painControlButton;

    @FindBy(xpath = "//*[normalize-space(text())='Boarding']") //28
    public WebElement boardingButton ;

    @FindBy(xpath = "//*[normalize-space(text())='ilave']") //29
    public WebElement ilaveButton;

    @FindBy(xpath = "//*[normalize-space(text())='yeni']") //30
    public WebElement yeniButton ;

    // <-- ==============Body mini buttons ================ -->
    @FindBy(xpath = "(//a[@href='https://qa.loyalfriendcare.com/Departments'])[2]") //31
    public WebElement miniDepartmentsButton ; // LİNKSİZ XPATH ALINABİLİR

    @FindBy(xpath = "(//a[@href='https://qa.loyalfriendcare.com/Doctors'])[2]") //32
    public WebElement miniDoctorsButton ; // LİNKSİZ XPATH ALINABİLİR

    @FindBy(xpath = "(//a[@href='https://qa.loyalfriendcare.com/Pets'])[2]") //33
    public WebElement miniMainVaccinationsButton ; // LİNKSİZ XPATH ALINABİLİR

    // <-- =============Footer DepartmentsButtons ============= -->

    // <-- =============Body popularDoctors Buttons =========== -->

    @FindBy(xpath = "//*[@alt='Dr. Alejandro Martinez']") //34
    public WebElement DrAlejandroMartinezButton;

    @FindBy(xpath = "//*[@alt='Dr. Marcus Rodriguez']") //35
    public WebElement DrMarcusRodriguezButton;

    @FindBy(xpath = "//*[@alt='Dr. Olivia Bennett']") //36
    public WebElement DrOliviaBennettButton;

    @FindBy(xpath = "//*[@alt='Dr. Emily Chang']") //37
    public WebElement DrEmilyChangButton;

    @FindBy(xpath = "//*[@alt='Dr. Nathan Patel']") //38
    public WebElement DrNathanPatelButton;

    @FindBy(xpath = "//*[@alt='Dr. Isabella Wong']") //39
    public WebElement DrIsabellaWongButton;

    @FindBy(xpath = "//*[contains(@alt,'Liam')]") //40
    public WebElement DrLiamOConnerButton;


    @FindBy(xpath = "//*[@alt='Dr. Sophia Kim']") //41
    public WebElement DrSophiaKimButton;

    @FindBy(xpath = "//img[@alt='Mr ALi']") //42
    public WebElement MrAliButton;

    // <-- =========== Body VacionationsofPetsButtons locates======== -->

    @FindBy(xpath = "//*[@alt='Rabies Vaccine']") //43
    public WebElement rabiesVaccineButton ;

    @FindBy(xpath = "//div[*='DHPP Vaccine (Distemper, Hepatitis, Parainfluenza, Parvovirus Vaccine):']") //44
    public WebElement DHPPVaccineButton ;

    @FindBy(xpath = "//div[*='Feline Leukemia Vaccine']") //45
    public WebElement felineLeukemiaVaccineButton ;


    @FindBy(xpath = "//div[*='Feline Immunodeficiency Virus (FIV) Vaccine']") //46
    public WebElement felineImmunoeficenyVirusButton ;

    @FindBy(xpath = "//div[*='Bordetella (Kennel Cough) Vaccine']") //47
    public WebElement bordetellaVaccineButton ;

    @FindBy(xpath = "//div[*='Feline Panleukopenia Vaccine']") //48
    public WebElement felinePanleukopeniaVaccineButton ;

    @FindBy(xpath = "//div[*='Feline Herpesvirus Vaccine']") //49
    public WebElement felineHerpesvirusVaccineButton ;

    @FindBy(xpath = "//div[*='Surgical Procedure: Spaying (Ovariohysterectomy)']") //50
    public WebElement surgicalProcedureButton ;

    // < --==============footer locates============-->
    @FindBy(xpath = "//*[@title='LoyalFriendCare - Pet Care & Veterinary ']") //51
    public WebElement footerLogoButtons ;

    @FindBy(xpath = "//a[contains(text(),'Wellness')]") //52
    public WebElement footerWellnesButton ;

    @FindBy(xpath = "//a[contains(text(),' Dental Care')]") //53
    public WebElement footerDentalCareButton  ;

    @FindBy(xpath = "//a[contains(text(),'Anaesthesia')]") //54
    public WebElement footerAnaesthesiaButton ;

    @FindBy(xpath = "//a[contains(text(),'Dermatology')]") //55
    public WebElement footerDermatologyButton ;

    @FindBy(xpath = "//a[contains(text(),'Diagnostics')]") //56
    public WebElement footerDiagnosticsButton ;

    @FindBy(xpath = "//*[@class='fab fa-facebook-square']") //57
    public WebElement footerFacebookButton ;

    @FindBy(xpath = "//*[@class='fab fa-twitter-square']") //58
    public WebElement footerXButton ;

    @FindBy(xpath = "//*[@class='fab fa-youtube-square']") //59
    public WebElement footerYoutubeButton ;

    @FindBy(xpath = "//*[@class='fab fa-pinterest-square']") //60
    public WebElement footerPinterestButton ;

    @FindBy(xpath = "//*[@class='fab fa-instagram']") //61
    public WebElement footerInstagramButton ;

    // <-- ================aboutUs pages Locaters============== -->

    @FindBy(xpath = "//*[@class='fas fa-money-check-alt']") //62
    public WebElement budgetVetCareButton ;

    @FindBy(xpath = "//*[@class='fas fa-dog']") //63
    public WebElement petShelterButton ;

    @FindBy(xpath = "//*[@class='fas fa-certificate']") //64
    public WebElement certifiedVetButton ;

    @FindBy(xpath = "//*[@class='fas fa-paw']") //65
    public WebElement nutritionShop ;

    // <-- ========== contactPage Locaters =============== -->

    @FindBy(xpath = "//*[@id='Date']") //66
    public WebElement dateButton ;

    @FindBy(xpath = "//*[@placeholder='Phone Number']") //67
    public WebElement phoneBox ;

    @FindBy(xpath = "//*[@name='category_id']") //68
    public WebElement departmentButton ;



    @FindBy(xpath = "//*[@placeholder='Create Message']") //70
    public WebElement messageBox ;

    @FindBy(xpath = "//*[@value='Submit']") //71
    public WebElement submitButton ;  // bir tane daha var mı kontrol edilecek

    // < -- === HEADER DEPARTMENTS DROPDOWNMENU LOCATE === - >

    @FindBy(xpath = "//*[text()='Wellness']")
    public WebElement ddWelnesButton ;

    @FindBy(xpath = "//*[text()='Dental Care']")
    public WebElement ddDentalCareButton ;

    @FindBy(xpath = "//*[text()='Anaesthesia']")
    public WebElement ddAnaesthesia ;

    @FindBy(xpath = "//*[text()='Dermatology']")
    public WebElement ddDermatology ;

    @FindBy(xpath = "//*[text()='Diagnostics']")
    public WebElement ddDiagnostics ;

    // < -- === Medicines Sayfası Locater === - >

    @FindBy(xpath = "(//div[@class='wrapper'])[1]")
    public WebElement rimadylButton            ;

    @FindBy(xpath = "(//div[@class='wrapper'])[2]")
    public WebElement revolutionButton            ;

    @FindBy(xpath = "(//div[@class='wrapper'])[3]")
    public WebElement baytrilButton            ;

    @FindBy(xpath = "(//div[@class='wrapper'])[4]")
    public WebElement apoquelButton            ;

    @FindBy(xpath = "(//div[@class='wrapper'])[5]")
    public WebElement metacamButton            ;

    @FindBy(xpath = "(//div[@class='wrapper'])[6]")
    public WebElement alpinaButton            ;

    @FindBy(xpath = "(//div[@class='container'])[1]")
    public WebElement statusBar ;

    @FindBy(xpath = "//textarea[@name='problem']")
    public WebElement messageTextarea;

    @FindBy(xpath = "//*[@id='submit-contact-detail']")
    public WebElement appoinmentBookingButton ;

    @FindBy(xpath = "//*[@class='alert alert-success']")
    public WebElement alertSuccesText ;






























    /*

    @FindBy(xpath = "")
    public WebElement             ;

     */






}
