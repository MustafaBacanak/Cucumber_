@homework2
Feature: US013_WebDriverUniversity negatif login test

  Background: siteye git
    Given kullanici "wdu_url" ana sayfasinda

  Scenario: TC18 Negatif login testi yapip ilk sayfaya donebilmeli

    Then kullanici loginPortal'a kadar asagi iner
    And kullanici loginPortal'a tiklar
    And kullanici diger window a gecer
    And username kutusuna deger yazar
    And password kutusuna deger yazar
    Then login butonuna click yapar
    And popUp'ta cikan yazinin validation failed oldugunu test eder
    Then OK diyerek popUp'i kapatir
    And ilk sayfaya geri doner
    Then ilk sayfaya donuldugunu test eder
    And acilan tum sayfalari kapatir