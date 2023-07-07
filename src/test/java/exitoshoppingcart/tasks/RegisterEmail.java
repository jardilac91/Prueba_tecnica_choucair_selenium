package exitoshoppingcart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static exitoshoppingcart.ui.CartShoppingPage.*;
import static exitoshoppingcart.ui.ExitoHomePage.SHOPPING_CART_BUTTON;
import static exitoshoppingcart.utils.ConvertAmountToInt.convertAmountToInt;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RegisterEmail implements Task {

    public static String email;

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SHOPPING_CART_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(SHOPPING_CART_BUTTON),
                WaitUntil.the(EMAIL_MODAL, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(email).into(EMAIL_INPUT),
                Click.on(CONFIRM_EMAIL_BUTTON),
                WaitUntil.the(EMAIL_MODAL, isNotVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static RegisterEmail registerEmail(){
        return new RegisterEmail();
    }
}
