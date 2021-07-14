package Android;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base1 {

	public static AndroidDriver<AndroidElement> Capabilities(String device) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver;
		File f=new File("src");
		File fs=new File(f,"ApiDemos-debug.apk");
		//File fs=new File(f,"General-Store.apk");
		DesiredCapabilities cap=new DesiredCapabilities();
		
		if(device.equals("emulator")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME,"AndroidEmulator");
			cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		}
		else if(device.equals("real")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
		}
		
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15);
		 driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		return driver;

	}

}
