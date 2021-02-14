package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;

public class ReportBugTest {
    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = Web.createChrome();
    }

    @Test
    public void reportarNovoBug() {
        new LoginPage(navegador)
                .realizarLogin("rodolfo.andrade", "rodolfo123")
                .irParaPaginaSelecaoProjeto()
                .irParaPaginaBugReport()
                .preencherRelatorioBug("ProjetoTreinamentoTati",
                        "[Todos os Projetos] General",
                        "sempre",
                        "grande",
                        "alta",
                        "Desktop  Windows 10",
                        10, 10)
                .enviarRelatorioBug();
    }

    @After
    public void tearDown() {
        navegador.quit();
    }


}
