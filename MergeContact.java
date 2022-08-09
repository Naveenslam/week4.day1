package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//div[@id=\"button\"]//a/following::a")).click();
		driver.findElement(By.partialLinkText("Contacts")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[4]//a")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[2]/div/form/table/tbody/tr[1]/td[2]/a/img"))
				.click();
		Set<String> newWindow = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(newWindow);
		driver.switchTo().window(list.get(1));
		Thread.sleep(20000);
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tr[1]//td)[1]")).click();
		//		(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/following::a)[1]")
		driver.switchTo().window(list.get(0));
		driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[2]/div/form/table/tbody/tr[2]/td[2]/a/img")).click();
		Set<String>newWindow1=driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(newWindow1);
		driver.switchTo().window(list1.get(1));		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/following::a[1])[2]")).click();
		driver.switchTo().window(list1.get(0));
		driver.findElement(By.xpath("//*[@id='ext-gen599']")).click();
		Alert alert = driver.switchTo().alert();
		String text=alert.getText();
		System.out.println(text);
		alert.accept();
		System.out.println(driver.getTitle());

	}

}
