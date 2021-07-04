package Android;

import java.net.MalformedURLException;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UiAutomatertest extends Base{

	public static void main(String[] args) throws MalformedURLException {
		
		
		AndroidDriver<AndroidElement> driver=Capabilities();
		
		//driver.findElementByAndroidUIAutomator("attribute("value")"); -- attribute
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		//validate clickable feature for all the options in views
		//driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)");--property
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
	}

}
