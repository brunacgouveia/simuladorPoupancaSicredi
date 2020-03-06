package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;

public class SimuladorResultadoPage {
	
	@FindBy(xpath="//a[contains(@class,'btnRefazer')]")
	private WebElement btnRefazerSimulacao;
	
	@FindBy(xpath="//div[@class='blocoResultadoSimulacao']/span[@class='texto']/strong")
	private WebElement labelMesesAplicado;
	
	@FindBy(xpath="//div[@class='blocoResultadoSimulacao']/span[@class='valor']")
	private WebElement labelValorTotal;
	
		
	private WebDriverWait wait;
	
	public SimuladorResultadoPage() {
		WebDriver driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);
	}
	
	public boolean isPaginaResultado() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'formularioBlocoResultado')]")));
			return true;
	    }
	    catch(TimeoutException error) {
	    	return false;
	    }	
	}
	
	public void clicarBotaoRefazerSimulacao() {
		btnRefazerSimulacao.click();
	}
	
	public String capturarMesesAplicados() {
		return labelMesesAplicado.getText();
	}
	
	public String capturarValorTotal() {
		return labelValorTotal.getText();
	}
	
	public boolean isTabelaMesValor() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='blocoResultadoSimulacao']/div[@class='maisOpcoes']")));
			return true;
	    }
	    catch(TimeoutException error) {
	    	return false;
	    }	
	}

}
