package scenario_Component;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Config.GenericMethods;
import Config.SingleTonInstance;
import generic_Component.ParserUtils;

public class Generic_steps extends GenericMethods {
	
	WebDriver driver;
	
	private static Logger LOGGER = Logger.getLogger("GenericMethods");
	
	
	
	public void browser() throws IOException {

		driver = loadingBrowser(driver);
		LOGGER.info("Loading browser");
		loginApplication(driver);
		LOGGER.info("Logging into eSA Application");
		ParserUtils.expWait(driver, SingleTonInstance.file.getProperty("WebTools"));
		LOGGER.info("Explicit wait after login into eSA application");
	}

}
