package com.classic.crmpro.testcases;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class LoginPageTest {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "D:\\Programming\\Automation\\automationFramework.classic.crmpro.com\\src\\SeleniumJarsAndWebDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://fr.cogmento.com");
	}
	@AfterMethod
	public void exitAll() {
		driver.quit();
	}
	@Test (priority = 1)
	public void testUrl() {
		String expectedResult = "https://fr.cogmento.com/";
		String actuelResult = driver.getCurrentUrl();
		Assert.assertEquals(actuelResult,expectedResult,"Failed because links not matches");
	}
	@Test (priority = 2)
	public void testTitle() {
		SoftAssert soft = new SoftAssert();
		String expectedResult = "Cogmento CRM and Business Cloud Solutions";
		String actuelResult = driver.getTitle();
		soft.assertEquals(actuelResult, expectedResult,"Title is not match");
		soft.assertAll();

	}
	@Test (priority = 3)
	public void testLogo() {
		WebElement logo = driver.findElement(By.xpath("//div[@class='rd-navbar-panel']"));
		boolean actuelResult = logo.isDisplayed();
		Assert.assertTrue(actuelResult);
	}
	@Test (priority=4)
	public void testLogin() {
		WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Log In')]"));
		loginButton.click();
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("rahaoui.bilalma@gmail.com");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Bmn123456");
		WebElement loginButton2 = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		loginButton2.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}


}

