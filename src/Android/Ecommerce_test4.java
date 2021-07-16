package Android;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_test4 extends Base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Aravind");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElementById("android:id/text1").click();
		// driver.findElementByAndroidUIAutomator("new UiScrollable(new
		// UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Argentina\").instance(0));"));
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		Thread.sleep(4000);
		int count = driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
		
		double sum=0;
		for(int i=0;i<count;i++) {
			String amount1=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
			double amount=getAmount(amount1);
			sum=sum+amount;
		}
		/*
		 * String amount1=driver.findElements(By.id(
		 * "com.androidsample.generalstore:id/productPrice")).get(0).getText(); double
		 * amount1value=getAmount(amount1); System.out.println(amount1value); String
		 * amount2=driver.findElements(By.id(
		 * "com.androidsample.generalstore:id/productPrice")).get(1).getText(); double
		 * amount2value=getAmount(amount2); System.out.println(amount2value);
		 * 
		 * amount1=amount1.substring(1); double
		 * amount1value=Double.parseDouble(amount1); System.out.println(amount1value);
		 * String amount2=driver.findElements(By.id(
		 * "com.androidsample.generalstore:id/productPrice")).get(1).getText();
		 * amount2=amount2.substring(1); double
		 * amount2value=Double.parseDouble(amount2); System.out.println(amount2value);
		 * double sumofProducts=amount1value+amount2value;
		 * 
		 */
		System.out.println("Sum of the products is:  " +sum);
		String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		total = total.substring(1);
		double totalvalue = Double.parseDouble(total);
		System.out.println(totalvalue);
		
		Assert.assertEquals(sum, totalvalue);
	}

	public static double getAmount(String value) {
		value = value.substring(1);
		double amount2value = Double.parseDouble(value);
		return amount2value;
	}

}
