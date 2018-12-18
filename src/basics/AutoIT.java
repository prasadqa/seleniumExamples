package basics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoIT {

	static  String firstName = "Selenium";
    static String lastName = "hq";

    public static void main(String[] args) throws InterruptedException, IOException {

        System.setProperty("webdriver.gecko.driver","D:\\SeleniumSamples\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    	/*System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSamples\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();*/
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).clear();
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
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
        Thread.sleep(5000);
        
        WebElement element = driver.findElement(By.xpath("//input[@class='duplexBox']"));
        
        Actions act = new Actions(driver);
        act.moveToElement(element).click().build().perform();
        
      
        /*Runtime.getRuntime().exec("C:\\Users\\chprasad\\Desktop\\upload.exe");
        Thread.sleep(500);
        driver.findElement(By.id("btnSave")).click();
        Thread.sleep(500);
        TakesScreenshot screens = (TakesScreenshot) driver;
        File screenFile = screens.getScreenshotAs(OutputType.FILE);
        File dastFile = new File("C:\\Users\\chprasad\\IdeaProjects\\Examples\\ScreenShots.png");
        FileUtils.copyFile(screenFile, dastFile);
        String profileName = driver.findElement(By.cssSelector("h1")).getText();
        System.out.println(profileName);
        if (profileName.equalsIgnoreCase(firstName+" "+lastName))
        {
        	
            System.out.println(firstName+" "+lastName+"Photo uploaded successfully");
        }
        else
        {
            System.out.println("Photo does not uploaded successfully");
        }*/
    }
}
