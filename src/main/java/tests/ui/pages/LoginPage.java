package tests.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.ui.base.BasePage;

public class LoginPage extends BasePage {

    // WebElements
    //PageFactory uses annotations like @FindBy to locate and initialize WebElement fields
    @FindBy(id = "login-username")
    private WebElement usernameInput;

    @FindBy(id = "login-password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    // Constructor
    //super: to call the constructor of the base page class from the constructor of the derived page class
    //public class DerivedPage extends BasePage
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Methods
    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}

