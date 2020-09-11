package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class Angularjs_Home  {
	
	public  WebDriver driver;
	
By Todo	= By.xpath("//input[@placeholder='What needs to be done?']");

By Markascomplete =By.xpath("/html[1]/body[1]/ng-view[1]/section[1]/section[1]/ul[1]/li[1]/div[1]/input[1]");
	
By Listitem = By.className("ng-binding");
By Item_count = By.className("todo-count");

By Remove = By.className("destroy");
By Active_btn = By.linkText("Active");
By Completed_btn = By.linkText("Completed");
By All_btn = By.linkText("All");

	
	
	public Angularjs_Home(WebDriver driver)    //constructor to give life for a driver
	   { 
		
		this.driver=driver;
	}
	
	public WebElement EnterTodo()//method for the particular element
	{
		return driver.findElement(Todo);//passing that variable as argument
	}
	
	public WebElement Markascomplete()//method for the particular element
	{
		return driver.findElement(Markascomplete);//passing that variable as argument
	}
	
	public WebElement EnteredList()//method for the particular element
	{
		return driver.findElement(Listitem);//passing that variable as argument
	}
	
	public WebElement List_Count()//method for the particular element
	{
		return driver.findElement(Item_count);//passing that variable as argument
	}
	
	public WebElement Active_list()//method for the particular element
	{
		return driver.findElement(Active_btn);//passing that variable as argument
	}
	
	public WebElement Completed_list()//method for the particular element
	{
		return driver.findElement(Completed_btn);//passing that variable as argument
	}
	
	public WebElement All_list()//method for the particular element
	{
		return driver.findElement(All_btn);//passing that variable as argument
	}
	
	public WebElement Remove_list()//method for the particular element
	{
		return driver.findElement(Remove);//passing that variable as argument
	}
}



