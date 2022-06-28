package Utility;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.FormPage;
import pageObjects.HomePage;
import pageObjects.WebPage;
import pageObjects.CartPage;

public class HybridApp extends Base{

	
    //to terminate appium server if already started so that it can be started by code here
	@BeforeTest
	public void KillAllPorts() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskKill /F /IM node.exe");
		Thread.sleep(3000);
	}

	@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	public void HybridCase(String s) throws IOException, InterruptedException
	{
		service=startServer();
		driver=capabilities();
		FormPage hp=new FormPage(driver);
		CartPage cp=new CartPage(driver);
		WebPage wp=new WebPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hp.enterName(s);
		driver.hideKeyboard();
		hp.form();
		cp.addProduct();
		cp.selectCheckBoxAndProceedToWebsite();
		Thread.sleep(5000);
		wp.switchToWeb();
		service.stop();
    }
	
	
	
	
}
