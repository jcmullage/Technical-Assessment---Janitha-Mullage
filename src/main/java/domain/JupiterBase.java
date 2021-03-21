package domain;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public abstract class JupiterBase {

    WebDriver driver;

    public Shop navigateToShop() {
        getCurrentPage().getNavBar().navigateToShop();
        return new Shop(driver);
    }

    public Contacts navigateToContacts() {
        getCurrentPage().getNavBar().navigateToContacts();
        return new Contacts(driver);
    }

    public Cart navigateToCart() {
        getCurrentPage().getNavBar().navigateToCart();
        return new Cart(driver);
    }

    abstract BasePage getCurrentPage();
}
