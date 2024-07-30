package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DataProvider.Constant;
public class transactionTest extends BaseTest{
	@BeforeMethod
	public void vendorList() throws Exception {
		 	loginPage.enterValidCredential(Constant.username, Constant.password);
	        Thread.sleep(2000);
	        dashboardPage.enterSubmitbtn();
	        Thread.sleep(2000);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void commonMethodForSelectDate() throws Exception {
		transcationPage.selectDateRange("Today");
		transcationPage.selectDateRange("Yesterday");
        transcationPage.selectDateRange("Last 7 Days");
        transcationPage.selectDateRange("This Month");
        transcationPage.selectDateRange("Last Month");
        transcationPage.selectDateRange("Custom Range");
        transcationPage.selectMonthAndyearForLeftCalender("Jun 2024");
        transcationPage.selectdateLeftdatePicker("13");
        transcationPage.selectMonthAndyearForRightCalender("Jul 2024");
        transcationPage.selectdateRightSidedatePicker("13");
	}
	  @Test
	  //TC_AXP_ADM_TRAN_01
	    public void verifyTransactionsMenu() {
		  	// Verify clickability
		  	transcationPage.clickTransactionsMenu();
	        // Verify visibility
	        Assert.assertTrue(transcationPage.isTransactionsMenuVisible(), "Transactions menu is not visible");
	    }
	  

	    @Test
	    //TC_AXP_ADM_TRAN_02
	    public void testselectStatusfromDropdown() {
	    	transcationPage.clickTransactionsMenu();
	        transcationPage.selectStatus("TXN not initiated");
	        transcationPage.selectStatus("Success");
	        transcationPage.selectStatus("Failed");
	        transcationPage.selectStatus("Tampered");
	        transcationPage.selectStatus("Cancelled");
	    }

	    @Test
	    //TC_AXP_ADM_TRAN_03
	    public void testDropdownDisplaysAllOptions() throws Exception {
	    	transcationPage.clickTransactionsMenu();
	    	transcationPage.clickMerchantDropdown();
	        List<WebElement> options = transcationPage.getAllOptions();
	        Assert.assertTrue((options.size() > 0),"Dropdown should display options");

	        // Optional: Check specific options if needed
	        boolean containsTechSolutions = options.stream().anyMatch(option -> option.getText().equals("Tech solutions"));
	        Assert.assertTrue( containsTechSolutions,"Dropdown should contain 'Tech solutions'");
	        
	        // Optional: Check specific options if needed
	        boolean containsTwilightITsolutions = options.stream().anyMatch(option -> option.getText().equals("Twilight IT Solutions"));
	        Assert.assertTrue( containsTwilightITsolutions,"Dropdown should contain 'Twilight IT Solutions'");
	    }
	    
	    
	    @Test
	    public void testSelectCompanyAndVerifyDetails() {
	    	transcationPage.clickTransactionsMenu();
	        String companyName = "INOVESTR GLOBAL PRIVATE LIMITED"; 
	        transcationPage.selectCompany(companyName);
	        transcationPage.verifyCompanyDetails(companyName);
	    }
	    
	        
	 
	    @Test 
	    //TC_AXP_ADM_TRAN_05 To //TC_AXP_ADM_TRAN_11
	    public void testSelectDateField() throws Exception {
	    	transcationPage.clickTransactionsMenu();
	    	commonMethodForSelectDate();
	    }	    
	
	    
	    @Test 
	    //TC_AXP_ADM_TRAN_12 To //TC_AXP_ADM_TRAN_18
	    public void testSelectDateAndcompanyInfo() throws Exception {
	    	transcationPage.clickTransactionsMenu();
	    	transcationPage.selectStatus("TXN not initiated");
	    	transcationPage.selectRandomMerchant();
	    	transcationPage.selectDateRange("This Month");
	     	transcationPage.verifyCompanyDetails(transcationPage.selectRandomMerchantAndGetSelectedName());
	    }
	    @Test 
	  //TC_AXP_ADM_TRAN_19 To //TC_AXP_ADM_TRAN_25
	    public void testSelectSuccessStatusAndDate() throws Exception{
	    	transcationPage.clickTransactionsMenu();
	    	transcationPage.selectStatus("Success");
	    	transcationPage.selectCompany("INOVESTR GLOBAL PRIVATE LIMITED");;
	    	transcationPage.selectDateRange("Today");
	     	transcationPage.verifyCompanyDetails(transcationPage.selectRandomMerchantAndGetSelectedName());
	    }
	    
	    @Test 
	  //TC_AXP_ADM_TRAN_26 To //TC_AXP_ADM_TRAN_32
	    public void testSelectFailedStatusAndDate() throws Exception{
	    	transcationPage.clickTransactionsMenu();
	    	transcationPage.selectStatus("Failed");
	    	transcationPage.selectRandomMerchant();
	    	transcationPage.selectDateRange("Last 7 Days");
	     	transcationPage.verifyCompanyDetails(transcationPage.selectRandomMerchantAndGetSelectedName());
	    }
	    
	    @Test 
	  //TC_AXP_ADM_TRAN_33 To //TC_AXP_ADM_TRAN_39
		    public void testSelectTamperedStatusAndDate() throws Exception{
		    	transcationPage.clickTransactionsMenu();
		    	transcationPage.selectStatus("Tampered");
		    	transcationPage.selectRandomMerchant();
		    	transcationPage.selectDateRange("Last Month");
		    	transcationPage.verifyCompanyDetails(transcationPage.selectRandomMerchantAndGetSelectedName());
		    }
	    
	    @Test 
	  //TC_AXP_ADM_TRAN_40 To //TC_AXP_ADM_TRAN_46
	    public void testSelectCancelledStatusAndDate() throws Exception{
	    	transcationPage.clickTransactionsMenu();
	    	transcationPage.selectStatus("Cancelled");
	    	transcationPage.selectRandomMerchant();
	    	transcationPage.selectDateRange("Custom Range");
	        transcationPage.selectMonthAndyearForLeftCalender("Jun 2024");
	        transcationPage.selectdateLeftdatePicker("13");
	        transcationPage.selectMonthAndyearForRightCalender("Jul 2024");
	        transcationPage.selectdateRightSidedatePicker("13");
	        transcationPage.clickapplybtn();
	        transcationPage.verifyCompanyDetails(transcationPage.selectRandomMerchantAndGetSelectedName());
	    }
	   
}
