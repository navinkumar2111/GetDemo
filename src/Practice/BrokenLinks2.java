package Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks2 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\navin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		SoftAssert a = new SoftAssert();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			//HttpURLConnection  conn = new (HttpURLConnection)new URL(url).openConnection();
			HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int ResponseCode = conn.getResponseCode();
			System.out.println(ResponseCode);
			a.assertTrue(ResponseCode < 400, "The link with" + link.getText()+ "is broken with codes" + ResponseCode);
			//if (ResponseCode > 400)
			//{
			//	System.out.println("The link with" + link.getText()+ "is broken with codes" + ResponseCode);
			//}
		}
		 a.assertAll();
	}

}
