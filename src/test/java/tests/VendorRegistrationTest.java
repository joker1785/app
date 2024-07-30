package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DataProvider.Constant;
public class VendorRegistrationTest extends BaseTest {
	
	
	@BeforeMethod
	public void setPage() throws Exception {
		// Click on the login button without entering username and password
        loginPage.enterValidCredential(Constant.username, Constant.password);
        Thread.sleep(2000);
        dashboardPage.enterSubmitbtn();
        Thread.sleep(2000);
	}
	
	 @Test
	 //TC_AXP_DB_01
	    public void testVendorMenuVisibilityAndClickability() throws Exception {
	        // Verify the Vendor menu is visible
	        Assert.assertTrue(vendorRegistrationPage.isVendorMenuVisible(), "Vendor menu is not visible");

	        // Verify the Vendor menu is clickable
	        Assert.assertTrue(vendorRegistrationPage.isVendorMenuClickable(), "Vendor menu is not clickable");
	    }
	 @Test
	 //TC_AXP_DB_02
	    public void testVendorOnboardingMenuVisibilityAndClickability() throws Exception {
	        // Verify the Vendor Onboarding menu is visible
	        Assert.assertTrue(vendorRegistrationPage.isVendorOnboardingMenuVisible(), "Vendor Onboarding menu is not visible");

	        // Verify the Vendor Onboarding menu is clickable
	        Assert.assertTrue(vendorRegistrationPage.isVendorOnboardingMenuClickable(), "Vendor Onboarding menu is not clickable");
	    }
	 
	 @Test
	 //TC_AXP_DB_03
	    public void testAddVendorButtonNavigation() throws Exception  {
	        // Verify the navigation to the onboarding page
		 	 Assert.assertTrue(vendorRegistrationPage.isOnboardingPageDisplayed(), "Failed to navigate to the onboarding page");
	    }
	 
	 @Test
	//TC_AXP_DB_04
	    public void testNumericAndSpecialCharactersInFields() throws Exception {
		 try {
	            vendorRegistrationPage.clickVendorMenu();
	            vendorRegistrationPage.clickOnboarding();

	            String numericAndSpecialChars = "12345!@#$%";
	            // Enter numeric and special characters into the First Name field
	            vendorRegistrationPage.enterFirstName(numericAndSpecialChars);
	            Assert.assertEquals(vendorRegistrationPage.getFirstName(), numericAndSpecialChars, "First Name field did not accept numeric and special characters.");

	            // Enter numeric and special characters into the Last Name field
	            vendorRegistrationPage.enterLastName(numericAndSpecialChars);
	            Assert.assertEquals(vendorRegistrationPage.getLastName(), numericAndSpecialChars, "Last Name field did not accept numeric and special characters.");

	            // Enter numeric and special characters into the User Name field
	            vendorRegistrationPage.enterUserName(numericAndSpecialChars);
	            Assert.assertEquals(vendorRegistrationPage.getUserName(), numericAndSpecialChars, "User Name field did not accept numeric and special characters.");
	        } catch (Exception e) {
	            e.printStackTrace();
	            Assert.fail("Test failed due to exception: " + e.getMessage());
	        }
}
	 @Test
	//TC_AXP_DB_05
	 public void VerifyEmptyFields(){
		 vendorRegistrationPage.clickVendorMenu();
         vendorRegistrationPage.clickOnboarding();
		 vendorRegistrationPage.submitbtn();
		 vendorRegistrationPage.errormsgforfirst_Name();
		 vendorRegistrationPage.errormsgforLast_Name();
		 vendorRegistrationPage.errormsgforUser_Name();
		 vendorRegistrationPage.errormsgforEmail_id();
		 vendorRegistrationPage.errormsgforMobile_number();
	 }
	 
	 @Test
	//TC_AXP_DB_06
	    public void testExistingUsernameErrorMessage() throws Exception {
	        // Enter an existing username
		 vendorRegistrationPage.clickVendorMenu();
         vendorRegistrationPage.clickOnboarding();
		 vendorRegistrationPage.enterUserName("Chitra A"); //existing username
		 
	        
	        // Get error message text
	        String errorMessage = vendorRegistrationPage.getErrorMessageAlready_exists();
	        // Verify error message is displayed
	        Assert.assertTrue(errorMessage.equals("Username already exists"));
	    }
	 

