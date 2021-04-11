package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initDriver() throws IOException {

		prop = new Properties();
		// System.getProperty("user.dir")
		// above command is used to access Users Project directory
		FileInputStream fis = new FileInputStream("A:\\JAVA\\E2EProject\\src\\main\\java\\resources\\data.properties");
		// FileInputStream fis = new
		// FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		// String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.contains("chrome")) {
			// Execute Chrome Browser

			System.setProperty("webdriver.chrome.driver", "A:\\Chromedriver\\88_1\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "A:\\Drivers\\Gaekodriver\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {

			System.setProperty("webdriver.edge.driver", "A:\\Drivers\\Microsoft Edge\\88.0.705.74\\msedgedriver.exe");
			driver = new EdgeDriver();

		}

		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenshot(String testCasename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCasename + ".png";
		// FileHandler.copy(source, new File(destinationFile));
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
