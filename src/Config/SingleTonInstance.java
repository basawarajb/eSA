package Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class SingleTonInstance {
	
	String result ="";
	InputStream inputStream;
	
	public static Properties file;
	private static SingleTonInstance configuration;
     
	 private SingleTonInstance(){
	
		file = new Properties();
		  String propFileName ="propertyfile.properties"; 
		  try
		  {
		  inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		  
		  
		  if(inputStream != null)
		  {
			  
			  
			  file.load(inputStream);
			  
		  }
		  }catch(Exception e){
			  
			  System.out.println("Exception: " + e);
			  
		  }finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		  }	  
	}
  public static SingleTonInstance getConfiguration() {
	  if(configuration==null)
	  {
		  configuration=new SingleTonInstance();
	  }
	return configuration;

  }

	public String getValue(String key) {
		return file.getProperty(key);

}

}