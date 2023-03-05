

@failed_scenario

Feature: hooks_test
  Background: googlea_git
    Given kullanici google gider

  Scenario: TC01_google_iphone_arama
    When kullanici "iphone" icin arama yapar
    Then sonuclarda "iphone" oldugunu dogrular
    Then close the application

  Scenario: TC02_google_tesla_arama
    When kullanici "tesla" icin arama yapar
    Then sonuclarda "toros" oldugunu dogrular
    Then ekran goruntusu al
    Then close the application


#  1. resources dosyasinin altında cucumber properties dosyası olustur : cucumber.properties
#  2. Su kodu ekle: cucumber.publish.enabled=true
#  3. Testi calistir. Bu sekilde cucumber html raporu cloud yuklenecektir. Fakat GitHub ile girls yapilmassa 24 saat icinde silinecektir. Bu yüzden GitHub ile giriş yapalım.
#  4. Login with GitHub a tikla > Authorize SmartBear
#  5. Create Collection
#  6. Tokeni cucumber.properties e ekle
#  7. Testi tekrar calistir. Collections klasorunde raporlar olusucakdir.
