package tests.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.ui.base.BasePage;

import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {

    // WebElements
    @FindBy(xpath = "//a[@href='/search']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//input[@data-testid='search-input']")
    private WebElement searchInput;

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Methods
    public void acceptCookies() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Wait for the accept cookies button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));

        // Click the accept cookies button
        acceptCookiesButton.click();
    }


    public boolean isSearchInputContaining(String searchTerm) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Wait for the search input to be present
        WebElement searchInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-testid='search-input']")));

        // Check if the search input contains the specified term
        return searchInput.getAttribute("value").contains(searchTerm);
    }


    public void searchForSong(String songName) {
        // Click the accept cookies button before searching
        acceptCookies();

        // Click the search button
        searchButton.click();


        // Wait for the search input to be visible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='search-input']")));

        searchInput.sendKeys(songName);

    }
}
