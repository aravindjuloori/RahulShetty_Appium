package Android;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_test2 extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		
		AndroidDriver<AndroidElement> driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		/*
		 * driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).
		 * sendKeys("hello"); driver.hideKeyboard();
		 */
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
	}

}