	    @Test
	  //TC_AXP_DB_08
	    public void testWeakPassword() {
	    	 vendorRegistrationPage.clickVendorMenu();
	         vendorRegistrationPage.clickOnboarding();
	        String weakPassword = "12";
	        vendorRegistrationPage.enterPassword(weakPassword);
	        // Assertion
	        Assert.assertEquals(weakPassword, vendorRegistrationPage.getPasswordValue(),"Password field should contain the weak password");
	    }

	    @Test
	  //TC_AXP_DB_09
	    public void testPasswordValidation() {
	    	vendorRegistrationPage.clickVendorMenu();
	        vendorRegistrationPage.clickOnboarding();
	        String testPassword = "Password123";
	        vendorRegistrationPage.enterPassword(testPassword);
	        
	        String enteredPassword = vendorRegistrationPage.getPasswordValue();
	        boolean hasUppercase = !enteredPassword.equals(enteredPassword.toLowerCase());
	        boolean hasLowercase = !enteredPassword.equals(enteredPassword.toUpperCase());
	        
	        Assert.assertTrue(hasUppercase,"Password should contain at least one uppercase letter.");
	        Assert.assertTrue(hasLowercase,"Password should contain at least one lowercase letter.");

	    }
	    
	    @Test
	  //TC_AXP_DB_11
	    public void testPasswordVisibilityToggle() {
	    	vendorRegistrationPage.clickVendorMenu();
	        vendorRegistrationPage.clickOnboarding();
	        String password = "TestPassword123";
	        vendorRegistrationPage.enterPassword(password);
	        
	        // Verify password field type is 'password'
	        Assert.assertEquals("password", vendorRegistrationPage.getPasswordFieldType());

	        // Click on the eye icon to toggle visibility
	        vendorRegistrationPage.clickPasswordToggleIcon();

	        // Verify password field type is 'text' after clicking the eye icon
	        Assert.assertEquals("text", vendorRegistrationPage.getPasswordFieldType());
	    }
	    @Test
	    ////TC_AXP_DB_12
	    public void testInvalidEmailFormat() {
	    	vendorRegistrationPage.clickVendorMenu();
	        vendorRegistrationPage.clickOnboarding();
	    	String invalidEmail = "invalidEmailWithoutAtSymbol";
	        vendorRegistrationPage.enterEmail(invalidEmail);
	        vendorRegistrationPage.errormsgforEmail_id();
	    }
	    
	    @Test
	//TC_AXP_DB_13
	    public void testExistingEmailErrorMessage() {
	    	vendorRegistrationPage.clickVendorMenu();
	        vendorRegistrationPage.clickOnboarding();
	    	vendorRegistrationPage.enterEmail("veerabalan@gmail.com");
	    	Assert.assertEquals(vendorRegistrationPage.getErrorMessage(), "Email already exists");
	    }
	    
	    @Test
	  //TC_AXP_DB_14
	    public void testEnteringLessThan10DigitsInMobileField() {
	    	vendorRegistrationPage.clickVendorMenu();
	        vendorRegistrationPage.clickOnboarding();
	        vendorRegistrationPage.enterMobile("34566");
	        vendorRegistrationPage.EnterPhoneNumberLessthanTenDigit();
	    }
	    
	    @Test
	    //TC_AXP_DB_15
	    public void testEnterAlphabetAndSymbolInMobileField() {
	    	vendorRegistrationPage.clickVendorMenu();
	        vendorRegistrationPage.clickOnboarding();
	    	String invalidInput = "abc@123";
	    	vendorRegistrationPage.enterMobile(invalidInput);
	        String enteredValue = vendorRegistrationPage.getMobileValue();
	        Assert.assertEquals( "123", enteredValue,"The mobile field should not accept alphabets and symbols.");
	        
	    }
	    @Test
	  //TC_AXP_DB_16
	    public void testDraftButtonSavesInformation() {
	    	vendorRegistrationPage.clickVendorMenu();
	        vendorRegistrationPage.clickOnboarding();
	    	vendorRegistrationPage.enterRandomData();
	    	vendorRegistrationPage.clickDraftButton();
	    }
	    
	 @Test
	 //TC_AXP_ADM_VENOB_17
	    public void testFormSubmission() {
		 vendorRegistrationPage.clickVendorMenu();
         vendorRegistrationPage.clickOnboarding();
		 vendorRegistrationPage.enterRandomData();
		 vendorRegistrationPage.submitbtn();
	    }

