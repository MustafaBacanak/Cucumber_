package stepdefinitions;

import io.cucumber.java.en.When;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class LoginStepDefinitions {

    LoginPage loginPage =new LoginPage();
    @When("kullanici emaili ve sifresini girer")
    public void kullanici_emaili_ve_sifresini_girer(io.cucumber.datatable.DataTable dataTable) {
        // 1. List<String> olarak datalari depolayabiliriz

//        List<String> musteriBilgisi=dataTable.row(1);
//        System.out.println(musteriBilgisi.get(0));
//        System.out.println(musteriBilgisi.get(1));
//        loginPage.blueRentalUsername.sendKeys(musteriBilgisi.get(0));
//        loginPage.blueRentalPassword.sendKeys(musteriBilgisi.get(1));
//        loginPage.blueRentalLogin.click();

        //2.   Datatable da datalari List<Map<String,String>> de depolayabiliriz
        List<Map<String,String>> musteriBilgisi = dataTable.asMaps(String.class,String.class);
        System.out.println(musteriBilgisi);
        for (Map<String ,String> musteri : musteriBilgisi){
            loginPage.blueRentalUsername.sendKeys(musteri.get("email"));
            loginPage.blueRentalPassword.sendKeys(musteri.get("sifre"));
            loginPage.blueRentalLogin.click();
        }

    }
}