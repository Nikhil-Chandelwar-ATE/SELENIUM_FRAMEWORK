package com.generic_Utilities;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.objectRepository.HomePage;
import com.objectRepository.LoginPage;
import com.objectRepository.WelcomePage;

public class BaseTest {

	public WebDriver driver;
	public static WebDriver sDriver;
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("chrome") String browser) {
		
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		sDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(FileUtility.getDataFromPropertiesFile("url"));
	}
	
	@BeforeMethod(alwaysRun = true)
	public void loginToDWS(Method method) {
		
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		LoginPage lp = new LoginPage(driver);
		lp.getEmailTextField().sendKeys(FileUtility.getDataFromPropertiesFile("email"));
		lp.getPasswordTextField().sendKeys(FileUtility.getDataFromPropertiesFile("password"));
		lp.getLoginButton().click();
	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutFromDWS() {
		HomePage hp = new HomePage(driver);
		hp.getLogoutLink().click();
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
}