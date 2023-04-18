package PracticeFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frame1{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\navin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		System.out.println(driver.findElement(By.tagName("iframe")).getSize());
		driver.switchTo().frame(0);
		
        Actions a = new Actions(driver);
        //WebElement Source = driver.findElement(By.id('draggable'));
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        
        a.dragAndDrop(source , target).build().perform();
        
		
	}

}
