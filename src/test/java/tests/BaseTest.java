package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import DataProvider.Constant;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MerchantListPage;
import pages.MerchantOnboardPage;
import pages.SettlementPage;
import pages.VendorRegistrationPage;
import pages.transcationPage;
import pages.vendorListPage;
public class BaseTest {
	protected WebDriver driver;
	 
	 protected DashboardPage dashboardPage;
	 protected LoginPage loginPage;
	 MerchantOnboardPage merchantOnboardPage;
	 VendorRegistrationPage vendorRegistrationPage;
	 MerchantListPage merchantListPage;
	 vendorListPage vendorListPage;
	 protected SettlementPage settlementPage; 
	 transcationPage transcationPage;
	 protected JavascriptExecutor jsExecutor;
	 public static Logger logger;
	 
	 @BeforeMethod
	public void setup() throws InterruptedException {
		setDriverPath("chrome",false);
		driver.manage().window().maximize();
		driver.get(Constant.url);
		dashboardPage = new DashboardPage(driver);
		loginPage = new LoginPage(driver);
		merchantOnboardPage = new MerchantOnboardPage(driver);
		vendorRegistrationPage = new VendorRegistrationPage(driver);
		merchantListPage = new MerchantListPage(driver);
		vendorListPage = new vendorListPage(driver);
		settlementPage = new SettlementPage(driver);
		transcationPage = new transcationPage(driver);
		jsExecutor = (JavascriptExecutor) driver;
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
			driver.quit();
	}

	protected void resizeBrowserWindow(int width, int height) {
        Dimension dimension = new Dimension(width, height);
        driver.manage().window().setSize(dimension);
    }
	
	private void setDriverPath(String browser, boolean isHeadless) {
		
		String os = System.getProperty("os.name").toLowerCase();
        switch (browser.toLowerCase()) {
        
            case "chrome":
               if (os.contains("win") || os.contains("mac") || os.contains("mac") || os.contains("nix") || os.contains("nux") || os.contains("aix")){
             	ChromeOptions chromeOptions = new ChromeOptions();
   			if (isHeadless) {
				chromeOptions.addArguments("--headless");      
				chromeOptions.addArguments("--disable-gpu");
			}
   			driver = new ChromeDriver(chromeOptions);
    			break;
              } else {
            	  throw new IllegalArgumentException("Unsupported operating system: " + os);
            }
            
               
            case "firefox":
                if (os.contains("win") || os.contains("mac") || os.contains("mac") || os.contains("nix") || os.contains("nux") || os.contains("aix")) {
                	FirefoxOptions firefoxOptions = new FirefoxOptions();
        			if (isHeadless) {
        				firefoxOptions.addArguments("--headless");
        			}
        			driver = new FirefoxDriver(firefoxOptions);
                } else {
                    throw new IllegalArgumentException("Unsupported operating system: " + os);
                }
                
            case "edge":
                if (os.contains("win") || os.contains("mac") || os.contains("mac") || os.contains("nix") || os.contains("nux") || os.contains("aix")){
                	EdgeOptions edgeOptions = new EdgeOptions();
        			if (isHeadless) {
        				edgeOptions.addArguments("--headless");
        				edgeOptions.addArguments("--disable-gpu");
        			}
        			driver = new EdgeDriver(edgeOptions);
        			break;
               
                } else {
                    throw new IllegalArgumentException("Unsupported operating system: " + os);
                }
                
            default:
    			ChromeOptions defaultOptions = new ChromeOptions();
    			if (isHeadless) {
    				defaultOptions.addArguments("--headless");
    				defaultOptions.addArguments("--disable-gpu");
    			}
    			driver = new ChromeDriver(defaultOptions);
    			break;
        }
       
	}
	
	
}
