package Android;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_test3 extends Base {

	public static void main(String[] args) throws MalformedURLException  {
		
		
		
		AndroidDriver<AndroidElement> driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Aravind");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElementById("android:id/text1").click();
	//	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Argentina\").instance(0));"));
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//System.out.println(driver.findElementsById("com.androidsample.generalstore:id/productName").size());
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0));"));
		int count=driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		for(int i=0;i<count;i++) {
			String textname=driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			if(textname.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
				break;
			}
			
			
		}
		
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		String pageText=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals("Jordan 6 Rings", pageText);
}
}
