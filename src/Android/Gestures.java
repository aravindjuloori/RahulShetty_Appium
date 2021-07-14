package Android;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
public class Gestures extends Base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		AndroidDriver<AndroidElement> driver=Capabilities();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		//Gestures
		TouchAction t=new TouchAction(driver);
		WebElement expandlist=driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']"));
		t.tap(tapOptions().withElement(element(expandlist))).perform();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();
		WebElement  peoplename=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		t.longPress(longPressOptions().withElement(element(peoplename)).withDuration(ofSeconds(2))).release().perform();
		System.out.println(driver.findElementById("android:id/title").isDisplayed());
		
		
		
	
		
	}

}