	    @Test
	  //TC_AXP_ADM_VENOB_18
	    public void testEditBusinessInfo() throws Exception {
	    	vendorRegistrationPage.clickVendorMenu();
	         vendorRegistrationPage.clickOnboarding();
			 vendorRegistrationPage.enterRandomData();
			 vendorRegistrationPage.clickVendorMenu();
			 vendorListPage.clickVendorList();
			 vendorListPage.clickEditButton("1");
	        
	    }
	 @Test
	//TC_AXP_ADM_VENOB_19
	    public void testSelectValidBusinessType() throws Exception {
		 testFormSubmission(); 
		 vendorRegistrationPage.selectBusinessCategory1("Private Limited");
	        Assert.assertTrue(merchantOnboardPage.isBusinessCategoryDisplayed1("Private Limited"));
	        vendorRegistrationPage.selectBusinessCategory1("Tours and Trave");
	        vendorRegistrationPage.selectBusinessCategory1("IT and Software");
	    	 Assert.assertTrue(vendorRegistrationPage.isBusinessCategoryDisplayed1("Tours and Trave"));
	         Assert.assertTrue(vendorRegistrationPage.isBusinessCategoryDisplayed1("IT and Software"));
	         vendorRegistrationPage.selectBusinessCategory2("Education");
		        Assert.assertTrue(vendorRegistrationPage.isCategoryDisplayed2("Education"));
		        vendorRegistrationPage.selectBusinessSubCategory("Cryptocurrency");
		        Assert.assertTrue(vendorRegistrationPage.isSubCategoryDisplayed("Cryptocurrency"));
	    }
	 
	
	 @Test
	  //TC_AXP_ADM_VENOB_20
	    public void testEnterInValidBankName() {
		 testFormSubmission(); 
	        String Invalid = "HDFC000S253";
	        vendorRegistrationPage.enterBankName(Invalid);
	        // Assertion
	        Assert.assertNotEquals(Invalid, vendorRegistrationPage.getBankName());
	    }
	 @Test
	  //TC_AXP_ADM_VENOB_21
	    public void testEnterValidBankName() {
		 testFormSubmission(); 
	        String valid = "Indian Bank Limited";
	        vendorRegistrationPage.enterBankName(valid);
	        // Assertion
	        Assert.assertEquals(valid, vendorRegistrationPage.getBankName());
	    }
	 
	 @Test
	  //TC_AXP_ADM_VENOB_22
	    public void testEnterInValidAccountNo() {
		 testFormSubmission(); 
	        String InvalidAccNo = "John@123";
	        vendorRegistrationPage.enterBankAccountNumber(InvalidAccNo);
	        // Assertion
	        Assert.assertNotEquals(InvalidAccNo, vendorRegistrationPage.getBankAccountNumberInputValue());
	    }
	 @Test
	  //TC_AXP_ADM_VENOB_23
	    public void testEnterPartialAccountNo() {
		 testFormSubmission(); 
	        String PartAccNo = "6594";
	        vendorRegistrationPage.enterBankAccountNumber(PartAccNo);
	        // Assertion
	        Assert.assertEquals(PartAccNo, vendorRegistrationPage.getBankAccountNumberInputValue());
	        Assert.assertEquals(vendorRegistrationPage.getErrorMessage(),"Bank account number must be between 9 and 18 digits long.");
	    }
	 
	 @Test
	  //TC_AXP_ADM_VENOB_24
	    public void testEntermorethan18digitsAccountNo() {
		 testFormSubmission(); 
	        String PartAccNo = "659434534364364674745747567568758585865856";
	        vendorRegistrationPage.enterBankAccountNumber(PartAccNo);
	        // Assertion
	        Assert.assertEquals(PartAccNo, vendorRegistrationPage.getBankAccountNumberInputValue());
	        Assert.assertEquals(vendorRegistrationPage.getErrorMessage(),"Bank account number must be between 9 and 18 digits long.");
	    }
	 @Test
	  //TC_AXP_ADM_VENOB_25
	    public void testEnterValidAccountNo() {
		 testFormSubmission(); 
	        String validAccNo = "6594823194";
	        vendorRegistrationPage.enterBankAccountNumber(validAccNo);
	        // Assertion
	        Assert.assertEquals(validAccNo, vendorRegistrationPage.getBankAccountNumberInputValue());
	    }

