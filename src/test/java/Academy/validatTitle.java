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

public class validatTitle extends base {
	public WebDriver driver;
	public static Logger logger = LogManager.getLogger(base.class.getName());
	LandingPage lp;

	@BeforeTest
	public void initBrowser() throws IOException {
		driver = initDriver();
		logger.info("Driver is initialized");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		logger.info("Naviagted to Home Page");
	}

	@Test
	public void assertTitle() throws IOException {
		lp = new LandingPage(driver);
		// compare the value from the browser with actual value
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		logger.info("Character Sequence Matched");
	}

	@Test
	public void assertInfo() throws IOException {

		Assert.assertEquals(lp.getacinfo().getText(), "An Academy to learn Everything about Testing");
		logger.info("Character Sequence Matched");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
