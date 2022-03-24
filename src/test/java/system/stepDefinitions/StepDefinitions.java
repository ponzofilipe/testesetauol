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
import system.pages.*;

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
    public void realizaOBuscaPeloConteúdo(String string)  {
        //Thread.sleep(1000);
        menu.inputBuscaDados("Brasil");
    }

    @Então("exibe tela de busca")
    public void exibeTelaComOResultadoDaBusca() {
        System.out.println(driver.getCurrentUrl());
        assertEquals(driver.getCurrentUrl(),"https://www.uol.com.br/");
    }

    @Quando("preencho o formulário de {string}")
    public void preenchoOFormulárioDe(String string) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        MainPage page = new MainPage();
        ComunicarErrorPage comunicarErro = new ComunicarErrorPage();
        Thread.sleep(6000);
        page.clicarBotaoComunicarErro();
        comunicarErro.preencherFormulario();
    }
    @Então("exibe na tela mensagem de sucesso")
    public void exibeNaTelaMensagemDeSucesso() {
        ComunicarErrorPage comunicarErro = new ComunicarErrorPage();
        String mensagemExibida = comunicarErro.getMensagemSucesso();
        comunicarErro.confirmarMensagemSucessoExibida(mensagemExibida);
    }

    @Quando("altero a previsão do tempo para a cidade {string}")
    public void alteroAPrevisãoDoTempoParaACidade(String cidade) {
        PrevisaoTempoMenuPage previsaoTempoMenuPage = new PrevisaoTempoMenuPage(this.driver, this.wait);
        previsaoTempoMenuPage.clicarNoIconePesquisa();
        previsaoTempoMenuPage.digitarNoInputPesquisaCidade(cidade);
        previsaoTempoMenuPage.clicarNaCidade(cidade);
    }
    @Então("exibe a previsão do tempo de {string}")
    public void exibeAPrevisãoDoTempoDe(String cidade) {
        PrevisaoTempoMenuPage previsaoTempoMenuPage = new PrevisaoTempoMenuPage(this.driver, this.wait);
        assertEquals(cidade, previsaoTempoMenuPage.obterNomeDaCidadeNaPrevisaoTempo());
    }

    @Quando("seleciono area do bate-papo uol")
    public void selecionoAreaDoBatePapoUol() {
        menu.ClicaAbaBatePapo();
        //menu.closePopupBatePapo();
    }
    @Quando("seleciono salas")
    public void selecionoSalas() {
        menu.ClicaAreaSalasPopUp();
        menu.ClicaAreaSalas();
    }
    @Então("exibe salas disponiveis")
    public void exibeSalasDisponiveis() {
//        String salasbatepapo = menu.GetVerificaSalasCat1();
        //assertEquals(salasbatepapo, "Camarote", "Categoria não encontrada");
    }
    @Então("exibe uma opção de experimentar por sete dias gratis")
    public void verificoplanogratis() {
        String valor = menu.GetVerificaPlanoSeteDias();
        assertEquals(valor, "Experimente 7 dias grátis", "Valor diferente do plano");
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
