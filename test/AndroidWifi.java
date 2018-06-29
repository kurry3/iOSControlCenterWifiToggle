package iOSWifi3;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.mobile.NetworkConnection.ConnectionType;

//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.*;

public class AndroidWifi{
	
	protected static AndroidDriver<MobileElement> driver;
	private static final ThreadLocal<AndroidDriver<MobileElement>> tldriver =new ThreadLocal<>();
	
	@Parameters({"deviceName", "platformName", "udid", "platformVersion", "url", "bootstrapPort"})
	@BeforeClass(alwaysRun = true)
	public void ixchariotLaunch(String deviceName, String platformName, String udid, String platformVersion, String url, int bootstrapPort) throws Exception {
		System.out.println("udid: "+ udid);
		System.out.println("ThreadID:"+ Thread.currentThread().getId());
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", platformName);
		cap.setCapability("platformVersion", platformVersion);
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("udid", udid);
		cap.setCapability("appPackage", "com.ixia.ixchariot");
		cap.setCapability("appActivity", "com.ixia.ixchariot.EndpointActivity");
		cap.setCapability("automationName", "uiautomator2");
		cap.setCapability("bootstrapPort", bootstrapPort);
		cap.setCapability("newCommandTimeout", "120");
		
		try {
			driver = (new AndroidDriver<MobileElement>(new URL(url),cap));
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

	@Parameters({"url", "deviceName"})
	@Test
    public void myFirstTest(String url, String deviceName) {
		ConnectionState state = (tldriver.get()).setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
		System.out.println(url + " " + deviceName);
		System.out.println(state.isWiFiEnabled());
		int count = 0;
		
		try {
			Thread.sleep(15*1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		do {
			if (state.isWiFiEnabled()==true) {
				try {
					Thread.sleep(15*1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				state = (tldriver.get()).setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
				System.out.println(url + " " + deviceName);
				//System.out.println("Wifi was on");
				try {
					Thread.sleep(15*1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}else if (state.isWiFiEnabled()==false) {
				state = (tldriver.get()).setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
				System.out.println(url + " " + deviceName);
				//System.out.println("Wifi was off");
				try {
					Thread.sleep(15*1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			count = count + 1;
			
			System.out.println(deviceName + " " + count + ": " + state.isWiFiEnabled());
		}while(count <=5);
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
