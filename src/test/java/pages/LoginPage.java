package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "formBasicEmail") public WebElement blueRentalUsername;
    @FindBy (id = "formBasicPassword") public WebElement blueRentalPassword;
    @FindBy (css = "button[class='btn btn-primary']") public WebElement blueRentalLogin;
}
