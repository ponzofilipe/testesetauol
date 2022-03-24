package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

public class ValorAssinaturaPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ValorAssinaturaPage() {
        this.driver = DriverManager.getDriver();
        this.wait = DriverManager.getDriverWait();
    }

    //****Locators****
    private By ValorAssinatura = By.cssSelector("#conteudo-exclusivo > section.top > div > div > div.item.destaque > div.price_plan");




    public String GetValorAssinatura(){
        return driver.findElement(ValorAssinatura).getText();
    }

}
