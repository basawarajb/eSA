package WebToolsModule;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Config.GenericMethods;
import Config.SingleTonInstance;
import Config.StaticDataProvider;
import generic_Component.ParserUtils;

public class Monitoring extends GenericMethods {

//	private static final String dataProvider = null;

	private static Logger LOGGER = Logger.getLogger("CreateUsecase");

	WebDriver driver;

	SingleTonInstance prop = SingleTonInstance.getConfiguration();

	@BeforeClass
	public void browser() throws IOException {

		driver = loadingBrowser(driver);

	}

	@Test
	public void login() throws IOException {

		loginApplication(driver);
		ParserUtils.expWait(driver, SingleTonInstance.file.getProperty("WebTools"));
	}


	@Test(dataProviderClass=StaticDataProvider.class,dataProvider="Monitoring")

	public void sqlQueryOverview(CharSequence Desc,CharSequence Query) {

		WebElement menu = driver.findElement(By.xpath(SingleTonInstance.file.getProperty("WebTools")));
		ParserUtils.hover(driver, menu);
		driver.findElement(By.xpath(SingleTonInstance.file.getProperty("SqlOverview"))).click();
		driver.findElement(By.xpath(SingleTonInstance.file.getProperty("NewButton"))).click();
		ParserUtils.expWait(driver, SingleTonInstance.file.getProperty("TestQueryButton"));
		driver.findElement(By.xpath(SingleTonInstance.file.getProperty("ShortDesc"))).sendKeys(Desc);
		driver.findElement(By.name(SingleTonInstance.file.getProperty("Query1"))).sendKeys(Query);
		driver.findElement(By.xpath(SingleTonInstance.file.getProperty("TestQueryButton"))).click();
		ParserUtils.expWait(driver, SingleTonInstance.file.getProperty("SaveButton"));
		driver.findElement(By.xpath(SingleTonInstance.file.getProperty("SaveButton"))).click();

	}


}
