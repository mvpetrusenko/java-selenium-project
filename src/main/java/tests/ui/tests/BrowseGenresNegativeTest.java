package tests.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.pages.SearchPage;


public class BrowseGenresNegativeTest {

    private WebDriver driver;
    private SearchPage searchPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        searchPage = PageFactory.initElements(driver, SearchPage.class);
    }

    @Test
    public void browseForGenreTest() {

        driver.get("https://www.spotify.com/");

        String expectedUrlPattern = "https://#open.spotify.com/genre/0JQ5DArNBzkmxXHCqFLx2J";

        searchPage.searchForGenre();

        Assert.assertFalse(driver.getCurrentUrl().startsWith(expectedUrlPattern), "URL does not match the expected pattern");

    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


