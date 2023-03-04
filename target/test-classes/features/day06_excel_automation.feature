
@excel_automation

Feature: excel_login_feature
  Scenario: TC01_musteri_giris_testi
    Given kullanici "customer_info" bilgileri ile giris yapar
    And close the application

  Scenario: TC02_admin_giris_testi
    Given kullanici "admin_info" bilgileri ile giris yapar
    And close the application
