package pages;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VendorRegistrationPage {
	private WebDriver driver;
	WebDriverWait wait;
	
	  // Locator
    By vendorMenu = By.xpath("//a[contains(.,'Vendor')]");
    By vendorOnboardingMenu = By.xpath("(//ul[@class='list-inline events']//a)[3]");
    By firstNameField = By.id("firstname-input");
    By lastNameField = By.id("lastname-input");
    By userNameField = By.id("userName");
    By submit = By.xpath("//input[@value='Next']");
    By passwordField = By.xpath("//input[@placeholder='Password']");
	 By emailField = By.xpath("//input[@placeholder='Email']");
	 By mobileNoField = By.xpath("//input[@placeholder='Mobile']");
	 By categorySelect = By.id("categorynameselect");
	 By selectedValue = By.xpath("//select[@id='categorynameselect']/option[@selected]");
	 
	 By businessTypeSelect = By.id("businesstypeselect");
	 
	 By subcategoryDropdown = By.id("subcategorynameselect");
	 
	 By categorynameselect = By.id("categorynameselect");
	 
	 By bankNameInput = By.id("banknameinput");
	 By bankAccountNumberInput = By.xpath("//input[@placeholder='Bank Acc No']");
	 
	 By invalidFeedback = By.className("invalid-feedback");

	 By ifsc_Input_Field = By.xpath("//input[@placeholder='Bank IFSC Code']");
	 By branchNameInput = By.id("branchnameinput");
	 By accountHolderNameInput = By.id("accountholdernameinput");
	

	 By monthlyExpenditureSelect = By.id("monthlyexpenditureselect");
	 By pincodeInput = By.id("companypincodeinput");
	 By cityInputField = By.id("cityinput");
	 By errorMessage = By.xpath("//input[@placeholder='City']/following-sibling::div[1]");
	 
	 By stateSelect = By.id("stateselect");
	 By selectedOption = By.xpath("//select[@id='stateselect']/option[@selected='selected']");
	 
	 By companyNameInput = By.id("companynameinput");
	 By companyAddressInput = By.id("companyaddressinput");
	 By errormessgeallfield = By.xpath("//div[text()='This field is required.']");
	 
	 By emailSelector = By.xpath("(//div[@class='mb-3']//div)[3]");
	 private By passwordToggleIcon = By.id("password-toggle-icon");
	 
	 private By vendorAgreementInput = By.id("vendorAgreement");
	 private By completeButton = By.xpath("//input[@value='Complete']");
	 private By draftButton = By.cssSelector("input.outline-btn[type='submit'][value='Draft']");
    
	public VendorRegistrationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	// Method to verify the Vendor menu is visible
    public void clickVendorMenu(){
        WebElement vendormenuElement = wait.until(ExpectedConditions.elementToBeClickable(vendorMenu));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", vendormenuElement);
        vendormenuElement.click();
    }
    
    public void clickOnboarding(){
        // Wait until the vendor onboarding menu is present and clickable
        WebElement menuElement = wait.until(ExpectedConditions.elementToBeClickable(vendorOnboardingMenu));
        menuElement.click();
       
    }
	
	 // Method to verify the Vendor menu is visible
    public boolean isVendorMenuVisible() throws Exception {
        WebElement vendorMenuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(vendorMenu));
        Thread.sleep(5000);
        return vendorMenuElement.isDisplayed();
    }

    // Method to verify the Vendor menu is clickable
    public boolean isVendorMenuClickable() {
        WebElement vendorMenuElement = wait.until(ExpectedConditions.elementToBeClickable(vendorMenu));
        return vendorMenuElement.isEnabled();
    }
    
    public boolean isVendorOnboardingMenuVisible() throws Exception {
    	clickVendorMenu();
    	
    	WebElement vendorOnboardingMenuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(vendorOnboardingMenu));
        return vendorOnboardingMenuElement.isDisplayed();
    }

    // Method to verify the Vendor Onboarding menu is clickable
    public boolean isVendorOnboardingMenuClickable() {
        WebElement vendorOnboardingMenuElement = wait.until(ExpectedConditions.elementToBeClickable(vendorOnboardingMenu));
        return vendorOnboardingMenuElement.isEnabled();
    }
    
    public boolean isOnboardingPageDisplayed() throws Exception {
    	clickVendorMenu();
    	Thread.sleep(1000);
    	clickOnboarding();
    	String onboardingPageUrl = "https://stageadmin.appxpay.com/onboarding/jnylavzkrs";
	 	String currenturl = driver.getCurrentUrl();
	 	return currenturl.equals(onboardingPageUrl);
    }
    
    public void enterFirstName(String firstName) {
        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }

    // Method to enter text into the Last Name field
    public void enterLastName(String lastName) {
        WebElement lastNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }

    // Method to enter text into the User Name field
    public void enterUserName(String userName) {
        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        userNameElement.clear();
        userNameElement.sendKeys(userName);
    }
    
 // Method to enter password
    public void enterPassword(String password) {
    	 WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
    	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", passwordElement);
    	 passwordElement.sendKeys(password);
    }

    public void clickPasswordToggleIcon() {
        driver.findElement(passwordToggleIcon).click();
    }

    public String getPasswordFieldType() {
        return driver.findElement(passwordField).getAttribute("type");
    }
    public void enterEmail(String email) {
   	 WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
   	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailElement);
   	emailElement .sendKeys(email);
    }
   	
   	public void enterMobile(String mobile) {
   		WebElement mobile_No = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNoField));
   	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mobile_No);
   		mobile_No.sendKeys(mobile);
    }
   
    

    // Method to get the value from the First Name field
    public String getFirstName() {
        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        return firstNameElement.getAttribute("value");
    }

    // Method to get the value from the Last Name field
    public String getLastName() {
        WebElement lastNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        return lastNameElement.getAttribute("value");
    }

    // Method to get the value from the User Name field
    public String getUserName() {
        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        return userNameElement.getAttribute("value");
    }

    public String getPasswordValue() {
        return driver.findElement(passwordField).getAttribute("value");
    }
    public String getEmailFieldValue() {
        return driver.findElement(emailField).getAttribute("value");
    }
    public String getMobileValue() {
        return driver.findElement(mobileNoField).getAttribute("value");
    }
  
    public void errormsgforfirst_Name() {
    	//This field is required for first name
    	String actualerrormsg = "This field is required";
    	String error = driver.findElement(By.xpath("(//div[text()='This field is required'])[1]")).getText();
    	Assert.assertEquals(actualerrormsg, error);
    }
    public void errormsgforLast_Name() {
    	//This field is required for last name
    	String actualerrormsg = "This field is required";
    	String error = driver.findElement(By.xpath("(//div[text()='This field is required'])[2]")).getText();
    	Assert.assertEquals(actualerrormsg, error);
    }
    public void errormsgforUser_Name() {
    	//This field is required for user name
    	String actualerrormsg = "This field is required";
    	String error = driver.findElement(By.xpath("(//div[@class='invalid-feedback'])[3]")).getText();
    	Assert.assertEquals(actualerrormsg, error);
    }
    public void errormsgforEmail_id() {
    	//This field is required for Email
    	String actualerrormsg = "Please enter a valid email address";
    	String error = driver.findElement(By.xpath("//div[text()='Please enter a valid email address']")).getText();
    	Assert.assertEquals(actualerrormsg, error);
    }
    public void errormsgforMobile_number() {
    	//This field is required for Email
    	String actualerrormsg = "Please enter a valid 10-digit phone number";
    	String error = driver.findElement(By.xpath("//input[@id='mobile']/following-sibling::div[1]")).getText();
    	Assert.assertEquals(actualerrormsg, error);
    }
    public void EnterPhoneNumberLessthanTenDigit() {
    	String actualerrormsg = "Please enter a valid 10-digit phone number";
    	String errortext = driver.findElement(By.xpath("//div[text()='Please enter a valid 10-digit phone number']")).getText();
    	Assert.assertEquals(actualerrormsg, errortext);
    }
    public String getErrorMessageAlready_exists() {
        WebElement errorMessage = driver.findElement(By.xpath("//div[text()='Username already exists']"));
        return errorMessage.getText();
    }
    
    public String getDisplayedUsername() {
        WebElement displayedUsername = driver.findElement(By.id("displayed_username"));
        return displayedUsername.getText();
    }
    public String getUsername() {
        return driver.findElement(userNameField).getAttribute("value");
    }
    

    public  String getRandomFirstName() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public  String getRandomLastName() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public String getRandomUsername() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    public  String getRandomPassword() {
        return RandomStringUtils.randomAlphanumeric(12);
    }

    public String getRandomEmail() {
        return RandomStringUtils.randomAlphanumeric(8) + "@example.com";
    }

    public  String getRandomMobileNumber() {
        return RandomStringUtils.randomNumeric(10);
    }
    
    public void enterRandomData() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement firstNameElem = driver.findElement(firstNameField);
        WebElement lastNameElem = driver.findElement(lastNameField);
        WebElement usernameElem = driver.findElement(userNameField);
       
        WebElement passwordElem = driver.findElement(passwordField);
        WebElement emailElem = driver.findElement(emailField);
        WebElement mobileNumberElem = driver.findElement(mobileNoField);

        firstNameElem.sendKeys("QA"+getRandomFirstName());
        lastNameElem.sendKeys("QA"+getRandomLastName());
        usernameElem.sendKeys("QA"+getRandomUsername());
        js.executeScript("window.scrollBy(0,500)"); // Scrolls down by 500 pixel
        passwordElem.sendKeys(getRandomPassword());
        emailElem.sendKeys(getRandomEmail());
        mobileNumberElem.sendKeys(getRandomMobileNumber());
        
    }
    
    public void submitbtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submit));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();

    }
    
    

    public void selectBusinessCategory1(String category) {
        Select select = new Select(driver.findElement(businessTypeSelect));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", select);
        select.selectByVisibleText(category);
    }

    public boolean isBusinessCategoryDisplayed1(String category) {
        Select select = new Select(driver.findElement(businessTypeSelect));
        return select.getOptions().stream().anyMatch(option -> option.getText().equals(category));
    }

    
    public void selectBusinessCategory2(String category) {
        Select dropdown = new Select(driver.findElement(categorynameselect));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
        dropdown.selectByVisibleText(category);
    }

    public boolean isCategoryDisplayed2(String category) {
        Select dropdown = new Select(driver.findElement(categorynameselect));
        return dropdown.getOptions().stream().anyMatch(option -> option.getText().equals(category));
    }
    
    public void selectBusinessSubCategory(String category) {
        Select dropdown = new Select(driver.findElement(subcategoryDropdown));
        dropdown.selectByVisibleText(category);
    }

    public boolean isSubCategoryDisplayed(String category) {
        Select dropdown = new Select(driver.findElement(subcategoryDropdown));
        return dropdown.getOptions().stream().anyMatch(option -> option.getText().equals(category));
    }
    

    public void selectCategory(String category) {
        WebElement selectElement = driver.findElement(categorySelect);
        selectElement.click();
        selectElement.findElement(By.xpath("//option[text()='" + category + "']")).click();
    }

    public String getSelectedCategory() {
        WebElement selectElement = driver.findElement(categorySelect);
        return selectElement.findElement(By.cssSelector("option:checked")).getText();
    }
    

    public void enterBankName(String bankName) {
    	WebElement bankNameInputF = driver.findElement(bankNameInput);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bankNameInputF);
    	bankNameInputF.sendKeys(bankName);
    }

    public String getBankName() {
        return driver.findElement(bankNameInput).getAttribute("value");
    }
    public void enterBankAccountNumber(String accountNumber) {
        WebElement accountnum = driver.findElement(bankAccountNumberInput);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accountnum);
        accountnum.clear();
        accountnum.sendKeys(accountNumber);
    }
    public String getBankAccountNumberInputValue() {
    	String attrbutevalue = driver.findElement(bankAccountNumberInput).getAttribute("value");
		return attrbutevalue;
    	
    }
    
    public String getInvalidFeedbackElement() {
    	
        return driver.findElement(invalidFeedback).getText();
    }
    

    public void enterIFSCCode(String ifscCode) {
    	WebElement ifscInputField = driver.findElement(ifsc_Input_Field);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ifscInputField);
        ifscInputField.clear();
        ifscInputField.sendKeys(ifscCode);
    }

    public String getIFSCCode() {
    	WebElement ifscInputField = driver.findElement(ifsc_Input_Field);
        return ifscInputField.getAttribute("value");
    }
    
    public void enterBranchName(String branchName) {
        WebElement inputField = driver.findElement(branchNameInput);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputField);
        inputField.clear();
        inputField.sendKeys(branchName);
    }

    public String getBranchNameValue() {
        return driver.findElement(branchNameInput).getAttribute("value");
    }
    

    // Actions
    public void enterAccountHolderName(String name) {
    	WebElement accountHolder = driver.findElement(accountHolderNameInput);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accountHolder);
    	accountHolder.clear();
    	accountHolder.sendKeys(name);
    }

    public String getAccountHolderName() {
        return driver.findElement(accountHolderNameInput).getAttribute("value");
    }
    
 // Actions
    public void enterCompanyName(String companyName) {
        driver.findElement(companyNameInput).sendKeys(companyName);
    }

    public String getCompanyNameInputValue() {
        return driver.findElement(companyNameInput).getAttribute("value");
    }
    
    // Actions
    public void selectMonthlyExpenditure(String optionValue) throws Exception {
    	
        WebElement selectElement = driver.findElement(monthlyExpenditureSelect);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectElement);
        selectElement.click();
        Thread.sleep(2000);
        WebElement option = driver.findElement(By.xpath("(//select[@id='monthlyexpenditureselect']//option)["+optionValue+"]"));
        option.click();
    }

    public String getSelectedOption() {
        WebElement selectElement = driver.findElement(monthlyExpenditureSelect);
        return selectElement.getAttribute("value");
    }
    
    
    

    // Actions
    public void enterPincode(String pincode) {
        WebElement inputField = driver.findElement(pincodeInput);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputField);
        inputField.clear();
        inputField.sendKeys(pincode);
    }

    public String getPincodeInputValue() {
        return driver.findElement(pincodeInput).getAttribute("value");
    }
    
 // Actions
    public void enterCity(String city) {
    	WebElement cityField = driver.findElement(cityInputField);
    	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cityField);
    	   cityField.clear();
    	   cityField.sendKeys(city);
    }

    public String getCityInputValue() {
        return driver.findElement(cityInputField).getAttribute("value");
    }

    public boolean getErrorMessagecity() {
        return ((CharSequence) driver.findElement(errorMessage)).isEmpty();
    }
    
    public void clickStateSelect() {
    	WebElement stateField = driver.findElement(stateSelect);
 	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stateField);
 	  stateField.click();
    }

    public void selectStateByValue(String value) {
        WebElement selectElement = driver.findElement(stateSelect);
        selectElement.findElement(By.xpath("(//select[@id='stateselect']//option)["+value+"]")).click();
    }

    public void nxtbtn() throws Exception {
	WebElement nxtbtn = driver.findElement(By.xpath("//input[@value='Next']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nxtbtn);
	nxtbtn.click();
	Thread.sleep(3000);
}
    // Actions
    public void enterCompanyAddress(String address) {
        driver.findElement(companyAddressInput).sendKeys(address);
    }
    public String getCompanyAddressInputValue() {
        return driver.findElement(companyAddressInput).getAttribute("value");
    }
    public String getErrorMessage() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(invalidFeedback));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", errorMessage);
        return errorMessage.getText();
    }
    public void uploadFileVendor_Agreement(String filePath) throws Exception {
        WebElement uploadElement = driver.findElement(vendorAgreementInput);
        wait.until(ExpectedConditions.visibilityOfElementLocated(vendorAgreementInput));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadElement);
        uploadElement.sendKeys(filePath);
        Thread.sleep(4000);
    }
    
    public void clickCompleteButton() {
            WebElement completebtn = driver.findElement(completeButton);
            wait.until(ExpectedConditions.visibilityOfElementLocated(completeButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", completebtn);
            completebtn.click();
    }

    public void clickDraftButton() {
        driver.findElement(draftButton).click();
    }
    
    }  
