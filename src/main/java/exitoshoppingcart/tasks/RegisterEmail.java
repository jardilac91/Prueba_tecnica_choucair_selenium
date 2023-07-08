package exitoshoppingcart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static exitoshoppingcart.ui.CartShoppingPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RegisterEmail implements Task {

    private String email;

    public RegisterEmail(String email) {
        this.email = email;
    }

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(EMAIL_MODAL, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(this.email).into(EMAIL_INPUT),
                Click.on(CONFIRM_EMAIL_BUTTON),
                WaitUntil.the(EMAIL_MODAL, isNotVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static RegisterEmail registerEmail(String email){
        return new RegisterEmail(email);
    }
}
