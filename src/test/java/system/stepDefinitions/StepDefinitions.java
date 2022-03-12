package system.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Então;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;
import system.pages.MainPage;
import system.pages.MenuUolPage;
import system.pages.ValorAssinaturaPage;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StepDefinitions {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void before(){
        this.driver = DriverManager.getDriver();
        this.wait = DriverManager.getDriverWait();
        driver.manage().window().maximize();
        System.out.println("Before");
    }

    @After
    public void after(){
        System.out.println("After");
        DriverManager.quitDriver();
    }

    MenuUolPage menu = new MenuUolPage();
    ValorAssinaturaPage valorAssinaturaPage = new ValorAssinaturaPage();


    ///***Cenarios***

    @Dado("que estou na tela inicial do UOL Notícias")
    public void queEstouNaTelaInicialDoUOLNotícias() {
        MainPage page = new MainPage();
        page.acessar();
    }
    @Quando("realiza o busca pelo conteúdo {string}")
    public void realizaOBuscaPeloConteúdo(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Então("exibe tela com o resultado da busca")
    public void exibeTelaComOResultadoDaBusca() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




    @Quando("preencho o formulário de {string}")
    public void preenchoOFormulárioDe(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Então("exibe na tela mensagem de sucesso")
    public void exibeNaTelaMensagemDeSucesso() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @Quando("altero a previsão do tempo para a cidade {string}")
    public void alteroAPrevisãoDoTempoParaACidade(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Então("exibe a previsão do tempo de {string}")
    public void exibeAPrevisãoDoTempoDe(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




    @Quando("seleciono area do bate-papo uol")
    public void selecionoAreaDoBatePapoUol() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Quando("seleciono salas")
    public void selecionoSalas() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Então("exibe salas disponiveis")
    public void exibeSalasDisponiveis() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Então("categorias")
    public void categorias() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




    @Quando("Verifico o valor da assinatura da pagina")
    public void verificoOValorDaAssinaturaDaPagina() {
        menu.ClicaAbaProdutos();
    }

    @Então("devo visualizar a assinatura promocional a {string}")
    public void devoVisualizarAAssinaturaPromocionalA(String string) {
        String valor = valorAssinaturaPage.GetValorAssinatura();
        assertEquals(valor, string, "Valor diferente do plano");
    }



}
