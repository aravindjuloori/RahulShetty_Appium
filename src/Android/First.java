package Android;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class First extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver=Capabilities();
		
		
		
		//xpath,id,classname and AndroidUIAutomater
		
		  driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click(); 
		  driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click(); 
		  driver.findElementById("android:id/checkbox").click();
		  driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		  driver.findElementByClassName("android.widget.EditText").sendKeys("Hello world");
		  driver.findElementsByClassName("android.widget.Button").get(1).click();
		 
		 
	}

}
