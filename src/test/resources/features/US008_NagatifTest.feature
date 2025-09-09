
@Negatif
Feature: Kullanici coklu negatif girisi test eder

  # BU BENİM ÇOKLU NEGATİF TESTTE İŞLEYEN 3NCÜ SENARYOM.
  # ÇOKLU NEGATİF TESTTE SONUNA ASSERTİONS KOYMAK ÖNEMLİ
  # TESTİ GEÇİRECEK Assortions lazım
  # Pozitif testle birlikte olaursa buradaki assortions positifi geçirmez

 Scenario Outline: TC_01 loyalfriendcare.com uzerinde coklu negatif test

    Given Kullanici loyalfriendcare ana Sayfasini acar
    And login sayfasina gider
    Then mailNBox kutusuna "<gecersizMail>" girer
    And  passwordBox kutusuna "<gecersizPassword>" girer
    And signIn Buttona tiklar
    Then Kullanici girisi yapilamadigini dogrular

    Examples:
      | gecersizMail  | gecersizPassword  |
      | gecersizMail1 | gecersizPassword1 |
      | gecersizMail2 | gecersizPassword2 |

   #EXAMPİLES tablosundaki değerler  String gecersizMail olarak giriliyor
  # ondan sonra coklu test yapmak ne ala.
  # sistemaysizng Enternasyonel gerisini otomatik olarak getiriyor
  #  // %%%TRY-CATCH negatif-pozitif testte kullanimi