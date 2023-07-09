package exitoshoppingcart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import java.util.*;

import static exitoshoppingcart.ui.ProductsPage.*;
import static exitoshoppingcart.ui.ExitoHomePage.SHOPPING_CART_BUTTON;
import static exitoshoppingcart.utils.ConvertNumberToInt.convertAmountToInt;
import static exitoshoppingcart.utils.ConvertNumberToInt.convertUnitsToInt;
import static exitoshoppingcart.utils.GenerateRandomNumbers.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SelectProducts implements Task {
    public List<Integer> index_products = new ArrayList<>();
    public static List<String> product_names = new ArrayList<>();
    public static List<Integer> product_prices = new ArrayList<>();
    public static List<Integer> product_quantities = new ArrayList<>();
    public int product_quantity;

    int product_price;
    public static int total_purchased=0;
    int units;

    @Override
    public <T extends Actor> void performAs(T actor){
        WaitUntil.the(SEARCH_RESULTS, isVisible()).forNoMoreThan(10).seconds();
        if(GEOLOCATION_MODAL.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Click.on(ClOSE_MODAL_BUTTON)
            );
        }
        actor.attemptsTo(
                Scroll.to(FOOTER),
                Scroll.to(SEARCH_RESULTS)
        );

        index_products = selectFiveRandomProducts(List_products(actor).size());

        for( int index = 0; index < 5; index++){
            product_quantity = selectRandomQuantityOfProducts();
            actor.attemptsTo(
                    Scroll.to(By.xpath(String.format(PRODUCT, index_products.get(index)))),
                    Click.on(By.xpath(String.format(FAST_BUY_BUTTON, index_products.get(index)))),
                    WaitUntil.the(QUICK_PURCHASE_MODAL, isVisible()).forNoMoreThan(10).seconds()

            );
            units = 0;
            for(int quantity = 1; quantity <= product_quantity; quantity++){
                if(quantity <= 1){
                    actor.attemptsTo(
                            Click.on(ADD_PRODUCT_BUTTON),
                            WaitUntil.the(UNITS, isVisible()).forNoMoreThan(10).seconds()
                    );
                    units = convertUnitsToInt(UNITS.resolveFor(actor).getText());
                }else {

                    actor.attemptsTo(
                            WaitUntil.the(UNITS, isVisible()).forNoMoreThan(10).seconds(),
                            Click.on(ADD_UNITS_BUTTON),
                            Click.on(CONTINUE_WITH_SHOPPING_BUTTON),
                            WaitUntil.the(QUICK_PURCHASE_MODAL, isNotVisible()).forNoMoreThan(10).seconds(),
                            Click.on(By.xpath(String.format(FAST_BUY_BUTTON, index_products.get(index)))),
                            WaitUntil.the(QUICK_PURCHASE_MODAL, isVisible()).forNoMoreThan(10).seconds()
                    );
                    units = convertUnitsToInt(UNITS.resolveFor(actor).getText());
                }
                if(units < quantity){
                    product_quantity = units;
                    break;
                }
            }

            product_quantities.add(product_quantity);
            product_names.add(PRODUCT_NAME.resolveFor(actor).getText());
            product_price = convertAmountToInt(PRODUCT_PRICE.resolveFor(actor).getText());
            product_prices.add(product_price*product_quantity);
            total_purchased += (product_price*product_quantity);
            actor.attemptsTo(
                    Click.on(CONTINUE_WITH_SHOPPING_BUTTON),
                    WaitUntil.the(QUICK_PURCHASE_MODAL, isNotVisible()).forNoMoreThan(10).seconds()
            );

        }

        actor.attemptsTo(
                WaitUntil.the(SHOPPING_CART_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(SHOPPING_CART_BUTTON)
        );
    }

    public static SelectProducts selectproducts(){

        return new SelectProducts();
    }
}
