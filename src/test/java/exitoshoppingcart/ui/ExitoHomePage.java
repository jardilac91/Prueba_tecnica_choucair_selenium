package exitoshoppingcart.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.exito.com/")
public class ExitoHomePage extends PageObject {
    public static final Target MENU_BUTTON = Target.the("Menu button")
            .located(By.id("category-menu"));
}
