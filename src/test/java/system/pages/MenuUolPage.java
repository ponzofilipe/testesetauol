package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

public class MenuUolPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MenuUolPage() {
        this.driver = DriverManager.getDriver();
        this.wait = DriverManager.getDriverWait();
    }
    public void closePopupBatePapo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(learnSeleniumPopup));
        driver.findElement(learnSeleniumPopup).click();
    }

    //****Locators****
    private By learnSeleniumPopup = By.cssSelector("#overlay > div > div.sc-gKsewC.gnwqMi > img");
    private By AbaProdutos = By.cssSelector("#app > div > header > nav > ul > li.menuDesktop__item.menuDesktop__item--produtos > a > span.menuDesktop__link__title");
    private By AbaBatePapo = By.cssSelector("#app > div > div.blackBar > div > ul.blackBar__listProducts > li:nth-child(2) > a");
    private By MenuSalas = By.cssSelector("#root > header > div:nth-child(3) > div.sc-giIncl.gHUUHu > ul > li:nth-child(1) > a");
    private By Salas = By.cssSelector("#root > header > div:nth-child(3) > div.sc-giIncl.gHUUHu > ul > li:nth-child(1) > a");
    private By SalasPopup = By.cssSelector("#overlay > div > div.sc-gKsewC.gnwqMi > img");
    private By SalasCategorias = By.cssSelector("#root > section > div > div:nth-child(3) > section.sc-kMOkjD.jZjyro > h2 > div");
    private By SalasCategorias2 = By.cssSelector("#root > section > div > div:nth-child(3) > section.sc-czgevV.giohnb > div:nth-child(1) > div.sc-bQVmPH.cROQXQ > div > h3");
    private By ExperimenteporSeteDias = By.cssSelector("#beVipRightNow > div.sc-hlWvWH.dgxEoC > div.sc-gVgnHT.bfDGHw > a");


    public void ClicaAbaProdutos(){
        driver.findElement(AbaProdutos).click();
    }
    public void ClicaAbaBatePapo(){
        driver.findElement(AbaBatePapo).click();
    }

    public void ClicaAreaSalas(){
        driver.findElement(MenuSalas).click();
    }
    public void ClicaAreaSalasPopUp(){
        driver.findElement(SalasPopup).click();
    }

    public String GetVerificaSalas(){
        return driver.findElement(SalasCategorias).getText();
    }
    public String GetVerificaSalasCat1(){ return driver.findElement(SalasCategorias2).getText();}
    public String GetVerificaPlanoSeteDias(){ return driver.findElement(ExperimenteporSeteDias).getText();}

    public String GetVerificaSalasCategorias(){
        return driver.findElement(SalasCategorias).getText();
    }




}
