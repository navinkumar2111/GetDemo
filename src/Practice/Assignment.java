package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.setProperty("webdriver.edge.driver", "C:\\Users\\navin\\Downloads\\edgedriver_win64\\msedgedriver.exe");
     WebDriver driver = new EdgeDriver();
     driver.manage().window().maximize();
     driver.get("https://rahulshettyacademy.com/AutomationPractice/");
     driver.findElement(By.id("name")).sendKeys("text");
     driver.findElement(By.id("alertbtn")).click();
     System.out.println(driver.switchTo().alert().getText());
     //driver.switchTo().alert().accept();
     driver.switchTo().alert().dismiss();
	}

}
