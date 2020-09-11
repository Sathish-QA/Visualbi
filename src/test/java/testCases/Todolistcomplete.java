package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page_objects.Angularjs_Home;
import resources.base;

public class Todolistcomplete extends base {
	
	public WebDriver driver;
	
//	@BeforeTest
//	public void initilize() throws IOException
//	{
//		driver = initializeDriver();
//		System.out.println("Test case 2");
////		driver.get(prop.getProperty("url"));
////		System.out.println("URL is launched");
		
	//}
	
	@Test 
	public void TodolistComplete()
	{
		Angularjs_Home Ah1 = new Angularjs_Home(driver);
		//String BeforeComplete = Ah1.List_Count().getText();
		String BeforeComplete = driver.findElement(By.className("todo-count")).getText();
		System.out.println("Count Before Complete - "+" "+ BeforeComplete);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Ah1.Markascomplete().click();
		String AfterComplete = Ah1.List_Count().getText();
		System.out.println("Count Before Complete - "+" "+ AfterComplete);
		Assert.assertNotEquals(BeforeComplete, AfterComplete);
	}
	

}
