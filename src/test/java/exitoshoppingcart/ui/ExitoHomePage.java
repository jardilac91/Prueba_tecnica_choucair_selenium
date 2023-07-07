package exitoshoppingcart.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.exito.com/")
public class ExitoHomePage extends PageObject {
    public static final Target MENU_BUTTON = Target.the("Menu button")
            .located(By.id("Trazado_7822"));

    public static final Target MENU = Target.the("Menu").
            located(By.className("exito-category-menu-3-x-containerDrawer"));

    public static final Target SUBMENU = Target.the("Submenu section").
            located(By.className("exito-category-menu-3-x-sideMenu"));

    public static final Target SHOPPING_CART_BUTTON = Target.the("Shopping Cart button").
            located(By.className("exito-header-3-x-minicartLink"));

    public static Target categorySelected(String category){

        String category_id =  String.format("//*[@id='undefined-nivel2-%s']",category);
        Target CATEGORY = Target.the(String.format("Category %s", category))
                .located(By.xpath(category_id));
        return CATEGORY;
    }

    public static Target subCategorySelected(String subcategory){
        String subcategory2 = String.format("Categorías-nivel3-%s", subcategory);
        System.out.println(subcategory2);
        Target SUBCATEGORY = Target.the(String.format("SubCategory %s", subcategory))
                .located(By.id(String.format("Categorías-nivel3-%s", subcategory)));
        return SUBCATEGORY;
    }

    public static ExitoHomePage exitohomepage(){
        return new ExitoHomePage();
    }

}
