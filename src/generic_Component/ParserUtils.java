package generic_Component;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Config.SingleTonInstance;

public class ParserUtils {

	private static Logger LOGGER = Logger.getLogger("ParserUtils");

	/**
	 * Hover function is used to mouse hover
	 * 
	 * @param menu
	 * @param driver
	 */

	public static void hover(WebDriver driver, WebElement menu) {

		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();

		LOGGER.info("Mouse hover on menu");
	}

	/**
	 * Hover function is used to mouse hover
	 */

	public static void selectDropdown(WebDriver driver, Select list, String dropdownComponent, String dropdownselected,
			String selection) {

		list = new Select(driver.findElement(By.xpath(SingleTonInstance.file.getProperty(dropdownComponent))));
		list.selectByVisibleText(SingleTonInstance.file.getProperty(dropdownselected));
		driver.findElement(By.xpath(SingleTonInstance.file.getProperty(selection))).click();

		LOGGER.info("Dropdown selection");

	}

	public static void expWait(WebDriver driver, String str1) {
		LOGGER.info("start of exp");
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str1)));

		LOGGER.info("Explicit wait found");
	}

	public static void browserMaximize(WebDriver driver) {

		driver.manage().window().maximize();

		LOGGER.info("Browser Maximize");

	}

	public static void implicitWait(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		LOGGER.info("Implicit wait");
	}

	public static WebDriver loadingBrowser(String BrowserLanguage, WebDriver driver) throws IOException {
		LOGGER.info("Loading browser");

		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", SingleTonInstance.file.getProperty("Language"));

		if (SingleTonInstance.file.getProperty("browsertype").equals("Mozilla")) {
			driver = new FirefoxDriver(profile);
		} else if (SingleTonInstance.file.getProperty("browsertype").equals("Headless")) {
			File file = new File(SingleTonInstance.file.getProperty("Headless"));
			System.getProperty("phantomjs.binary.path", file.getAbsolutePath());
			driver = new PhantomJSDriver();
		}

		else if (SingleTonInstance.file.getProperty("browsertype").equals("Explorer")) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability("requireWindowFocus", true);
			// WebDriver driver = new InternetExplorerDriver(capabilities);
			System.getProperty("webdriver.ie.driver", SingleTonInstance.file.getProperty("Explorer"));
			driver = new InternetExplorerDriver(capabilities);

		}
		return driver;
	}

	public static void TakeSnapShot(WebDriver driver, String Filepath) throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrFile, new File("F:\\screenshot.png"));

	}
	
	public static void click(WebDriver driver, String str){
		
		driver.findElement(By.xpath(SingleTonInstance.file.getProperty(str)));
	}

}
