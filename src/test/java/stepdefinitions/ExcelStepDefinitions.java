package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class ExcelStepDefinitions {
//Page Objelerini Olustur

    HomePage homePage;
    LoginPage loginPage;
    ExcelUtils excelUtils;
    List<Map<String,String>> excelData;

    @Given("kullanici {string} bilgileri ile giris yapar")

    public void kullanici_bilgileri_ile_giris_yapar(String sayfaAdi) throws IOException {

        String path="./src/test/resources/testdata/mysmoketestdata.xlsx";
        String sayfa = "customer_info";
        excelUtils= new ExcelUtils(path,sayfaAdi);
        excelData=excelUtils.getDataList();

//        NOTE Loop kodunu tamamla

        for(Map<String,String> data : excelData){
            Driver.getDriver().get(ConfigReader.getProperty("app_url"));
            homePage=new HomePage();
            loginPage=new LoginPage();
            homePage.bluerentalLogin.click();
            ReusableMethods.waitFor(2);
            loginPage.blueRentalUsername.sendKeys(data.get("username"));
            loginPage.blueRentalPassword.sendKeys(data.get("password"));
            loginPage.blueRentalLogin.click();
            ReusableMethods.waitFor(1);
            Assert.assertTrue(homePage.userID.isDisplayed());
            ReusableMethods.getScreenshot("Ss");

            homePage.userID.click();
            ReusableMethods.waitFor(1);
//            Driver.closeDriver();  // >> bu da bi seçenek :D
            homePage.logOutLink.click();
            homePage.OK.click();
        }

    }
}