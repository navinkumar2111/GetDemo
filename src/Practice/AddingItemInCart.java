package Practice;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddingItemInCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\navin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 WebDriver driver = new ChromeDriver(options);
		 
		 WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		 
		 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
	     String[] itemsNeeded = {"Cucumber - 1 Kg" ,"Brocolli - 1 Kg" ,"Beetroot - 1 Kg"};
	     driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	     additems(driver,itemsNeeded);
	     driver.findElement(By.cssSelector("img[alt='Cart']")).click();
	     driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
	     
	     w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
	     
	     driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
	   
	     w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.promoBtn")));
	    
	     driver.findElement(By.cssSelector("button.promoBtn")).click();
	     
	     w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
	     
	     System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	     

	}
	
	
	
	
	
	
	public static void additems(WebDriver driver, String[] itemsNeeded) {
		
	
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

}
}