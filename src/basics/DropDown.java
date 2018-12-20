package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\chprasad\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://primusbank.qedgetech.com/");
		WebElement element = driver.findElement(By.id("drlist"));
		Select select = new Select(element);
		List<WebElement> elist = select.getOptions();
		System.out.println(elist.size());
		// this for loop 
		/*for(int i=0;i<elist.size();i++)
		{
			String name = elist.get(i).getText();
			System.out.println(name);
		}*/
		
		
		///for each loop
		for(WebElement name:elist)
		{
			System.out.println(name.getText());
		}
		driver.close();
	}

}
