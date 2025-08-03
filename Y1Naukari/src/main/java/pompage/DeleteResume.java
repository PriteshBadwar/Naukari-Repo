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
		 uploadResume.sendKeys("C:\\Users\\Admin\\Downloads\\Pritesh_3.7_Exp.pdf");
//		Actions actions = new Actions(driver);
//		actions.moveToElement(uploadResume).click().perform();
		}
	
	public void resumeHeadline()
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    // Step 1: Wait for visibility and scroll into view first
		    wait.until(ExpectedConditions.visibilityOf(resumeHeadline));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", resumeHeadline);

		    // Step 2: Wait until clickable (ensure it's not hidden under overlay)
		    wait.until(ExpectedConditions.elementToBeClickable(resumeHeadline));

		    // Step 3: Click using JavaScript to avoid intercept issues
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", resumeHeadline);

		    // Step 4: Resume normal flow
		    wait.until(ExpectedConditions.visibilityOf(resumeHeadlineTextArea));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", resumeHeadlineTextArea);

		    String oldText = resumeHeadlineTextArea.getAttribute("value");

		    // Optional: clean + add jenkins.
		    if (oldText.contains("jenkins.")) {
		        oldText = oldText.replace("jenkins.", "");
		    }
		    String newText = oldText.trim() + " jenkins.";

		    resumeHeadlineTextArea.clear();
		    resumeHeadlineTextArea.sendKeys(newText);

		    wait.until(ExpectedConditions.elementToBeClickable(saveHeadlineButton)).click();
		    }
	
     public void keySkills()
     {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

 	    // Step 1: Open the edit popup
 	    wait.until(ExpectedConditions.visibilityOf(keySkills));
 	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", keySkills);
 	    wait.until(ExpectedConditions.elementToBeClickable(keySkills));
 	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", keySkills);

 	    // Step 2: Delete "BBT" if exists
 	    try {
 	        wait.until(ExpectedConditions.visibilityOf(keySkillPopup));
 	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", keySkillPopup);
 	    } catch (Exception e) {
 	        System.out.println("Skill 'BBT' was not found to delete. Proceeding to add.");
 	    }

 	    // Step 3: Add the skill "BBT"
 	    WebElement addSkillInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("keySkillSugg")));
 	    addSkillInput.sendKeys("BBT");

 	    // Wait and select from suggestion
 	    Actions actions = new Actions(driver);
 	    actions.sendKeys(org.openqa.selenium.Keys.ARROW_DOWN).sendKeys(org.openqa.selenium.Keys.ENTER).perform();

 	    // Step 4: Save the skill changes
 	    wait.until(ExpectedConditions.elementToBeClickable(keySkillSaveButton)).click();/////can u make code simple and short
     }
	

}
