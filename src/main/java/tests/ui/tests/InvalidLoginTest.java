package tests.ui.tests;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.pages.LoginPage;

public class InvalidLoginTest {

    private WebDriver driver;
    private LoginPage loginPage;


    //TestNG testing framework for annotations (@BeforeClass, @Test, @AfterClass)

    @BeforeClass
    public void setup() {
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginToSpotify() {
        driver.get("https://www.spotify.com/");

        // Perform login using the LoginPage
        loginPage.loginToProfile("your_username", "your_password");

        String actualXPath3 = "//span[contains(@class, 'Message')]";
        String expectedXPath3 = "//span[contains(@class, 'Message')]";
        Assert.assertEquals(actualXPath3, expectedXPath3);

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

