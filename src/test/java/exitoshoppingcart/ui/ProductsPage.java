package exitoshoppingcart.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPage extends PageObject {

    public static final Target GEOLOCATION_MODAL = Target.the("Geolocation modal").
            located(By.id("exito-geolocation-3-x-modalContainer"));
    public static final Target ClOSE_MODAL = Target.the("Close modal button").
            located(By.className("exito-geolocation-3-x-cursorPointer"));
}




