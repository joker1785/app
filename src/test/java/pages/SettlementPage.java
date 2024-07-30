package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettlementPage {
	private WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
	By settlementLink = By.xpath("//a[.='Settlement']");
	private By businessTypeSelect = By.id("businesstypeselect");


  public SettlementPage(WebDriver driver) {
	this.driver = driver;
	this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	this.actions = new Actions(driver);
}
     
  public void clickSettlementLink() {
	  WebElement settLink = driver.findElement(settlementLink);
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", settLink);
	  settLink.click();
  }
    
  public void selectCompanyByIndex(int index) {
      Select select = new Select(driver.findElement(businessTypeSelect));
      select.selectByIndex(index);
  }

  public String getSelectedCompany() {
      Select select = new Select(driver.findElement(businessTypeSelect));
      return select.getFirstSelectedOption().getText();
  }
  public boolean isDropdownDisplayed() {
      return driver.findElement(businessTypeSelect).isDisplayed();
  }
}
