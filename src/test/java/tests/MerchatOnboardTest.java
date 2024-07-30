package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DataProvider.Constant;
public class MerchatOnboardTest extends BaseTest {
	
	
	@BeforeMethod
	public void setPage() throws Exception {
		// Click on the login button without entering username and password
        loginPage.enterValidCredential(Constant.username, Constant.password);
        Thread.sleep(2000);
        dashboardPage.enterSubmitbtn();
        Thread.sleep(2000);
	}
	
	@Test
	//TC_AXP_ADM_MERON_01
    public void testMerchantRegisterLink() {
        // Click on "Merchant Register" link
		merchantOnboardPage.clickMerchantRegister();
        
        // Example verification: Assert the current URL or page title after clicking
       Assert.assertTrue(merchantOnboardPage.isMerchantRegisterLinkClickable());
    }
	

	@Test
	//TC_AXP_ADM_MERON_02
    public void verifyMerchantOnboardingLink() throws Exception {
		merchantOnboardPage.clickMerchantRegister();
		merchantOnboardPage.clickMerchantOnboarding();
		Thread.sleep(2000);
		String currentLink = driver.getCurrentUrl();
        Assert.assertEquals(merchantOnboardPage.isPageLoaded(),currentLink, "Merchant Onboarding page did not load successfully");
    }

	 @Test
	//TC_AXP_ADM_MERON_03
		 public void VerifyEmptyFields() throws Exception{
		
		 merchantOnboardPage.clickMerchantRegister();
		 merchantOnboardPage.clickMerchantOnboarding();
		 jsExecutor.executeScript("window.scrollBy(0,500)"); // Scrolls down by 500 pixel
		 merchantOnboardPage.submitbtn();
		 merchantOnboardPage.errormsgforfirst_Name();
		 merchantOnboardPage.errormsgforLast_Name();
		 merchantOnboardPage.errormsgforUser_Name();
		 merchantOnboardPage.errormsgforEmail_id();
		 merchantOnboardPage.errormsgforMobile_number();
		 }
	 
	 @Test
	//TC_AXP_ADM_MERON_04
	    public void verifyDraftButtonWithEmptyMandatoryFields() throws Exception {
		
		 merchantOnboardPage.clickMerchantRegister();
		 merchantOnboardPage.clickMerchantOnboarding();
		 jsExecutor.executeScript("window.scrollBy(0,500)"); // Scrolls down by 500 pixel
		 merchantOnboardPage.clickDraftButton();
		 merchantOnboardPage.errormsgforfirst_Name();
		 merchantOnboardPage.errormsgforLast_Name();
		 merchantOnboardPage.errormsgforUser_Name();
		 merchantOnboardPage.PasswordErrorMessage();
		 merchantOnboardPage.errormsgforEmail_id();
		 merchantOnboardPage.errormsgforMobile_number();
		 

	    }
	 @Test
		//TC_AXP_ADM_MERON_05
		    public void testNumericAndSpecialCharactersInFields() throws Exception {
			 try {
				 merchantOnboardPage.clickMerchantRegister();
				 merchantOnboardPage.clickMerchantOnboarding();
		            String numericAndSpecialChars = "12345!@#$%";
		            // Enter numeric and special characters into the First Name field
		            merchantOnboardPage.enterFirstName(numericAndSpecialChars);
		            Assert.assertEquals(merchantOnboardPage.getFirstNameValue(), numericAndSpecialChars, "First Name field did not accept numeric and special characters.");

		            // Enter numeric and special characters into the Last Name field
		            merchantOnboardPage.enterLastName(numericAndSpecialChars);
		            Assert.assertEquals(merchantOnboardPage.getLastNameValue(), numericAndSpecialChars, "Last Name field did not accept numeric and special characters.");

		            // Enter numeric and special characters into the User Name field
		            merchantOnboardPage.enterUserName(numericAndSpecialChars);
		            Assert.assertEquals(merchantOnboardPage.getUserName(), numericAndSpecialChars, "User Name field did not accept numeric and special characters.");
		        } catch (Exception e) {
		            e.printStackTrace();
		            Assert.fail("Test failed due to exception: " + e.getMessage());
		        }
	 		}
	 
	 @Test
	//TC_AXP_ADM_MERON_06
	    public void testWeakPassword() {
		
		 merchantOnboardPage.clickMerchantRegister();
		 merchantOnboardPage.clickMerchantOnboarding();
		 jsExecutor.executeScript("window.scrollBy(0,500)"); // Scrolls down by 500 pixel
	        // Enter a weak password
		 	merchantOnboardPage.enterPassword("weak");
	        // Verify the password error message
	        Assert.assertTrue(merchantOnboardPage.getPasswordErrorMessage());
	    }
	 
