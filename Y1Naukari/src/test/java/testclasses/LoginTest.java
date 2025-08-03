package testclasses;

import org.testng.annotations.Test;

public class LoginTest extends BaseClass {
	
	@Test(priority = 1)
	public void callingEnterDetails()
	{
		lp.enterDetails();
	}

}
