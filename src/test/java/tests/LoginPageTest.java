package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.Constant;
public class LoginPageTest extends BaseTest  {
	
	
	@Test
    public void testLoginWithoutCredentials() throws Exception {
        // Click on the login button without entering username and password
        loginPage.clickLoginButton();
	}
	
	 @Test
	    public void testErrorMessageDisplay() throws Exception {
	        // Example test to check if error message is displayed
	       
	    }
	 @Test
	 //TC_AXP_ADM_LOG_03
	    public void testPasswordVisibilityToggle() throws Exception {
		 	loginPage.enterPassword(Constant.password);
	        Thread.sleep(2000);
	        loginPage.clickPasswordToggleIcon();
	        Assert.assertTrue(loginPage.isPasswordVisible(), "Password should be visible after clicking toggle icon");
	        Assert.assertTrue(loginPage.isPasswordinVisible(), "Password should be hidden after clicking toggle icon again");
	    }
	 @Test
	 //TC_AXP_ADM_LOG_04
	    public void testInvalidLogin() throws Exception {
	        // Enter invalid username and password
	        loginPage.enterUsername(Constant.InValidEmail);
	        loginPage.enterPassword(Constant.Invalidpassword);
	        loginPage.clickLoginButton();
	        // Verify the error message
	        String expectedErrorMessage = "You entered wrong credentials";
	        String actualErrorMessage = loginPage.getErrorMessage();
	        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	    }

	  @Test
	  //TC_AXP_ADM_LOG_05//TC_AXP_ADM_LOG_06
	    public void testWrongCredentialsAttempts() throws Exception {
	        // First attempt
	        verifyWrongCredentialsAttempt(1);

	        // Second attempt
	        verifyWrongCredentialsAttempt(2);
	    }

	    private void verifyWrongCredentialsAttempt(int attemptNumber) throws Exception {
	        loginPage.enterUsername(Constant.username);
	        loginPage.enterPassword(Constant.Invalidpassword);
	        loginPage.clickLoginButton();
	        String expectedErrorMessage = "You entered wrong credentials\n" + "Only " + attemptNumber + "/3 Passwords Attempts left";
	        String actualErrorMessage = loginPage.getErrorMessageInvalidCredential();
	        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	    }

	@Test
	 //TC_AXP_ADM_LOG_07
	 public void testWrongCredentialsThirdAttempt() throws Exception {
		loginPage.enterUsername(Constant.username);
		loginPage.enterPassword(Constant.Invalidpassword);
		loginPage.clickLoginButton();
		String expectedErrorMessage = "You entered wrong credentials\r\n"
		      		+ "Account will get lock temporary, If you fail this time";
		String actualErrorMessage = loginPage.getErrorMessageInvalidCredential();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}
	@Test
	 //TC_AXP_ADM_LOG_08
	 public void testWrongCredentialsFourthAttempt() throws Exception {
		loginPage.enterUsername(Constant.username);
		loginPage.enterPassword(Constant.Invalidpassword);
		loginPage.clickLoginButton();
		String expectedErrorMessage = "Your account got locked temporarily,contact your department head";
		String actualErrorMessage = loginPage.getErrorMessageInvalidCredential();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}
	
}
