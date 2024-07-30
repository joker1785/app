package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DashboardPage {
	private WebDriver driver;
	
	By submitbtn = By.id("otp-match-now");
	By dashboardLink = By.xpath("//span[text()='Dashboard']");
	By dateInputField = By.xpath("//input[@class='form-control common-date-picker']");
	By calender_icon = By.xpath("//input[@class='form-control common-date-picker']");
	By Company_Dropdown = By.xpath("(//select[@class='form-control'])[1]");
	By merchat_Dropdown = By.xpath("(//select[@class='form-control'])[2]");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterSubmitbtn() {
		driver.findElement(submitbtn).click();
	}
	
	 public boolean isDashboardMenuVisible() {
		 WebElement dashboardMenu = driver.findElement(dashboardLink);
	        return dashboardMenu.isDisplayed();
	    }

	    public boolean isDashboardMenuClickable() {
	    	WebElement dashboardMenu = driver.findElement(dashboardLink);
	        return dashboardMenu.isEnabled();
	    }

	    public void clickDashboardMenu() {
	    	WebElement dashboardMenu = driver.findElement(dashboardLink);
	        dashboardMenu.click();
	    }
	    

	    public void enterDuration(String duration) {
	    	WebElement durationField = driver.findElement(dateInputField);
	        durationField.sendKeys(duration);
	    }

	    public String getDuration() {
	    	WebElement durationField = driver.findElement(dateInputField);
	        return durationField.getAttribute("value");
	    }

	    public boolean isDurationFieldVisible() {
	    	WebElement durationField = driver.findElement(dateInputField);
	        return durationField.isDisplayed();
	    }

	    public boolean isDurationFieldEnabled() {
	    	WebElement durationField = driver.findElement(dateInputField);
	        return durationField.isEnabled();
	    }
	  

	    public void selectCompany(String merchantName) {
	    	WebElement companyDropdown = driver.findElement(Company_Dropdown);
	        Select select = new Select(companyDropdown);
	        select.selectByVisibleText(merchantName);
	    }
	    public void selectMerchant(String merchantName) throws Exception {
	    	WebElement merchantDropdown = driver.findElement(merchat_Dropdown);
	        Select select = new Select(merchantDropdown);
	        select.selectByVisibleText(merchantName);
	        Thread.sleep(2000);
	    }
	    public String getSelectedMerchant() {
	    	WebElement merchantDropdown = driver.findElement(merchat_Dropdown);
	        Select select = new Select(merchantDropdown);
	        return select.getFirstSelectedOption().getText();
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
	    
	    
	   
}
	    