	 @Test
	//TC_AXP_ADM_MERON_07
	 public void testPasswordAndEyeIcon() throws Exception {
		
		 merchantOnboardPage.clickMerchantRegister();
		 merchantOnboardPage.clickMerchantOnboarding();
		 jsExecutor.executeScript("window.scrollBy(0,500)"); // Scrolls down by 500 pixel
	     // Verify that the password is displayed in plain text
		 merchantOnboardPage.enterPassword("AppXpay@123");
		 merchantOnboardPage.clickEyeIcon();
	     
		 WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']")); 
	     String fieldType = passwordField.getAttribute("type");
	     Assert.assertEquals(fieldType, "text", "Password is not displayed in plain text after clicking the eye icon.");
	     merchantOnboardPage.clickEyeIcon();
	 }
	 

	    @Test
	  //TC_AXP_ADM_MERON_08
	    public void testInvalidEmailFormat() {
	    	
			merchantOnboardPage.clickMerchantRegister();
			merchantOnboardPage.clickMerchantOnboarding();
			jsExecutor.executeScript("window.scrollBy(0,500)"); // Scrolls down by 500 pixel
	    	merchantOnboardPage.enterEmail("invalidemail");
	        merchantOnboardPage.errormsgforEmail_id();
	    }
	    
	    @Test
	  //TC_AXP_ADM_MERON_09
	    public void testInvalidMobileFormat() {
	    	
			merchantOnboardPage.clickMerchantRegister();
			merchantOnboardPage.clickMerchantOnboarding();
			jsExecutor.executeScript("window.scrollBy(0,500)"); // Scrolls down by 500 pixel
	    	merchantOnboardPage.enterMobile("12345"); // Entering less than 10 digits
	        merchantOnboardPage.EnterPhoneNumberLessthanTenDigit();
	    }
	    
	    @Test
		//TC_AXP_DB_10
		    public void testExistingUsernameErrorMessage() throws Exception {
		        // Enter an existing username
	    	merchantOnboardPage.clickMerchantRegister();
			merchantOnboardPage.clickMerchantOnboarding();
			merchantOnboardPage.enterUserName("Chitra A"); //existing username 
			 Thread.sleep(2000);
		        
		        // Get error message text
		        String errorMessage = vendorRegistrationPage.getErrorMessageAlready_exists();
		        // Verify error message is displayed
		        Assert.assertTrue(errorMessage.equals("Username already exists"));
		    }
	    
	    @Test
	  //TC_AXP_DB_11
	    public void testValidDetailsAndDraft() throws Exception {
	    	
	    	merchantOnboardPage.clickMerchantRegister();
			merchantOnboardPage.clickMerchantOnboarding();
	    	
			merchantOnboardPage.enterRandomData();
	    	
			jsExecutor.executeScript("window.scrollBy(0,500)"); // Scrolls down by 500 pixel
			
			merchantOnboardPage.clickDraftButton();
			
			Thread.sleep(4000);
	    }
	    
	    @Test
	    //TC_AXP_ADM_MERON_12
	    public void testEnterValidDetailsAndClickNext() throws Exception {
	    	
	    	merchantOnboardPage.clickMerchantRegister();
			merchantOnboardPage.clickMerchantOnboarding();
	    	
			merchantOnboardPage.enterRandomData();
	    	
			jsExecutor.executeScript("window.scrollBy(0,500)"); // Scrolls down by 500 pixel
			
			merchantOnboardPage.submitbtn();
			Thread.sleep(2000);
			
			 String alertMessage = merchantOnboardPage.toastMessage();
		        System.out.println("Alert message: " + alertMessage);

		        // Verify the alert message
		        Assert.assertEquals(alertMessage, "Step One Completed Successfully!!", "Alert message does not match.");
		        String expectedURL = driver.getCurrentUrl();
		        String expectedTitle = driver.getTitle();
		        System.out.println(expectedURL);
		        System.out.println(expectedTitle);
		        
	    }
	    
	    @Test
	  //TC_AXP_ADM_MERON_13
	    public void testClickPersonalDetailsTab() throws Exception {
	    	
	    	merchantOnboardPage.clickMerchantRegister();
			merchantOnboardPage.clickMerchantOnboarding();
	        // Click the Personal Details tab
			merchantOnboardPage.enterRandomData();

			jsExecutor.executeScript("window.scrollBy(0,500)"); // Scrolls down by 500 pixel
			
			merchantOnboardPage.submitbtn();
			Thread.sleep(3000);
			merchantOnboardPage.clickPersonalDetailsTab();
			
	        // Verify that the Personal Details page is displayed
	        boolean isPersonalDetailsPageDisplayed = merchantOnboardPage.isPersonalDetailsPageDisplayed();
	        Assert.assertTrue(isPersonalDetailsPageDisplayed, "Personal Details page is not displayed.");
	        jsExecutor.executeScript("window.scrollBy(0,500)");
	        try {
	        	merchantOnboardPage.enterPassword(Constant.password);
	        }
	        catch (Exception e) {
			System.out.println(e.getMessage());	
			}
	        merchantOnboardPage.submitbtn();
	        
	    }
	    
}
