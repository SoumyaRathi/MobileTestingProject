package Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {

	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	//start server
	public AppiumDriverLocalService startServer()
	{
		boolean flag=checkIfServerIsRunning(4723);
		if(!flag)
		{
			service=AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}
	
	public boolean checkIfServerIsRunning(int port)
	{
		boolean isServerRunning=false;
		ServerSocket serverSocket;
		try
		{
			serverSocket=new ServerSocket(port);
			serverSocket.close();
		}
		catch(IOException e)
		{
			//if control comes here that means port is in use
			isServerRunning=true;
		}
		finally
		{
			serverSocket=null;
		}
		return isServerRunning;
		
	}
	//starting emulator
//	public static void startEmulator() throws IOException, InterruptedException
//	{
//		Runtime.getRuntime().exec("src/test/resources/startEmulator.bat");
//		Thread.sleep(5000);
//	}
	public static AndroidDriver<AndroidElement> capabilities() throws IOException, InterruptedException {
	
		
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("globalConfig.properties");
		prop.load(fis);
		
		File appDir=new File("src/test/resources");
		File app=new File(appDir,prop.getProperty("AppName"));
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("Device"));
		String device=prop.getProperty("Device");
//		if(device.contains("emulator"))
//		{
//			startEmulator();
//		}
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,  prop.getProperty("AutomationName"));
		
	    driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
	}
	
	public static  void getScreenShot(String TestName) throws IOException
	{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\Screenshots\\"+TestName+".png"));
	}

}
