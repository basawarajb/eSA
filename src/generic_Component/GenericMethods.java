package generic_Component;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Config.SingleTonInstance;
import generic_Component.ParserUtils;

public abstract class GenericMethods {

	private static WebDriver driver;
	ParserUtils pars;
	SingleTonInstance prop = SingleTonInstance.getConfiguration();

	private static Logger LOGGER = Logger.getLogger("GenericMethods");

	public abstract void browser() throws IOException;

	public WebDriver loadingBrowser(WebDriver driver) throws IOException {

		pars = new ParserUtils();
		driver = ParserUtils.loadingBrowser(prop.file.getProperty("browsertype"), driver);

		return driver;
	}

	public void loginApplication(WebDriver driver) {

		ParserUtils.implicitWait(driver);
		driver.get(SingleTonInstance.file.getProperty("URL"));
		LOGGER.info("Loading application URL");
		ParserUtils.implicitWait(driver);
		ParserUtils.browserMaximize(driver);
		LOGGER.info("Maximize browser");
	}

}
