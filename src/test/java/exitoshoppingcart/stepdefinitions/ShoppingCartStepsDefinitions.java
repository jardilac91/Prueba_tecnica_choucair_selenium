package exitoshoppingcart.stepdefinitions;

import exitoshoppingcart.tasks.SelectProducts;
import exitoshoppingcart.tasks.ValidateShoppingCart;
import exitoshoppingcart.ui.ExitoHomePage;
import exitoshoppingcart.utils.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.Collections;

import static exitoshoppingcart.tasks.SelectCategoryAndSubcategory.selectcategoryandsubcategory;
import static exitoshoppingcart.tasks.SelectProducts.selectproducts;
import static exitoshoppingcart.tasks.RegisterEmail.registerEmail;
import static exitoshoppingcart.tasks.ValidateShoppingCart.validateShoppingCart;

public class ShoppingCartStepsDefinitions {

    @Managed()
    protected WebDriver webDriver;
    Config driver = new Config();

    @Given("the user is in the Exito shopping page.")
    public void theUserIsInTheExitoShoppingPage() {
        driver.setupActor(webDriver);
        theActorInTheSpotlight().wasAbleTo(Open.browserOn().the(ExitoHomePage.class));
    }

    @When("the user select a category {string} and a subcategory {string}.")
    public void theUserSelectACategoryAndASubcategory(String category, String subcategory) {
        theActorInTheSpotlight().attemptsTo(
                selectcategoryandsubcategory(category, subcategory)
        );

    }

    @And("adds five random products with an aleatory quantity between 1-10 products.")
    public void addsFiveRandomProductsWithAnAleatoryQuantityBetweenOneToTen() {
        theActorInTheSpotlight().attemptsTo(
                selectproducts()
        );
    }

    @And("add the email {string} to complete the purchase.")
    public void addTheEmailToCompleteThePurchase(String email) {
        theActorInTheSpotlight().attemptsTo(
                registerEmail(email)
        );
    }
    @Then("the information of the products in the shopping cart have to be the same as the selected products.")
    public void theNameTotalPriceQuantityAndTheNumberOfTheProductsInTheShoppingHaveToBeTheSameAsTheSelectedProducts() {
        theActorInTheSpotlight().attemptsTo(
                validateShoppingCart()
        );

        Collections.sort(SelectProducts.product_names);
        Collections.sort(SelectProducts.product_quantities);
        Collections.sort(SelectProducts.product_prices);
        Collections.sort(ValidateShoppingCart.product_name_shopping_cart);
        Collections.sort(ValidateShoppingCart.product_quantity_shopping_cart);
        Collections.sort(ValidateShoppingCart.product_price_shopping_cart);

        theActorInTheSpotlight().should(
                seeThat("The products name has to be: ",
                        product_names -> ValidateShoppingCart.product_name_shopping_cart,
                        equalTo(SelectProducts.product_names)),
                seeThat("The products quantity has to be: ",
                        product_quantity -> ValidateShoppingCart.product_quantity_shopping_cart,
                        equalTo(SelectProducts.product_quantities)),
                seeThat("The products price has to be: ",
                        product_price -> ValidateShoppingCart.product_price_shopping_cart,
                        equalTo(SelectProducts.product_prices)),
                seeThat("The total purchased has to be: ",
                        total_purchase -> ValidateShoppingCart.total_purchase,
                        equalTo(SelectProducts.total_purchased))
        );

        webDriver.quit();
    }



}
