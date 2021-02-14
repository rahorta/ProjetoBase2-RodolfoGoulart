package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import suporte.Generator;
import suporte.Screenshot;

public class BasePage {
    protected WebDriver navegador;

    public BasePage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public BasePage screenshot(String nomeMetodo) {
        String screenshotArquivo = "./screenshot/" + Generator.dataHoraParaArquivo() + "_" + nomeMetodo + ".png";
        Screenshot.tirarPrint(navegador, screenshotArquivo);

        return this;
    }

    public String identificarUsuarioLogado() {
        return navegador.findElement(By.xpath("//table[@class='hide']//td[@class='login-info-left']//following-sibling::span[@class='italic']")).getText();
    }

    public MyViewPage irParaPaginaMinhaVisao() {
        navegador.findElement(By.linkText("Minha visão")).click();

        return new MyViewPage(navegador);
    }

    public ViewAllBugPage irParaPaginaVerCasos() {
        navegador.findElement(By.linkText("Ver Casos")).click();

        return new ViewAllBugPage(navegador);
    }

    public SelecaoProjetoPage irParaPaginaSelecaoProjeto() {
        navegador.findElement(By.linkText("Relatar Caso")).click();

        return new SelecaoProjetoPage(navegador);
    }

    public AccountPage irParaPaginaMinhaConta() {
        navegador.findElement(By.linkText("Minha Conta")).click();

        return new AccountPage(navegador);
    }

    public LoginPage fazerLogout() {
        navegador.findElement(By.linkText("Sair")).click();

        return new LoginPage(navegador);
    }

}
