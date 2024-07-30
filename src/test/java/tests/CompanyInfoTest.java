package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DataProvider.Constant;
public class CompanyInfoTest extends BaseTest {
	 
	
	@BeforeMethod
	public void companyPage() throws Exception {
		 	loginPage.enterValidCredential(Constant.username, Constant.password);
	        Thread.sleep(2000);
	        dashboardPage.enterSubmitbtn();
	        Thread.sleep(2000);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    	merchantOnboardPage.clickMerchantRegister();
		merchantOnboardPage.clickMerchantOnboarding();
		merchantOnboardPage.enterRandomData();
    	merchantOnboardPage.submitbtn();
    	
	}
	@Test
    //TC_AXP_ADM_MERON_14
    public void verifyMandatoryFieldValidation() throws Exception {
        // Click the Personal Details tab
		
    	merchantOnboardPage.submitbtn();
    	Thread.sleep(2000);
        String expectedMessage = "This field is required."; // Replace with the actual expected validation message
        
        List<WebElement> option = driver.findElements(By.xpath("//div[@class = 'invalid-feedback']"));
        for(WebElement list : option) {
        	String errorMessage = list.getText();
        Assert.assertEquals(errorMessage, expectedMessage, "Validation message mismatch!");
        
    }
        System.out.println(option.size());
   }
    
    @Test
  //TC_AXP_ADM_MERON_15
    public void verifyMandatoryFieldValidationWhenSavingAsDraft() throws Exception {
    	
    	merchantOnboardPage.clickDraftButton();
    	Thread.sleep(2000);
        String expectedMessage = "This field is required."; // Replace with the actual expected validation message
        
        List<WebElement> option = driver.findElements(By.xpath("//div[@class = 'invalid-feedback']"));
        for(WebElement list : option) {
        	String errorMessage = list.getText();
        Assert.assertEquals(errorMessage, expectedMessage, "Validation message mismatch!");
        
    }
        System.out.println(option.size());
    }
    
    @Test
  //TC_AXP_ADM_MERON_16
    public void testSelectValidBusinessType() throws Exception {
    	
        merchantOnboardPage.selectBusinessCategory1("Private Limited");
        Assert.assertTrue(merchantOnboardPage.isBusinessCategoryDisplayed1("Private Limited"));
    	
        merchantOnboardPage.selectBusinessCategory1("Tours and Trave");
    	merchantOnboardPage.selectBusinessCategory1("IT and Software");
    	 Assert.assertTrue(merchantOnboardPage.isBusinessCategoryDisplayed1("Tours and Trave"));
         Assert.assertTrue(merchantOnboardPage.isBusinessCategoryDisplayed1("IT and Software"));
    }
    
    @Test
    //TC_AXP_ADM_MERON_17
    public void selectValidBusinessCategory() throws Exception {
    	
    	merchantOnboardPage.selectBusinessCategory2("Education");
        Assert.assertTrue(merchantOnboardPage.isCategoryDisplayed2("Education"));
        
        merchantOnboardPage.selectBusinessSubCategory("Cryptocurrency");
        Assert.assertTrue(merchantOnboardPage.isSubCategoryDisplayed("Cryptocurrency"));
            
    }

    @Test
  //TC_AXP_ADM_MERON_18
    public void testSpecialCharactersBankNameInput() throws Exception {
    	Thread.sleep(2000);
    	merchantOnboardPage.enterBankName("#$%^123");
        Assert.assertEquals("", merchantOnboardPage.getBankName());

    }
    
    @Test
  //TC_AXP_ADM_MERON_19
    public void testAlphabeticCharactersInBankAccountNumberField() throws Exception {
    	merchantOnboardPage.enterBankAccountNumber("abc123");
    	Thread.sleep(2000);
        String actualValue = merchantOnboardPage.getBankAccountNumberInputValue();
        Assert.assertEquals(actualValue, "123", "Bank Account Number field should only accept numerical values");
    }

    @Test
  //TC_AXP_ADM_MERON_20//TC_AXP_ADM_MERON_21
    public void testErrorMessageDisplayedForLessThan9Digits() throws Exception {
    	
    	merchantOnboardPage.enterBankAccountNumber("123");
    	Thread.sleep(3000);
        
    	// Perform actions to trigger error message for less than 9 digits bank account number
        Assert.assertTrue(merchantOnboardPage.getInvalidFeedbackElement().isDisplayed());
        
        merchantOnboardPage.enterBankAccountNumber("4567891011121314151617181920212223");
        Assert.assertTrue(merchantOnboardPage.getInvalidFeedbackElement().isDisplayed());

    }
   
    @Test
	  //TC_AXP_ADM_MERON_22
	    public void verify_entering_valid_account_number() throws Exception{
    	
    	try {
    		merchantOnboardPage.enterBankAccountNumber("1234567899");
        	Thread.sleep(3000);
            
        	// Perform actions to trigger error message for less than 9 digits bank account number
            Assert.assertFalse(merchantOnboardPage.getInvalidFeedbackElement().isDisplayed());
    	}
    	catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
    }
    
    @Test
  //TC_AXP_ADM_MERON_23
    public void testEnterAlphanumericIFSCCode() throws Exception {
    	
        String alphanumericIFSC = "ABCD@1234#";
        merchantOnboardPage.enterIFSCCode(alphanumericIFSC);
        String enteredIFSC = merchantOnboardPage.getIFSCCode();
        Assert.assertEquals(enteredIFSC, alphanumericIFSC);
    }
    
