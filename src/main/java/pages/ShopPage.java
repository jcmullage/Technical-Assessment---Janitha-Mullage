package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage extends BasePage {

    public ShopPage(WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.product img")));
    }

    public void clickBuyBtn(String product) {
        String xpath = String.format("//div/h4[text()='%s']/..//a", product);
        driver.findElement(By.xpath(xpath)).click();
    }

}
