package week4.day1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.chittorgarh.com/");
		driver.findElement(By.xpath("//*[@id='navbtn_stockmarket']")).click();
		driver.findElement(By.xpath("//*[@id='nav_stockmarket']/div/div/div[2]/a[2]")).click();
		Thread.sleep(3000);
		List<WebElement> findElement1 = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']/tbody/tr/td[3]"));
        System.out.println("Before remove duplicates :"+findElement1.size());
        Set<String>list=new LinkedHashSet<String>();
		for (int i = 0; i < findElement1.size(); i++) {

			String text=(findElement1.get(i).getText());
			list.add(text);
		}
		System.out.println("After remove duplicates :"+list.size());
		System.out.println(" ");
		System.out.print(list);
	}
}

			
			
			
