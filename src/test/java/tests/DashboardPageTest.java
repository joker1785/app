package tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DataProvider.Constant;


public class DashboardPageTest extends BaseTest {
	@BeforeMethod
	public void setPage() throws Exception {
		// Click on the login button without entering username and password
        loginPage.enterValidCredential(Constant.username, Constant.password);
        Thread.sleep(2000);
        dashboardPage.enterSubmitbtn();
        Thread.sleep(2000);
	}
	
	@Test
	//TC_AXP_ADM_DAB_01
    public void testLoginValidCredential() throws Exception {
		
        // Verify the URL to confirm successful redirection to the dashboard
        String expectedUrl = "https://stageadmin.appxpay.com/dashboard";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Admin was not redirected to the dashboard page after login.");

        // Get the page source and extract the title
        String pageTitle = "AppXpay";       
        String expectedTitle =  driver.getTitle();
        Assert.assertEquals(pageTitle, expectedTitle, "The page title does not match the expected dashboard title.");
        }
	
	
	@Test
	//TC_AXP_ADM_DAB_02
    public void Verify_dashboard_menu_visible_and_clickable() throws Exception {
		// Click the Dashboard menu to ensure it's functional
        dashboardPage.clickDashboardMenu();
		
        // Verify that the Dashboard menu is visible and clickable
        Assert.assertTrue(dashboardPage.isDashboardMenuVisible(), "Dashboard menu is not visible.");
        Assert.assertTrue(dashboardPage.isDashboardMenuClickable(), "Dashboard menu is not clickable.");
	}
	
	@Test
	//TC_AXP_ADM_DAB_03
    public void Verify_that_the_Duration_field_is_visible_and_enabled() throws Exception {
		 // Verify that the Duration field is visible and enabled
        Assert.assertTrue(dashboardPage.isDurationFieldVisible(), "Duration field is not visible.");
        Assert.assertTrue(dashboardPage.isDurationFieldEnabled(), "Duration field is not enabled.");
        Thread.sleep(4000);
        // Enter a date or text in the Duration field and verify the input
        String testDuration = " 2024-05-14 AppXPay";
        dashboardPage.enterDuration(testDuration);
        Thread.sleep(4000);
        String actualDuration = dashboardPage.getDuration();
        Assert.assertEquals(actualDuration, testDuration, "The input in the Duration field does not match the expected value.");
	}
	
	@Test
	//TC_AXP_ADM_DAB_04
    public void Verify_the_default_date_in_the_Duration_field() throws Exception {

        // Get the current date
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - dd/MM/yyyy");
        String expectedDate = currentDate.format(formatter);

        // Verify the default date in the Duration field
        String actualDate = dashboardPage.getDuration();
        Assert.assertEquals(actualDate, expectedDate, "The default date in the Duration field does not match the current date.");
	}
	
	@Test
	//TC_AXP_ADM_DAB_05
    public void testDashboardMetricsAfterDateRangeSelection() throws Exception {
		dashboardPage.selectDateRange("Custom Range");
		dashboardPage.selectMonthAndyearForLeftCalender("Jun 2024");
		dashboardPage.selectdateLeftdatePicker("13");
        Thread.sleep(2000);
        dashboardPage.selectMonthAndyearForRightCalender("Jul 2024");
        dashboardPage.selectdateRightSidedatePicker("25");
        dashboardPage.selectApplybtnIndatePicker();
        Thread.sleep(2000);
        List<WebElement> optionList = driver.findElements(By.xpath("(//div[contains(@class,'row row-new')])[2]/div"));
        for(WebElement  option : optionList) {
        	Assert.assertTrue(option.isDisplayed());
        }
        
	}
	
	 @Test
	//TC_AXP_ADM_DAB_06
	    public void testSelectCompanyAndTodaysDate() throws Exception {
	        // Select a merchant
	        dashboardPage.selectCompany("DILEEPKUMAR");
	        // Select today's date
	        dashboardPage.selectDateRange("Today");
	        Thread.sleep(3000);
	        List<WebElement> optionList = driver.findElements(By.xpath("(//div[contains(@class,'row row-new')])[2]/div"));
	        for(WebElement  option : optionList) {
	        	Assert.assertTrue(option.isDisplayed());
	        }
	 }
	 
	 
	 @Test
		//TC_AXP_ADM_DAB_07
		    public void testSelectCompanyAndYesterday() throws Exception {
		        // Select a merchant
		        dashboardPage.selectCompany("Twilight");
		        // Select today's date
		        dashboardPage.selectDateRange("Yesterday");
		        Thread.sleep(3000);
		        List<WebElement> optionList = driver.findElements(By.xpath("(//div[contains(@class,'row row-new')])[2]/div"));
		        for(WebElement  option : optionList) {
		        	Assert.assertTrue(option.isDisplayed());
		        }
		 }
	 
	 
	 @Test
		//TC_AXP_ADM_DAB_08
		    public void testSelectCompanyAndLastSevenDays() throws Exception {
		        // Select a merchant
		        dashboardPage.selectCompany("INOVESTR GLOBAL PRIVATE LIMITED");
		        // Select today's date
		        dashboardPage.selectDateRange("Last 7 Days");
		        Thread.sleep(3000);
		        List<WebElement> optionList = driver.findElements(By.xpath("(//div[contains(@class,'row row-new')])[2]/div"));
		        for(WebElement  option : optionList) {
		        	Assert.assertTrue(option.isDisplayed());
		        }
		 }
	 

