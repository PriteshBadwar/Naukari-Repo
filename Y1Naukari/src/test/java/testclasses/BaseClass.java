package testclasses;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pompage.DeleteResume;
import pompage.LoginPage;

public class BaseClass {
	
	static WebDriver driver;
	static LoginPage lp;
	static DeleteResume dr;
	@BeforeSuite
	public void InItBrowser()
	{
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://www.naukri.com/mnjuser/profile");
	}
	
	
	@BeforeClass
	public void callingObjects()
	{
		 lp = new LoginPage(driver);
		 dr = new DeleteResume(driver);
	}
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
}
