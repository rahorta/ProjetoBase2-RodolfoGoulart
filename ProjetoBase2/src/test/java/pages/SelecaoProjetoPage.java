package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelecaoProjetoPage extends BasePage{
    public SelecaoProjetoPage(WebDriver navegador) {
        super(navegador);
    }


    public BugReportPage irParaPaginaBugReport() {
        navegador.findElement(By.xpath("//input[@value='Selecionar Projeto']")).click();

        return new BugReportPage(navegador);
    }
}