	 @Test
		//TC_AXP_ADM_DAB_09
		    public void testSelectCompanyAndLastLast_30_Days() throws Exception {
		        // Select a merchant
		        dashboardPage.selectCompany("Tech solutions");
		        // Select today's date
		        dashboardPage.selectDateRange("Last 30 Days");
		        Thread.sleep(3000);
		        List<WebElement> optionList = driver.findElements(By.xpath("(//div[contains(@class,'row row-new')])[2]/div"));
		        for(WebElement  option : optionList) {
		        	Assert.assertTrue(option.isDisplayed());
		        }
		 }
	 
	 @Test
		//TC_AXP_ADM_DAB_10
		    public void testSelectCompanyAndLastThisMonth() throws Exception {
		        // Select a merchant
		        dashboardPage.selectCompany("Financial");
		        // Select today's date
		        dashboardPage.selectDateRange("This Month");
		        Thread.sleep(3000);
		        List<WebElement> optionList = driver.findElements(By.xpath("(//div[contains(@class,'row row-new')])[2]/div"));
		        for(WebElement  option : optionList) {
		        	Assert.assertTrue(option.isDisplayed());
		        }
		 }
	 
	 @Test
		//TC_AXP_ADM_DAB_11
		    public void testSelectCompanyAndLastLastMonth() throws Exception {
		        // Select a merchant
		        dashboardPage.selectCompany("tcs");
		        // Select today's date
		        dashboardPage.selectDateRange("Last Month");
		        Thread.sleep(3000);
		        List<WebElement> optionList = driver.findElements(By.xpath("(//div[contains(@class,'row row-new')])[2]/div"));
		        for(WebElement  option : optionList) {
		        	Assert.assertTrue(option.isDisplayed());
		        }
		 }
	 
	 
	 @Test
		//TC_AXP_ADM_DAB_12
		    public void testSelectCustomRange() throws Exception {
		        dashboardPage.selectDateRange("Custom Range");
		        dashboardPage.selectMonthAndyearForLeftCalender("Mar 2024");
				dashboardPage.selectdateLeftdatePicker("13");
		        Thread.sleep(2000);
		        dashboardPage.selectMonthAndyearForRightCalender("Apr 2024");
		        dashboardPage.selectdateRightSidedatePicker("25");
		        dashboardPage.selectApplybtnIndatePicker();
		        Thread.sleep(2000);
		        Thread.sleep(3000);
		        List<WebElement> optionList = driver.findElements(By.xpath("(//div[contains(@class,'row row-new')])[2]/div"));
		        for(WebElement  option : optionList) {
		        	Assert.assertTrue(option.isDisplayed());
		        }
		 }

	  @Test
	 // TC_AXP_ADM_DAB_13
	 public void testSelectMerchant() throws Exception {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		
	     List<WebElement> optionList = driver.findElements(By.xpath("(//select[@class='form-control'])[2]/option"));
	     for (int i = 0; i < optionList.size(); i++) {
	         optionList = driver.findElements(By.xpath("(//select[@class='form-control'])[2]/option"));
	         WebElement option = optionList.get(i);

	         String merchantName = option.getText();
	         if (merchantName != null && !merchantName.isEmpty()) {
	        	 Thread.sleep(2000);
	        	 dashboardPage.selectMerchant(merchantName);
	        	 js.executeScript("window.scrollBy(0,500)"); // Scrolls down by 1000 pixel
	        	 Thread.sleep(2000);
	             // Verify the selection
	             String selectedMerchant = dashboardPage.getSelectedMerchant();
	             Assert.assertEquals(selectedMerchant, merchantName, "The selected merchant is not correct");
	         }
	     }
	     
	   }
	  
	  
	  
}
	
	
	
	
	
	
	
	

	
	
	

