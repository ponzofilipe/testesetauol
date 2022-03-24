package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PrevisaoTempoMenuPage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @FindBy(css = "div.weather__search__button")
    private WebElement pesquisarIcone;
    @FindBy(css = "div.suggest.weather__search__suggest input.suggest__input")
    private WebElement pesquisarInput;
    @FindBy(css = "ul.suggest__list")
    private WebElement listaSugestoes;
    @FindBy(css = "div.weather__box__title")
    private WebElement nomeCidadePrevisaoTempo;


    public PrevisaoTempoMenuPage(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(this.driver, this);
    }

    public void clicarNoIconePesquisa() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(this.pesquisarIcone));
        this.pesquisarIcone.click();
    }

    public void digitarNoInputPesquisaCidade(String cidade) {
        webDriverWait.until(ExpectedConditions.visibilityOf(this.pesquisarInput));
        this.pesquisarInput.sendKeys(cidade);
    }

    public void clicarNaCidade(String cidade){
        webDriverWait.until(ExpectedConditions.visibilityOf(this.listaSugestoes));
        driver.findElement(By.xpath("//p[@class='suggest__text']//strong[text()='"+ cidade +"']")).click();
        webDriverWait.until(ExpectedConditions.textToBe(By.cssSelector("div.weather__box__title"), cidade));
    }

    public String obterNomeDaCidadeNaPrevisaoTempo() {
        return this.nomeCidadePrevisaoTempo.getText();
    }
}
