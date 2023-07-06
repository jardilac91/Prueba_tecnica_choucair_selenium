package exitoshoppingcart.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuSectionPage extends PageObject {

    public Target categorySelected(String category){
        Target CATEGORY = Target.the(String.format("Category %s", category))
                .located(By.id(String.format("undefined-nivel2-%s",category)));
        return CATEGORY;
    }

    public Target subCategorySelected(String category){
        Target SUBCATEGORY = Target.the(String.format("SubCategory %s", category))
                .located(By.id(String.format("Categorías-nivel3-%s",category)));
        return SUBCATEGORY;
    }
}
