package pageObejct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	By emailId = By.cssSelector("#user_email");
	By password = By.cssSelector("#user_password");
	By loginbtn = By.cssSelector("[value*='Log In']");
	By forgotpass = By.cssSelector("[href*='password/new']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getemailId() {
		return driver.findElement(emailId);
	}

	public WebElement getpassword() {
		return driver.findElement(password);
	}

	public WebElement getloginbtn() {
		return driver.findElement(loginbtn);
	}

	public ForgotPassword getforgotpass() { // One way to return a object of a class
		driver.findElement(forgotpass).click(); // It's used to concise code and no need to create a retun object
		return new ForgotPassword(driver); // Refer LoginPage getLogin() in LadingPage class for normal way
	}

}
