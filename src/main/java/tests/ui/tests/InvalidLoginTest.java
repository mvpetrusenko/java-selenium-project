package tests.ui.tests;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        loginPage.login("your_username", "your_password");

        // Add assertions or further actions as needed
    }

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}

