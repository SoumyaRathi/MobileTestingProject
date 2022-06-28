package Utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	
	 public void onTestFailure(ITestResult result) 
	      {
		 String s= result.getName();
		 try {
			Base.getScreenShot(s);
		} catch (IOException e)
		 {
			e.printStackTrace();
		}
		  }

}
