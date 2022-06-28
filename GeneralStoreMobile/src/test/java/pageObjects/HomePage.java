package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//all the objects from one html page will be in one class
public class HomePage {
	//to call the driver object from testcases to pageobjects
	
	//we can make webelement private and use getter and setter
	public HomePage(AppiumDriver driver)
	{
      PageFactory.initElements(new AppiumFieldDecorator(driver), this);//this method is to initialise all the elements(initElements) of this current(using this keyword, if some other page we want then give that page's name) page with driver which is passed from test cases	works same as driver.findElement	
                                                                       //AppiumFieldDecorator is compatible to work with both ios and android elements
	}
	
	@AndroidFindBy(xpath="")
	public WebElement WebElement1;
	

}
