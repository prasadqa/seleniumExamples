package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ra {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver","D:\\SeleniumSamples\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/ResourceAdda/#/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@ui-sref='login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Email ID']")).sendKeys("customer1@gmail.com");
		driver.findElement(By.cssSelector("#Passwod")).sendKeys("customer1@gmail.com");
		driver.findElement(By.cssSelector("#btn")).click();
		Thread.sleep(2000);
		String str = driver.findElement(By.cssSelector(".ng-binding")).getAttribute("Test");
		System.out.println(str);
	}

}
