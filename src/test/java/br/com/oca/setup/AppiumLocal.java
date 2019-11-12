package br.com.oca.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.*;

public class AppiumLocal {

    public AndroidDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Android_7.0");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("app", "src/test/resources/uy.com.oca.ocatarjetas_25_apps.evozi.com.apk");
        desiredCapabilities.setCapability("udid", "emulator-5554");
        desiredCapabilities.setCapability("fullReset", true);
        desiredCapabilities.setCapability("avd", "Android_7.0");
        //driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        
    }
    
 
  
      @Test (enabled=true) public void myFirstTest() throws InterruptedException {
        
        assert "Cedric".equals("Cedric");

        
        //Assert.assertEquals("test","test");
        
      }
    
    @AfterMethod
    public void teardown(){
        //driver.quit();
    }
}
