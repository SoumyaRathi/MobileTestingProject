package Utility;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name="InputData")
    public Object[][] getData()
    {
  	  Object[][] obj=new Object[][] {{"Mary"},{"%fgth#$"}};
  	  
  	  return obj;
    }
}
