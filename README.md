# iPhoneToggle

About: 
  - TestNG test that uses Appium to interact with the GUI of a real iPhone and display the control center to toggle the wifi for testing purposes
  
Environment: 
- Appium: 5.0.4 , Appium Desktop: 1.8
- Selenium: 3.12
- Maven:4.0, TestNG: 6.14.3
- Eclipse: 4.0, Java: 6.0.0
- XCode: 9.4


## **Installing Appium + WebDriverAgent for real iOS device testing**
### **XCode WebDriverAgent**
  - Set Up: https://www.linkedin.com/pulse/appium-ver-171-setup-mac-os-sierra-ios-real-device-suraj-salunkhe
  - Signing - https://github.com/appium/appium-xcuitest-driver/blob/master/docs/real-device-config.md
  
  **When Signing Profile Expires**
  - Open WebDriverAgent.xcode from directory:
     - /Applications/Appium.app/Contents/Resources/app/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent
  - Change the **Bundle Identifier** for all targets found in **General** and **Build Settings**.
  - Select your account for signing found in **General**
    -  **Each Apple Developers Profile (free) can only accommodate 3 devices. These clients cannot be changed until the profile is renewed annually.**
  - Signing certificate expires in 7 days. So in 7 days, you will have to repeat the steps above and reinstall WebDriverAgent onto your device.
   - Terminal:
      - cd /Applications/Appium.app/Contents/Resources/app/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent    
      - xcodebuild -project WebDriverAgent.xcodeproj -scheme WebDriverAgentRunner -destination 'id=<udid>' test
        - How to retrieve UDID of iPhone
          1. Connect phone and launch iTunes
          2. Phone > Summary > click information below Phone Number until the UDID is displayed
          OR
          1. Connect phone and run "instruments -s devices"
      -if codesign wants to access key access in your keychain
        -input user password and select Always Allow
  
### **Appium**
  - Set Up 1: https://medium.com/@abrisad_it/setting-up-appium-with-java-on-os-x-83b4b59f1cfc
  - Set Up 2: http://www.automationtestinghub.com/appium-project-in-eclipse/
  - Import necessary libraries and external .jar files
  - Import pom.xml file 
      - will import Maven Dependencies necessary
  - Appium Server: http://www.automationtestinghub.com/appium-desktop/
  - **How to Launch Appium Desktop Inspector**
    1. Click the magnifying glass in the top right of Appium desktop
    2. Create a Custom Server
    3. Edit Desired Capabilities: 
      ```
      { 
          "platformName": "iOS",
          "platformVersion": "11.4",
          "deviceName" : " ",
          "automationName": " ",
          "udid": " ",
          "bundleId": " "
         }
      ```
    4. Start Session
    
  - **How to Retrieve bundleId for iOS**
     - Self-Made Application: https://pspdfkit.com/guides/ios/current/faq/finding-the-app-bundle-id/
     - App Store Application: https://offcornerdev.com/bundleid.html
  - **How to Retrieve capabilities information for Android**
     -udid:
      - run command: **adb devices**
     -appPackage & appActivity
      - run command: **adb shell**
      - open application on phone
      - run command: **dumpsys window windows | grep -E 'mCurrentFocus'**
        - ex: appPackage/appActivity
  - **Create and Run Appium Test with Maven**
      - https://stackoverflow.com/questions/24919159/how-to-create-in-eclipse-and-run-your-appium-test-on-the-ios-device-not-emulato


  
