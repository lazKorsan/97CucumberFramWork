

  Feature: US070 Kullanici yanlis bilgilerle giris yapamaz

   Scenario Outline: TC01 Kullanici liste olarak verilen gecersizi email ve
                     gecersiz passwordlerler sisteme giris yapilamadigini test eder

      Given Kullanici loyalfriendcare anaSayfasina gider
      Then signIn buttona basar
      And mail kutusuna mail girer
     When email olarak "<verilenMail>" girer
     And password olarak "<verilenPassword>" girerr
     And signIn Butonuna basarak giris yaparr
     Then giris yapilamadigini test ederr

     
     # BİLGİ GİRİŞİNİN ÇEŞİTLİ KOMBİNASYONLARİ VAR
     # CONFİGREADERDAN ALINABİLECEĞİ GİBİ TEST İÇİNDE DİREK GÖNDERİLEBİLİR
     # YADA TEST DATASİ KULLANILABİLİR
     # EN ESNEK OLAN VE SÜRÜDÜRÜLEBİLEN TestData sı ile yapmak daha sürdürülebilir

Examples:
  | verilenMail | verilenPassword |
  |hataliMail   |hataliPassword   |