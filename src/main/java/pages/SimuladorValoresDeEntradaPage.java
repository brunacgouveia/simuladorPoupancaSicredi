package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;

public class SimuladorValoresDeEntradaPage{
	
	@FindBy(id="valorAplicar")
	private WebElement textValorAplicado;
	
	@FindBy(id="valorInvestir")
	private WebElement textValorPoupado;
	
	@FindBy(id="tempo")
	private WebElement textTempoAplicado;
	
	@FindBy(className="btSelect")
	private WebElement comboMesAno;
	
	@FindBy(xpath="//ul[@class='listaSelect' and @style='display: block;']//a[@rel='A']")
	private WebElement opcaoAno;
	
	@FindBy(xpath="//ul[@class='listaSelect' and @style='display: block;']//a[@rel='M']")
	private WebElement opcaoMes;
	
	@FindBy(xpath="//button[contains(@class,'btnSimular')]")
	private WebElement btnSimular;
		
	@FindBy(xpath="//a[contains(@class,'btnLimpar')]")
	private WebElement linkLimparFormulario;	
	
	
	private WebDriverWait wait;	
	
	public SimuladorValoresDeEntradaPage() {
		WebDriver driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, 1);
		PageFactory.initElements(driver, this);
	}

	public void preencherValorAplicado(String valorAplicado) {
		textValorAplicado.clear();
		textValorAplicado.sendKeys(valorAplicado);
	}
	
	public void preencherValorPoupado(String valorPoupado) {
		textValorPoupado.clear();
		textValorPoupado.sendKeys(valorPoupado);
	}
	
	public void preencherTempoAplicado(String tempoAplicado) {
		textTempoAplicado.clear();
		textTempoAplicado.sendKeys(tempoAplicado);
	}
	
	public void selecionarMes() {
		comboMesAno.click();
		opcaoMes.click();
	}
	
	public void selecionarAno() {
		comboMesAno.click();
		opcaoAno.click();
	}
	
	public void clicarBotaoSimular() {
		btnSimular.click();
	}
	
	public void clicarLinkLimparFormulario() {
		linkLimparFormulario.click();
	}
	
	public boolean isMensagemTempoObrigatorio() {
		try {
			wait.withTimeout(Duration.ofSeconds(1));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='tempo-error' and not(@style='display: none;') and text()='Obrigatório']")));
			return true;
	    }
	    catch(TimeoutException error) {
	    	return false;
	    }
	}
	
	public boolean isMensagemValorAplicadoMinimo() {
		try {
			//wait.withTimeout(Duration.ofSeconds(1));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='valorAplicar-error' and not(@style='display: none;') and text()='Valor mínimo de 20.00']")));
			return true;
	    }
	    catch(TimeoutException error) {
	    	return false;
	    }		
	}

	public boolean isMensagemValorPoupadoMinimo() {
		try {
			wait.withTimeout(Duration.ofSeconds(1));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='valorInvestir-error' and not(@style='display: none;') and text()='Valor mínimo de 20.00']")));
			return true;
	    }
	    catch(TimeoutException error) {
	    	return false;
	    }		
	}
	
	public boolean isPaginaValoresDeEntrada() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='formularioBloco']")));
			return true;
		}
		catch(TimeoutException error) {
			return false;
		}				
	}
	
}
