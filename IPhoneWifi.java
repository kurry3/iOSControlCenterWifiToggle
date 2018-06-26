package iOSWifi3;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.TouchAction;

public class IPhoneWifi2{
	
	protected static IOSDriver<MobileElement> driver;
	private static final ThreadLocal<IOSDriver<MobileElement>> tldriver =new ThreadLocal<>();
	
	@Parameters({"deviceName", "platform", "udid", "platformVersion", "url", "wdaLocalPort"})
	@BeforeClass(alwaysRun = true)
	public void ixchariotLaunch(String deviceName, String platform, String udid, String platformVersion, String url, String wdaLocalPort) throws Exception {
		System.out.println("udid: "+ udid);
		System.out.println("ThreadID:"+ Thread.currentThread().getId());
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", platform);
		cap.setCapability("platformVersion", platformVersion);
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("automationName", "XCUITest");
		cap.setCapability("udid", udid);
		cap.setCapability("wdaLocalPort", wdaLocalPort);
		cap.setCapability("bundleId", "com.yourcompany.Endpoint");
		
		try {
			driver = (new IOSDriver<MobileElement>(new URL(url),cap));
			tldriver.set(driver);
		}catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println("Appium Session Started");
		System.out.println(udid);
		System.out.println(url+"\n");
	
		try {
			Thread.sleep(2*1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Parameters({"url"})
	@Test
    public void myFirstTest(String url) {
		System.out.println(url + " Test Started");
		//System.out.println(tldriver.get().manage());
		Dimension d = driver.manage().window().getSize();
		int height = d.getHeight();
		int width = d.getWidth();
		System.out.println(height);
		System.out.println(width);

		TouchAction touchAction = new TouchAction(tldriver.get());
		touchAction.press(PointOption.point(width/2, height)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(width/2, -height)).release().perform();

		try {
			Thread.sleep(2*1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}

		int count = 0;

		do {
			(tldriver.get()).findElementByAccessibilityId("wifi-button").click();
			count = count + 1;
			try {
				Thread.sleep(4900);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(count);
		}while (count <= 5);
		
		
    }
   @Parameters({"url"})
	@AfterClass
	public void tearDown(String url) throws Exception{
		/*try {
			Thread.sleep(10*1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}*/
	   System.out.println(url + "Test Fin\n");
		(tldriver.get()).quit();
		
	}

}
