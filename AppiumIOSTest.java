package test.java.iOSWifiToggling;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


public class AppiumIOSTest {
	
	
	@SuppressWarnings("rawtypes")
	private static AppiumDriver<MobileElement> driver;
	
	@SuppressWarnings("rawtypes")
	@BeforeClass
	public static void ixchariotLaunch() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "iOS");
		cap.setCapability("platformVersion", "11.3");
		cap.setCapability("deviceName", "RF's iPhone");
		cap.setCapability("automationName", "XCUITest");
		cap.setCapability("udid", "0a1364a47e9b044d605558130817ad53a9b5208c");
		cap.setCapability("bundleId", "com.yourcompany.Endpoint");
		
		try {
			driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4725/wd/hub"),cap);
		}catch (MalformedURLException e) {
			e.printStackaTrace();
		}
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Appium Session Started");
	}

	//@Test
	/*public void testScript() throws Exception{
		System.out.println("something happened");
		driver.findElement(By.name("About")).click();
		try {
			Thread.sleep(100*1000);
		}catch(InterruptedException e) {
			System.out.println("oops");
		}
	}*/
	
	
	int height = driver.findElementById("UIAWindow").getSize().getHeight();
	int width = driver.findElementById("UIAWindow").getSize().getWidth();
	@SuppressWarnings("rawtypes")
	@Test
	public void controlCenterSwipe() throws Exception{
		//@SuppressWarnings("rawtypes")
		/*int height = driver.findElementById("UIAWindow").getSize().getHeight();
		int width = driver.findElementById("UIAWindow").getSize().getWidth();
		int starty = (int) (height * 0.70);
		int endy = (int) (height * 0.20);
		int x = width / 2;
		(new TouchAction(driver)).press(PointOption.point(x, starty)).moveTo(PointOption.point(x, endy)).release().perform();*/

		//driver.findElement(By.name("About")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Object> swipeObj = new HashMap<>();

		swipeObj.put("fromY", 0);
		swipeObj.put("fromX", 200);
		swipeObj.put("toX", 200);
		swipeObj.put("toY", 500);
		swipeObj.put("duration", 1);
		js.executeScript("mobile:dragFromToForDuration", swipeObj);

		
	}
	

	@AfterClass
	public static void tearDown() throws Exception{
		try {
			Thread.sleep(10*1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}

	


