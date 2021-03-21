package domain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.CartPage;

public class Cart extends JupiterBase {

    CartPage cartPage;

    public Cart(WebDriver driver) {
        cartPage = new CartPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn-checkout")));
    }

    public boolean isCartContains(String product, int qty) {
        return cartPage.isProductInCart(product) &&
                cartPage.getProductQty(product) == qty;
    }

    @Override
    BasePage getCurrentPage() {
        return cartPage;
    }
}
