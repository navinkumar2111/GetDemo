package Practice;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class UpdatedDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver","C:\\Users\\navin\\Downloads\\edgedriver_win64\\msedgedriver.exe");
   
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        Assert.assertEquals(false, driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
        System.out.println(driver.findElement(By.cssSelector("input[type='checkbox']")).getSize());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        
        
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);
        int i=0;
        while(i < 5)
        {
        driver.findElement(By.id("hrefIncAdt")).click();
        i++;
        }
        
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"6 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
