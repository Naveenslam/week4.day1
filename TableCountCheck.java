package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableCountCheck {
	public static void main(String args[])
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table");
        int rowCount=driver.findElements(By.xpath("//div[@class='render']/table//tr")).size();
       int columnCount=driver.findElements(By.xpath("//div[@class='render']/table//td")).size();    
       System.out.println("Row Count is :"+rowCount);
       System.out.println("Column Count is :"+columnCount);
       driver.close();
		
		
	}

}
