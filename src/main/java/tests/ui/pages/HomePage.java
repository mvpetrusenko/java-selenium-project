package tests.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.ui.base.BasePage;

import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {

    // WebElements
    @FindBy(xpath = "//a[@href='/search']")
    public WebElement searchButton;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//input[@data-testid='search-input']")
    private WebElement searchInput;


    @FindBy(xpath = "//button[contains(@class, 'Button-sc-1dqy6lx-0 emaScS')]")
    private WebElement addPlaylistButton;


    @FindBy(xpath = "//button[@role = 'menuitem']")
    private WebElement createNewPlaylistButton;


    @FindBy(xpath = "/div[contains(@class, 'tsv')][1]")
    private WebElement firstSongItem;


    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));

        acceptCookiesButton.click();
    }


    public boolean isSearchInputContaining(String searchTerm) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement searchInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-testid='search-input']")));

        return searchInput.getAttribute("value").contains(searchTerm);
    }


    public void searchForSong(String songName) {

        acceptCookies();

        searchButton.click();


        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='search-input']")));

        searchInput.sendKeys(songName);

    }

    public void createNewPlaylist() {

        acceptCookies();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(addPlaylistButton));

        addPlaylistButton.click();


        //WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(createNewPlaylistButton));


        createNewPlaylistButton.click();


    }


    public void playAnySong() {

        acceptCookies();

        // Creation of Actions instance
        Actions actions = new Actions(driver);

        // Performing hover over the element
        actions.moveToElement(firstSongItem).perform();

        // Perform click after the hover
        //actions.click().perform();

//        addPlaylistButton.click();
//
//
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(createNewPlaylistButton));
//
//
//        createNewPlaylistButton.click();
    }
}