	    @Test
	  //TC_AXP_ADM_VENOB_26
	    public void testEnteringSpecialCharactersInBankIFSCCode() {
	    	 testFormSubmission(); 
	    	vendorRegistrationPage.enterIFSCCode("twilight@!#$");
	        String enteredValue = vendorRegistrationPage.getIFSCCode();
	        Assert.assertEquals(enteredValue,"twilight","Special characters should be entered in the field");

	    }
	    @Test
		  //TC_AXP_ADM_VENOB_27
		    public void testEnterValidInBankIFSCCode() {
		    	 testFormSubmission(); 
		    	vendorRegistrationPage.enterIFSCCode("HDFC000S253");
		        String enteredValue = vendorRegistrationPage.getIFSCCode();
		        Assert.assertEquals(enteredValue,"HDFC000S253","Special characters should be entered in the field");
		    }
	    @Test
		  //TC_AXP_ADM_VENOB_28
		    public void testEnterInvalidBranchName() {
		    	 testFormSubmission(); 
		    	vendorRegistrationPage.enterBranchName("twilight@!#$");
		        String enteredValue = vendorRegistrationPage.getBranchNameValue();
		        Assert.assertNotEquals(enteredValue,"twilight@!#$","Special characters should be entered in the field");
		    }
	 
	    @Test
		  //TC_AXP_ADM_VENOB_29
		    public void testEntervalidBranchName() {
		    	 testFormSubmission(); 
		    	vendorRegistrationPage.enterBranchName("Main Branch");
		        String enteredValue = vendorRegistrationPage.getBranchNameValue();
		        Assert.assertEquals(enteredValue,"MainBranch","Special characters should be entered in the field");
		    }
	 
	 @Test
	  //TC_AXP_ADM_VENOB_30
	    public void testEnterInValidAccountHolderName() {
		 testFormSubmission(); 
	        String validName = "John@123";
	        vendorRegistrationPage.enterAccountHolderName(validName);
	        // Assertion
	        Assert.assertEquals(validName, vendorRegistrationPage.getAccountHolderName());
	    }
	    
	    @Test
	  //TC_AXP_ADM_VENOB_31
	    public void testEnterValidAccountHolderName() {
	    	testFormSubmission(); 
	        String validName = "John Doe";
	        vendorRegistrationPage.enterAccountHolderName(validName);
	        // Assertion
	        Assert.assertEquals(validName, vendorRegistrationPage.getAccountHolderName());
	    }
	    @Test
	  //TC_AXP_ADM_VENOB_32
	    public void testValidCompanyNameInput() {
	    	testFormSubmission(); 
	        String validCompanyName = "Tech Innovations Inc.";
	        vendorRegistrationPage.enterCompanyName(validCompanyName);
	        String enteredValue = vendorRegistrationPage.getCompanyNameInputValue();
	        Assert.assertEquals(validCompanyName, enteredValue);
	    }
	    
	    @Test
	    ////TC_AXP_ADM_VENOB_33
	    public void testSpecialAndNumericValuesInCompanyName() {
	    	testFormSubmission(); 
	        // Test with special characters
	        String specialChars = "!@#$%^&*()_+";
	        vendorRegistrationPage.enterCompanyName(specialChars);
	        Assert.assertNotEquals(specialChars, vendorRegistrationPage.getCompanyNameInputValue());

	        // Test with numeric values
	        String numericValue = "1234567890";
	        vendorRegistrationPage.enterCompanyName(numericValue);
	        Assert.assertNotEquals(numericValue, vendorRegistrationPage.getCompanyNameInputValue());
	    }
	    
	    @Test
	  //TC_AXP_ADM_VENOB_34
	    public void testValidCompanyAddressSubmission() {
	    	testFormSubmission(); 
	        String validAddress = "1234 Elm Street, Springfield, IL 62704";
	        vendorRegistrationPage.enterCompanyAddress(validAddress);
	        Assert.assertEquals(validAddress, vendorRegistrationPage.getCompanyAddressInputValue());
	    }
	    @Test
		  //TC_AXP_ADM_VENOB_35
		    public void testInValidCompanyAddressSubmission() {
		    	testFormSubmission(); 
		        String validAddress = "!@#$%^&*()_+@1234567890";
		        vendorRegistrationPage.enterCompanyAddress(validAddress);
		        Assert.assertNotEquals(validAddress, vendorRegistrationPage.getCompanyAddressInputValue());
		    }
	    
