package domain;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.HomePage;

public class Home extends JupiterBase {

    HomePage homePage;

    public Home(WebDriver driver) {
        homePage = new HomePage(driver);
        this.driver = driver;
    }

    @Override
    BasePage getCurrentPage() {
        return homePage;
    }
}