    @Test
  //TC_AXP_ADM_MERON_24
    public void testEnterValidIFSCCode() {
    
        String validIFSCCode = "HDFC0001234";
        
        // Enter IFSC code
        merchantOnboardPage.enterIFSCCode(validIFSCCode);
        
        // Verification step (you might need to add some wait if necessary)
        String enteredIFSCCode = merchantOnboardPage.getIFSCCode();
        Assert.assertEquals(enteredIFSCCode, validIFSCCode, "IFSC Code is not entered correctly.");
    }
    
    
    @Test
    //TC_AXP_ADM_MERON_25
    public void testSpecialAndNumericValuesInBranchName() throws Exception {
        // Test with special characters
        String specialChars = "!@#$%^&*()";
        merchantOnboardPage.enterBranchName(specialChars);
        Assert.assertNotEquals("Branch name should not accept special characters", specialChars, merchantOnboardPage.getBranchNameValue());
        Thread.sleep(3000);
        // Test with numeric values
        String numericValue = "12345";
        merchantOnboardPage.enterBranchName(numericValue);
        Assert.assertNotEquals("Branch name should not accept numeric values", numericValue, merchantOnboardPage.getBranchNameValue());

        driver.quit();
    }
    
    @Test
    //TC_AXP_ADM_MERON_26
    public void testValidBranchNameInput() throws Exception {
    	jsExecutor.executeScript("window.scrollBy(0,400)");
            String validBranchName = "Main Branch";
            Thread.sleep(3000);
            merchantOnboardPage.enterBranchName(validBranchName);
            
            Assert.assertEquals(validBranchName, merchantOnboardPage.getBranchNameValue());
    }
    

    @Test
  //TC_AXP_ADM_MERON_27
    public void testSpecialAndNumericValues() throws Exception {
    	
        // Test with special characters
        String specialChars = "!@#$%^&*()_+";
        merchantOnboardPage.enterAccountHolderName(specialChars);
        Assert.assertEquals("Special characters input failed", specialChars, merchantOnboardPage.getAccountHolderName());
        
        Thread.sleep(3000);
        // Test with numeric values
        String numericValue = "1234567890";
        merchantOnboardPage.enterAccountHolderName(numericValue);
        Assert.assertEquals("Numeric input failed", numericValue, merchantOnboardPage.getAccountHolderName());
    }
    
    @Test
    //TC_AXP_ADM_MERON_28
    public void testEnterValidAccountHolderName() {
    
        // Test Case: Enter valid Account Holder Name
        String validName = "Aadhira";
        merchantOnboardPage.enterAccountHolderName(validName);

        // Assertion
        Assert.assertEquals(validName, merchantOnboardPage.getAccountHolderName());
    }
    @Test
  //TC_AXP_ADM_MERON_29
    public void testSelectMonthlyExpenditure() throws Exception {
    	
    	merchantOnboardPage.selectMonthlyExpenditure("5"); // Selecting "25 Lakhs to 50 Lakhs"
    	Thread.sleep(3000);
        String selectedOption = merchantOnboardPage.getSelectedOption();
        Assert.assertEquals("4", selectedOption);
    }
    
    @Test
    //TC_AXP_ADM_MERON_30
    public void testEnterAlphabetsInPincode() {
    	
    	try {
        	merchantOnboardPage.enterPincode("ABCDE");
            Assert.assertEquals("ABCDE", merchantOnboardPage.getPincodeInputValue());
            merchantOnboardPage.enterPincode("@#$%^");
            Assert.assertEquals("@#$%^", merchantOnboardPage.getPincodeInputValue());
    	}catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
    
    @Test
  //TC_AXP_ADM_MERON_31
    public void testEnterValidPincode() throws Exception {
            String validPincode = "607006";
            merchantOnboardPage.enterPincode(validPincode);
            Thread.sleep(2000);

            Assert.assertEquals(validPincode, merchantOnboardPage.getPincodeInputValue(),"Pincode value did not match");
    }
    
    
    @Test
    //TC_AXP_ADM_MERON_32
    public void testSpecialCharacterInput() throws Exception {
        String specialCharacters = "!@#$%^&*()";
        merchantOnboardPage.enterCity(specialCharacters);
        Thread.sleep(2000);
        Assert.assertEquals(specialCharacters, merchantOnboardPage.getCityInputValue(),"Special characters input failed");
        
        String numericInput = "12345";
        
        merchantOnboardPage.enterCity(numericInput);
        Assert.assertEquals(numericInput, merchantOnboardPage.getCityInputValue(),"Numeric input failed");
    }
    
    @Test
  //TC_AXP_ADM_MERON_33
    public void testValidCityName() {
        String validCityName = "Chennai"; // Example of a valid city name
        merchantOnboardPage.enterCity(validCityName);
    }
    

    @Test
  //TC_AXP_ADM_MERON_34
    public void testSelectState() throws Exception {
    	merchantOnboardPage.clickStateSelect();
    	Thread.sleep(2000);
    	merchantOnboardPage.selectStateByValue("32"); // Selecting "Andaman And Nicobar"
    }
    
    @Test
  //TC_AXP_ADM_MERON_35
    public void CompanyInfo() throws Exception {
    	merchantOnboardPage.selectBusinessCategory1("Public Limited");
    	merchantOnboardPage.selectBusinessCategory2("Government Bodies");
    	selectValidBusinessCategory();
    	merchantOnboardPage.enterBankName("Housing Development Finance Corporation");
    	merchantOnboardPage.enterBankAccountNumber("0000888899999");
    	merchantOnboardPage.enterIFSCCode("HDFC0001234");
        merchantOnboardPage.enterBranchName("Main Branch");
        testEnterValidAccountHolderName();
        testSelectMonthlyExpenditure();
        merchantOnboardPage.enterCompanyName("Twilight IT Solutions");
        merchantOnboardPage.enterCompanyAddress("Puducherry");
        testEnterValidPincode();
        testValidCityName();
        testSelectState(); 
        merchantOnboardPage.clickPersonalDetailsTab();
        Thread.sleep(3000);
        jsExecutor.executeScript("window.scrollBy(0,700)");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='Next']")).click();
    }
    

