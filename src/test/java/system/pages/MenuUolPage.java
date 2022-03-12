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
    private By AbaBatePapo = By.cssSelector("#app > div > header > nav > ul > li.menuDesktop__item.menuDesktop__item--produtos > a > span.menuDesktop__link__title");
    private By AbaSalas = By.cssSelector("#conteudo-exclusivo > section.top > div > div > div.item.destaque > div.price_plan");
    private By MenuSalas = By.cssSelector("#conteudo-exclusivo > section.top > div > div > div.item.destaque > div.price_plan");
    private By Salas = By.cssSelector("#conteudo-exclusivo > section.top > div > div > div.item.destaque > div.price_plan");
    private By SalasCategorias = By.cssSelector("#conteudo-exclusivo > section.top > div > div > div.item.destaque > div.price_plan");

    public void ClicaAbaProdutos(){
        driver.findElement(AbaProdutos).click();
    }
    public void ClicaAbaBatePapo(){
        driver.findElement(AbaBatePapo).click();
    }

    public void ClicaAreaSalas(){
        driver.findElement(MenuSalas).click();
    }

    public String GetVerificaSalas(){
        return driver.findElement(Salas).getText();
    }

    public String GetVerificaSalasCategorias(){
        return driver.findElement(SalasCategorias).getText();
    }




}
