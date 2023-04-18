package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        System.setProperty("webdriver.edge.driver", "C:\\Users\\navin\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//a[@value = 'BLR']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@value = 'MAA'])[2]")).click();
        //driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value = 'MAA'")).click();
        
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
        	System.out.println("its Enabled");
        	Assert.assertEquals(true , driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"));
        }
	}

}
