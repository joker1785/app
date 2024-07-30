package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DataProvider.Constant;
public class VendorListTest extends BaseTest{

	@BeforeMethod
	public void vendorList() throws Exception {
		 	loginPage.enterValidCredential(Constant.username, Constant.password);
	        Thread.sleep(2000);
	        dashboardPage.enterSubmitbtn();
	        Thread.sleep(2000);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        vendorRegistrationPage.clickVendorMenu();
	}

	@Test(description = "TC_AXP_ADM_VENOB_46")
    public void testEditBusinessInfo() throws Exception {
    	 vendorListPage.clickVendorList();
    }
	
	 @Test(description = "TC_AXP_ADM_VENOB_47")
    public void testAddVendorNavigation() throws Exception {
		 vendorListPage.clickVendorList();
		vendorListPage.clickAddVendorButton();
    }
	 
	 @Test(description = "TC_AXP_ADM_VENOB_48")
	    public void testValidSearchQuery() throws Exception {
		 vendorListPage.clickVendorList();
		 vendorListPage.enterSearchQuery("APPXPAY142802");
	    }
	 @Test(description = "TC_AXP_ADM_VENOB_49 // TC_AXP_ADM_VENOB_50")
	    public void testInValidSearchQuery() throws Exception {
		 vendorListPage.clickVendorList();
		 vendorListPage.enterSearchQuery("God");
	    }
	 
	 @Test(description = "TC_AXP_ADM_VENOB_51 // TC_AXP_ADM_VENOB_52")
	    public void testClickingImageOpensModalWithCorrectBankDetails() throws Exception {
		 vendorListPage.clickVendorList();
		 vendorListPage.clickBankDetailsImage();
		WebElement enterbankname = driver.findElement(By.name("bank_name"));
		enterbankname.sendKeys("HDFC");
		Assert.assertNotEquals(enterbankname, driver.findElement(By.id("bank_name")).getAttribute("value"));
	    }
	 
	 @Test(description = "TC_AXP_ADM_VENOB_53")
	    public void testCopyPasteSearchField() throws Exception {
		 	vendorListPage.clickVendorList();
	        String dataToCopy = "test data";
	        vendorListPage.enterSearchQuery(dataToCopy);
	        vendorListPage.copyFromSourceField();

	        // Paste data into the search box
	        vendorListPage.pasteIntoSearchBox();

	        // Verify that the search box contains the pasted data
	        String searchBoxValue = vendorListPage.getSearchBoxValue();
	        Assert.assertEquals(searchBoxValue, dataToCopy, "Data pasted successfully in the search box.");
	    }
	 
	 
	 @Test(description = "TC_AXP_ADM_VENOB_55")
	    public void testEditButtonOpensEditingInterface() throws Exception {
		 vendorListPage.clickVendorList();
		 vendorListPage.clickEditButton("5");
	    }
	 	@Test(description = "TC_AXP_ADM_VENOB_59")
	    public void testNavigateToNextPage() throws Exception {
	 	vendorListPage.clickVendorList();
		 vendorListPage.clickNext();
	    }
	    
	    
	    @Test(description = "TC_AXP_ADM_VENOB_60")
	    public void testPrevButtonNavigation() throws Exception {
	    	vendorListPage.clickVendorList();
	    	vendorListPage.clickNext();
	    	vendorListPage.clickPrevButton();
	    }
	    
	    @Test(description = "TC_AXP_ADM_VENOB_63")
	    public void testMerchantsButtonNavigation() throws Exception {
	    		vendorListPage.clickVendorList();
	    		vendorListPage.clickMerchantsButton();
	    }

	    @Test(description = "TC_AXP_ADM_VENOB_64")
	    public void testClickingCompletedButtonDisplaysCompletedItems() throws Exception {
	    	vendorListPage.clickVendorList();
	    	vendorListPage.clickCompletedButton();
	    	Assert.assertTrue(vendorListPage.getCompletedButton());
	    }
	    
	    @Test
	    public void testVerifyMerchantButtonClick() throws Exception {
	         	vendorRegistrationPage.clickOnboarding();
	         	vendorRegistrationPage.enterRandomData();
	         	vendorRegistrationPage.submitbtn();
	    	
			    vendorRegistrationPage.selectBusinessCategory1("Public Limited");
			 	vendorRegistrationPage.selectBusinessCategory2("Government Bodies");
			 	vendorRegistrationPage.selectBusinessSubCategory("Cryptocurrency");
			 	
		    	vendorRegistrationPage.enterBankName("Housing Development Finance Corporation");
		    	vendorRegistrationPage.enterBankAccountNumber("0000888899999");
		    	vendorRegistrationPage.enterIFSCCode("HDFC0001234");
		    	vendorRegistrationPage.enterBranchName("Main Branch");
		    	vendorRegistrationPage.enterAccountHolderName("dileep");
		        vendorRegistrationPage.enterCompanyName("Twilight IT Solutions");
		        vendorRegistrationPage.enterCompanyAddress("Puducherry");
		        vendorRegistrationPage.enterPincode("607006");
		        vendorRegistrationPage.enterCity("cuddalore");
		        vendorRegistrationPage.clickStateSelect();
	      		merchantOnboardPage.selectStateByValue("3"); // Selecting "Andaman And Nicobar"
	      		String validPdfPath = "C:/Users/veera/Documents/9-11.pdf";
	 	        vendorRegistrationPage.uploadFileVendor_Agreement(validPdfPath);
	 	        vendorRegistrationPage.clickCompleteButton();
	 	        
	 	        vendorListPage.clickDraftButton();
	    }
	    
	    
	 
	 

}
