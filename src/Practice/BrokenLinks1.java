package Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks1 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\navin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//broken links
		//Step 1 - IS to get all urls tied up to the links using Selenium
        //Java methods will call URL's and gets you the status code
        //if status code >400 then that url is not working-> link which tied to url is broken
        //a[href*="soapui"]'
        
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("a[ href*='soapui']"));
		String url = driver.findElement(By.cssSelector("a[ href*='soapui']")).getAttribute("href");
		//HttpURLConnection  conn = new (HttpURLConnection)new URL(url).openConnection();
		HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int ResponseCode = conn.getResponseCode();
		System.out.println(ResponseCode);
		
	}

}
