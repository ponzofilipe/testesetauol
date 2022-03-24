package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComunicarErrorPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By inputNome = By.cssSelector("#name");
    private By inputEmail = By.cssSelector("#email");
    private By inputDescricaoErro = By.cssSelector("#description");
    private By botaoEnviar = By.cssSelector("#app > div > footer > nav > div.reportErrorForm.footer__reportErrorForm > form > button");
    private By mensagemSucesso = By.cssSelector("#app > div > footer > nav > div.reportErrorForm.footer__reportErrorForm > div > p");

    public ComunicarErrorPage() {
        this.driver = DriverManager.getDriver();
        this.wait = DriverManager.getDriverWait();
    }
    public void preencherFormulario(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputNome));
        driver.findElement(inputNome).sendKeys("Nome de Teste'");
        driver.findElement(inputEmail).sendKeys("claricemoraesf@gmail.com");
        driver.findElement(inputDescricaoErro).sendKeys("descricao de teste");
        driver.findElement(botaoEnviar).click();
    }

    public void confirmarMensagemSucessoExibida(String mensagemExibida){
        assertEquals("O UOL agradece sua colaboração. Sua mensagem será analisada pela Redação e os erros confirmados serão corrigidos.", mensagemExibida);
    }

    public void aguardarExibirMensagemSucesso(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemSucesso));
    }
    public String getMensagemSucesso(){
        return driver.findElement(mensagemSucesso).getText();
    }
}
