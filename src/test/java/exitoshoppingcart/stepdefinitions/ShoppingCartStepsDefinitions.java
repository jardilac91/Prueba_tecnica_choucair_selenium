package exitoshoppingcart.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCartStepsDefinitions {
    @Given("the user is in the Exito shopping page.")
    public void theUserIsInTheExitoShoppingPage() {
    }

    @When("the user select a <Category> and a <Subcategory>.")
    public void theUserSelectACategoryAndASubcategory() {
    }

    @And("adds five random products with an aleatory quantity between {int}{int}.")
    public void addsFiveRandomProductsWithAnAleatoryQuantityBetween(int arg0, int arg1) {
    }

    @Then("the name, total price, quantity and the number of the products in the shopping have to be the same as the selected products")
    public void theNameTotalPriceQuantityAndTheNumberOfTheProductsInTheShoppingHaveToBeTheSameAsTheSelectedProducts() {
    }
}
