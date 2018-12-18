package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMExample {

	static WebDriver driver ;
	
	@FindBy(xpath = "//input[@type='text']")
	static WebElement userName;
	
	
	@FindBy(xpath = "//input[@type='password']")
	static WebElement PassWord;
	
	@FindBy(id = "btnLogin")
	static WebElement submitButton;
	
	@FindBy(linkText = "Welcome Admin")
	static WebElement validationText;
	
	public static void main(String[] args) 
	{
		POMExample.setUpBeforeTest();
		PageFactory.initElements(driver, POMExample.class);//its initiate the page factories
		userName.sendKeys("Admin");
		PassWord.sendKeys("admin123");
		submitButton.click();
		
		String str = validationText.getText();
		
		if(str.equalsIgnoreCase("Welcome Admin"))
			System.out.println("pass");
		else
			System.out.println("fail");
			
		POMExample.setUpAfterTest();
		
		
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
	
	/*
	 *By userName = By.xpath("//*[@type='text']");
	By password = By.xpath("//input[@type='password']");
	By submitBtn = By.id("btnLogin");
	By adminPageTest = By.linkText("Welcome Admin"); */
	

}
