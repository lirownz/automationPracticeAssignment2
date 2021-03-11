package godaddy.com;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class goDaddySiteTest extends seleniumSetup{

	@BeforeClass
	public void setUpTest() {
		//setting Chrome driver  	
		super.setUpTest();
	}
	@Test
	public void reSizeWindow(){
		// dimension the Chrome window to 800x600
		Dimension dimension = new Dimension(800, 600);
		driver.manage().window().setSize(dimension);
		// full screen the Chrome window
		driver.manage().window().fullscreen();
		// maximize the Chrome window
		driver.manage().window().maximize();
	}

	@Test
	public void testPageTitle() {
		Assert.assertEquals(driver.getTitle(),"Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IL");
	}

	@Test
	public void testPageURL() {
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.godaddy.com/");
	}

	@Test
	public void testPageSource() {
		//printing page source
		System.out.println(driver.getPageSource());		
	}

	@Test
	public void validateTitleInPageSource() {
		//checking if page source contain the page title
		// using "boolean Assert True" to check if page source contain the wanted string
		boolean titleInPageSource = driver.getPageSource().contains("Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IL");
		Assert.assertTrue(titleInPageSource);
	}
	
	@Test
	public void validateDescriptionInPageSource() {
		//checking if page source contain the page Description
		// using "boolean Assert True" to check if page source contain the wanted string
		boolean descriptionInPageSource = driver.getPageSource().contains("GoDaddy offers domain names, web hosting, online marketing, phone services, web design and an easy to use website builder.");
		Assert.assertTrue(descriptionInPageSource);
	}

	@AfterClass
	public void finishTest() {
		super.quitDriver();
	}		
}
