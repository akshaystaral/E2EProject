package stepDefinations;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObejct.LandingPage;
import pageObejct.LoginPage;
import resources.base;

public class LoginstepDefination extends base {
	@Given("Initiatialize driver with ChromeDriver")
	public void initiatialize_driver_with_chrome_driver() throws IOException {
		driver = initDriver();
	}

	@And("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_something_site(String strArg1) throws Throwable {
		driver.get(strArg1);
	}

	@And("^Click on Login link in home page to land on Secure Sign in Page$")
	public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
		LandingPage lp = new LandingPage(driver);
		lp.getLogin();
	}

	@When("User enters {string} and {string} and logged in")
	public void user_enters_and_and_logged_in(String Username, String Password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.getemailId().sendKeys(Username);
		loginpage.getpassword().sendKeys(Password);
		loginpage.getloginbtn().click();

	}

	@Then("Verify if User is successfully logged in")
	public void verify_if_user_is_successfully_logged_in() {
		// Write code here that turns the phrase above into concrete actions

	}

}
