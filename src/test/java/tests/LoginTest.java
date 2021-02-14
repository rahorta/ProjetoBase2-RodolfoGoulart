package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "LoginTestData.csv")
public class LoginTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp() {
        navegador = Web.createChrome();
    }

    @Test
    public void testRealizarLogin(@Param(name="login")String username, @Param(name="senha")String password) {
        String usuarioLogado = new LoginPage(navegador)
                .realizarLogin(username, password)
                .screenshot(test.getMethodName())
                .identificarUsuarioLogado();


        assertEquals(username, usuarioLogado);
    }

    @Test
    public void testRealizarLoginInvalido(
            @Param(name="login")String username,
            @Param(name="senha")String password,
            @Param(name="mensagem")String mensagemEsperada) {
        String mensagemFalhaAutenticacao = new LoginPage(navegador)
                .digitarLogin(username)
                .digitarSenha(password)
                .clicarLoginPage()
                .capturarMensagemDeFalhaNoLogin();

        assertEquals(mensagemEsperada, mensagemFalhaAutenticacao);
    }

    @Test
    public void testSolicitarResetDaSenha() {
        String mensagemPasswordEnviada = new LoginPage(navegador)
                .clicarLostYourPassword()
                .resetarSenha("rodolfo.andrade", "rodolfogoulart89@gmail.com")
                .capturarMensagemPasswordResetEnviada();

        assertEquals("Password Message Senta", mensagemPasswordEnviada);
    }

    @After
    public void tearDown() {
        navegador.quit();
    }


}
