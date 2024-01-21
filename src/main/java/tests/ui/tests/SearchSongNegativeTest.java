package tests.ui.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tests.ui.pages.HomePage;

public class SearchSongNegativeTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialization Page Object using PageFactory
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    //@Test
    //@Test(alwaysRun = true)
    @Test(groups = {"SmokeTest"})
    //@Test(groups = {"Regression"})
    //@Test(priority = 1)
    public void searchForSongTest() {

        driver.get("https://www.spotify.com/");

        homePage.searchForSong("spring");

        String searchTerm = "love";
        Assert.assertFalse(homePage.isSearchInputContaining(searchTerm), "Search input does not contain the expected term: " + searchTerm);


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
