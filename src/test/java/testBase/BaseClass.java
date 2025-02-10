package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	public static Properties p;
	
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		//loading config.properties file
		FileInputStream file=new FileInputStream("./src//test//resources//Config.properties");
		p=new Properties();
		p.load(file);
		
		logger =LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		case "chrome":driver =new ChromeDriver();break;
		case "edge":driver =new EdgeDriver();break;
		case "firefox":driver =new FirefoxDriver();break;
		default:System.out.println("Invallid Browser");return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(p.getProperty("appURL"));//reading data from properties file
		driver.manage().window().maximize();
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void tearDown()
	{
		driver.quit();
	}
	
	// Generating Random Data======================================================================
	static String CHARACTERS="qwertyuioplkjhgfdsazxcvbnm1234567890";
	static SecureRandom RANDOM=new SecureRandom();
	
	
	public static String random(int length)
		{
			StringBuilder result=new StringBuilder(length);
			for(int i=0;i<length;i++)
			{
				int index=RANDOM.nextInt(CHARACTERS.length());
				result.append(CHARACTERS.charAt(index));
			}
			return result.toString();
		}
	//==============================================================================================
}
