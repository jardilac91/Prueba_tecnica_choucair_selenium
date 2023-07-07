package exitoshoppingcart.tasks;

import exitoshoppingcart.utils.ConvertAmountToInt;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import java.util.*;

import static exitoshoppingcart.ui.ProductsPage.*;
import static exitoshoppingcart.ui.ExitoHomePage.SHOPPING_CART_BUTTON;
import static exitoshoppingcart.utils.GenerateRandomNumbers.select_five_random_products;
import static exitoshoppingcart.utils.GenerateRandomNumbers.select_random_quantity_of_products;
import static exitoshoppingcart.utils.ConvertAmountToInt.convertAmountToInt;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectProducts implements Task {
    public static List<Integer> index_products = new ArrayList<>();
    public static List<String> product_names = new ArrayList<>();
    public static List<Integer> product_prices = new ArrayList<>();
    public static List<Integer> product_quantities = new ArrayList<>();
    public static int product_quantity;

    public static Set<Integer> unique_product = new HashSet<>();

    public static List<WebElementFacade> array_products = new ArrayList<WebElementFacade>();

    int product_price;
    public static int total_purchased=0;

    @Override
    public <T extends Actor> void performAs(T actor){
        WaitUntil.the(SEARCH_RESULTS,isVisible()).forNoMoreThan(10).seconds();
        if(GEOLOCATION_MODAL.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Click.on(ClOSE_MODAL_BUTTON)
            );
        }
        actor.attemptsTo(
                Scroll.to(FOOTER),
                Scroll.to(SEARCH_RESULTS)
        );

        index_products = select_five_random_products(List_products(actor).size());

        System.out.println(String.format("Lista de indices de productos: %s", index_products));


        for( int index = 0; index < 5; index++){
            product_quantity = select_random_quantity_of_products();
            System.out.println(String.format("Cantidad de productos: %s",product_quantity));
            actor.attemptsTo(
                    Scroll.to(By.xpath(String.format(PRODUCT, index_products.get(index)))),
                    Click.on(By.xpath(String.format(FAST_BUY_BUTTON, index_products.get(index)))),
                    WaitUntil.the(QUICK_PURCHASE_MODAL, isVisible()).forNoMoreThan(10).seconds()

            );
            product_quantities.add(product_quantity);
            product_names.add(PRODUCT_NAME.resolveFor(actor).getText());
            product_price = convertAmountToInt(PRODUCT_PRICE.resolveFor(actor).getText());
            product_prices.add(product_price*product_quantity);
            for(int quantity = 1; quantity <= product_quantity; quantity++){
                if(quantity <= 1){
                    actor.attemptsTo(
                            Click.on(ADD_PRODUCT_BUTTON)
                    );
                }else {
                    actor.attemptsTo(
                            Click.on(ADD_UNITS_BUTTON)
                    );
                }
            }
            total_purchased += (product_price*product_quantity);
            actor.attemptsTo(
                    Click.on(CONTINUE_WITH_SHOPPING_BUTTON)
            );
        }

        System.out.println(String.format("Nombres de los productos: %s", product_names));
        System.out.println(String.format("Precios  de los productos: %s", product_prices));
        System.out.println(String.format("Total de la compra: %s", total_purchased));

        actor.attemptsTo(
                WaitUntil.the(SHOPPING_CART_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(SHOPPING_CART_BUTTON)
        );
    }

    public static SelectProducts selectproducts(){
        return new SelectProducts();
    }
}
