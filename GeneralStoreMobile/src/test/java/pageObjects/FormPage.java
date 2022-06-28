package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

	AndroidDriver<AndroidElement> ldriver;
	public FormPage(AndroidDriver<AndroidElement> driver)
	{
		ldriver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement name;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement femaleRadio;
	
	@AndroidFindBy(id="android:id/text1")
	public WebElement dropdownCountry;
	
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	public WebElement argentina;
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement letsShopButton;
	

	public void enterName(String Name)
	{
		name.sendKeys(Name);
	}
	
	public void form()
	{
		
		dropdownCountry.click();
		ldriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		argentina.click();
		femaleRadio.click();
		letsShopButton.click();
		
		
	}
	
	
}
