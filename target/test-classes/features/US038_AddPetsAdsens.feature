
@E2E
  Feature: US039 add to Pet Adsense

    Scenario: madeANewPetsAdsens

      Scenario: admin yeni bir reklam uretebilmekliklik

        When adminotorumuacar
        And yonetimpanelinegider
        And goesToPetsAdsensPage
        Then addAnewPetsAdsens