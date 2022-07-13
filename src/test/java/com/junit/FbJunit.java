package com.junit;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbJunit {
	static WebDriver driver;
	@BeforeClass
	public static void browserOpen() {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\eclipse-workspace\\Selenium\\Drivers\\chromedriver.exe");
	   driver=new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	   driver.get("https://www.flipkart.com/");	
	}
	/*@AfterClass
	public static void browserClose() {
		driver.quit();	
	}*/
	@Test
	public void method1() {
	driver.findElement(By.xpath("//button[text()='✕']")).click();

	}
	@Test
	public void method2() {
		driver.findElement(By.name("q")).sendKeys("samsung galaxy");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
	@Test
	public void method3() {
		driver.findElement(By.xpath("(//div[contains(text(),'SAMSUNG Galaxy ')])[1]")).click();

	}
	@Test
	public void method4() {
		String pWin=driver.getWindowHandle();
        Set<String> AllWin=driver.getWindowHandles();
        for(String x:AllWin) {
        	if(!x.equals(pWin)) {
        		driver.switchTo().window(x);
        	}
        }
	}
	
	@Test
	public void method5() throws Exception {
		String s=driver.getTitle();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("C:\\Users\\User\\eclipse-workspace\\com.junit\\Screenshot\\fkart.png");
		FileUtils.copyFile(source,target);
		

	}

}
