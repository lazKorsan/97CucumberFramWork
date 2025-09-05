


Feature: US007 loyalfriendcare.com adresinde yeni kullanici olusturmak

  Scenario: Ziyaretci yeni uyelik olusturur
    Given ziyaretci register sayfasina gider
    Then userNameBoxa "username" girer
    And mailBoxa "email" girer
    And passwordBoxa "password" girer
    And comfirmPasswordBoxa "password" girer
    Then signinButona basarak kaydini tamalar