	    @Test
		  //TC_AXP_ADM_VENOB_36
		    public void testEnterInValidPincode() throws Exception {
	    			testFormSubmission(); 
		            String validPincode = "twilight";
		            vendorRegistrationPage.enterPincode(validPincode);
		            Thread.sleep(2000);
		            Assert.assertNotEquals(validPincode, vendorRegistrationPage.getPincodeInputValue(),"Pincode value did not match");
		    }
	    @Test
	  //TC_AXP_ADM_VENOB_37
	    public void testEnterValidPincode() throws Exception {
	    		testFormSubmission(); 
	            String validPincode = "607006";
	            vendorRegistrationPage.enterPincode(validPincode);
	            Thread.sleep(2000);
	            Assert.assertEquals(validPincode, vendorRegistrationPage.getPincodeInputValue(),"Pincode value did not match");
	    }
	    @Test
	    //TC_AXP_ADM_VENOB_38
	      public void testInValidCityName() {
	    	  testFormSubmission();
	          String validCityName = "607006"; // Example of a valid city name
	          vendorRegistrationPage.enterCity(validCityName);
	          Assert.assertNotEquals(validCityName, vendorRegistrationPage.getCityInputValue());
	          
	      }
	    @Test
	  //TC_AXP_ADM_VENOB_39
	      public void testValidCityName() {
	    	testFormSubmission();
	          String validCityName = "New York"; // Example of a valid city name
	          vendorRegistrationPage.enterCity(validCityName);
	      }
	      

	      @Test
	    //TC_AXP_ADM_MERON_40
	      public void testSelectState() throws Exception {
	    	  	testFormSubmission();
	    	  	vendorRegistrationPage.clickStateSelect();
	      		merchantOnboardPage.selectStateByValue("3"); // Selecting "Andaman And Nicobar"
	      }

	 	 @Test
	 	//TC_AXP_ADM_VENOB_42//TC_AXP_ADM_VENOB_43
	 	    public void uploadFileVendorAgreement() throws Exception {
	 		 	testFormSubmission();
	 	        String validPdfPath = "C:/Users/veera/Documents/9-11.pdf";
	 	        vendorRegistrationPage.uploadFileVendor_Agreement(validPdfPath);
	 	    }
	 	 @Test
		 	//TC_AXP_ADM_VENOB_44
		 	    public void uploadInvalidFileFormatVendorAgreement() throws Exception {
	 		 		testFormSubmission();
		 	        String validPdfPath = "C:/Users/veera/Documents/ideaIC-2018.3.6.exe";
		 	        vendorRegistrationPage.uploadFileVendor_Agreement(validPdfPath);
		 	    }
	      
	 @Test
	//TC_AXP_ADM_VENOB_45
	    public void CompanyInfo() throws Exception {
		 	testFormSubmission();
		 	vendorRegistrationPage.selectBusinessCategory1("Public Limited");
		 	vendorRegistrationPage.selectBusinessCategory2("Government Bodies");
		 	vendorRegistrationPage.selectBusinessSubCategory("Cryptocurrency");
	    	vendorRegistrationPage.enterBankName("Housing Development Finance Corporation");
	    	vendorRegistrationPage.enterBankAccountNumber("0000888899999");
	    	vendorRegistrationPage.enterIFSCCode("HDFC0001234");
	    	vendorRegistrationPage.enterBranchName("Main Branch");
	    	String validName = "John Doe";
	        vendorRegistrationPage.enterAccountHolderName(validName);
	        vendorRegistrationPage.enterCompanyName("Twilight IT Solutions");
	        vendorRegistrationPage.enterCompanyAddress("Puducherry");
	        String validPincode = "607006";
            vendorRegistrationPage.enterPincode(validPincode);
            String validCityName = "New York"; // Example of a valid city name
	        vendorRegistrationPage.enterCity(validCityName);
	        vendorRegistrationPage.clickStateSelect();
      		merchantOnboardPage.selectStateByValue("3");
      		String validPdfPath = "C:/Users/veera/Documents/9-11.pdf";
	 	    vendorRegistrationPage.uploadFileVendor_Agreement(validPdfPath);
	        vendorRegistrationPage.clickCompleteButton();
	    }
	 
	 
	 
	    
}
