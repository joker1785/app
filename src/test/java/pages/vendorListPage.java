package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class vendorListPage {
	private WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	 By vendorList = By.xpath("//a[text()[normalize-space()='List']]"); 
	 private By addVendorButton = By.id("add-roles-model");
	 private By searchInput = By.cssSelector("input[type='search']");
	 
	 private By resultsList = By.id("listofnewmerchants");
	 
	 private By nextPageLink = By.id("listofnewmvendor_next");
	 private By prevButton = By.id("listofnewmvendor_previous");

	 private By verifyMerchantButton = By.id("verify_merchant");
	// Selectors
	    private By verifyButton = By.id("viewmerchantlist");
	    private By okbuttonLocator = By.cssSelector("button.swal2-confirm");
	    
	    private By bankDetailsImage = By.xpath("(//img[@id='openpopupbankdetails'])[1]");
	    private By modal = By.id("information");
	    private By modalContent = By.cssSelector("#information .modal-body");
	    private By merchantsButton = By.id("draftmerchantlist");
	    private By completedButton = By.xpath("(//button[@id='draftmerchantlist'])[2]");
	
	    public vendorListPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	 
	    
	    public void clickVendorList() throws Exception {
	    	WebElement vendor_List = driver.findElement(vendorList);
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", vendor_List);
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(vendorList));
	    	vendor_List.click();
	        Thread.sleep(3000);
	    }
	 public void clickAddVendorButton() throws Exception{
	    	WebElement addroles = driver.findElement(addVendorButton);
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addroles);
	    	addroles.click();
	        Thread.sleep(3000);
	    }
	
	 
	    public void enterSearchQuery(String query) throws Exception {
	        WebElement searchField = driver.findElement(searchInput);
	        searchField.clear();
	        searchField.sendKeys(query);
	        Thread.sleep(3000);
	    }
	   
	    public String getSearchBoxValue() {
	    	WebElement searchField = driver.findElement(searchInput);
	    	return searchField.getAttribute("value");
	    }
	    public void clickEditButton(String value) {
	    	WebElement editbtn = driver.findElement(By.xpath("(//div[@class='align-items-center d-flex']//a)["+value+"]"));
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editbtn);
	    	editbtn.click();
	    }
	    public boolean isResultsDisplayed() {
	        return driver.findElement(resultsList).isDisplayed();
	    }
	

	    public void clickDraftButton() {
	    	WebElement draftbtn = driver.findElement(By.xpath("(//div[@class='table-data']//div)[1]"));;
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", draftbtn);
	    	draftbtn.click();
	    }
	   
	    public void clickNext() throws Exception {
	    	WebElement nxtLink = driver.findElement(nextPageLink);
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nxtLink);
	    	nxtLink.click();
	    	Thread.sleep(3000);
	    }
	    
	    public void clickPrevButton() throws Exception {
	    	WebElement preLink = driver.findElement(prevButton);
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", preLink);
	    	preLink.click();
	    	Thread.sleep(3000);
	    }
	    public void clickVerifyButton() {
	    	WebElement verifybtn = driver.findElement(verifyButton);
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", verifybtn);
	    	verifybtn.click();
	    }
	    // Actions
	    public void clickVerifyVendorButton() {
	    	WebElement VerifyMerchantbtn = driver.findElement(verifyMerchantButton);
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", VerifyMerchantbtn);
	    	VerifyMerchantbtn.click();
	    }
	    
	    public void clickOkButton() throws Exception {
	    	WebElement okbtn = driver.findElement(okbuttonLocator);
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", okbtn);
	    	okbtn.click();
	    	Thread.sleep(3000);
	    }
	    
	    public void clickBankDetailsImage() {
	        driver.findElement(bankDetailsImage).click();
	    }

	    public boolean isModalDisplayed() {
	        return driver.findElement(modal).isDisplayed();
	    }

	    public String getModalContent() {
	        return driver.findElement(modalContent).getText();
	    }
	    
	    public void copyFromSourceField() {
	        actions.moveToElement(driver.findElement(searchInput)).click().keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).perform();
	    }

	    // Method to paste data into the search box
	    public void pasteIntoSearchBox() {
	    	driver.findElement(searchInput).clear();
	        actions.moveToElement(driver.findElement(searchInput)).click().keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
	    }
	    
	    public void clickMerchantsButton() {
	        driver.findElement(merchantsButton).click();
	    }
	    public void clickCompletedButton() {
	    	driver.findElement(completedButton).click();
	    }
	    public boolean getCompletedButton() {
	        return driver.findElement(completedButton).isDisplayed();
	    }
}
