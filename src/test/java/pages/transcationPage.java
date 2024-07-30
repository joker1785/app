package pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class transcationPage {
	private WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
	By transactionlink = By.xpath("//span[text()='Transaction']");
	// Selectors
    private By statusDropdown = By.id("status-select");
    private By successMessage = By.id("success-message"); // Assuming an ID for success message
    private By errorMessage = By.id("error-message"); // Assuming an ID for error message
    private By securityAlert = By.id("security-alert"); // Assuming an ID for security alert
    private By orderStatusNotification = By.id("order-status-notification"); // Assuming an ID for order status notification
    private By merchantDropdown = By.id("merchant-select");
    private By options = By.xpath("//select[@id='merchant-select']/option");
    private By calender_icon = By.xpath("//div[contains(@class,'mb-3 datetimes-width')]//input[1]");
    
    private By hourSelect = By.cssSelector(".hourselect");
    private By minuteSelect = By.xpath("(//select[@class='minuteselect'])[1]");
    private By secondSelect = By.cssSelector(".secondselect");
    private By ampmSelect = By.cssSelector(".ampmselect");
    private By merchantSelect = By.id("merchant-select");
    
    By tableRows = By.xpath("(//table[contains(@class,'table dataTable')]//tr)");
    
    
    public transcationPage(WebDriver driver) {
	this.driver = driver;
	this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	this.actions = new Actions(driver);
	PageFactory.initElements(driver, this);
    }
    
    public boolean isTransactionsMenuVisible() {
    	
        return driver.findElement(transactionlink).isDisplayed();
    }

    public void clickTransactionsMenu() {
    	WebElement transactionsMenu = driver.findElement(transactionlink);
        transactionsMenu.click();
    }
    
    public String getDefaultOption() {
        Select select = new Select(driver.findElement(statusDropdown));
        return select.getFirstSelectedOption().getText();
    }

    public void selectStatus(String status) {
        Select select = new Select(driver.findElement(statusDropdown));
        select.selectByVisibleText(status);
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public String getSecurityAlert() {
        return driver.findElement(securityAlert).getText();
    }

    public String getOrderStatusNotification() {
        return driver.findElement(orderStatusNotification).getText();
    }
    
    public void clickMerchantDropdown() {
        driver.findElement(merchantDropdown).click();
    }

    public List<WebElement> getAllOptions() {
        return driver.findElements(options);
    }
    
    
    public void selectDateRange(String dateRange) throws Exception {
        WebElement dropdown = driver.findElement(calender_icon);
        dropdown.click(); 
        Thread.sleep(4000);
        By optionLocator;

        switch (dateRange) {
            case "Today":
                optionLocator = By.xpath("(//li[@class='active'])[3]");
                break;
            case "Yesterday":
                optionLocator = By.xpath("//li[@data-range-key='Yesterday']");
                break;
            case "Last 7 Days":
                optionLocator = By.xpath("//li[@data-range-key='Last 7 Days']");
                break;
            case "Last 30 Days":
                optionLocator = By.xpath("//li[@data-range-key='Last 30 Days']");
                break;
            case "This Month":
                optionLocator = By.xpath("//li[@data-range-key='Last 30 Days']");
                break;
            case "Last Month":
                optionLocator = By.xpath("//li[@data-range-key='Last Month']");
                break;
            case "Custom Range":
                optionLocator = By.xpath("//li[@data-range-key='Custom Range']");
                break;
            default:
                throw new IllegalArgumentException("Invalid date range: " + dateRange);
        }

        WebElement option = driver.findElement(optionLocator);
        option.click(); // Select the option
        Thread.sleep(4000);
    }
	
    public void clickapplybtn() {
    	 WebElement appltbtn = driver.findElement(By.xpath("//button[contains(@class,'applyBtn btn')]"));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", appltbtn);
         appltbtn.click();
    }
	
    public void selectMonthAndyearForLeftCalender(String value) {
        
    	while(true) {
        	String month_year = driver.findElement(By.xpath("//div[@class = 'drp-calendar left']//th[@class = 'month']")).getText();
        	if(month_year.equals(value)) {
        		break;
       }
        	
        	driver.findElement(By.xpath("//th[@class='prev available']")).click();
        }
    }
    
    public void selectdateLeftdatePicker(String date) throws InterruptedException {
    	List<WebElement> alldates = driver.findElements(By.xpath("//div[@class = 'drp-calendar left']//tr//td"));
    	Thread.sleep(5000);
	    for( WebElement dt : alldates) {
	    	if(dt.getText().equals(date)) {
	    		dt.click();
	    		Thread.sleep(5000);
	    		break;
	    	}
	    }
    }
    	
    
    public void selectMonthAndyearForRightCalender(String value) {
        
    	while(true) {
        	String month_year = driver.findElement(By.xpath("//div[@class = 'drp-calendar right']//th[@class = 'month']")).getText();
        	if(month_year.equals(value)) {
        		break;
       }
        	driver.findElement(By.xpath("(//th[@class='prev available']//span)[2]")).click();
        }
    }
    
    public void selectdateRightSidedatePicker(String date) throws InterruptedException {
    	List<WebElement> alldates = driver.findElements(By.xpath("//div[@class = 'drp-calendar right']//tr//td"));
    	Thread.sleep(5000);
	    for( WebElement dt : alldates) {
	    	if(dt.getText().equals(date)) {
	    		dt.click();
	    		Thread.sleep(5000);
	    		break;
	    	}
	    }
    }
    	
    public void selectApplybtnIndatePicker() {
    	 driver.findElement(By.xpath("//button[contains(@class,'applyBtn btn')]")).click();
    	
    }
    public void selectHour(int hour) throws Exception {
        WebElement hourDropdown = driver.findElement(hourSelect);
        hourDropdown.sendKeys(String.valueOf(hour));
        Thread.sleep(3000);
    }
    
    public void selectMinute(int minute) throws Exception {
        WebElement minuteDropdown = driver.findElement(minuteSelect);
        minuteDropdown.sendKeys(String.valueOf(minute));
        Thread.sleep(3000);
    }

    public void selectSecond(int second) throws Exception {
        WebElement secondDropdown = driver.findElement(secondSelect);
        secondDropdown.sendKeys(String.valueOf(second));
        Thread.sleep(3000);
    }

    public void selectAM() {
        WebElement ampmDropdown = driver.findElement(ampmSelect);
        ampmDropdown.sendKeys("AM");
    }

    public void selectPM() {
        WebElement ampmDropdown = driver.findElement(ampmSelect);
        ampmDropdown.sendKeys("PM");
    }

    public String getSelectedHour() {
        return driver.findElement(hourSelect).getAttribute("value");
    }

    public String getSelectedMinute() {
        return driver.findElement(minuteSelect).getAttribute("value");
    }

    public String getSelectedSecond() {
        return driver.findElement(secondSelect).getAttribute("value");
    }

    public String getSelectedPeriod() {
        return driver.findElement(ampmSelect).getAttribute("value");
    }
    
    
    public void selectCompany(String companyName) {
    	WebElement dropdown = driver.findElement(merchantSelect);
        dropdown.click();
        dropdown.findElement(By.xpath("//option[text()='" + companyName + "']")).click();
        
    }
    
    public void verifyCompanyDetails(String companyName) {
        List<WebElement> rows = driver.findElements(tableRows);
        for (WebElement row : rows) {
            String displayedCompanyName = row.findElement(By.xpath("//td[2]")).getText();
            if(displayedCompanyName.equals(companyName)) {
            	System.out.println(displayedCompanyName);
            	Assert.assertEquals(displayedCompanyName, companyName);
            }
            else if (!displayedCompanyName.equals(companyName)) {
            	String nodata = driver.findElement(By.className("dataTables_empty")).getText();
            	Assert.assertEquals(nodata, "No data available in table");
            }
        }
    }
    public List<WebElement> getSelectedCompanyFromTable() {
    	List<WebElement> company = driver.findElements(By.cssSelector("table#transactionlistpayin>tbody>tr>td:nth-of-type(2)"));
		return company;
        
    }
    
    public String getNotdata() {
    	WebElement nodata = driver.findElement(By.className("dataTables_empty"));
    	return	nodata.getText();
    }
    public String selectRandomMerchantAndGetSelectedName() {
        Select select = new Select(driver.findElement(merchantSelect));
        List<WebElement> options = select.getOptions();
        Random random = new Random();
        int randomIndex = random.nextInt(options.size()); // Selects any index from 0 to options.size() - 1
        select.selectByIndex(randomIndex);
        return select.getFirstSelectedOption().getText();
    }

    public void selectRandomMerchant() {
        Select select = new Select(driver.findElement(merchantSelect));
        List<WebElement> options = select.getOptions();
        Random random = new Random();
        int randomIndex = random.nextInt(options.size() - 1);
        select.selectByIndex(randomIndex);
    }

    public String getSelectedMerchant() {
        Select select = new Select(driver.findElement(merchantSelect));
        return select.getFirstSelectedOption().getText();
    }
}
