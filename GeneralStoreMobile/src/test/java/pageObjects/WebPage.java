package pageObjects;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WebPage {
	
	AndroidDriver<AndroidElement> ldriver;
	public WebPage(AndroidDriver<AndroidElement> driver)
	{
		ldriver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@FindBy(xpath="//input[@name='q']")
	public WebElement searchBox;
	
	public void switchToWeb()
	{
		Set<String> contexts=ldriver.getContextHandles();
		for(String context:contexts)
		{
			System.out.println(context);
		}
		ldriver.context("WEBVIEW_com.androidsample.generalstore");
		
		if(ldriver.getPageSource().contains("Google"))
		{
			Assert.assertTrue(true);
			System.out.println("web is launched");
		}
			
		
		searchBox.sendKeys("hello");
		searchBox.sendKeys(Keys.ENTER);
		ldriver.pressKey(new KeyEvent(AndroidKey.BACK));
		ldriver.context("NATIVE_APP");
		System.out.println("back to android");
	}

}
