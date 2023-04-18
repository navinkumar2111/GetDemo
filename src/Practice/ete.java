package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ete {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.edge.driver","C:\\Users\\navin\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	      WebDriver driver = new EdgeDriver();
	      driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	      driver.manage().window().maximize();
	      driver.findElement(By.id("autosuggest")).sendKeys("ind");
	        Thread.sleep(3000);
	        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
	        
	        for(WebElement option:options) 
	        {
	        	if (option.getText().equalsIgnoreCase("india"))
	        	{
	        		option.click();
	        	}
	        	}
	        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	        Thread.sleep(1000);
	        
	        driver.findElement(By.xpath("//a[@value = 'BLR']")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("(//a[@value = 'MAA'])[2]")).click();
	        //driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value = 'MAA'")).click();

	        System.out.println(driver.findElement(By.cssSelector("input[type='checkbox']")).getSize());
	        
	        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
	        
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
	        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	        
	        Select dropdown = new Select(staticDropdown);
	        dropdown.selectByIndex(3);
	        System.out.println(dropdown.getFirstSelectedOption().getText());
	        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
	        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
	        
	        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
	        	System.out.println("its Enabled");
	        	Assert.assertEquals(true, driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"));
	        }
	}

}
