package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      //System.setProperty("webDriver.driver.edge", "C:\\Users\\navin\\Downloads\\edgedriver_win64\\msedgedriver.exe\");"
      System.setProperty("webdriver.edge.driver","C:\\Users\\navin\\Downloads\\edgedriver_win64\\msedgedriver.exe");
      WebDriver driver = new EdgeDriver();
      driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
      
      WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
      
      Select dropdown = new Select(staticDropdown);
      dropdown.selectByIndex(3);
      System.out.println(dropdown.getFirstSelectedOption().getText());
	}

}