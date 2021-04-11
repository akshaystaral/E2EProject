package pageObejct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.cssSelector("div[class='text-center'] h2");
	private By navbar = By.cssSelector("ul[class='nav navbar-nav navbar-right']");
	private By acinfo = By.xpath("//h3[normalize-space()='An Academy to learn Everything about Testing']");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLogin() {
		driver.findElement(signin).click();
		LoginPage loginpg = new LoginPage(driver);
		return loginpg;
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getnavbar() {
		System.out.println("Trying to access Navbar Element");
		return driver.findElement(navbar);
	}
	
	public WebElement getacinfo() {
		return driver.findElement(acinfo);
	}
}
