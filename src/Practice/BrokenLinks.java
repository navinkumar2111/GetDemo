package Practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\navin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		WebElement ColumnDriver = driver.findElement(By.xpath("//table/tbody/tr/td[1] /ul"));
		System.out.println(ColumnDriver.findElements(By.tagName("a")).size());
		
		//open the ink in all column
		
		for(int i=1; i < ColumnDriver.findElements(By.tagName("a")).size();i++ )
		{
			String ClickControl = Keys.chord(Keys.CONTROL,Keys.ENTER);
			ColumnDriver.findElements(By.tagName("a")).get(i).sendKeys(ClickControl);
		}
		  Set<String> windows = driver.getWindowHandles();
		  Iterator<String> itr = windows.iterator();
		  while(itr.hasNext()) {
			  driver.switchTo().window(itr.next());
			  System.out.println(driver.getTitle());
		  }
	}

}
