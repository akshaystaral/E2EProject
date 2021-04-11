package pageObejct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;

	By emailId = By.cssSelector("[id*='user_email']");
	By sendinstructions = By.cssSelector("input[name='commit']");

	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getemailId() {
		return driver.findElement(emailId);
	}
	
	public WebElement getsendinstructions() {
		return driver.findElement(sendinstructions);
	}

}
