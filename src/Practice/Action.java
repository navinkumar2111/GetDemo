package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("weddriver.chrome.driver", "C:\\Users\\navin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		   driver.get("https://www.amazon.in/");
		   Actions a = new Actions(driver);
		   WebElement Move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		   
		   a.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		   
		   // move to specific element
		   a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();
		   a.moveToElement(Move).contextClick().build().perform();
	}

}
