

# BU TEST testNG deki dataProvider olayına karşılık geliyor.
  # Stepdefinitions iyi oluşturulursa  miss.
  #bu test için stepdefinitions oluşturmak çok önemli
  @E2E
Feature: US007 loyalfriendcare.com adresinde yeni kullanici olusturmak

  Scenario: TC_01 Ziyaretci yeni uyelik olusturur
    Given ziyaretci register sayfasina gider
    Then userNameBoxa "username" girer
    And mailBoxa "email" girer
    And passwordBoxa "password" girer
    And comfirmPasswordBoxa "password" girer
    Then signinButona basarak kaydini tamalar


  Scenario: TC_02 Ziyaretci yeni uyelik olusturur
    Given ziyaretci register sayfasina gider
    Then userNameBoxa "username" girer
    And mailBoxa "email" girer
    And passwordBoxa "password" girer
    And comfirmPasswordBoxa "password" girer
    Then signinButona basarak kaydini tamalar

  Scenario: TC_03 Ziyaretci yeni uyelik olusturur
    Given ziyaretci register sayfasina gider
    Then userNameBoxa "username" girer
    And mailBoxa "email" girer
    And passwordBoxa "password" girer
    And comfirmPasswordBoxa "password" girer
    Then signinButona basarak kaydini tamalar

  Scenario: TC_04 Ziyaretci yeni uyelik olusturur
    Given ziyaretci register sayfasina gider
    Then userNameBoxa "username" girer
    And mailBoxa "email" girer
    And passwordBoxa "password" girer
    And comfirmPasswordBoxa "password" girer
    Then signinButona basarak kaydini tamalar