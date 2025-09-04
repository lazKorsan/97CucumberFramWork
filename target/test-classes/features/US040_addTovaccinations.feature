

  Feature: US040 vaccinations Ekleme
    Scenario: admin page uzerinde asi ekleyebilmeklik

      When adminotorumuacar
      And yonetimpanelinegider
      And goesToVaccinationsPage
      And addNewVaccinations
      Then sayfadancikisyapar