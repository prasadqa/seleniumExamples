package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.profiler.ProfilerLogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Clickable {
	
	static  String firstName = "Selenium";
    static String lastName = "hq";

	public static void main(String[] args) throws InterruptedException 
	{
		/*System.setProperty("webdriver.gecko.driver","D:\\SeleniumSamples\\geckodriver.exe");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("dom.file.createInChild", true);
		DesiredCapabilities capabilities = new DesiredCapabilities().firefox();
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        
        WebDriver driver = new FirefoxDriver(capabilities);*/
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSamples\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
        driver.findElement(By.id("txtUsername")).clear();
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys("Admin");
        driver.findElement(By.name("Submit")).click();
        String welcomeNote = driver.findElement(By.className("panelTrigger")).getText();
        //Assert.assertEquals("Welcome Admin",welcomeNote,);
        if(welcomeNote.equalsIgnoreCase("Welcome Admin"))
        {
            System.out.println("Pass");
        }
        else
        {
            System.out.println("fail");
        }
        Thread.sleep(2000);
        driver.findElement(By.linkText("PIM")).click();
        driver.findElement(By.linkText("Add Employee")).click();
        driver.findElement(By.cssSelector("input[id='firstName'][class='formInputText']")).clear();
        driver.findElement(By.cssSelector("input[id='firstName'][class='formInputText']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[id='lastName'][class='formInputText']")).clear();
        driver.findElement(By.cssSelector("input[id='lastName'][class='formInputText']")).sendKeys(lastName);
        if(driver.findElement(By.cssSelector("input.duplexBox")).isDisplayed())
        {
        	System.out.println("Yes, It is displayed");
        	 Thread.sleep(2000);
        	driver.findElement(By.cssSelector("input.duplexBox")).click();
        }
        else
        {
        	System.out.println("Unable to click");
        }
	}

}
