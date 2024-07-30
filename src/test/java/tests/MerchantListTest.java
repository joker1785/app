package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DataProvider.Constant;
public class MerchantListTest extends BaseTest{

	@BeforeMethod
	public void companyPage() throws Exception {
		 	loginPage.enterValidCredential(Constant.username, Constant.password);
	        Thread.sleep(2000);
	        dashboardPage.enterSubmitbtn();
	        Thread.sleep(2000);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    	merchantOnboardPage.clickMerchantRegister();
    	
	}
	
	@Test
	//TC_AXP_ADM_MERON_102
    public void verifyMerchantListVisibilityAndClickability() {
		 try {
			merchantListPage.clickMerchantList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Assert.assertTrue(merchantListPage.isMerchantListVisible(),"Merchant List is not visible");
		
	}
	

    @Test
    //TC_AXP_ADM_MERON_103
    public void testAddMerchantsButton() {
    	try {
    		merchantListPage.clickMerchantList();
			merchantListPage.clickAddRolesButton();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    @Test
    //TC_AXP_ADM_MERON_104
    public void testValidSearchQuery() throws Exception {
    	merchantListPage.clickMerchantList();
    	merchantListPage.enterSearchQuery("APPXPAY701484");
        Assert.assertTrue( merchantListPage.isResultsDisplayed(),"Results should be displayed for valid search query");
    }
    
    @Test
    //TC_AXP_ADM_MERON_105
    public void testInValidSearchQuery() throws Exception {
    	merchantListPage.clickMerchantList();
    	merchantListPage.enterSearchQuery("LOVE@YOU");
        Assert.assertTrue( merchantListPage.isResultsDisplayed(),"Results should be displayed for valid search query");
    }
	
    @Test
    //TC_AXP_ADM_MERON_109
    public void testEditButtonOpensEditingInterface() throws Exception {
    	merchantListPage.clickMerchantList();
    	merchantListPage.clickEditButton("6");
    }
    
    @Test
    //TC_AXP_ADM_MERON_111
    public void testDraftButtonClickDisplaysMerchantList() throws Exception {
    	merchantListPage.clickMerchantList();
    	merchantListPage.clickDraftButton("6");
    }
    
    @Test
    //TC_AXP_ADM_MERON_118
    public void testNavigateToNextPage() throws Exception {
    	merchantListPage.clickMerchantList();
                // Click the "Next" link
    	merchantListPage.clickNext();
    }
    
    
    @Test//TC_AXP_ADM_MERON_117
    public void testPrevButtonNavigation() throws Exception {
    	merchantListPage.clickMerchantList();
    	merchantListPage.clickNext();
    	merchantListPage.clickPrevButton();
    }
    
    
    @Test
    //TC_AXP_ADM_MERON_124
    public void testVerifyMerchantButtonClick() throws Exception {
		merchantOnboardPage.clickMerchantOnboarding();
		merchantOnboardPage.enterRandomData();
    	merchantOnboardPage.submitbtn();
    	
    	merchantOnboardPage.selectBusinessCategory1("Private Limited");
    	merchantOnboardPage.selectBusinessCategory2("Education");
    	merchantOnboardPage.selectBusinessSubCategory("Cryptocurrency");
    	merchantOnboardPage.enterBankName("Housing Development Finance Corporation");
    	merchantOnboardPage.enterBankAccountNumber("0000888899999");
    	merchantOnboardPage.enterIFSCCode("HDFC0001234");
        merchantOnboardPage.enterBranchName("Main Branch");
        merchantOnboardPage.enterAccountHolderName("dileep");
        merchantOnboardPage.selectMonthlyExpenditure("3");
        merchantOnboardPage.enterCompanyName("Twilight IT Solutions");
        merchantOnboardPage.enterCompanyAddress("Puducherry");
        String validPincode = "123456";
        merchantOnboardPage.enterPincode(validPincode);
        String validCityName = "New York"; // Example of a valid city name
        merchantOnboardPage.enterCity(validCityName);
        merchantOnboardPage.clickStateSelect();
    	Thread.sleep(2000);
    	merchantOnboardPage.selectStateByValue("2"); // Selecting "Andaman And Nicobar"
    	driver.findElement(By.xpath("//input[@value='Next']")).click();
    	
    	merchantOnboardPage.enterPercentageFees("40.5");
    	merchantOnboardPage.selectVendor("Super Admin");
    	merchantOnboardPage.clickPayInButton();
    	merchantOnboardPage.clickPayOutToggle();
    	merchantOnboardPage.clickAddButton();
    	merchantOnboardPage.enterValidDetails();
    	merchantOnboardPage.clickToggleButton();
    	merchantOnboardPage.ClickAddAppButton();
    	driver.switchTo().defaultContent();
    	merchantOnboardPage.nxtbtn();
    	
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
         merchantOnboardPage.clickconfirmbtn();
    	
    	
    	merchantListPage.clickMerchantList();
    	merchantListPage.clickVerifyButton();
    	merchantListPage.clickVerifyMerchantButton();
    	merchantListPage.clickOkButton();
    }
    
}
