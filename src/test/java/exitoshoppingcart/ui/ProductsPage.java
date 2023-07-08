package exitoshoppingcart.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.exceptions.NoSuchElementException;
import org.awaitility.Awaitility;
import org.openqa.selenium.By;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductsPage extends PageObject {

    public static final Target SEARCH_RESULTS = Target.the("Search result section").
            located(By.id("search-result-anchor"));
    public static final Target GEOLOCATION_MODAL = Target.the("Geolocation modal").
            located(By.xpath("//span[@class=exito-geolocation-3-x-modalContainer]"));
    public static final Target ClOSE_MODAL_BUTTON = Target.the("Close modal button").
            located(By.xpath("exito-geolocation-3-x-cursorPointer"));

    public static final Target FOOTER = Target.the("Footer").
            located(By.className("exito-footer-3-x-footer"));
    public static final String PRODUCT = "//*[@id='gallery-layout-container']/div[%s]";

    public static final String FAST_BUY_BUTTON = "//*[@id='gallery-layout-container']/div[%s]" +
            "/section/a/article/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div";
    public static final Target QUICK_PURCHASE_MODAL = Target.the("Quick purchase modal").
            located(By.xpath("//div[contains(@class, 'exito-vtex-components-4-x-quickPurchaseModalContainermodal')]"));
    public static final Target PRODUCT_NAME = Target.the("Product name").
            located(By.xpath("//div[contains(@class, 'exito-vtex-components-4-x-quickPurchaseModalContainermodal')]//div[2]/div/div/div[6]/div/div[1]/h3/span"));

    public static final Target PRODUCT_PRICE = Target.the("Product price").
            located(By.xpath("//div[contains(@class, 'exito-vtex-components-4-x-quickPurchaseModalContainermodal')]//div[2]/div/div/div[8]/div/span"));

    public static final Target ADD_PRODUCT_BUTTON = Target.the("Add product button").
            located(By.xpath("//span[contains(text(),'Agregar')]"));

    public static final Target UNITS = Target.the("Units of product").
            located(By.xpath("//*[@class='exito-vtex-components-4-x-stepperContainerQty']"));
    public static final Target ADD_UNITS_BUTTON = Target.the("Add more units button").
            located(By.className("product-summary-add-to-car-plus"));

    public static final Target CONTINUE_WITH_SHOPPING_BUTTON = Target.the("Continue with shopping button").
            located(By.className("exito-vtex-components-4-x-continue"));


    public static List<WebElementFacade> List_products(Actor actor){
        List<WebElementFacade> PRODUCTS = Target.the("product_list").
                located(By.className("vtex-search-result-3-x-galleryItem")).resolveAllFor(actor);
        return PRODUCTS;
    }

    public static Target NO_PRODUCT_AVAILABLE = Target.the("No product available message").
            located(By.xpath("(//*[@class='pr5 mw6-ns lh-copy'])"));

    public static ProductsPage productsPage(){
        return new ProductsPage();
    }
}


