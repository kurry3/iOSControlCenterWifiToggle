package test.java.iOSWifiToggling;
//package io.appium.java_client.touch;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

//import org.testng.annotations.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.Point;
//import org.openqa.selenium.interactions.internal.TouchAction;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
//import io.appium.java_client.ios.*;
import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.ios.IOSElement;
//import io.appium.java_client.touch.ActionOptions;
import io.appium.java_client.touch.offset.*;
import io.appium.java_client.TouchAction;



public class AppiumIOSTest {
	
	
	private static AppiumDriver<MobileElement> driver;
	
	@BeforeAll
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
			e.printStackTrace();
		}
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Appium Session Started");
	}

	@Test
	public static void controlCenterSwipe() throws Exception{

		System.out.println("Test Started");
		//driver.findElement(By.name("About")).click();
		
		/*Dimension d = driver.manage().window().getSize();
		int height = d.getHeight();
		int width = d.getWidth();
		System.out.println(height);
		System.out.println(width);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Object> swipeObj = new HashMap<>();
		swipeObj.put("fromY", height);
		swipeObj.put("fromX", width/2);
		swipeObj.put("toX", width/2);
		swipeObj.put("toY", -height);
		swipeObj.put("duration", 0.5);
		js.executeScript("mobile:dragFromToForDuration", swipeObj);
		HashMap<String,Object> params = new HashMap<>();
		params.put("direction", "up");
		js.executeScript("mobile:swipe", params);
		HashMap<String,Object> scrollParams = new HashMap<>();
		scrollParams.put("direction","down");
		js.executeScript("mobile:scroll", scrollParams);
		TouchAction touchAction = new TouchAction(driver);
		touchAction.press(new PointOption().withCoordinates(width/2, height)).moveTo(new PointOption().withCoordinates(width/2, -height)).release().perform();
		//driver.getinstance().findElement(By.id("Wi-Fi"));*/
		
		
		
		/* if (driver.getInstance()findElement(By.id("WiFi")).isEnabled()){
		 * 	click("WiFi", Attribute.NAME);
		 * }
		 * else {
		 * 	click("WiFi", Attribute.NAME);
		 * }
		 * 
		 * */
		
		//driver.tap(point(341, 630)).perform();
		
	}
	

	@AfterAll
	public static void tearDown() throws Exception{
		try {
			Thread.sleep(10*1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}

	


