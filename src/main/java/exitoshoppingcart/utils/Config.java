package exitoshoppingcart.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Config {


    @Managed
    protected WebDriver webDriver;
    public void setupActor( WebDriver webDriver){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User").whoCan(BrowseTheWeb.with(webDriver));
    }

    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }
    public void tearDown(){
        webDriver.quit();
    }

}
