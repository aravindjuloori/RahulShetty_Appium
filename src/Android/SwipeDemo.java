package Android;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class SwipeDemo extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		
		
	driver.findElement(By.xpath("//*[@content-desc='9']")).click();
	//driver.findElementByAndroidUIAutomator("content-desc(\"9\")").click();
		
		TouchAction t=new TouchAction(driver);
		
		WebElement source=driver.findElementByXPath("//*[@content-desc='15']");
		WebElement destination=driver.findElementByXPath("//*[@content-desc='45']");
		
		
		t.longPress(longPressOptions().withElement(element(source)).withDuration(ofSeconds(2))).moveTo(element(destination)).release().perform();
		
		
		
	}

}
