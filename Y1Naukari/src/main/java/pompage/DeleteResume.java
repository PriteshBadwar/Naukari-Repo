package pompage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteResume {
	static WebDriver driver;
	@FindBy(xpath = "//*[@class=\"view-profile-wrapper\"]")
	WebElement openProfile;
	@FindBy(xpath = "//*[contains(text(),'deleteOneTheme')]")
	WebElement deleteButton;
	@FindBy(xpath = "//*[@class=\"lightbox model_open flipOpen\"]/descendant::button[text()=\"Delete\"]")
    WebElement deletePopup;	
	@FindBy(xpath = "//input[@id=\"attachCV\"]")
	WebElement uploadResume;
	
	@FindBy(xpath = "//*[@id=\"lazyResumeHead\"]/descendant::span[text()='editOneTheme']")
	WebElement resumeHeadline;

	 @FindBy(id = "resumeHeadlineTxt")
	 WebElement resumeHeadlineTextArea;

	 @FindBy(xpath = "//button[text()='Save']")
	 WebElement saveHeadlineButton;
	 
	 @FindBy (xpath = "//*[@id=\"lazyKeySkills\"]/descendant::span[text()='editOneTheme']")
	 WebElement keySkills;
	 
	 @FindBy(xpath = "//*[@class=\"chipsContainer\"]/descendant::div[@title=\"BBT\"]/descendant::a[text()='Cross']")
	 WebElement keySkillPopup;
	 
	 @FindBy(xpath = "//*[@id=\"saveKeySkills\"]")
	 WebElement keySkillSaveButton;
	 
	
	public DeleteResume(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	public void deleteProfile()
	{
		openProfile.click();
		
		deleteButton.click();
		deletePopup.click();
	//    uploadResume.click();
		 uploadResume.sendKeys("C:\\Users\\Admin\\Downloads\\Pritesh_3.7_Exp.pdf.pdf.pdf");//new path;
//		Actions actions = new Actions(driver);
//		actions.moveToElement(uploadResume).click().perform();
		}
	
	public void resumeHeadline()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Step 1: Wait for visibility and scroll into view first
	    wait.until(ExpectedConditions.visibilityOf(resumeHeadline));
	    js.executeScript("arguments[0].scrollIntoView(true);", resumeHeadline);

	    // Step 2: Wait until clickable
	    wait.until(ExpectedConditions.elementToBeClickable(resumeHeadline));

	    // Step 3: Click using JavaScript
	    js.executeScript("arguments[0].click();", resumeHeadline);

	    // Step 4: Edit headline
	    wait.until(ExpectedConditions.visibilityOf(resumeHeadlineTextArea));
	    js.executeScript("arguments[0].scrollIntoView(true);", resumeHeadlineTextArea);

	    String oldText = resumeHeadlineTextArea.getAttribute("value");

	    if (oldText.contains("jenkins.")) {
	        oldText = oldText.replace("jenkins.", "");
	    }
	    String newText = oldText.trim() + " jenkins.";

	    resumeHeadlineTextArea.clear();
	    resumeHeadlineTextArea.sendKeys(newText);

	    // Step 5: Save changes using JavaScript click
	    wait.until(ExpectedConditions.elementToBeClickable(saveHeadlineButton));
	    js.executeScript("arguments[0].click();", saveHeadlineButton);
	
		    }
	
     public void keySkills()
     {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    JavascriptExecutor js = (JavascriptExecutor) driver;

    	    try {
    	        // Click the edit icon
    	        wait.until(ExpectedConditions.elementToBeClickable(keySkills));
    	        js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", keySkills);

    	        // Wait for the input to appear
    	        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id("keySkillInput")));
    	        js.executeScript("arguments[0].scrollIntoView(true);", input);
    	        input.click();
    	        input.sendKeys("BBT");

    	        // Wait for suggestion box to appear
    	        WebElement suggestionBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("keySkillSugg")));

    	        // Select the first suggestion (BBT) using keyboard keys
    	        new Actions(driver).sendKeys(org.openqa.selenium.Keys.ARROW_DOWN, org.openqa.selenium.Keys.ENTER).perform();

    	        // Save the updated skills
    	        wait.until(ExpectedConditions.elementToBeClickable(keySkillSaveButton)).click();

    	    } catch (Exception e) {
    	        System.out.println("Skill 'BBT' might already be present or there was an issue adding it.");
    	    }
    	}
	

}
