package tests.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends HomePage {

    // WebElements
    //PageFactory uses annotations like @FindBy to locate and initialize WebElement fields


    @FindBy(xpath = "//button[@data-testid = 'login-button']")
    private WebElement loginButton;

    @FindBy(id = "login-username")
    private WebElement usernameInput;

    @FindBy(id = "login-password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton2;



    //
    // Constructor
    //super: to call the constructor of the base page class from the constructor of the derived page class
    //public class DerivedPage extends BasePage
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginToProfile(String username, String password) {

        acceptCookies();

        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(usernameInput));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton2.click();
    }
}

