package scenario_Component;

import Config.GenericMethods;
import Config.SingleTonInstance;
import generic_Component.ParserUtils;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class CustomerCreate extends GenericMethods {

	WebDriver driver;
	
	@BeforeClass
	public void browser() throws IOException {

		driver = loadingBrowser(driver);

	}

	@BeforeMethod
	public void login() throws IOException {
		loginApplication(driver);
		ParserUtils.expWait(driver, SingleTonInstance.file.getProperty("eBanking"));
	}



	@AfterMethod
	public void afterMethod() {
	}

}
