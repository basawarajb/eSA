package Config;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class StaticDataProvider {
	
	private static WebDriver driver;
	
	 @DataProvider(name = "MasterData")
	 
	 public static Object[][] data(){
		 
		 
		return new Object[][] {{"UC455800","B"}};
		 
		 
	 }
	 
	@DataProvider(name = "UserCreation")
	
	public static Object[][] user(){
		
		return new Object [][] {{"UC444300","118257350"},{"UC444400","118257350"}};
		
		
	}
	
	@DataProvider(name="Monitoring")
	
	public static Object [][] monitor(){
		
		return new Object [][] {{"Desc","select * from tab"}};
		
		
	}
	
	@DataProvider(name="deletion")
	
	public static Object [][] delete(){
		
		return new Object [][] {{"UC446400"}};
		
		
	}
	
	@DataProvider(name = "UserCreation")
	
	public static Object [][] PartnerNum_Input(){
		
		return new Object [][] {{"173264357"}};
	}
	
	public class SimpleTestFactory 
	{
	//    @Factory
	//    public Object[] factoryMethod() {
	//        return new Object[] { new SimpleTest(), new SimpleTest() };
	    }
	
	
	}
	 

