package tests.ui.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends HomePage {

    @FindBy(xpath = "//a[@href='/genre/0JQ5DArNBzkmxXHCqFLx2J']")
    public WebElement genreItem;

    // Constructor
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchForGenre() {

        acceptCookies();

        searchButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(genreItem));

        genreItem.click();
    }
}
