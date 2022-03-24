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
    private By botaoOkAceitarCookies = By.cssSelector("body > div.banner-lgpd-consent-container > div > div:nth-child(2) > button");
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
            clicarBotaoOkAceitarCookies();
            driver.findElement(botaoComunicarErro).click();
        }
    }

    public String getSiteName() {
        return this.driver.findElement(siteNameSeletor).getText();
    }

    private void moverMouseParaFinalDaPagina(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    private void clicarBotaoOkAceitarCookies(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(botaoOkAceitarCookies));
        driver.findElement(botaoOkAceitarCookies).click();
    }

    private void closePopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(learnSeleniumPopup));
        driver.findElement(learnSeleniumPopup).click();
    }

    public LeftMenuPage leftMenu() {
        return new LeftMenuPage();
    }
}
