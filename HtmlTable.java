package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlTable {
	
		public static void main(String[] args) throws InterruptedException {
			//Initializing chromedriver using webdriver manager
			WebDriverManager.chromedriver().setup();
			//Creating object for chromedriver and maximizing the chrome
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			//Implementing implict wait
			driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
			//Launching URL "https://html.com/tags/table/"
			driver.get("https://html.com/tags/table/");
			//Printing the respective values based on given Library
			WebElement elementTable = driver.findElement(By.xpath("(//table[1])[1]"));
			List<WebElement> elementRowsData = elementTable.findElements(By.tagName("tr"));
//			Thread.sleep(1000);
			//use for loop and print all values in the tables
			for(int i=0;i<elementRowsData.size();i++)
			{
				
				System.out.println(elementRowsData.get(i).getText());
			}
                
			
		}

}

