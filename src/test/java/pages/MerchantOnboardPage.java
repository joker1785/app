package pages;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class MerchantOnboardPage {
	private WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
	 
	By merchantRegisterLink = By.xpath("(//span[@class='link_name'])[2]");
	 By merchantOnboarding = By.xpath("//a[contains(.,'Merchant Onboarding')]");
	
	 By firstNameField = By.id("firstname-input");
	 By lastNameField = By.id("lastname-input");
	 By userNameField = By.id("userName");
	 By passwordField = By.xpath("//input[@placeholder='Password']");
	 By emailField = By.xpath("//input[@placeholder='Email']");
	 By mobileNoField = By.xpath("//input[@placeholder='Mobile']"); 
	 By submitbutton = By.xpath("//input[@value='Next']");
	 By draftButton = By.xpath("//input[@value='Draft']");
	 By pa_eyeicon = By.xpath("//span[@class='input-group-text']//i[1]");
	 By toast_message = By.xpath("//div[@class='alert alert-success']");
	 
	 By companyDetailsHeader = By.xpath("(//div[@class='step-icon'])[2]");
	 By personalDetailHeadet = By.xpath("(//div[@class='step-icon'])[1]");
	 By nextbtn = By.xpath("(//input[@type='submit'])[2]");
	 
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
	 By displayedContent = By.xpath("//label[text()='Contact No']/following-sibling::div");
	 By userIdValue = By.xpath("(//div[@class='mb-3']//div)[2]");
	 
	 By percentageFeesInput = By.id("percentage_fees");
	
	 By payInButton = By.id("pay_in_button");
	 By payInInput = By.id("pay_in_input");
	 
	 By payOutButton = By.id("pay_out_button");
	 By payOutInput = By.id("pay_out_input");
	 
	 By alert_danger = By.xpath("//div[@class='alert alert-danger']");
	 By addButton = By.id("add-web-apps-manual");
	 
	 
	 By modal = By.id("addwebapps");
	By refered_by = By.xpath("//label[@for='refferedBy']/following-sibling::select[1]");
	    
	 By closeButton = By.id("closepopupwebapplicationsbutton");
	 By orderPrefixField = By.id("order_prefix");
	 By orderNumberSelector = By.cssSelector("td");
	 
	 By badgeSelector = By.cssSelector("span.badge.badge-info");
	 By sorting_asc = By.cssSelector("th.sorting_asc");
	 
	 By searchInput = By.cssSelector("input[type='search']");
	  	
	 	private By appNameInput = By.id("app_name");
	    private By appUrlInput = By.id("app_url");
	    private By orderPrefixInput = By.id("order_prefix");
	    private By webhookUrlInput = By.id("webhook_url");
	    private By ipWhitelistInput = By.id("ip_whitelist");
	    private By addApplicationButton = By.id("addwebapplicationsbutton");
	    private By invalid_Feedback = By.className("invalid-feedback");
	    By  orderId = By.xpath("(//tr[@class='odd']//td)[2]");
	    // Selectors
	    private By webAppStatusToggle = By.id("webapp_status_toggle");
	    private By statusInput = By.id("webapp_status_input");
	    By data_list = By.xpath("//td[text()='No data available in table']");
	    By dataPerPageDropdown = By.name("webApps_datatable_length");
	    By previousButton = By.xpath("//a[contains(@class,'paginate_button previous')]");
	    By nextButton = By.xpath("//a[contains(@class,'paginate_button next')]");
	    By updateButton = By.cssSelector("button.btn.update-webapp.btn-primary.btn-sm");
	    
	    By pay_in_tab = By.xpath("(//div[@class='step-icon'])[3]");
	    By buss_info_tab = By.xpath("//div[text()='04']");
	    
	    // Selectors
	    private By payInSettingsTab = By.xpath("(//div[@class='step-icon'])[3]");
	    private By businessInfoTab = By.xpath("//div[text()='04']");
	    
	    private By completeButton = By.id("completesubmitbutton");
	    private By companyPanInput = By.id("companypan");
	    By cancelButton = By.cssSelector(".swal2-cancel.btn.btn-danger");
	    By companyGstInput = By.id("companygst");

	    
	    
	    
	    
	    public MerchantOnboardPage(WebDriver driver) {
			this.driver = driver;
			this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			this.actions = new Actions(driver);
			PageFactory.initElements(driver, this);
		}
	
	 // Methods
    public void clickMerchantRegister() {
        WebElement element = driver.findElement(merchantRegisterLink);
        element.click();
    }
    
    public boolean isMerchantRegisterLinkClickable() {
        WebElement element = driver.findElement(merchantRegisterLink);
        return element.isEnabled() && element.isDisplayed();
    }
    

    public void clickMerchantOnboarding() {
    	WebElement element = driver.findElement(merchantOnboarding);
    	element.click();
    }
    
 // Method to verify if the Merchant Onboarding page is loaded
    public String  isPageLoaded() {
    	String actualText = "https://stageadmin.appxpay.com/onboarding/eqyroksfig";
		return actualText;
         
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
    	 passwordElement.sendKeys(password);
    }
    
    public void enterEmail(String email) {
   	 WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
   	emailElement .sendKeys(email);
    }
   	
   	public void enterMobile(String mobile) {
   		WebElement mobile_No = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNoField));
   		mobile_No.sendKeys(mobile);
    }
   
    // Method to get the value from the First Name field
    public String getFirstNameValue() {
        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        return firstNameElement.getAttribute("value");
    }

    // Method to get the value from the Last Name field
    public String getLastNameValue() {
        WebElement lastNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        return lastNameElement.getAttribute("value");
    }
    public String getEmailValue() {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailElement);
        return emailElement.getAttribute("value");
    }
    public String getMobileNumberValue() {
        WebElement mobileElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNoField));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mobileElement);
        return mobileElement.getAttribute("value");
    }
    
    // Method to get the value from the User Name field
    public String getUserName() {
        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        return userNameElement.getAttribute("value");
    }
    public void submitbtn() {
    	WebElement submitbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(submitbutton));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitbtn);
    	
    	submitbtn.click();
    }
    
    public void clickDraftButton() {
    	WebElement draftbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(draftButton));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", draftbutton);
    	draftbutton.click();
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
    	
    	String actualerrormsg = "Please enter a valid 10-digit phone number";
    	String error = driver.findElement(By.xpath("//input[@id='mobile']/following-sibling::div[1]")).getText();
    	Assert.assertEquals(actualerrormsg, error);
    }
    public void EnterPhoneNumberLessthanTenDigit() {
    	String actualerrormsg = "Please enter a valid 10-digit phone number";
    	String error = driver.findElement(By.xpath("//div[text()='Please enter a valid 10-digit phone number']")).getText();
    	Assert.assertEquals(actualerrormsg, error);
    }
    public void  PasswordErrorMessage() {
    	String error = driver.findElement(By.xpath("//input[@type='password']/following-sibling::div[1]")).getText();
    	String actualerrormsg = "This field is required";
    	Assert.assertEquals(actualerrormsg, error);
    }
 // Method to get password error message
    public boolean getPasswordErrorMessage() {
    	boolean error = driver.findElement(By.xpath("//input[@type='password']/following-sibling::div[1]")).isDisplayed();
		return error;
    }
    
    public String getErrorMessage_User_Already_exists() {
        WebElement errorMessage = driver.findElement(By.xpath("//div[text()='Username already exists']")); 
        return errorMessage.getText();
    }
    public void clickEyeIcon() {
    	WebElement eyeIcon = driver.findElement(pa_eyeicon);
    	eyeIcon.click();
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
    
    public String toastMessage() {
    	String toastMss = driver.findElement(toast_message).getText();
    	return toastMss;
    }
    
    public void clickCompanyDetailsTab() {
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(companyDetailsHeader));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tab);
        tab.click();
    }
    
    public boolean isCompanyDetailsPageDisplayed() {
        return driver.findElement(companyDetailsHeader).isDisplayed();
    }
    
    public void clickPersonalDetailsTab() {
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(personalDetailHeadet));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tab);
        tab.click();
    }
    

    public boolean isPersonalDetailsPageDisplayed() {
        return driver.findElement(personalDetailHeadet).isDisplayed();
    }
    
    public void clickNextButton() {
        driver.findElement(nextbtn);
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
    
    public WebElement getInvalidFeedbackElement() {
    	
        return driver.findElement(invalidFeedback);
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

    public void selectStateByValue(String value) throws Exception {
        WebElement selectElement = driver.findElement(stateSelect);
        selectElement.findElement(By.xpath("(//select[@id='stateselect']//option)["+value+"]")).click();
        Thread.sleep(3000);
    }

    public void enterCompanyName(String companyName) {
        driver.findElement(companyNameInput).sendKeys(companyName);
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
    public String getErrorMessage() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(invalidFeedback));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", errorMessage);
        return errorMessage.getText();
    }
    public String getDisplayedEmail() {
        return driver.findElement(emailSelector).getText();
    }
    public String getDisplayedContent() {
        return driver.findElement(displayedContent).getText();
    }
    
    public String getUserIdValue() {
        return driver.findElement(userIdValue).getText();
    }
    
    public void enterPercentageFees(String value) {
    	
        WebElement inputField = driver.findElement(percentageFeesInput);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputField);
        inputField.clear();
        inputField.sendKeys(value);
    }

    public String getPercentageFeesValue() {
        return driver.findElement(percentageFeesInput).getAttribute("value");
    }
    
    public void selectVendor(String vendor) throws Exception {
    	//driver.findElement(By.xpath("//label[@class='control-label']/following-sibling::select[1]")).click();
        WebElement dropdown = driver.findElement(refered_by);
        Select select = new Select(dropdown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
        select.selectByVisibleText(vendor);
        Thread.sleep(3000);
    }

    public String getSelectedVendor() {
        WebElement dropdown = driver.findElement(businessTypeSelect);
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }
    
 // Actions
    public void clickPayInButton() throws Exception {
    	WebElement paybtn = driver.findElement(payInButton);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paybtn);
    	paybtn.click();
    	Thread.sleep(3000);
    	
    }

    public boolean isPayInButtonPressed() {
        return Boolean.parseBoolean(driver.findElement(payInButton).getAttribute("aria-pressed"));
    }

    public String getPayInInputValue() {
        return driver.findElement(payInInput).getAttribute("value");
    }
    

    public void clickPayOutToggle() throws Exception {
    	WebElement payOutbtn = driver.findElement(payInButton);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", payOutbtn);
        driver.findElement(payOutButton).click();
        Thread.sleep(3000);
    }

    public boolean isPayOutToggled() {
        return Boolean.parseBoolean(driver.findElement(payOutButton).getAttribute("aria-pressed"));
    }
    public String getErrorMessage_without_any_webapps() {
        WebElement errorMessage = driver.findElement(alert_danger); 
        wait.until(ExpectedConditions.visibilityOfElementLocated(alert_danger));
        return errorMessage.getText();
    }
    
    public void clickAddButton() {
    	WebElement Addbtn = driver.findElement(addButton);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Addbtn);
    	Addbtn.click();
    }
    
    public void ClickAddAppButton() throws Exception {
    	WebElement AddAppbtn = driver.findElement(addApplicationButton);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AddAppbtn);
    	Thread.sleep(2000);
    	AddAppbtn.click();
    }
    public boolean isModalDisplayed() {
        return driver.findElement(modal).isDisplayed();
    }

    public void enterAPPNameInput(String AppName) {
    	WebElement Appname = driver.findElement(appNameInput);
    	Appname.clear();
    	Appname.sendKeys(AppName);;
    }

    public String getAppNameInputValue() {
        return driver.findElement(appNameInput).getAttribute("value");
    }

    public void enterAppUrlInputValue(String URL) {
    	WebElement UrlField = driver.findElement(appUrlInput);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", UrlField);
    	UrlField.clear();
    	UrlField.sendKeys(URL);;
    }


    public String getAppUrlInputValue() {
        return driver.findElement(appUrlInput).getAttribute("value");
    }
    
    public void enterOrderPrefixInputValue(String OrderPrefix) throws Exception {
    	WebElement orderprefixField = driver.findElement(orderPrefixInput);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", orderprefixField);
    	orderprefixField.clear();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(orderPrefixInput));
    	orderprefixField.sendKeys(OrderPrefix);
    }

    public String getOrderPrefixInputValue() {
        return driver.findElement(orderPrefixInput).getAttribute("value");
    }
    
    public void enterWebhookUrlInputValue(String WebhookUrl) {
    	WebElement webHookField = driver.findElement(webhookUrlInput);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webHookField);
    	webHookField.clear();
    	webHookField.sendKeys(WebhookUrl);
      
    }

    public String getWebhookUrlInputValue() {
        return driver.findElement(webhookUrlInput).getAttribute("value");
    }


    public void enterIpWhitelistInputValue(String IpWhitelistI) {
    	WebElement IpField = driver.findElement(ipWhitelistInput);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", IpField);
    	IpField.click();
    	IpField.sendKeys(IpWhitelistI);
       
    }
    public String getIpWhitelistInputValue() {
        return driver.findElement(ipWhitelistInput).getAttribute("value");
    }

    public String getInvalidFeedbackText() {
        return driver.findElement(invalid_Feedback).getText();
    }

    public void enterValidDetails() throws Exception {
    	
    	 
        String appName = "TestApp" ;
        String appUrl = "https://" + appName.toLowerCase() + ".example.com";
        String orderPrefix = "ORD";
        String webhookUrl = appUrl + "/webhook";
        String ipWhitelist = "172.16.254.1";

    	enterAPPNameInput(appName);
    	enterAppUrlInputValue(appUrl);
    	enterOrderPrefixInputValue(orderPrefix);
    	enterWebhookUrlInputValue(webhookUrl);
    	enterIpWhitelistInputValue(ipWhitelist);
       
    }
    // Action
    public void clickCloseButton() throws Exception {
    	WebElement closebtn = driver.findElement(closeButton);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closebtn);
    	Thread.sleep(2000);
    	closebtn.click();
    }
    // Actions
    public void clickToggleButton() {
    	WebElement toggle = wait.until(ExpectedConditions.visibilityOfElementLocated(webAppStatusToggle));
    	toggle.click();
    }

    public boolean isToggleButtonPressed() {
        return Boolean.parseBoolean(driver.findElement(webAppStatusToggle).getAttribute("aria-pressed"));
    }

    public String getStatusInputValue() {
        return driver.findElement(statusInput).getAttribute("value");
    }
    
   
    public boolean isCloseButtonDisplayed() {
        return driver.findElement(closeButton).isDisplayed();
    }
    
    public String getOrderPrefixFieldValue() {
        return driver.findElement(orderPrefixField).getAttribute("value");
    }

    public void setOrderPrefixField(String value) {
    	WebElement ORD = driver.findElement(orderPrefixField);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ORD);
    	ORD.sendKeys(value);
    }
    
 // Actions
    public String getOrderNumber() {
    	WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("td")));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return driver.findElement(orderNumberSelector).getText();
    }
    
    public String getOrderID() {
    	WebElement order_Id = wait.until(ExpectedConditions.visibilityOfElementLocated(orderId));
    	return order_Id.getText();
    	
    }
    
    public String getBadgeText() {
    	WebElement badge = driver.findElement(badgeSelector);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", badge);
        return driver.findElement(badgeSelector).getText();
    }

    public boolean isBadgeVisible() {
        return driver.findElement(badgeSelector).isDisplayed();
    }
    
 // Actions
    public void clickTerminalIDHeader() throws Exception {
    	WebElement sorting = wait.until(ExpectedConditions.visibilityOfElementLocated(sorting_asc));
    		sorting.click();
    		Thread.sleep(3000);
    	
    }

    public String getSortingClass() {
        return driver.findElement(sorting_asc).getAttribute("class");
    }
    
 // Actions
    public void enterSearchText(String text) throws Exception {
        WebElement searchBox = driver.findElement(searchInput);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBox);
        searchBox.clear();
        searchBox.sendKeys(text);
        Thread.sleep(3000);
    }

    public String getSearchInputValue() {
        return driver.findElement(searchInput).getAttribute("value");
    }
    
    public String getNodataInPay_In() {
    	WebElement no_data = driver.findElement(data_list);
    	return no_data.getText();
    }
    
    public void copyFromSourceField() {
        actions.moveToElement(driver.findElement(searchInput)).click().keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).perform();
    }

    // Method to paste data into the search box
    public void pasteIntoSearchBox() {
    	driver.findElement(searchInput).clear();
        actions.moveToElement(driver.findElement(searchInput)).click().keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
    }

    // Method to get the value from the search box
    public String getSearchBoxValue() {
    	WebElement searchbox  = driver.findElement(searchInput);
        return searchbox.getAttribute("value");
    }
    
    
    public void selectDataPerPage(String visibleText) throws Exception {
    	WebElement dropdownElement = driver.findElement(dataPerPageDropdown);
    	Select dropdown = new Select(dropdownElement);
    	dropdown.selectByVisibleText(visibleText);
    	Thread.sleep(3000);
    }
    
    public String getDropdownValue() {
    	WebElement element = driver.findElement(dataPerPageDropdown);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    	String dropdownElement = driver.findElement(dataPerPageDropdown).getAttribute("value");
    	return dropdownElement;
    }
    

    public void clickPreviousButton() {
    	WebElement previoudbtn = driver.findElement(previousButton);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", previoudbtn);
    	previoudbtn.click();
    }

    public boolean isPreviousButtonDisabled() {
        return driver.findElement(previousButton).getAttribute("class").contains("disabled");
    }
    
    // Actions
    public void clickNextButtononPage() {
    	WebElement nxtbtn = driver.findElement(previousButton);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nxtbtn);
    	nxtbtn.click();
    }

    public boolean isNextButtonEnabled() {
        return driver.findElement(nextButton).getAttribute("class").contains("disabled");
    }
    
    public void clickUpdateButton() throws Exception {
    	WebElement updatebtn = driver.findElement(updateButton);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", updatebtn);
    	updatebtn.click();
    	Thread.sleep(4000);
    }

    public boolean isUpdateButtonDisplayed() {
        return driver.findElement(updateButton).isDisplayed();
    }
  
    public void clickPayInTab() throws Exception {
    	WebElement payIn = driver.findElement(pay_in_tab);
    	payIn.click();
    	Thread.sleep(4000);
    	
    }
    
    public void clickBussInfoTab() throws Exception {
    	WebElement bussIn = driver.findElement(buss_info_tab);
    	bussIn.click();
    	Thread.sleep(4000);
    }
    	
    // Actions
    public void clickPayInSettingsTab() {
        driver.findElement(payInSettingsTab).click();
    }

    public void clickBusinessInfoTab() {
        driver.findElement(businessInfoTab).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    
    public void clickCompleteButton() throws Exception {
    	WebElement completebtn = driver.findElement(completeButton);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", completebtn);
    	completebtn.click();
    	Thread.sleep(3000);
    }
    
    public void uploadFilePAN(String filePath) {
        WebElement uploadElement = driver.findElement(companyPanInput);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(companyPanInput));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadElement);
        uploadElement.sendKeys(filePath);
        
    }
    
    public void uploadInvalidFileGST(String filePath) {
        WebElement fileInput = driver.findElement(companyGstInput);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileInput);
        fileInput.sendKeys(filePath);
    }
    
    
    public boolean isCancelButtonEnabled() {
        return driver.findElement(cancelButton).isEnabled();
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }
    
    public String getFileInputValue() {
        return driver.findElement(companyPanInput).getAttribute("value");
    }
    
    By bankStatementInput = By.id("bankstatement");
    
    public void uploadBankStatement(String filePath) {
    	WebElement bankStatement = driver.findElement(bankStatementInput);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bankStatement);
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(bankStatementInput));
        driver.findElement(bankStatementInput).sendKeys(filePath);
    }
    
    By cancelChequeInput = By.id("cancelcheque");
    
    public void uploadCancelCheque(String filePath) {
    	WebElement CancelCheque = driver.findElement(cancelChequeInput);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CancelCheque);
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cancelChequeInput));
        driver.findElement(cancelChequeInput).sendKeys(filePath);
    }
    
    By certificationIncorporationfileInput = By.id("certificationIncorporation");
   
    public void uploadCertification_of_Incorporation(String filePath) {
     	WebElement Certification_of_Incorporation = driver.findElement(certificationIncorporationfileInput);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Certification_of_Incorporation);
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(certificationIncorporationfileInput));
        
        driver.findElement(certificationIncorporationfileInput).sendKeys(filePath);
    }
    
    By momInput = By.id("mom");
    public void uploadMOA(String filePath) {
    	WebElement MOA = driver.findElement(momInput);
    	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MOA);
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(momInput));
       
        driver.findElement(momInput).sendKeys(filePath);
    }
    By aoainputFile = By.id("aoa");
    
    public void uploadAOA(String filePath) {
    	WebElement AOA = driver.findElement(aoainputFile);
    	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AOA);
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(aoainputFile));
      
        driver.findElement(aoainputFile).sendKeys(filePath);
    }
    By authsignatorypancardfileInput = By.id("authsignatorypancard");
    
    
    public void uploadauthsignatorypancard(String filePath) {
    	WebElement authsignatorypancard = driver.findElement(authsignatorypancardfileInput);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", authsignatorypancard);
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(authsignatorypancardfileInput));
        
        driver.findElement(authsignatorypancardfileInput).sendKeys(filePath);
    }
    By authSignatoryAadharcardfileInput = By.id("authSignatoryAadharcard");
   
    
    public void uploaduthSignatoryAadharcard(String filePath) throws Exception {
    	WebElement aduthSignatoryAadharcard = driver.findElement(authSignatoryAadharcardfileInput);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aduthSignatoryAadharcard);
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(authSignatoryAadharcardfileInput));
        
        driver.findElement(authSignatoryAadharcardfileInput).sendKeys(filePath);
        Thread.sleep(3000);
    }

   
    
    By buttonEl = By.cssSelector("button.swal2-confirm.btn.btn-success");

    public void clickOkButtononbussinesspage() {
    	WebElement buttonbussinessinfo = driver.findElement(buttonEl);
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(buttonEl));
    	buttonbussinessinfo.click();
    }
    
    By complete_itbtn = By.xpath("//button[contains(@class,'swal2-confirm btn')]");
    
    public void clickconfirmbtn() throws Exception {
    	WebElement complete = driver.findElement(complete_itbtn);
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(complete_itbtn));
    	complete.click();
    	Thread.sleep(3000);
    	
    }
    
    
    By buttonSelector = By.cssSelector(".swal2-confirm.btn.btn-success");
    public WebElement getButton() {
        return driver.findElement(buttonSelector);
    }

    public boolean isButtonEnabled() {
        return getButton().isEnabled();
    }

    public void clickButton() {
        getButton().click();
    }
    
    private By pdfLink = By.cssSelector("a.view-align");
    public By getPdfLink() {
        return pdfLink;
    }
}




