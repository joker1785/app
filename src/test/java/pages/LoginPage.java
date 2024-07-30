package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
		WebDriver driver;
	
	   By usernameInputField = By.id("employee_username");
	   By passwordInputField = By.xpath("(//input[@class='input'])[2]");
	   By loginButton = By.xpath("//input[@value='Login']");
	   By passwordToggleIcon = By.xpath("//i[contains(@class,'fa fa-eye-slash')]");
	   By errorMessage = By.id("employee-login-error");
	   By loginError = By.id("employee-login-error");
	   
	   
	   public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Method to click the login button
    public void clickLoginButton() throws Exception {
        driver.findElement(loginButton).click();
        Thread.sleep(2000);
    }

    public void enterUsername(String username) {
    	WebElement usernameField = driver.findElement(usernameInputField);
    	usernameField.sendKeys(username);
    }
        
    
    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(passwordInputField);
        passwordField.sendKeys(password);
    }

    public String getErrorMessage() {
    	WebElement errormessage = driver.findElement(errorMessage);
        return errormessage.getText();
    }
    public void clickPasswordToggleIcon() {
        driver.findElement(passwordToggleIcon).click();
    }

    public boolean isPasswordVisible() {
        WebElement passwordField = driver.findElement(passwordInputField);
        return passwordField.getAttribute("type").equals("text");
    }
    public boolean isPasswordinVisible(){
    	driver.findElement(By.xpath("//i[contains(@class,'fa password-toggle')]")).click();
        WebElement passwordField = driver.findElement(passwordInputField);
        return passwordField.getAttribute("type").equals("password");
    }
    public String getErrorMessageInvalidCredential() {
    	WebElement errormsg = driver.findElement(loginError);
        return errormsg.getText();
    }
    
    public void enterValidCredential(String username , String password) throws Exception {
    	enterUsername(username);
    	enterPassword(password);
    	clickLoginButton();
    	
    }

}
