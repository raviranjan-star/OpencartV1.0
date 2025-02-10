package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected static WebDriver driver;
	protected static Actions Act;
	protected static JavascriptExecutor js;
	protected static WebDriverWait wait;
	
	public BasePage(WebDriver driver)
	{
		BasePage.driver=driver;
		PageFactory.initElements(driver, this);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		Act=new Actions(BasePage.driver);
		js=(JavascriptExecutor)BasePage.driver;
	}
}