    @Test
  //TC_AXP_ADM_MERON_36
    public void CompanyInfoExceptBankIFSCCode() throws Exception {
    	testSelectValidBusinessType();
    	selectValidBusinessCategory();
    	merchantOnboardPage.enterBankName("Housing Development Finance Corporation");
    	merchantOnboardPage.enterBankAccountNumber("0000888899999");
    	//merchantOnboardPage.enterIFSCCode("HDFC0001234");
        merchantOnboardPage.enterBranchName("Main Branch");
        testEnterValidAccountHolderName();
        testSelectMonthlyExpenditure();
        merchantOnboardPage.enterCompanyName("Twilight IT Solutions");
        merchantOnboardPage.enterCompanyAddress("Puducherry");
        testEnterValidPincode();
        testValidCityName();
        testSelectState(); 
        driver.findElement(By.xpath("//input[@value='Next']")).click();
        Thread.sleep(5000);
        Assert.assertEquals(merchantOnboardPage.getErrorMessage(),"This field is required.");
    }
    
    @Test
  //TC_AXP_ADM_MERON_37
    public void testEnterValidDetailsAndClickDraft() throws Exception {
    	testSelectValidBusinessType();
    	selectValidBusinessCategory();
    	merchantOnboardPage.enterBankName("Housing Development Finance Corporation");
    	merchantOnboardPage.enterBankAccountNumber("0000888899999");
    	merchantOnboardPage.enterIFSCCode("HDFC0001234");
        merchantOnboardPage.enterBranchName("Main Branch");
        testEnterValidAccountHolderName();
        testSelectMonthlyExpenditure();
        merchantOnboardPage.enterCompanyName("Twilight IT Solutions");
        merchantOnboardPage.enterCompanyAddress("Puducherry");
        testEnterValidPincode();
        testValidCityName();
        testSelectState(); 
        driver.findElement(By.xpath("//input[@value='Draft']")).click();
        Thread.sleep(5000);
        
    }
    @Test
  //TC_AXP_ADM_MERON_38
    public void testValidCompanyDetails() throws Exception {
    	testSelectValidBusinessType();
    	selectValidBusinessCategory();
    	merchantOnboardPage.enterBankName("Housing Development Finance Corporation");
    	merchantOnboardPage.enterBankAccountNumber("0000888899999");
    	merchantOnboardPage.enterIFSCCode("HDFC0001234");
        merchantOnboardPage.enterBranchName("Main Branch");
        testEnterValidAccountHolderName();
        testSelectMonthlyExpenditure();
        merchantOnboardPage.enterCompanyName("Twilight IT Solutions");
        merchantOnboardPage.enterCompanyAddress("Puducherry");
        testEnterValidPincode();
        testValidCityName();
        testSelectState(); 
        driver.findElement(By.xpath("//input[@value='Next']")).click();
        System.out.println(driver.getCurrentUrl());
    	
    }
    
    @Test
  //TC_AXP_ADM_MERON_39
    public void testClickCompanyInfoTab() throws Exception {
    	testValidCompanyDetails();
    	Thread.sleep(3000);
    	merchantOnboardPage.clickCompanyDetailsTab();
    }
    
