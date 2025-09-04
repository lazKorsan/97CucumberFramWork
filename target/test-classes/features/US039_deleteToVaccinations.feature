

Feature: US039 delete To Vaccinations And list

  Scenario: admin page üzerinde asi silebilmekliklik

    When adminotorumuacar
    And yonetimpanelinegider
    And goesToVaccinationsPage
    Then TakeAlistVaccinationsAndDeleteVaccinations
    Then sayfadancikisyapar
