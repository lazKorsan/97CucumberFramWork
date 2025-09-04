

Feature: US043 Admin Sayfasinda Bilgi duzenleme

  Scenario: Admin Sayfasinda Bilgi Duzenleme

    When AdminOturumAcar
    And yonetimpanelinegider
    Then profileButtondanBilgiDuzenlemeSayfasinaGider
    Then hataMesajininEkranAlintisiniAlir
    And otorumuKapatir

