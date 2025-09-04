

  Feature: US037  add sense page list edit delete

    Scenario: Admin reklam listesini alır reklama ekleme yapar ardından siler

      When adminotorumuacar
      And yonetimpanelinegider
      And goesToPetsAdsensPage
      Then addAnewPetsAdsens