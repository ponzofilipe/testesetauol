package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

public class MenuUolPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MenuUolPage() {
        this.driver = DriverManager.getDriver();
        this.wait = DriverManager.getDriverWait();
    }

    //****Locators****
    private By AbaProdutos = By.cssSelector("#app > div > header > nav > ul > li.menuDesktop__item.menuDesktop__item--produtos > a > span.menuDesktop__link__title");






public void ClicaAbaProdutos(){
    driver.findElement(AbaProdutos).click();
}





}
