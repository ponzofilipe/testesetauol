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

    @Dado("que o usuário acessou a página Selenium Easy")
    public void que_o_usuário_acessou_a_página_selenium_easy() {
        MainPage page = new MainPage();
        page.acessar();
    }

    @Quando("o usuário acessa a tabela de Search Demo")
    public void o_usuário_acessa_a_tabela_de_search_demo() {
        WebElement botaoTableMenu = driver.findElement(By.cssSelector("#navbar-brand-centered > ul:nth-child(1) > li:nth-child(2) > a"));
        wait.until(ExpectedConditions.presenceOfElementLocated((By) botaoTableMenu));
        botaoTableMenu.click();

        WebElement botaoSubMenu = driver.findElement(By.cssSelector("#navbar-brand-centered > ul:nth-child(1) > li.dropdown.open > ul > li:nth-child(4) > a"));
        botaoSubMenu.click();

        // Clicar no botão Table sort and Search
        By botaoTableSortSearchSeletor = By.cssSelector(".dropdown-menu > li:nth-child(4)");
        wait.until(ExpectedConditions.presenceOfElementLocated(botaoTableSortSearchSeletor));

        WebElement botaoTableSortSearch = botaoTableMenu.findElement(botaoTableSortSearchSeletor);
        botaoTableSortSearch.click();
    }
    @Quando("pesquisa pelo nome {string}")
    public void pesquisa_pelo_nome(String string) {
        // Digitar um texto no campo de busca da tabela
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#example")));
        By seletorSearchInput = By.cssSelector("#example_filter input");
        driver.findElement(seletorSearchInput).sendKeys(string);
    }
    @Então("devo visualizar o nome {string} na tabela")
    public void devo_visualizar_o_nome_na_tabela(String string) {
        // Aguardar a tabela ser filtrada
        By seletorMensagemShowing = By.cssSelector("#example_info");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(seletorMensagemShowing, "filtered"));

        // Validar a quantidade de linhas pós filtragem
        String nomeTabela = driver.findElement(By.cssSelector("#example > tbody > tr > td.sorting_1")).getText();
        //int quantidadeRealLinhasTabela = driver.findElements(By.cssSelector("#example tbody tr")).size();

        assertEquals(
                nomeTabela,
                "A. Cox",
                "Nome não existe na tebela");
    }

}
