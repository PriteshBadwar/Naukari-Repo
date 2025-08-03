package pompage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	static WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"usernameField\"]")
	WebElement userName;
	@FindBy(xpath = "//*[@id=\"passwordField\"]")
	WebElement passWord;
	@FindBy(xpath = "//*[@class=\"waves-effect waves-light btn-large btn-block btn-bold blue-btn textTransform\"]")
	WebElement loginButton;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterDetails()
	{
		userName.sendKeys("pallubadwar777@gmail.com");
		passWord.sendKeys("Palluloveme09@");
		loginButton.click();
	}
	
	
}
