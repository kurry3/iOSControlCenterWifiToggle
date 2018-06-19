# iPhoneToggle
Environment: 
- Appium: 6.0+
- Selenium: 3.12+
- JUnit: 5.2+, Maven:4.0+
- Eclipse: latest , Java: 6.0+
- XCode: latest


## **Installing Appium + WebDriverAgent for real device testing**
### **XCode WebDriverAgent**
  - Set Up: https://www.linkedin.com/pulse/appium-ver-171-setup-mac-os-sierra-ios-real-device-suraj-salunkhe
  - Signing - https://github.com/appium/appium-xcuitest-driver/blob/master/docs/real-device-config.md
  
  **When signing profile expires**
  - Open WebDriverAgent.xcode from directory:
     - /Applications/Appium.app/Contents/Resources/app/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent
  - Change the **Bundle Identifier** for all targets found in **General** and **Build Settings**. Personally, I used:
    - com.iPhone.TestAutomation for WebDriverAgentLib and WebDriverAgentRunner
    - com.iPhone.TestAutomation.IntegrationTests for the IntegrationTests
    - com.iPhone.TestAutomation.IntegrationApp for the IntegrationApp
   - Select your account for signing found in **General**
    - Signing certificate expires in 7 days. So in 7 days, you will have to repeat the steps above and reinstall WebDriverAgent onto your device.
   - Terminal:
      - cd /Applications/Appium.app/Contents/Resources/app/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent    
      - xcodebuild -project WebDriverAgent.xcodeproj -scheme WebDriverAgentRunner -destination 'id=<udid>' test
  
### **Appium**
- Set Up: https://medium.com/@abrisad_it/setting-up-appium-with-java-on-os-x-83b4b59f1cfc
- Import pom.xml file 
   - will import Maven Dependencies necessary
- Right click project > Build Path > Configure Build Path ...
    - > Import JUnit5 or the required JUnit library
    - > Referenced Libraries
      - hi


  
  
  





  
