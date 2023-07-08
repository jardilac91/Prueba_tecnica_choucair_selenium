package exitoshoppingcart.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static exitoshoppingcart.ui.CartShoppingPage.*;
import static exitoshoppingcart.utils.ConvertNumberToInt.convertAmountToInt;


public class ValidateShoppingCart implements Task {
    public static List<String> product_name_shopping_cart = new ArrayList<>();
    public static List<Integer> product_price_shopping_cart = new ArrayList<>();
    public static List<Integer> product_quantity_shopping_cart = new ArrayList<>();

    public static int total_purchase;
    String product_price;
    String product_quantity;
    @Override
    public <T extends Actor> void performAs(T actor){
        total_purchase = 0;
        total_purchase = convertAmountToInt(TOTAL_PURCHASE.resolveFor(actor).getText());
        for(int product = 1; product<=5; product ++){
            if(product == 3){
                actor.attemptsTo(
                        Scroll.to(FOOTER_SHOPPING_CART)
                );
            }
            product_name_shopping_cart.add(Target.the("product_name").
                    located(By.xpath(String.format(PRODUCT_NAME_SHOPPING_CART, product))).
                    resolveFor(actor).getText());
            product_price = Target.the("product_price").
                    located(By.xpath(String.format(PRODUCT_PRICE_SHOPPING_CART, product))).
                    resolveFor(actor).getText();
            product_price_shopping_cart.add(convertAmountToInt(product_price));
            product_quantity = Target.the("product_quantity").
                    located(By.xpath(String.format(PRODUCT_QUANTITY_SHOPPING_CART, product))).
                    resolveFor(actor).getText();
            product_quantity_shopping_cart.add(convertAmountToInt(product_quantity));
        }

        System.out.println(String.format("Nombres de los productos en carrito: %s", product_name_shopping_cart));
        System.out.println(String.format("cantidad de productos en carrito: %s", product_quantity_shopping_cart));
        System.out.println(String.format("Precios  de los productos en carrito: %s", product_price_shopping_cart));
        System.out.println(String.format("Total de la compra en carrito: %s", total_purchase));


    }

    public static ValidateShoppingCart validateShoppingCart(){
        return new ValidateShoppingCart();
    }
}
