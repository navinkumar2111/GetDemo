package Practice;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
     //System.setProperty("webdriver.edge.driver", "Beetroot - 1 Kg");
     //WebDriver driver = new EdgeDriver();
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\navin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
	 ChromeOptions options = new ChromeOptions();
	 options.addArguments("--remote-allow-origins=*");
	 WebDriver driver = new ChromeDriver(options);
	 driver.manage().window().maximize();
     String[] itemsNeeded = {"Cucumber - 1 Kg" ,"Brocolli - 1 Kg" ,"Beetroot - 1 Kg"};
     driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
     
     List<WebElement> Products = driver.findElements(By.cssSelector("h4.product-name"));
     for (int i= 0;i<Products.size();i++)
     {
    	String name = Products.get(i).getText();
    	List itemsNeededList = Arrays.asList(itemsNeeded);
    	 
    	 //if(name.contains("Brocolli"))
    	 if(itemsNeededList.contains(name))
    	 {
    		 driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();    	 
    		 }
    	 
     }
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("img[alt='Cart']")).click();
     driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
	}

}
