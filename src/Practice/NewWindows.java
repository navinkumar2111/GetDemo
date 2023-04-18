package Practice;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\navin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Switching of element
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> Handles = driver.getWindowHandles();
		Iterator<String> it= Handles.iterator();
		String ParentId = it.next();
		String ChildId = it.next();
		driver.switchTo().window(ChildId);
		
		driver.get("https://courses.rahulshettyacademy.com/courses");
		String CourseName = driver.findElements(By.cssSelector(".course-listing-subtitle ")).get(2).getText();
		driver.switchTo().window(ParentId);
		//driver.findElement(By.cssSelector(".form-control.ng-pristine.ng-invalid.ng-touched")).sendKeys(CourseName);
		//driver.findElement(By.cssSelector("[name='name']")).sendKeys(CourseName);
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(CourseName);
		//Screenshot
		File file=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		//heigth of WebElement
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
	}

}
