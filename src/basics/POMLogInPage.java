package basics;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POMLogInPage {
	WebDriver driver;
	By userName = By.xpath("//*[@type='text']");
	By password = By.xpath("//input[@type='password']");
	By submitBtn = By.id("btnLogin");
	By adminPageTest = By.linkText("Welcome Admin");
	public POMLogInPage(WebDriver driver)
	{
		//System.setProperty("webdriver.gecko.driver", "D:\\SeleniumSamples\\geckodriver.exe");
		this.driver = driver;
	}
	
	//set User Name
	public void setUserName(String setuserName)
	{
		driver.findElement(userName).sendKeys(setuserName);
	}
	// set Password
	public void setPassWord(String setPassWord)
	{
		driver.findElement(password).sendKeys(setPassWord);
	}
	public void clickOperation()
	{
		driver.findElement(submitBtn).click();
	}
	public String getAdminPageText()
	{
		return driver.findElement(adminPageTest).getText();
	}
	public String UserLogIn(String userName,String passWord)
	{
		setUserName(userName);
		setPassWord(passWord);
		clickOperation();
		
		 return getAdminPageText(); 
	}
	
}
