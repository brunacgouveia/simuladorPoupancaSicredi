package driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Esta classe faz o gerenciamento do driver (browser): inicializa, fecha etc
 * 
 * @author Bruna Gouveia
 *
 */

public class DriverFactory {
	public static WebDriver driver;

	public DriverFactory() {
		driver = null;
	}
	
	public static void startDriver() {
		initializeChromeDriver();
	}
	
	public static void close() {
		driver.close();
		driver = null;
	}
	
	public static WebDriver getDriver() {
		if(driver == null)
			initializeChromeDriver();
		return driver;
	}
	
	public static void accessURL(String url){		
		try {	
			driver.navigate().to(url);
		} 
		catch (UnhandledAlertException f) {
			try{
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("Alert data: " + alertText);
				alert.dismiss();
			} catch (NoAlertPresentException e) {
				e.printStackTrace();
				driver.navigate().to(url);
			}
		}
	}
	
    private static void initializeChromeDriver() {    	
    	Proxy proxy = new Proxy();
        proxy.setProxyType(ProxyType.SYSTEM);
    	    	
    	ChromeOptions options = new ChromeOptions();
    	options.setCapability("proxy", proxy);
    	
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver(options);
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
    	driver.manage().window().maximize();
    }
	
}
