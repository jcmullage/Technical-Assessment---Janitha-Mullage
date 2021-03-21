package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn-checkout")));
    }

    public boolean isProductInCart(String product) {
        List<WebElement> products = driver.findElements(By.xpath(
                String.format("//td[contains(text(),'%s')]", product)));
        return products.size() > 0;
    }

    public int getProductQty(String product) {
        WebElement productQty = driver.findElement(By.xpath(
                String.format("//td[contains(text(),'%s')]/../td/input[@name='quantity']", product)
        ));
        return Integer.parseInt(productQty.getAttribute("value"));
    }

}
