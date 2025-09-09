Feature: Kullanici loyalfriendcare sayfasinda excelleden urun arama testi yapar

  Scenario Outline: Excell den urun aratma testi
    Given Kullanici loyalfriendcare ana Sayfasini acar
    And urunler excellindeki "<satirNumarasi>" numarali satirdaki urun ismini ve min. miktarini kaydeder
    And aranan urunleri loyalfriendcare sayfasinda aratir ve urun sayisini kaydeder
    Then bulunan urun sayisinin kayitli min. miktardan fazla yada esit oldugunu test eder

    Examples:
      | satirNumarasi |
      | 1             |
      | 2             |
