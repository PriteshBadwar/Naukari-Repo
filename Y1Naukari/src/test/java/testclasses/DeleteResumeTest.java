package testclasses;

import org.testng.annotations.Test;

public class DeleteResumeTest extends BaseClass{
	
	@Test(priority = 2)
	public void callingDeleteResume()
	{
		dr.deleteProfile();
	}
	@Test(priority=3)
	public void callingResumeHeadline()
	{
		dr.resumeHeadline();
	}
	
	@Test(priority=4)
	public void callingKeySkills()
	{
		dr.keySkills();
	}

}
