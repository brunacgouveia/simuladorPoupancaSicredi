
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import driver.DriverFactory;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;	

@RunWith(Cucumber.class)				
@CucumberOptions(features="src/test/resources/features")	
	
public class TestRunner {
	
	
	@BeforeClass
	public static void start() {
		System.out.println("Iniciando driver...");
		DriverFactory.startDriver();
		DriverFactory.accessURL("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
	}

	
	@AfterClass
	public static void tearDown() {
		System.out.println("Fechando driver...");
		DriverFactory.close();
	}
	
}


