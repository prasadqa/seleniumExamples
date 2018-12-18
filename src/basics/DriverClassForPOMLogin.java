package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DriverClassForPOMLogin {

	static WebDriver driver;
	public static void main(String[] args) 
	{
		DriverClassForPOMLogin.setUpBeforeTest();
		
		POMLogInPage initi = new POMLogInPage(driver);
		String TestAdminPage = initi.UserLogIn("Admin", "admin123");
		if (TestAdminPage.equalsIgnoreCase("Welcome Admin")) 
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
			
		}
			

		DriverClassForPOMLogin.setUpAfterTest();
		
	}
	public static void setUpBeforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSamples\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	public static void setUpAfterTest()
	{
		driver.close();
	}

}
