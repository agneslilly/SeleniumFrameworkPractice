package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {
	
     public static WebDriver driver;
     public Logger logger;
     public Properties p;
    

	@BeforeClass(groups= {"sanity","master"},alwaysRun=true)
	@Parameters(value="browser")
	public void setUp(String br) throws IOException
	{
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver();break;
		case "edge": driver=new EdgeDriver();break;
		default: System.out.println("Invalid browser"); return;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL"));

	}
	@AfterClass(groups= {"sanity","master"},alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString(int length)
		{
			Random random=new Random();
			StringBuilder builder=new StringBuilder();
			for(int i=0;i<length;i++) 
			{
			char randomChar= (char)('a'+random.nextInt(26));
			builder.append(randomChar);
			}
			return builder.toString();	
		}
			
			
	public String TelephoneNumberGenerator()
	    {
	    	Random random=new Random();
	    	StringBuilder builder = new StringBuilder("9");
	    	for(int i=0;i<9;i++)
	    	{
	    		 builder.append(random.nextInt(10));
	    	}
	    	return builder.toString();
	    }
	
	
	

}
