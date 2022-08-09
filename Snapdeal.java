package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement shoes = driver.findElement(By.xpath("//input[@id='inputValEnter']"));
		Thread.sleep(10000);
		shoes.sendKeys("Training Shoes", Keys.ENTER);
		Thread.sleep(10000);
		List<WebElement> size = driver.findElements(By.xpath("//picture[@class='picture-elem']//img"));
		System.out.println("training shoes count is :" + size.size());
		Thread.sleep(1000);
//		before sorting check the price details
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		Thread.sleep(3000);
		List<String> shoe = new ArrayList<String>();
		for (int i = 0; i < price.size(); i++) {
			String text = price.get(i).getText();

			shoe.add(text);
//			System.out.println(shoe);

		}System.out.println("before sort :"+shoe);
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//ul[@class='sort-value']//li[3]")).click();
		Thread.sleep(5000);
//		After sorting check the price details
		List<WebElement> price1 = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));

		List<String> shoe1 = new ArrayList<String>();
		for (int i = 0; i < price1.size(); i++) {
			String text1 = price1.get(i).getText();

			shoe1.add(text1);
			

		}System.out.println("After sort :"+shoe1);
		shoe = shoe1;
//		check the both sorting using if condition whether it's sorted or not?
		if (shoe == shoe1) {
			System.out.println("price is sorted");
		} else {
			System.out.println("price is not sorted");
		}
		
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("900",Keys.ENTER);
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1500",Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='filter-accordian']//i[@class='sd-icon sd-icon-plus'])[1]")).click();
		Thread.sleep(1000);
	driver.findElement(By.xpath("//label[@for='Color_s-Blue']")).click();
	Thread.sleep(10000);
	String btag= driver.findElement(By.xpath("//label[@for='Color_s-Blue']")).getText();
	System.out.println(btag);
	Thread.sleep(1000);
	if(btag.contains("Blue"))
	{
		System.out.println("blue color is selected");
		
	}else
	{
		System.out.println("blue color is not selected");
	}
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//div[@class='nudge-image-bottom-left']//following::img)[1]")).click();
	Thread.sleep(5000);
	Set<String> newWindow = driver.getWindowHandles();
	List<String>newList=new ArrayList<String>(newWindow);
	driver.switchTo().window(newList.get(1));
	Thread.sleep(10000);
	String shoePrice= driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
	Thread.sleep(5000);
	System.out.println("shoe price is :"+shoePrice);
	Thread.sleep(2000);
	String discount = driver.findElement(By.xpath("(//span[@class='payBlkBig']//following::span)[2]")).getText();
	Thread.sleep(500);
	System.out.println("The Shoe discount percentage is :"+discount +" OFF");
	Thread.sleep(2000);
	WebElement element = driver.findElement(By.xpath("//div[@class='col-xs-21 reset-padding height-inherit']"));
	Thread.sleep(10000);
	File fileSource = element.getScreenshotAs(OutputType.FILE);
	Thread.sleep(1000);
	File storage=new File("./Pics/IMG001.png");
	FileUtils.copyFile(fileSource, storage);
		
}		
}



