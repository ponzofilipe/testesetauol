package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;
import static system.helpers.PagesURL.SELENIUM_EASY_MAIN_PAGE;

public class MainPage {

    /*
     Representação
     */
    private WebDriver driver;
    private WebDriverWait wait;
    private By siteNameSeletor = By.cssSelector("#site-name");
    private By learnSeleniumPopup = By.cssSelector(".at-cm-no-button");

    /*
     Interação
     */

    public MainPage() {
        this.driver = DriverManager.getDriver();
        this.wait = DriverManager.getDriverWait();
    }

    public MainPage acessar() {
        this.driver.get(SELENIUM_EASY_MAIN_PAGE);

        try {
            this.closePopup();
        } catch (Exception e) {
            // nada
        }

        return this;
    }

    public String getSiteName() {
        return this.driver.findElement(siteNameSeletor).getText();
    }

    private void closePopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(learnSeleniumPopup));
        driver.findElement(learnSeleniumPopup).click();
    }

    public LeftMenuPage leftMenu() {
        return new LeftMenuPage();
    }
}
