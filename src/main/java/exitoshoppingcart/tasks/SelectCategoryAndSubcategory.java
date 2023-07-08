package exitoshoppingcart.tasks;

import exitoshoppingcart.ui.ExitoHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static exitoshoppingcart.ui.ExitoHomePage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectCategoryAndSubcategory implements Task {
    private String category;
    private String subcategory;

    public SelectCategoryAndSubcategory(String category, String subcategory) {
        this.category = category;
        this.subcategory = subcategory;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                WaitUntil.the(MENU_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(MENU_BUTTON),
                WaitUntil.the(MENU, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ExitoHomePage.categorySelected(this.category)),
                WaitUntil.the(SUBMENU, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ExitoHomePage.subCategorySelected(this.subcategory)),
                WaitUntil.the(MENU, isNotVisible()).forNoMoreThan(20).seconds()
        );
    }

    public static SelectCategoryAndSubcategory selectcategoryandsubcategory(String category, String subcategory){
        return new SelectCategoryAndSubcategory(category, subcategory);
    }
}


