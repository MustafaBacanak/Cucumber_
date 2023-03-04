@parametre
  Feature: arama_feature

    Background: google'a_git
      Given kullanici google gider

    @smoke
      Scenario: TC01_google_iphone_arama
        When kullanici "iphone" için arama yapar
        Then sonuclarda "iphone" oldugunu dogrular
        Then close the application

    @smoke
    Scenario: TC02_google_tesla_arama
      When kullanici "tesla" için arama yapar
      Then sonuclarda "tesla" oldugunu dogrular
      Then close the application