package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObejct.ForgotPassword;
import pageObejct.LandingPage;
import pageObejct.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	public static Logger logger = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initBrowser() throws IOException {
		driver = initDriver();
		driver.manage().window().maximize();
		logger.info("Naviagted to Home Page");
	}

	@Test(dataProvider = "getData")
	public void basePagnavigation(String Username, String Password) throws IOException {
		driver.get(prop.getProperty("URL"));
		// Creating objects of LandingPage and invoke methods
		LandingPage lp = new LandingPage(driver);
		lp.getLogin();
		//LoginPage loginpg = lp.getLogin(); // Calling loginpg from LandingPage class
		logger.debug("Clicked on Login Button");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.getemailId().sendKeys(Username);
		logger.info("Entered Username");
		loginpage.getpassword().sendKeys(Password);
		logger.info("Entered Password");
		loginpage.getloginbtn().click();
		logger.info("Clicked on Login Button");

		ForgotPassword fp = loginpage.getforgotpass();
		fp.getemailId().sendKeys("akshaystaral@gmail.com");
		fp.getsendinstructions().click();

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		// Row Stands for how many different data types test should run.
		// Columns stands for how many values for each test
		Object[][] data = new Object[2][2];
		// O'th Row
		data[0][0] = "nonrestricted user@qws.in";
		data[0][1] = "123456";

		// 1st Row
		data[1][0] = "restricteduser@qas.in";
		data[1][1] = "pass@123";

		return data;

	}

}
