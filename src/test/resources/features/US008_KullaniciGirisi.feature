

  Feature: US008 Kullanici loyalfriendcare.com sitesine giris yapar

    # 3 FARKLİ şekilde sisteme giris yapilamadigini test edin

    Scenario:  TC_01 Gecersiz eMail ile sisteme giris yapilamaz

      Given KK login sayfasina gider
      Then Gecersiz "gecersizMail" girer
      And password olarak "gecerliPassword" girer
      Then signIn Butonuna basarak giris yapar
      And sisteme giris yapilamadigini test eder
      And sayfayi kapatir


    Scenario:  TC_02 Gecersiz eMail ile sisteme giris yapilamaz

      Given KK login sayfasina gider
      Then Gecersiz "gecerliMail" girer
      And password olarak "gecersisizPassword" girer
      Then signIn Butonuna basarak giris yapar
      And sisteme giris yapilamadigini test eder
      And sayfayi kapatir

    Scenario:  TC_03 Gecersiz eMail ve geccersiz password ile sisteme giriş yapılamaz

      Given KK login sayfasina gider
      Then Gecersiz "gecersizMail" girer
      And password olarak "gecersisizPassword" girer
      Then signIn Butonuna basarak giris yapar
      And sisteme giris yapilamadigini test eder
      And sayfayi kapatir






