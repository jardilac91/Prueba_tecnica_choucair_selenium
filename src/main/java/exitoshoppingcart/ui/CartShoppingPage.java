package exitoshoppingcart.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class CartShoppingPage extends PageObject {

    public static final Target EMAIL_MODAL = Target.the("Email modal").
            located(By.className("exito-checkout-io-0-x-preLoginContainer"));

    public static final Target EMAIL_INPUT = Target.the("Email input").
            located(By.xpath("//div[contains(@class, 'exito-checkout-io-0-x-preLoginInputText')]/input"));

    public static final Target CONFIRM_EMAIL_BUTTON = Target.the("Confirm email input").
            located(By.className("exito-checkout-io-0-x-preLoginActiveButton"));

    public static final String PRODUCT_NAME_SHOPPING_CART = "(//div[@class='exito-checkout-io-0-x-itemCartContent'])[%s]/div[1]/div[4]/span";

    public static final String PRODUCT_PRICE_SHOPPING_CART = "(//div[@class='exito-checkout-io-0-x-itemCartContent'])[%s]/div[1]/div[5]/div/span/span";
    public static final String PRODUCT_QUANTITY_SHOPPING_CART = "(//div[@class='exito-checkout-io-0-x-itemCartContent'])[%s]/div[1]/div[6]/div/div/div/div/span[1]";

    public static final Target TOTAL_PURCHASE = Target.the("Total purchase").
            located(By.xpath("(//div[@class='exito-checkout-io-0-x-summaryContainer'])/div[1]/div[2]/div[1]/span[2]"));

    public static final Target FOOTER_SHOPPING_CART = Target.the("Footer in the shopping cart").
            located(By.className("exito-checkout-io-0-x-footerBar"));

}
