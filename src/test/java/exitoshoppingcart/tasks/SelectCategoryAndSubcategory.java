package exitoshoppingcart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static exitoshoppingcart.ui.ExitoHomePage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectCategoryAndSubcategory implements Task {
    public static String category;
    public static String subcategory;

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                WaitUntil.the(MENU_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(MENU_BUTTON),
                WaitUntil.the(MENU, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(exitohomepage().categorySelected(category)),
                WaitUntil.the(SUBMENU, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(exitohomepage().subCategorySelected(subcategory)),
                WaitUntil.the(MENU, isNotVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static SelectCategoryAndSubcategory selectcategoryandsubcategory(){
        return new SelectCategoryAndSubcategory();
    }
}
