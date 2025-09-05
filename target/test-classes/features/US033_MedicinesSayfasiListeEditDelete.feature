
Feature: US033 Medicine sayfasında listeleme bilgi ekleme ve ilac silme islemleri

  Scenario: Admin ilac listesini alır  bir ilaca ekleme yapar ve ardından ilaci siler

    When adminotorumuacar
    And yonetimpanelinegider
    And goesToMedicinePages
    And takeAlistMedicines
    Then changeMedicinesInfo
    Then sayfadancikisyapar
    # silme işlemi yukarıda yapıldı  : changeMedicinesInfo


