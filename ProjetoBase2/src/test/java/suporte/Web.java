package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver createChrome() {
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        //navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Navegando para a página de teste
        navegador.get("https://mantis-prova.base2.com.br/login_page.php");

        return navegador;
    }

}
