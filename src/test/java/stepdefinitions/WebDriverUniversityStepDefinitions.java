package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.WebDriverUniversityPage;
import utilities.ConfigReader;
import utilities.Driver;


import java.util.Set;

public class WebDriverUniversityStepDefinitions {
    WebDriverUniversityPage webDriverUniversityPage=new WebDriverUniversityPage();
    String window1;
    Faker faker= new Faker();

    @Given("kullanici {string} ana sayfasinda")
    public void kullanici_ana_sayfasinda(String string) {
        Driver.getDriver().get(ConfigReader.getProperty(string));

    }
    @Then("kullanici loginPortal'a kadar asagi iner")
    public void kullaniciLoginPortalAKadarAsagiIner() {
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @And("kullanici loginPortal'a tiklar")
    public void kullaniciLoginPortalATiklar(){
        window1= Driver.getDriver().getWindowHandle();
        Driver.wait(2);
        webDriverUniversityPage.loginPortal.click();
    }

    @Then("kullanici diger window a gecer")
    public void kullanici_diger_window_a_gecer() {
        Set<String> allWindowHandles= Driver.getDriver().getWindowHandles();
        String ikinciSyfaHandleDegeri="";

        for (String w:allWindowHandles){
            if (!w.equals(window1)){
                ikinciSyfaHandleDegeri=w;
            } }
        Driver.getDriver().switchTo().window(ikinciSyfaHandleDegeri);
    }
    @And("username kutusuna deger yazar")
    public void usernameKutusunaDegerYazar() {
        webDriverUniversityPage.usernameBox.sendKeys(faker.name().username());
    }

    @And("password kutusuna deger yazar")
    public void passwordKutusunaDegerYazar() {
        webDriverUniversityPage.passwordBox.sendKeys(faker.internet().password());
    }

    @Then("login butonuna click yapar")
    public void login_butonuna_click_yapar() {
        webDriverUniversityPage.loginButton.click();
        Driver.wait(1);
    }

    @Then("popUp'ta cikan yazinin validation failed oldugunu test eder")
    public void pop_up_ta_cikan_yazinin_validation_failed_oldugunu_test_eder() {
        String alertText = Driver.getDriver().switchTo().alert().getText();
        org.junit.Assert.assertEquals(alertText,"validation failed");
    }

    @Then("OK diyerek popUp'i kapatir")
    public void ok_diyerek_pop_up_i_kapatir()  {
        Driver.getDriver().switchTo().alert().accept();
        Driver.wait(2);
    }

    @Then("ilk sayfaya geri doner")
    public void ilk_sayfaya_geri_doner() {
        Driver.getDriver().switchTo().window(window1);
    }

    @Then("ilk sayfaya donuldugunu test eder")
    public void ilk_sayfaya_donuldugunu_test_eder() {
        assert webDriverUniversityPage.firstPageElement.isDisplayed();

    }

    @And("acilan tum sayfalari kapatir")
    public void acilanTumSayfalariKapatir() {
        Driver.closeDriver();
    }
}