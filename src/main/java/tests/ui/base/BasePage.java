package tests.ui.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    // Constructor
    //PageFactory helps in initializing the elements of a Page Object: the elements are initialized only when they are accessed
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

