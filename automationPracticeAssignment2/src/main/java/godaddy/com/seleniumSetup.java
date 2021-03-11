package godaddy.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumSetup {

	protected WebDriver driver;
	
	void setupWebDriverForTesting(WebDriver driver) {
		this.driver = driver;
	}

	public void setUpTest() {
		//setting Chrome driver from Maven  
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.godaddy.com/");
	}
	
	public void quitDriver() {
		//setting Chrome driver to quit after finishing all tests
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
	}
}
