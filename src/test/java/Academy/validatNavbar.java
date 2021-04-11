package Academy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObejct.LandingPage;
import resources.base;

public class validatNavbar extends base {
	public WebDriver driver;
	public static Logger logger = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initBrowser() throws IOException {
		driver = initDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		logger.info("Naviagted to Home Page");
	}

	@Test
	public void assertNavbar() throws IOException {

		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getnavbar().isDisplayed());
		// Assert.assertFalse(condition);
		logger.info("Navbar is Displayed");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
