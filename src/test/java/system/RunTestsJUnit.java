package system;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;
import system.pages.MainPage;
import system.pages.LeftMenuPage;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RunTestsJUnit {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void before() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
    }

    @AfterEach
    void after() {
        DriverManager.quitDriver();
    }

    @Disabled("...")
    @Test
    void atividade13() throws InterruptedException {
        System.out.println("***** ATIVIDADE 13 *****");

        driver.get("https://demo.seleniumeasy.com/input-form-demo.html");

        WebElement formulario = driver.findElement(By.cssSelector("#contact_form"));
        WebElement firstName = formulario.findElement(By.cssSelector("[name='first_name']"));
        WebElement state = formulario.findElement(By.cssSelector("[name='state']"));
        WebElement hostingYes = formulario.findElement(By.cssSelector(".radio input"));
        WebElement botaoSend = formulario.findElement(By.cssSelector("[type='submit']"));

        firstName.sendKeys("Maria Fernanda");
        state.sendKeys("Arizona");
        hostingYes.click();
        botaoSend.click();
        Thread.sleep(2000);
    }

    @Disabled("...")
    @Test
    void atividade14() {
        System.out.println("***** ATIVIDADE 14 *****");

        driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");

        WebElement umaLinhaQualquer = driver.findElement(By.cssSelector("#task-table tbody tr:nth-child(4)"));
        System.out.println(umaLinhaQualquer.getText());
    }

    @Disabled("...")
    @Test
    void atividade15() {
        System.out.println("***** ATIVIDADE 15 *****");

        driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");

        WebElement tabela = driver.findElement(By.cssSelector("#task-table"));
        WebElement cabecalhoTerceiraColuna = tabela.findElement(By.cssSelector("tr th:nth-child(3)"));
        List<WebElement> corpoTerceiraColuna = tabela.findElements(By.cssSelector("tr td:nth-child(3)"));

        System.out.println(cabecalhoTerceiraColuna.getText());

        for (WebElement item : corpoTerceiraColuna) {
            System.out.println(item.getText());
        }
    }

    @Disabled("...")
    @Test
    void atividade16() throws InterruptedException{
        System.out.println("***** ATIVIDADE 16 *****");

        driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");

        WebElement botaoFiltro = driver.findElement(By.cssSelector(".filterable button"));
        WebElement filtroUserName = driver.findElement(By.cssSelector(".filters th:nth-child(2) input"));
        WebElement filtroLastName = driver.findElement(By.cssSelector(".filterable .filters th:nth-child(4) input"));

        botaoFiltro.click();
        filtroUserName.sendKeys("c");
        filtroLastName.sendKeys("ano");

        WebElement primeiraLinhaPosFiltro = driver.findElement(By.cssSelector(".filterable tbody tr:not([style])"));
        System.out.println(primeiraLinhaPosFiltro.getText());
        Thread.sleep(2000);
    }

    @Disabled("...")
    @Test
    void atividade17() throws InterruptedException{
        System.out.println("***** ATIVIDADE 17 *****");

        driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");

        WebElement followAllBotao = driver.findElement(By.cssSelector("#followall"));


        System.out.println(driver.getWindowHandles().size());
        followAllBotao.click();
        System.out.println(driver.getWindowHandles().size());

        for(String janela : driver.getWindowHandles()){
            driver.switchTo().window(janela);
            System.out.println(driver.getTitle());
            driver.close();
            Thread.sleep(1000);
        }
    }

    @Disabled("...")
    @Test
    void atividade18() throws InterruptedException {
        System.out.println("***** ATIVIDADE 18 *****");

        driver.get("https://www.saucedemo.com");

        // login
        List<WebElement> camposLogin = driver.findElements(By.cssSelector(".login-box .form_group input"));
        WebElement botaoLogin = driver.findElement(By.cssSelector("#login-button"));

        camposLogin.get(0).sendKeys("standard_user");
        camposLogin.get(1).sendKeys("secret_sauce");
        botaoLogin.click();

        // resto da atividade
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        WebElement quintoProduto = driver.findElement(By.cssSelector(".inventory_list .inventory_item:nth-child(5)"));
        WebElement nomeQuintoProduto = quintoProduto.findElement(By.cssSelector(".inventory_item_name"));
        WebElement precoQuintoProduto = quintoProduto.findElement(By.cssSelector(".inventory_item_price"));

        System.out.println(nomeQuintoProduto.getText());
        System.out.println(precoQuintoProduto.getText());
    }

    //

    @Disabled("...")
    @Test
    void atividade19() {
        System.out.println("***** ATIVIDADE 19 *****");

        driver.get("https://www.saucedemo.com");

        // login
        List<WebElement> camposLogin = driver.findElements(By.cssSelector(".login-box .form_group input"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        camposLogin.get(0).sendKeys("standard_user");
        camposLogin.get(1).sendKeys("secret_sauce");
        loginButton.click();

        // atividade
        try {
            driver.findElement(By.cssSelector(".shopping_cart_badge"));
        } catch (Exception e) {
            System.out.println(e.getClass());
        }

    }

    @Disabled("...")
    @Test
    void atividade20() {
        System.out.println("***** ATIVIDADE 20 *****");

        driver.get("https://www.saucedemo.com");

        // login
        List<WebElement> camposLogin = driver.findElements(By.cssSelector(".login-box .form_group input"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        camposLogin.get(0).sendKeys("standard_user");
        camposLogin.get(1).sendKeys("secret_sauce");
        loginButton.click();

        // atividade
        try {
            driver.findElement(By.cssSelector("#logout_sidebar_link")).click();
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }

    @Disabled("...")
    @Test
    void atividade21() {
        System.out.println("***** ATIVIDADE 21 *****");

        driver.get("https://www.saucedemo.com/inventory.html");

        // login
        List<WebElement> camposLogin = driver.findElements(By.cssSelector(".login-box .form_group input"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        camposLogin.get(0).sendKeys("standard_user");
        camposLogin.get(1).sendKeys("secret_sauce");
        loginButton.click();

        // atividade
        try {
            driver.findElement(By.cssSelector(".shopping_cart_link"));
        } catch (Exception e) {
            System.out.println(e.getClass());
        }

    }

    @Disabled("...")
    @Test
    void atividade22() {
        System.out.println("***** ATIVIDADE 22 *****");

        driver.get("https://www.saucedemo.com/inventory.html");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // login
        List<WebElement> camposLogin = driver.findElements(By.cssSelector(".login-box .form_group input"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        camposLogin.get(0).sendKeys("standard_user");
        camposLogin.get(1).sendKeys("secret_sauce");
        loginButton.click();

        // atividade
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".shopping_cart_badge")));
            driver.findElement(By.cssSelector(".shopping_cart_badge"));
        } catch (Exception e) {
            System.out.println(e.getClass());
            WebElement botaoAddProduto = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
            botaoAddProduto.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".shopping_cart_badge")));
            WebElement badgeCarrinho = driver.findElement(By.cssSelector(".shopping_cart_badge"));
            System.out.println(badgeCarrinho.getText());
        }

    }

    @Disabled("...")
    @Test
    void atividade23() {
        System.out.println("***** ATIVIDADE 23 *****");

        driver.get("https://demo.seleniumeasy.com/ajax-form-submit-demo.html");

        WebElement inputNome = driver.findElement(By.cssSelector("[name='title']"));
        WebElement inputComentario = driver.findElement(By.cssSelector("#description"));
        WebElement botaoSubmit = driver.findElement(By.cssSelector("[name='btn-submit']"));
        By seletorLoading = By.cssSelector("#submit-control img");
        By seletorMensagemSucesso = By.cssSelector("#submit-control");

        inputNome.sendKeys("esse e o nome");
        inputComentario.sendKeys("esse e o comentario");
        botaoSubmit.click();

//        wait.until(ExpectedConditions.stalenessOf(driver.findElement(seletorLoading)));
//        System.out.println(driver.findElement(seletorMensagemSucesso).getText());

        wait.until(ExpectedConditions.textToBe(seletorMensagemSucesso, "Form submited Successfully!"));
        System.out.println(driver.findElement(seletorMensagemSucesso).getText());
    }


    //

    @Disabled("...")
    @Test
    void atividade24() {
        System.out.println("***** ATIVIDADE 24 *****");

        driver.get("https://demo.seleniumeasy.com/input-form-demo.html");

        By projectDescriptionSelector = By.cssSelector("#contact_form [name='comment']");
        By emailFieldSelector = By.cssSelector("[name='email']");
        By emailFieldErrorSelector = By.cssSelector("[data-bv-validator='emailAddress']");
        By sendBtnSelector = By.cssSelector(".form-group:last-child [type='submit']");
        String descriptionText = "menos10";

        driver.findElement(projectDescriptionSelector).sendKeys(descriptionText);

        assertEquals(
                descriptionText,
                driver.findElement(projectDescriptionSelector).getAttribute("value"),
                "A descrição está correta"
        );

        assertFalse(
                driver.findElement(sendBtnSelector).isEnabled(),
                "O botão 'send' não está habilitado, pois a descrição tem menos de 10 caracteres"
        );

        driver.findElement(emailFieldSelector).sendKeys("lala@dsad");

        assertAll("Validar o tratamento de de erro do email",
                () -> assertTrue(
                        driver.findElement(emailFieldErrorSelector).isDisplayed(),
                        "A msg de erro do email é mostrada"),

                () -> assertEquals(
                        "Please supply a valid email address",
                        driver.findElement(emailFieldErrorSelector).getText(),
                        "O texto da mensagem de erro do email está correto"
                )
        );
    }

    @Disabled("...")
    @Test
    void atividade25(){
        System.out.println("***** ATIVIDADE 25 *****");

        driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");

        WebElement qualquerLinhaTabela = driver.findElement(By.cssSelector("#task-table tbody tr:nth-child(4)"));
        String assigneeName = "Emily John";

        assertTrue(
                qualquerLinhaTabela.getText().contains(assigneeName),
                "A quarta linha da tabela contém o assignee " + assigneeName);
    }

    @Disabled("...")
    @Test
    void atividade26() {
        System.out.println("***** ATIVIDADE 26 *****");

        driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");

        WebElement tabela = driver.findElement(By.id("task-table"));
        WebElement cabecalhoTerceiraColuna = tabela.findElement(By.cssSelector("thead tr th:nth-child(3)"));
        List<WebElement> terceiraColuna = tabela.findElements(By.cssSelector("tbody tr td:nth-child(3)"));
        List<String> esperadoTerceiraColuna = Arrays.asList("John Smith", "Mike2 Trout", "Loblab Dan", "Emiqly John");

        assertEquals(
                "Assignee",
                cabecalhoTerceiraColuna.getText(),
                "O cabeçalho da terceira coluna é 'Assignee'");

        assertAll("O conteúdo da terceira coluna está correto",
                () -> assertEquals(
                        esperadoTerceiraColuna.get(0),
                        terceiraColuna.get(0).getText(),
                        "A primeira linha da terceira coluna tem o valor correto"),
                () -> assertEquals(
                        esperadoTerceiraColuna.get(1),
                        terceiraColuna.get(1).getText(),
                        "A segunda linha da terceira coluna tem o valor correto"),
                () -> assertEquals(
                        esperadoTerceiraColuna.get(2),
                        terceiraColuna.get(2).getText(),
                        "A terceira linha da terceira coluna tem o valor correto"),
                () -> assertEquals(
                        esperadoTerceiraColuna.get(3),
                        terceiraColuna.get(3).getText(),
                        "A quarta linha da terceira coluna tem o valor correto")
        );
    }

    @Disabled("...")
    @Test
    void atividade27() throws InterruptedException {
        System.out.println("***** ATIVIDADE 27 *****");

        driver.get("https://demo.seleniumeasy.com");

        // Fechar popup
        By popupJanela = By.cssSelector(".at-cm-no-button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(popupJanela));
        driver.findElement(popupJanela).click();

        // Clicar no botão Table
        WebElement botaoTableMenu = driver.findElement(By.cssSelector("#navbar-brand-centered .nav > li:nth-child(3)"));
        botaoTableMenu.click();

        // Clicar no botão Table sort and Search
        By botaoTableSortSearchSeletor = By.cssSelector(".dropdown-menu > li:nth-child(4)");
        wait.until(ExpectedConditions.presenceOfElementLocated(botaoTableSortSearchSeletor));

        WebElement botaoTableSortSearch = botaoTableMenu.findElement(botaoTableSortSearchSeletor);
        botaoTableSortSearch.click();

        // Digitar um texto no campo de busca da tabela
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#example")));
        By seletorSearchInput = By.cssSelector("#example_filter input");
        driver.findElement(seletorSearchInput).sendKeys("London");

        // Aguardar a tabela ser filtrada
        By seletorMensagemShowing = By.cssSelector("#example_info");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(seletorMensagemShowing, "filtered"));

        // Validar a quantidade de linhas pós filtragem
        int quantidadeEsperadaLinhasTabela = 7;
        int quantidadeRealLinhasTabela = driver.findElements(By.cssSelector("#example tbody tr")).size();

        assertEquals(
                quantidadeEsperadaLinhasTabela,
                quantidadeRealLinhasTabela,
                "Depois de filtrada por 'London' a tabela mostra 7 resultados");

        Thread.sleep(4000);
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "Emily John, 4",
            "Holden Charles, 5",
            "John Smith, 1"
    })
    void atividade28(String nome, int numLinha) {
        System.out.println("***** ATIVIDADE 28 *****");

        driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");

        WebElement qualquerLinhaTabela =
                driver.findElement(By.cssSelector("#task-table tbody tr:nth-child(" + numLinha + ")"));

        assertTrue(qualquerLinhaTabela.getText().contains(nome),
                "A linha " + numLinha + " da tabela contém o assignee " + nome);
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "Emily John, 4",
            "Holden Charles, 5",
            "John Smith, 1"
    })
    void atividade28ExtraCsv(String nome, int numLinha) {
        System.out.println("***** ATIVIDADE 28 *****");

        driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");

        WebElement qualquerLinhaTabela =
                driver.findElement(By.cssSelector("#task-table tbody tr:nth-child(" + numLinha + ")"));

        assertTrue(qualquerLinhaTabela.getText().contains(nome),
                "A linha " + numLinha + " da tabela contém o assignee " + nome);
    }

    @Disabled
    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/system/resources/data/nome-idade.csv", numLinesToSkip = 1)
    void atividade28ExtraCsvComArquivo(String nome, int numLinha) {
        System.out.println("***** ATIVIDADE 28 *****");

        driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");

        WebElement qualquerLinhaTabela =
                driver.findElement(By.cssSelector("#task-table tbody tr:nth-child(" + numLinha + ")"));

        assertTrue(qualquerLinhaTabela.getText().contains(nome),
                "A linha " + numLinha + " da tabela contém o assignee " + nome);
    }


    //

    @Test
    void atividades29e30() throws InterruptedException {
        // Opcao 1
        MainPage paginaPrincipal = new MainPage();
        LeftMenuPage leftMenu = new LeftMenuPage();

        paginaPrincipal.acessar();
        leftMenu.clicarBotaoTable();

        // Opcao 2
        // MainPage paginaPrincipal = new MainPage();
        //paginaPrincipal.acessar().leftMenu().clicarBotaoTable();
    }
}
