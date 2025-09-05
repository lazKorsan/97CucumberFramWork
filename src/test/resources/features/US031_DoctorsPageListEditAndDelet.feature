


  Feature: US031 Doktorlar sayfasında listeleme  bilgi ekleme ve silme işlemleri

    Scenario: Admin doktorlar listesini alır düzenleme ve silme işlemleri yapar

      When adminotorumuacar
      And yonetimpanelinegider
      Then goesToDoctorsPage
      And takeAlistDoctors
      And goesToCreateDoctorsPage
      And createNewDoctor
      And editInfoDoctor
      Then deleteNewDoctor
      Then sayfadancikisyapar