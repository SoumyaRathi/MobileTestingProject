package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class CartPage {
	
	AndroidDriver<AndroidElement> ldriver;
	public CartPage(AndroidDriver<AndroidElement> driver)
	{
		ldriver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	public List<WebElement> products;
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement addToCart;
	
	
	@AndroidFindBy(className="android.widget.CheckBox")
	public WebElement checkbox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	public WebElement proceedtoWebsite;
	
	public void addProduct()
	{
		int count=products.size();
		for(int i=0;i<count;i++)
		{
			products.get(i).click();
		}
		addToCart.click();
	}
	
	public void selectCheckBoxAndProceedToWebsite()
	{
		TouchAction t= new TouchAction(ldriver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		proceedtoWebsite.click();
	}
	
	
	
	
}
