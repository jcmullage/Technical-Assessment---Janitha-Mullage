package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBar {

    @FindBy(css = "#nav-contact a")
    WebElement contactMenu;

    @FindBy(css = "#nav-shop a")
    WebElement shopMenu;

    @FindBy(css = "#nav-cart a")
    WebElement cartMenu;

    WebDriver driver;

    public NavBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ContactsPage navigateToContacts() {
        contactMenu.click();
        return new ContactsPage(driver);
    }

    public ShopPage navigateToShop() {
        shopMenu.click();
        return new ShopPage(driver);
    }

    public CartPage navigateToCart() {
        cartMenu.click();
        return new CartPage(driver);
    }
}
