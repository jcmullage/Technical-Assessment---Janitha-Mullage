package domain;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.ShopPage;

public class Shop extends JupiterBase {

    ShopPage shopPage;

    public Shop(WebDriver driver) {
        shopPage = new ShopPage(driver);
        this.driver = driver;
    }

    public void buy(String product, int qty) {
        for (int i = 0; i < qty; i++) {
            shopPage.clickBuyBtn(product);
        }
    }

    @Override
    BasePage getCurrentPage() {
        return shopPage;
    }
}
