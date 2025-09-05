

Feature: US034 Medicine Sayfasinda ilac ekleme bilgi değiştirme

  Scenario: Admin ilac ekler uzerinde degisiklik yapar

    When adminotorumuacar
    And yonetimpanelinegider
    And goesToMedicinePages
    Then goesToAddMedicinesPages
    And createMedicinesAndChangeInfoThenDelete
    Then sayfadancikisyapar