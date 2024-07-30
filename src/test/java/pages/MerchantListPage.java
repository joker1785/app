package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MerchantListPage {
	private WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
	By merchantList = By.xpath("//a[contains(.,'Merchant List')]"); 
	private By addRolesButton = By.id("add-roles-model");
	private By searchInput = By.cssSelector("input[type='search']");
    private By resultsList = By.id("listofnewmerchants");
    //private By editButton = By.cssSelector("button[data-id='602']");
    private By nextButton = By.id("listofnewmerchants_next");
    private By prevButton = By.id("listofnewmerchants_previous");
    private By verifyMerchantButton = By.id("verify_merchant");
    
    // Selectors
    private By verifyButton = By.id("viewmerchantlist");
    private By okbuttonLocator = By.cssSelector("button.swal2-confirm");
    
    
    public MerchantListPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
    
    public void clickMerchantList() throws Exception {
    	WebElement merchant_List = driver.findElement(merchantList);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", merchant_List);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(merchantList));
        driver.findElement(merchantList).click();
        Thread.sleep(3000);
    }
    
    public boolean isMerchantListVisible() {
        return driver.findElement(merchantList).isDisplayed();
    }
    

    public void clickAddRolesButton() throws Exception{
    	WebElement addroles = driver.findElement(addRolesButton);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addroles);
        driver.findElement(addRolesButton).click();
        Thread.sleep(3000);
    }
    
    public void enterSearchQuery(String query) throws Exception {
        WebElement searchField = driver.findElement(searchInput);
        searchField.clear();
        searchField.sendKeys(query);
        Thread.sleep(3000);
    }

    public boolean isResultsDisplayed() {
        return driver.findElement(resultsList).isDisplayed();
    }
    
 // Actions
    public void clickEditButton(String value) {
    	WebElement editbtn = driver.findElement(By.xpath("(//div[@class='align-items-center d-flex']//a)["+value+"]"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editbtn);
    	editbtn.click();
    }

    public void clickDraftButton(String value) {
    	WebElement draftbtn = driver.findElement(By.xpath("(//button[text()='Draft'])["+value+"]"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", draftbtn);
    	draftbtn.click();
    }
    
 // Action methods
    public void clickNext() throws Exception {
    	WebElement nxtLink = driver.findElement(nextButton);
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
    public void clickVerifyMerchantButton() {
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
}
