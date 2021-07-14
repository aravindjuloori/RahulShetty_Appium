package Android;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class First extends Base1 {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver=Capabilities("emulator");
		
		//xpath,id,classname and AndroidUIAutomater
		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click(); 
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("Hello world");
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		
			 
		 
	}

}
