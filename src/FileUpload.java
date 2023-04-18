import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\navin\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.cssSelector(".uploader__btn")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("E:\\AutoIT\\FileUpload.exe");
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn"))).click();
		File f = new File("C:\\Users\\navin\\Downloads\\ilovepdf_pages-to-jpg.zip");
		if(f.exists())
		{
			Assert.assertTrue(f.exists());
			//System.out.println("File found");
			if(f.delete())
			
				System.out.println("File Deleted");
			
		}
	}

}
