package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    public MyViewPage clicarLogin() {
        navegador.findElement(By.xpath("//input[@class='button']")).click();

        return new MyViewPage(navegador);
    }

    public LoginPage clicarLoginPage() {
        navegador.findElement(By.xpath("//input[@class='button']")).click();

        return this;
    }

    public LoginPage digitarSenha(String senha) {
        navegador.findElement(By.xpath("//input[@name='password']")).sendKeys(senha);

        return this;
    }

    public LoginPage digitarLogin(String login) {
        navegador.findElement(By.xpath("//input[@name='username']")).sendKeys(login);

        return this;
    }

    public MyViewPage realizarLogin(String login, String senha) {
        digitarLogin(login);
        digitarSenha(senha);
        clicarLogin();

        return new MyViewPage(navegador);
    }

    public String capturarMensagemDeFalhaNoLogin() {
        return navegador.findElement(By.xpath("//div[@align='center']/font[@color='red']")).getText();
    }

    public LostPasswordPage clicarLostYourPassword() {
        navegador.findElement(By.linkText("Lost your password?")).click();

        return new LostPasswordPage(navegador);
    }
}
