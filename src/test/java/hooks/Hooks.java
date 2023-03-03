package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

 /*
    Hooks: Her bir Scenario ya da Scenario Outline'dan ONCE ya da SONRA calismasini istedigimiz method'lar konur.
    @Before & @After method'larini icerir.
    Burada onemli olan raporlama isleminin ekran goruntusu ile birlikte Hooks yardimiyla yapilmasidir
 */

    @Before
    public void setUpScenarios() {
        System.out.println("Before");
    }

    @After
    public void tearDownScenarios(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] failedScreenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(failedScreenshot, "image/png", "failed_scenario" + scenario.getName());

            Driver.closeDriver();
        }
    }
}
