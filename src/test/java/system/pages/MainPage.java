package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

import java.util.concurrent.TimeUnit;

import static system.helpers.PagesURL.SELENIUM_EASY_MAIN_PAGE;

public class MainPage {

    /*
     Representação
     */
    private WebDriver driver;
    private WebDriverWait wait;
    private By siteNameSeletor = By.cssSelector("#site-name");
    private By learnSeleniumPopup = By.cssSelector(".at-cm-no-button");
    private By botaoComunicarErro = By.cssSelector("#app > div > footer > nav > div.footer__error.footer__footerBar > button");
    /*
     Interação
     */

    public MainPage() {
        this.driver = DriverManager.getDriver();
        this.wait = DriverManager.getDriverWait();
    }

    public MainPage acessar() {
        this.driver.get(SELENIUM_EASY_MAIN_PAGE);
        return this;
    }

    public void clicarBotaoComunicarErro() throws Exception{
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        try {
            moverMouseParaFinalDaPagina();
            wait.until(ExpectedConditions.elementToBeClickable(botaoComunicarErro));
            driver.findElement(botaoComunicarErro).click();
        }catch (Exception e){
            moverMouseParaFinalDaPagina();
            closePopupSemanaDoConsumidor();
            driver.findElement(botaoComunicarErro).click();
        }
    }

    public String getSiteName() {
        return this.driver.findElement(siteNameSeletor).getText();
    }

    private void moverMouseParaFinalDaPagina(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    private void closePopupSemanaDoConsumidor(){
        Actions mouse = new Actions(driver);
        mouse.moveToElement(driver.findElement(By.cssSelector("#app > div > footer > nav > div.footer__error.footer__footerBar > button"))).build().perform();
        mouse.moveToElement(driver.findElement(By.cssSelector("#second-frame > div:nth-child(2)"))).click().perform();
    }

    private void closePopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(learnSeleniumPopup));
        driver.findElement(learnSeleniumPopup).click();
    }

    public LeftMenuPage leftMenu() {
        return new LeftMenuPage();
    }
}