    @Test
  //TC_AXP_ADM_MERON_40
    public void testEditCompanyInfoAndClickNext() throws Exception {
    	testValidCompanyDetails();
    	Thread.sleep(2000);
    	merchantOnboardPage.clickCompanyDetailsTab();
    	Thread.sleep(3000);
    	WebElement nxtbtn = driver.findElement(By.xpath("//input[@value='Next']"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nxtbtn);
    	nxtbtn.click();
    	System.out.println(driver.getCurrentUrl());
    }
    
    @Test
  //TC_AXP_ADM_MERON_41//TC_AXP_ADM_MERON_42
    public void testClickPersonalDetailsTab() throws Exception {
    	testValidCompanyDetails();
    	merchantOnboardPage.clickPersonalDetailsTab();
    	System.out.println(driver.getCurrentUrl());
    	Thread.sleep(2000);
    	merchantOnboardPage.nxtbtn();
    	merchantOnboardPage.clickCompanyDetailsTab();
    	Thread.sleep(3000);
    	merchantOnboardPage.nxtbtn();
    	System.out.println(driver.getCurrentUrl());
    }
    
    @Test
  //TC_AXP_ADM_MERON_43
    public void verifyUserDetailsDisplayedCorrectly() throws Exception {
    	testValidCompanyDetails();
    	Thread.sleep(2000);
    	merchantOnboardPage.clickPersonalDetailsTab();
    	jsExecutor.executeScript("window.scrollBy(0,500)");
    	Thread.sleep(5000);
    	String expectedEmail = merchantOnboardPage.getEmailValue();
    	String expectedmobileNum = merchantOnboardPage.getMobileNumberValue();
    	
    	merchantOnboardPage.clickCompanyDetailsTab();
    	merchantOnboardPage.nxtbtn();
    	
    	String actualEmailId = merchantOnboardPage.getDisplayedEmail();
    	String actualcontactNum = merchantOnboardPage.getDisplayedContent();

    	Assert.assertEquals(expectedEmail, actualEmailId);
    	Assert.assertEquals(expectedmobileNum, actualcontactNum);
    }
    
    @Test
  //TC_AXP_ADM_MERON_44
    public void validateUserIdFormat() throws Exception {
    	testValidCompanyDetails();
    	Thread.sleep(2000);
        String userId = merchantOnboardPage.getUserIdValue();
        System.out.println(userId);
        // Validate that the User ID is displayed correctly
        Assert.assertNotNull("User ID is not displayed", userId);
    }
    

    @Test
    //TC_AXP_ADM_MERON_45
    public void testClickNextButton() throws Exception {
    	testValidCompanyDetails();
    	merchantOnboardPage.nxtbtn();
    	Thread.sleep(2000);
    	Assert.assertEquals(merchantOnboardPage.getErrorMessage(),"This field is required.");
    }
    @Test
  //TC_AXP_ADM_MERON_46
    public void testEnterAlphabetsAndSpecialCharacters() throws Exception {
    	testValidCompanyDetails();
    	Thread.sleep(2000);
        String[] testValues = {"abc", "@#$%", "1a2b3c", "!@#123"};
        for (String value : testValues) {
        	merchantOnboardPage.enterPercentageFees(value);
            String enteredValue = merchantOnboardPage.getPercentageFeesValue();
            Assert.assertEquals( value, enteredValue,"The entered value should match the input value");
        }
        
    } 

    @Test
  //TC_AXP_ADM_MERON_47
    public void testEnterNumberMoreThan100Percent() throws Exception {
    	testValidCompanyDetails();
    	Thread.sleep(2000);
    	merchantOnboardPage.enterPercentageFees("150");
    	String enteredValue = merchantOnboardPage.getPercentageFeesValue();
        Assert.assertEquals( "150", enteredValue,"The entered value should match the input value");
        Thread.sleep(2000);
        Assert.assertEquals(merchantOnboardPage.getErrorMessage(),"Please enter a valid percentage (0-100) with up to 2 decimal places.");
    }
    @Test
  //TC_AXP_ADM_MERON_48
    public void testValidPercentageFees() throws Exception {
    	testValidCompanyDetails();
    	Thread.sleep(2000);
        String validPercentage = "15";
        merchantOnboardPage.enterPercentageFees(validPercentage);
        Thread.sleep(2000);
        String enteredValue = merchantOnboardPage.getPercentageFeesValue();
        Assert.assertEquals( validPercentage, enteredValue,"The entered percentage fees should match the valid input.");
    }
    
    @Test
  //TC_AXP_ADM_MERON_49
    public void testSelectVendor() throws Exception {
    	testValidCompanyDetails();
    	Thread.sleep(2000);
    	merchantOnboardPage.selectVendor("Super Admin");
        String selectedVendor = merchantOnboardPage.getSelectedVendor();
        Assert.assertEquals("Super Admin", selectedVendor);
    }
    
    @Test
    //TC_AXP_ADM_MERON_50
    public void testPayInToggleSwitch() throws Exception {
    	testValidCompanyDetails();
    	Thread.sleep(2000);
    	
        // Initial state verification
        Assert.assertFalse(merchantOnboardPage.isPayInButtonPressed());
        Assert.assertEquals("0", merchantOnboardPage.getPayInInputValue());

        // Click the pay in button
        merchantOnboardPage.clickPayInButton();
        Thread.sleep(2000);

        // Verification after clicking
        Assert.assertTrue(merchantOnboardPage.isPayInButtonPressed());
        Assert.assertEquals("1", merchantOnboardPage.getPayInInputValue());
        Thread.sleep(2000);
        merchantOnboardPage.clickPayOutToggle();
        Thread.sleep(2000);
        Assert.assertTrue( merchantOnboardPage.isPayOutToggled(),"Pay Out toggle should be on");
    }
    @Test
  //TC_AXP_ADM_MERON_51
    public void testMandatoryFieldsAndNextButton() throws Exception {
    	testValidCompanyDetails();
    	String validPercentage = "60.5";
        merchantOnboardPage.enterPercentageFees(validPercentage);
        merchantOnboardPage.selectVendor("Super Admin");
        merchantOnboardPage.clickPayInButton();
        merchantOnboardPage.clickPayOutToggle();
        //merchantOnboardPage.nxtbtn();
        Thread.sleep(2000);
    	//Assert.assertEquals(merchantOnboardPage.getErrorMessage_without_any_webapps(), "Add active web app atleast one record Required!!");
    	
    }
    @Test
  //TC_AXP_ADM_MERON_52
    public void testClickingButtonOpensModal() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	Thread.sleep(2000);
    	merchantOnboardPage.clickAddButton();
    	Thread.sleep(2000);
        Assert.assertTrue( merchantOnboardPage.isModalDisplayed(),"Modal should be displayed");
    }
    
