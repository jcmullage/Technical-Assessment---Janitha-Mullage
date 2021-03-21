import domain.Cart;
import domain.Home;
import domain.Shop;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartTest extends BaseTest {

    @Test
    public void testShoppingCartCount() {
        Home home = new Home(driver);
        Shop shop = home.navigateToShop();
        String item1 = "Funny Cow";
        String item2 = "Fluffy Bunny";
        shop.buy(item1, 2);
        shop.buy(item2, 1);
        Cart cart = shop.navigateToCart();
        assertThat(cart.isCartContains(item1, 2)).isTrue();
        assertThat(cart.isCartContains(item2, 1)).isTrue();
    }


}
