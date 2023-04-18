package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ChromeOptions Options = new ChromeOptions();
      Options.setAcceptInsecureCerts(true);
      
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\navin\\Downloads\\chromedriver_win32\\chromedriver.exe");
      WebDriver driver = new ChromeDriver(Options);
      driver.get("https://expired.badssl.com/");
      System.out.println(driver.getTitle());
	}

}
