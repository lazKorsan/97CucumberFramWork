Feature: US045 Ziyaretci olarak uyelik islemleri

  Scenario Outline: Yeni kullanıcı kaydı - <Test_Durumu>
    Given Register sayfasina gidilir
    When Gecerli kullanıcı adı girilir
    And Gecerli e-posta adresi girilir
    And Gecerli şifre girilir ve dogrulama yapilir
    Then Kayit tamamlanir
    And Hesaptan cikis yapilir

    Examples:
      | Test_Durumu      |
      | Standart Kayıt   |
      | Uzun Karakterler |
      | Özel Semboller   |
