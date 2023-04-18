package Practice;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\navin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		// capture all webelements into list
		
		List<WebElement> elementlist = driver.findElements(By.xpath("//tr/td[1]"));
		
		// capture text of all webelements into new(original) list
		List<String> OriginalList = elementlist.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort on the original list of step 3 -> sorted list
		List<String> Sortedlist = OriginalList.stream().sorted().collect(Collectors.toList());
		
		//Compare original list to sorted list
		Assert.assertTrue(OriginalList.equals(Sortedlist));
		
		// scan the name column with get text-> beans Print the price of beans
		List<String> Price;
		
		do {
		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));	
		Price = rows.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggi(s)).collect(Collectors.toList());
		Price.forEach(a->System.out.print(a));
		if(Price.size()<1)
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(Price.size()<1);
		
	}

	private static String getPriceVeggi(WebElement s) {
		// TODO Auto-generated method stub
		// //tr/td[1]/ following-sibling::td[1]
		String PriceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return PriceValue ;
	}

}
