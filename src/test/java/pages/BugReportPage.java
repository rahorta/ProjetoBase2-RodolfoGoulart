package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import suporte.Generator;

public class BugReportPage extends BasePage{
    public BugReportPage(WebDriver navegador) {
        super(navegador);
    }

    public BugReportPage selecionarProjeto(String projeto) {
        WebElement campoProjeto = navegador.findElement(By.name("project_id"));
        new Select(campoProjeto).selectByVisibleText(projeto);

        return this;
    }

    public BugReportPage selecionarCategoria(String categoria) {//categoria = "[Todos os Projetos] General"
        WebElement campoCategoria = navegador.findElement(By.name("category_id"));
        new Select(campoCategoria).selectByVisibleText(categoria);

        return this;
    }

    public BugReportPage selecionarFrequencia(String frequencia) {//frequencia = "sempre"
        WebElement campoFrequencia = navegador.findElement(By.name("reproducibility"));
        new Select(campoFrequencia).selectByVisibleText(frequencia);

        return this;
    }

    public BugReportPage selecionarGravidade(String gravidade) {//gravidade = "grande"
        WebElement campoGravidade = navegador.findElement(By.name("severity"));
        new Select(campoGravidade).selectByVisibleText(gravidade);

        return this;
    }

    public BugReportPage selecionarPrioridade(String prioridade) {//prioridade = "alta"
        WebElement campoPrioridade = navegador.findElement(By.name("priority"));
        new Select(campoPrioridade).selectByVisibleText(prioridade);

        return this;
    }

    public BugReportPage selecionarPerfil(String perfil) {//perfil = "Desktop  Windows 10"
        WebElement campoPerfil = navegador.findElement(By.name("profile_id"));
        new Select(campoPerfil).selectByVisibleText(perfil);

        return this;
    }

    public BugReportPage preencherResumoDoBug(int caracteres) {
        navegador.findElement(By.xpath("//input[@name='summary']")).sendKeys(Generator.TextoAleatorio(caracteres));

        return this;
    }

    public BugReportPage preencherDescricaoDoBug(int caracteres) {
        navegador.findElement(By.xpath("//textarea[@name='description']")).sendKeys(Generator.TextoAleatorioComposto(caracteres));

        return this;
    }

    public BugReportPage marcarVisibilidadePublico() {
        WebElement radioPublico = navegador.findElement(By.xpath("//input[@value='10']"));
        radioPublico.click();

        return this;
    }
    public BugReportPage marcarVisibilidadePrivado() {
        WebElement radioPrivado = navegador.findElement(By.xpath("//input[@value='50']"));
        radioPrivado.click();

        return this;
    }

    public BugReportPage enviarArquivo() {
        navegador.findElement(By.id("ufile[]")).sendKeys("C:\\Projetos\\ProjetoBase2\\src\\test\\resources\\LoginTestData.csv");

        return this;
    }

    public BugReportPage preencherRelatorioBug(
            String projeto, String categoria, String frequencia, String gravidade, String prioridade, String perfil,
            int caracteresResumo, int caracteresDescricao) {
        selecionarProjeto(projeto);
        selecionarCategoria(categoria);
        selecionarFrequencia(frequencia);
        selecionarGravidade(gravidade);
        selecionarPrioridade(prioridade);
        selecionarPerfil(perfil);
        preencherResumoDoBug(caracteresResumo);
        preencherDescricaoDoBug(caracteresDescricao);
        marcarVisibilidadePrivado();
        enviarArquivo();

        return this;
    }

    public ViewAllBugPage enviarRelatorioBug() {
        navegador.findElement(By.xpath("//input[@value='Enviar Relatório']")).click();

        return new ViewAllBugPage(navegador);
    }

}
