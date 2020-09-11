package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page_objects.Angularjs_Home;
import resources.base;

public class Addtodo extends base{
	
	public WebDriver driver;
	
	@BeforeTest
	public void initilize() throws IOException
	{
		driver = initializeDriver();
		System.out.println("Driver is initilied");
		driver.get(prop.getProperty("url"));
		System.out.println("URL is launched");
		
	}
	@Test (priority =1)
	public void AddTodoList()
	{
		Angularjs_Home Ah = new Angularjs_Home(driver);
		Ah.EnterTodo().sendKeys(prop.getProperty("To_do1"));// Entering item one
		Ah.EnterTodo().submit();
		Ah.EnterTodo().sendKeys(prop.getProperty("To_do2")); // Entering item two
		Ah.EnterTodo().submit();
		Ah.EnterTodo().sendKeys(prop.getProperty("To_do3")); // Entering item three
		Ah.EnterTodo().submit();
		System.out.println("Entered to do list");
		
		String order1 = Ah.EnteredList().getText();
		Assert.assertEquals(order1, prop.getProperty("To_do1")); // Verifying iteem one is added to the list
		System.out.println("Verified item  " + order1 + " is  added to the  list");
		
		
	}
	
	@Test (priority =2)
	public void TodolistComplete()
	{
		Angularjs_Home Ah1 = new Angularjs_Home(driver);
		String BeforeComplete = Ah1.List_Count().getText();
		System.out.println("Count Before Complete - "+" "+ BeforeComplete);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Ah1.Markascomplete().click();
		String AfterComplete = Ah1.List_Count().getText();
		System.out.println("Count Before Complete - "+" "+ AfterComplete);
		Assert.assertNotEquals(BeforeComplete, AfterComplete);
	}
	
	@Test (priority =3)
	public void Filter_Todolist()
	{
		Angularjs_Home Ah2 = new Angularjs_Home(driver);
		Ah2.Active_list().click();
		String Activecount = Ah2.List_Count().getText(); // getting count  of active list
		System.out.println("Active list items "+ Activecount );
		Assert.assertTrue(true, "Active");
		
		Ah2.Completed_list().click();
		String Completedcount =Ah2.List_Count().getText();
		System.out.println("Completed list items "+ Completedcount );
		Assert.assertTrue(true, "Completed");
		
		}
	
	@Test(priority =4)
	public void Delete_Todolist()
	{
		Angularjs_Home Ah3 = new Angularjs_Home(driver);
		Ah3.All_list().click();
		String Allcount = Ah3.List_Count().getText(); // getting count  of active list
		System.out.println("List items before Delete - "+ Allcount );
		
		 Ah3.EnteredList().click();
		 String Name =Ah3.EnteredList().getText();
		Ah3.Remove_list().click();
		Assert.assertEquals(Name, prop.getProperty("To_do1"));
	   System.out.println("List items after Delete - "+ Allcount );
		
		//Assert.assertFalse(condition, message);
		
		
		}
	

}
