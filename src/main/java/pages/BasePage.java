package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    NavBar navBar;
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        navBar = new NavBar(driver);
        wait.until(ExpectedConditions.elementToBeClickable(navBar.contactMenu));

    }

    public NavBar getNavBar() {
        return this.navBar;
    }

}