    @Test
  //TC_AXP_ADM_MERON_53
    public void testAddApplicationWithEmptyMandatoryFields() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	merchantOnboardPage.clickAddButton();
    	Thread.sleep(2000);
    	 WebElement element = driver.findElement(By.xpath("//button[text()='Add Application']"));
    	 // Use JavaScript to scroll to the element
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
         Thread.sleep(2000);
         element.click();
         Thread.sleep(3000);
        String invalidFeedbackText = merchantOnboardPage.getInvalidFeedbackText();
        Assert.assertTrue( invalidFeedbackText.contains("This field is required."),"Expected invalid feedback for App Name");
        
    }
    

    @Test
  //TC_AXP_ADM_MERON_54
    public void testClickCloseButton() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	Thread.sleep(2000);
    	merchantOnboardPage.clickAddButton();
    	Thread.sleep(2000);
    	merchantOnboardPage.clickCloseButton();
        Assert.assertTrue( merchantOnboardPage.isCloseButtonDisplayed(),"Close button should be displayed");
    }
    
    @Test
  //TC_AXP_ADM_MERON_55//TC_AXP_ADM_MERON_56//TC_AXP_ADM_MERON_57
    public void testAddWebApplicationandCloseButton() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	Thread.sleep(2000);
    	merchantOnboardPage.clickAddButton();
    	merchantOnboardPage.enterValidDetails();
    	merchantOnboardPage.clickCloseButton();
    	Thread.sleep(3000);
    	merchantOnboardPage.clickAddButton();
    	Thread.sleep(3000);
    }
    
    @Test
  //TC_AXP_ADM_MERON_58
    public void testEnterAppName() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	merchantOnboardPage.clickAddButton();
    	merchantOnboardPage.enterValidDetails();
    	Assert.assertEquals(merchantOnboardPage.getAppNameInputValue(), "appxpay");
    }
    
    @Test
  //TC_AXP_ADM_MERON_59
    public void testInvalidUrlEntry() throws Exception {
    	testMandatoryFieldsAndNextButton();
    
    	merchantOnboardPage.clickAddButton();
    	merchantOnboardPage.enterAppUrlInputValue("invalid-url");
    	Assert.assertEquals(merchantOnboardPage.getInvalidFeedbackText(), "Please enter a valid URL.");
    }
    
    @Test
  //TC_AXP_ADM_MERON_60
    public void testEnterValidUrlInAppUrlField() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	merchantOnboardPage.clickAddButton();
    	merchantOnboardPage.enterAppUrlInputValue("https://stageadmin.appxpay.com/onboarding/cokxgpauql/373");
    	
    }
    

    @Test
  //TC_AXP_ADM_MERON_61
    public void testSpecialCharactersInOrderPrefix() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	merchantOnboardPage.clickAddButton();
        String specialChars = "!@#$%^&*()";
        merchantOnboardPage.setOrderPrefixField(specialChars);
        String actualValue = merchantOnboardPage.getOrderPrefixFieldValue();
        assertEquals("", actualValue); // Expecting no value should be set
    }
    
    @Test
  //TC_AXP_ADM_MERON_62
    public void testOrderPrefixMoreThanFourCharacters() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	merchantOnboardPage.clickAddButton();
        String orderPrefix = "ABCDE"; // More than 4 characters
        merchantOnboardPage.enterOrderPrefixInputValue(orderPrefix);
        // Assertion
        Assert.assertEquals("ABCD", merchantOnboardPage.getOrderPrefixInputValue());
    }
    
    
    @Test
    //TC_AXP_ADM_MERON_63
    public void testInvalidWebhookUrl() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	merchantOnboardPage.clickAddButton();
        String invalidUrl = "invalid-url";
        merchantOnboardPage.enterWebhookUrlInputValue(invalidUrl);
        String enteredValue = merchantOnboardPage.getWebhookUrlInputValue();
        Assert.assertEquals( invalidUrl, enteredValue,"The entered value should match the invalid URL.");
        
    }
    
    @Test
  //TC_AXP_ADM_MERON_64
    public void testEnterValidWebhookUrl() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	merchantOnboardPage.clickAddButton();
        String validUrl = "https://example.com/webhook";
        merchantOnboardPage.enterWebhookUrlInputValue(validUrl);
        
        // Assert that the value is entered correctly
        Assert.assertEquals(validUrl, merchantOnboardPage.getWebhookUrlInputValue(),"The entered value should match the invalid URL.");
    }
    
    @Test
  //TC_AXP_ADM_MERON_65
    public void testInvalidIPv4AddressWithLetters() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	merchantOnboardPage.clickAddButton();
    	merchantOnboardPage.enterIpWhitelistInputValue("192.168.a.1");
        // Assert that the input is invalid
        Assert.assertEquals( merchantOnboardPage.getIpWhitelistInputValue(),"192.168.a.1","The input should be rejected");

    }

    @Test
  //TC_AXP_ADM_MERON_66
    public void testValidIpAddress() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	merchantOnboardPage.clickAddButton();
        String validIp = "192.168.1.1";
        merchantOnboardPage.enterIpWhitelistInputValue(validIp);
        
        Assert.assertEquals(validIp, merchantOnboardPage.getIpWhitelistInputValue());
    }
    
    @Test
    //TC_AXP_ADM_MERON_67
    public void testToggleSwitch() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	merchantOnboardPage.clickAddButton();
    	merchantOnboardPage.enterValidDetails();
    	
        // Verify initial state
        Assert.assertFalse( merchantOnboardPage.isToggleButtonPressed(),"Toggle should be off initially");
        Assert.assertEquals("0", merchantOnboardPage.getStatusInputValue(),"Initial status input value should be 0");

        // Click the toggle button
        merchantOnboardPage.clickToggleButton();

        // Verify state after click
        Assert.assertTrue( merchantOnboardPage.isToggleButtonPressed(),"Toggle should be on after click");
        Assert.assertEquals("1", merchantOnboardPage.getStatusInputValue(),"Status input value should be 1 after toggle");

    }
    
    @Test
  //TC_AXP_ADM_MERON_68
    public void testValidSubmission() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	Thread.sleep(2000);
    	merchantOnboardPage.clickAddButton();
    	merchantOnboardPage.enterValidDetails();
    	merchantOnboardPage.clickToggleButton();
    	merchantOnboardPage.ClickAddAppButton();
    	driver.switchTo().defaultContent();
    	System.out.println(merchantOnboardPage.getOrderID());
     }
    
    @Test
  //TC_AXP_ADM_MERON_69
    public void verifyBadgeTextAndVisibility() throws Exception {
    	testValidSubmission();
        String badgeText = merchantOnboardPage.getBadgeText();
        Assert.assertEquals("Yes", badgeText);
        Assert.assertTrue(merchantOnboardPage.isBadgeVisible());

    }
    
    
    
    @Test
  //TC_AXP_ADM_MERON_70
    public void verifyBadgeTextAndVisibilityFor_NO() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	Thread.sleep(2000);
    	merchantOnboardPage.clickAddButton();
    	merchantOnboardPage.enterValidDetails();
    	merchantOnboardPage.ClickAddAppButton();
    	driver.switchTo().defaultContent();
    	System.out.println(merchantOnboardPage.getOrderID());
        String badgeText = merchantOnboardPage.getBadgeText();
        Assert.assertEquals("No", badgeText);
        Assert.assertTrue(merchantOnboardPage.isBadgeVisible());
    }
    

    @Test
  //TC_AXP_ADM_MERON_71
    public void testSortingIndicatorChangesToDescending() throws Exception {
        // Initial click to sort ascending
    	testValidSubmission();
    	merchantOnboardPage.clickTerminalIDHeader();
        String initialClass = merchantOnboardPage.getSortingClass();
        Assert.assertTrue( initialClass.contains("sorting_asc"),"Sorting class should indicate ascending");

    }
    
    @Test
    //TC_AXP_ADM_MERON_72
      public void testSortingIndicatorChangesToAscending() throws Exception {
    	 // Second click to sort descending
        merchantOnboardPage.clickTerminalIDHeader();
        String updatedClass = merchantOnboardPage.getSortingClass();
        Assert.assertTrue(updatedClass.contains("sorting_desc"),"Sorting class should indicate descending");
    }
    
    @Test
  //TC_AXP_ADM_MERON_73
    public void testNoDataInWebAppsList() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	
    }
    

    @Test
  //TC_AXP_ADM_MERON_74
    public void testEmptySearchInput() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	merchantOnboardPage.enterSearchText(""); // Entering blank space

        String searchInputValue = merchantOnboardPage.getSearchInputValue();
        Assert.assertEquals("", searchInputValue,"Search input should be empty");

    }
    @Test
  //TC_AXP_ADM_MERON_75
    public void testIrrelevantSearchText() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	String irrelevantText = "abcxyz123";
        merchantOnboardPage.enterSearchText(irrelevantText);
        
        // Assertion to verify the entered text
        Assert.assertEquals( irrelevantText, merchantOnboardPage.getSearchInputValue(),"Search box should contain the irrelevant text");
        Assert.assertEquals(merchantOnboardPage.getNodataInPay_In(),"No data available in table");
    }

    @Test
  //TC_AXP_ADM_MERON_76
    public void testCopyPasteSearchField() throws Exception {
        // Navigate to the 'Pay-in settings' tab
    	testMandatoryFieldsAndNextButton();

        // Set and copy data from the source field
    	
        String dataToCopy = "test data";
        merchantOnboardPage.enterSearchText(dataToCopy);
        merchantOnboardPage.copyFromSourceField();

        // Paste data into the search box
        merchantOnboardPage.pasteIntoSearchBox();

        // Verify that the search box contains the pasted data
        String searchBoxValue = merchantOnboardPage.getSearchBoxValue();
        Assert.assertEquals(searchBoxValue, dataToCopy, "Data pasted successfully in the search box.");
    }

    @Test
    //TC_AXP_ADM_MERON_77
    public void testSearchAndClear() throws Exception {
    	// Navigate to the 'Pay-in settings' tab
    	testMandatoryFieldsAndNextButton();
        // Enter text in the search box
        String searchText = "Test Search";
        merchantOnboardPage.enterSearchText(searchText);

        // Assert that the text is entered correctly
        Assert.assertEquals(searchText, merchantOnboardPage.getSearchInputValue());

        // Click on the 'x' icon to clear the search box
        driver.findElement(By.cssSelector("input[type='search']")).clear();

        // Assert that the search box is empty
        Assert.assertEquals("", merchantOnboardPage.getSearchInputValue());

    }
    @Test
    //TC_AXP_ADM_MERON_78
    public void testSelectDataPerPage() throws Exception {
    	testMandatoryFieldsAndNextButton();
        String selectedValue = "25";
        merchantOnboardPage.selectDataPerPage(selectedValue);
        
         //Assertion to verify the selection
        Assert.assertEquals(selectedValue, merchantOnboardPage.getDropdownValue(), "The selected data per page option is incorrect.");
    }
    @Test
  //TC_AXP_ADM_MERON_79
    public void testPreviousButtonDisabledOnFirstPage() throws Exception {
    	testMandatoryFieldsAndNextButton();
    	
        // Click the disabled button
    	merchantOnboardPage.clickPreviousButton();
    	Assert.assertTrue( merchantOnboardPage.isPreviousButtonDisabled(),"Previous button should not be disabled");

    }
    @Test
  //TC_AXP_ADM_MERON_80
    public void testClickPreviousButtonOnLastPage() throws Exception {
    	testMandatoryFieldsAndNextButton();
        // Attempt to click the Previous button
        merchantOnboardPage.clickPreviousButton();

        // Assert that the button remains disabled
        Assert.assertTrue( merchantOnboardPage.isPreviousButtonDisabled(),"Previous button should not be disabled");
    }
    
    @Test
  //TC_AXP_ADM_MERON_81
    public void testNextButtonNavigation() throws Exception{
    	testMandatoryFieldsAndNextButton();
        // Click the "Next" button
        merchantOnboardPage.clickNextButtononPage();
        
        // Verify that the "Next" button is enabled before clicking
        Assert.assertTrue(merchantOnboardPage.isNextButtonEnabled(),"Next button should be enabled");

    }
    
    @Test
  //TC_AXP_ADM_MERON_84
    public void testUpdateButtonTriggersUpdateProcess() throws Exception{
    	testValidSubmission();
        Assert.assertTrue( merchantOnboardPage.isUpdateButtonDisplayed(),"Update button is not displayed");
        jsExecutor.executeScript("window.scrollBy(1000,0)");
        merchantOnboardPage.clickUpdateButton();
    }

    @Test
  //TC_AXP_ADM_MERON_85
    public void testUpdateWebApp() throws Exception{
    	testValidSubmission();
        Assert.assertTrue( merchantOnboardPage.isUpdateButtonDisplayed(),"Update button is not displayed");
        jsExecutor.executeScript("window.scrollBy(1000,0)");
        merchantOnboardPage.clickUpdateButton();
        merchantOnboardPage.enterAppUrlInputValue("https://opnworx.com/app/user-timesheet");
        merchantOnboardPage.clickToggleButton();
    	merchantOnboardPage.ClickAddAppButton();
    }
    @Test
  //TC_AXP_ADM_MERON_86
    public void testChangeOrderPrefix() throws Exception {
    	testValidSubmission();
        Assert.assertTrue( merchantOnboardPage.isUpdateButtonDisplayed(),"Update button is not displayed");
        merchantOnboardPage.clickUpdateButton();
        try{
        	merchantOnboardPage.enterOrderPrefixInputValue("ORD");
            merchantOnboardPage.clickToggleButton();
        	merchantOnboardPage.ClickAddAppButton();
        }catch (Exception e) {
		System.out.println(e.getMessage());
		}
        
    }

    @Test
  //TC_AXP_ADM_MERON_87
    public void testUpdateWebAppData() throws Exception {
    	testValidSubmission();
        Assert.assertTrue( merchantOnboardPage.isUpdateButtonDisplayed(),"Update button is not displayed");
        merchantOnboardPage.clickUpdateButton();
        merchantOnboardPage.enterWebhookUrlInputValue("https://opnworx.com/app/");
    	merchantOnboardPage.ClickAddAppButton();
    }
    @Test
    //TC_AXP_ADM_MERON_88
    public void testEnterValuesAndAddWebApp() throws Exception {
    	testValidSubmission();
    	merchantOnboardPage.nxtbtn();
    }
    
    @Test
  //TC_AXP_ADM_MERON_89
    public void testClickOnPayInSettingsTab() throws Exception {
    	testEnterValuesAndAddWebApp();
    	
    	try {
    		merchantOnboardPage.clickPayInSettingsTab();
    		merchantOnboardPage.clickBusinessInfoTab();
        	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
    }
    
    @Test
    //TC_AXP_ADM_MERON_90
      public void testClickbussinessInfoTab() throws Exception {
    	testEnterValuesAndAddWebApp();
    	try {
    		merchantOnboardPage.clickCompanyDetailsTab();
    		Thread.sleep(2000);
    		merchantOnboardPage.clickPayInSettingsTab();
    		merchantOnboardPage.clickBusinessInfoTab();
        	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    
    }
    

    @Test
    //TC_AXP_ADM_MERON_91//TC_AXP_ADM_MERON_92
      public void testClickPersonalDetailTab() throws Exception {
    	testEnterValuesAndAddWebApp();
    	try {
    		merchantOnboardPage.clickPersonalDetailsTab();
    		merchantOnboardPage.clickCompanyDetailsTab();
    		Thread.sleep(2000);
    		merchantOnboardPage.clickPayInSettingsTab();
    		merchantOnboardPage.clickBusinessInfoTab();
        	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
    
    @Test
    //TC_AXP_ADM_MERON_93
    public void testCompleteButtonSubmitsForm() throws Exception {
        // Assume that all required fields are filled out correctly before this step
    	testEnterValuesAndAddWebApp();
    	//merchantOnboardPage.clickCompleteButton();
    	//merchantOnboardPage.clickCancelButton();
    	//driver.findElement(By.xpath("//button[contains(@class,'swal2-confirm btn')]")).click();
    	
    }
    
    
    @Test
  //TC_AXP_ADM_MERON_94
    public void testUploadPdfFile() throws Exception {
    	testCompleteButtonSubmitsForm();
        String pdfFilePath = "C:/Users/veera/Documents/9-11.pdf"; // Provide the path to a valid PDF file
        merchantOnboardPage.uploadFilePAN(pdfFilePath);
        
    }
    
    
    @Test
    public void testCancelButtonIsClickable() {
       
        // Assertion to check if the button is disabled
        Assert.assertFalse(merchantOnboardPage.isCancelButtonEnabled(),"Cancel button should be disabled");
        
        // Attempt to click the button
        merchantOnboardPage.clickCancelButton();
    }
    
    @Test
    //TC_AXP_ADM_MERON_94
    public void testUploadInValidPdfFile() throws Exception {
    	testCompleteButtonSubmitsForm();
        String validPdfFilePath = "C:/Users/veera/Documents/ideaIC-2018.3.6.exe"; 
        merchantOnboardPage.uploadInvalidFileGST(validPdfFilePath);
    }
    @Test
    public void testUploadFileMoreThan5Mb() throws Exception {
    	testCompleteButtonSubmitsForm();
        String validPdfFilePath = "C:/Users/veera/Documents/2022-23 IT.pdf"; 
        merchantOnboardPage.uploadInvalidFileGST(validPdfFilePath);
    }
    
    
    @Test
    //TC_AXP_ADM_MERON_97
    public void testUploadFileAgain() throws Exception {
    	testCompleteButtonSubmitsForm();
    	merchantOnboardPage.uploadFilePAN("C:/Users/veera/Documents/9-11.pdf");
        Thread.sleep(3000);
        merchantOnboardPage.uploadFilePAN("C:/Users/veera/Documents/02 - 12.pdf");
    }
    

    @Test
    //TC_AXP_ADM_MERON_99
    public void testUploadPdfFile_all_mandatoryfields () throws Exception {
    	testCompleteButtonSubmitsForm();
        merchantOnboardPage.uploadFilePAN("C:/Users/veera/Documents/9-11.pdf");
        merchantOnboardPage.uploadInvalidFileGST("C:/Users/veera/Documents/9-11.pdf");
        merchantOnboardPage.uploadBankStatement("C:/Users/veera/Documents/9-11.pdf");
        merchantOnboardPage.uploadCancelCheque("C:/Users/veera/Documents/9-11.pdf");
        merchantOnboardPage.uploadCertification_of_Incorporation("C:/Users/veera/Documents/9-11.pdf");
        merchantOnboardPage.uploadMOA("C:/Users/veera/Documents/9-11.pdf");
        merchantOnboardPage.uploadAOA("C:/Users/veera/Documents/9-11.pdf");
        merchantOnboardPage.uploadauthsignatorypancard("C:/Users/veera/Documents/9-11.pdf");
        merchantOnboardPage.uploaduthSignatoryAadharcard("C:/Users/veera/Documents/9-11.pdf");
        //click Complete Button
        merchantOnboardPage.clickCompleteButton();
    }
    @Test
    //TC_AXP_ADM_MERON_100
    public void verify_click_Cancel_button() throws Exception {
    	testUploadPdfFile_all_mandatoryfields();
    	merchantOnboardPage.clickCancelButton();
    	// Attempt to click the button
    	merchantOnboardPage.clickOkButtononbussinesspage();
    	
    }
    @Test
  //TC_AXP_ADM_MERON_101
    public void testCompleteItButtonClick() throws Exception {
    	testUploadPdfFile_all_mandatoryfields();
    	merchantOnboardPage.clickconfirmbtn();
    }

    
    
    
//    @Test
//    public void testViewPDFbtn() {
//        
//        Assert.assertTrue( merchantOnboardPage.isButtonEnabled(),"Button should be enabled");
//        merchantOnboardPage.clickButton();
//    }
//    
//    @Test
//    public void verifyPdfLinkOpensInNewTab() throws Exception {
//    	testCompleteButtonSubmitsForm();
//        merchantOnboardPage.uploadFilePAN("C:/Users/veera/Documents/9-11.pdf");
//        // Click the PDF link
//        driver.findElement(merchantOnboardPage.getPdfLink()).click();
//
//        // Wait for new tab and switch to it
//        Thread.sleep(3000);
//        String originalWindow = driver.getWindowHandle();
//        for (String windowHandle : driver.getWindowHandles()) {
//            if (!windowHandle.equals(originalWindow)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }
//
//        // Verify the PDF document is opened
//        Assert.assertTrue(driver.getCurrentUrl().contains(".pdf"));
//
//        // Close the new tab and switch back to the original
//        driver.close();
//        driver.switchTo().window(originalWindow);
//        
//        
//    }
//    
}
    
    
    
    

    
    
    
    

