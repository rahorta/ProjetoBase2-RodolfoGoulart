package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LostPasswordPage extends BasePage{
    public LostPasswordPage(WebDriver navegador) {
        super(navegador);
    }

    public LostPasswordPage digitarUsername(String username) {
        navegador.findElement(By.xpath("//input[@name='username']")).sendKeys(username);

        return this;
    }

    public LostPasswordPage digitarEmail(String email) {
        navegador.findElement(By.xpath("//input[@name='email']")).sendKeys(email);

        return this;
    }

    public LostPasswordPage clicarSubmit() {
        navegador.findElement(By.xpath("//input[@value='Submit']")).click();

        return this;
    }

    public LostPasswordPage resetarSenha(String username, String email) {
        digitarUsername(username);
        digitarEmail(email);
        clicarSubmit();

        return this;
    }

    public String capturarMensagemPasswordResetEnviada() {
        return navegador.findElement(By.xpath("//table//following-sibling::b")).getText();
    }
}
