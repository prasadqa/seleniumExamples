package basics;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class ScreenShot {

	public static void main(String[] args) 
	{
		String nameOFscreen = "sample";
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSamples\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
        
        Shutterbug.shootPage(driver).withName(nameOFscreen+"_"+date()).save("./DefineByMe");
        System.out.println("done");
        
        driver.close();
        
		
	}
	public static String date()
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_mm_ss");
		return sdf.format(d);
		 
	}
}
