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

import org.junit.*;

import org.junit.rules.TestWatcher;

import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;


public class AppiumTest {

//    public AndroidDriver driver;
  //  public WebDriverWait wait;
  //

   @Rule
    public TestWatcher watcher = Factory.createWatcher();

    private static EnhancedAndroidDriver<MobileElement> driver;


    @Before
    public void setup() throws MalformedURLException {
        
     DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    /*    desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Android_7.0");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("app", "src/test/resources/uy.com.oca.ocatarjetas_25_apps.evozi.com.apk");
        desiredCapabilities.setCapability("udid", "emulator-5554");
        desiredCapabilities.setCapability("fullReset", true);
        desiredCapabilities.setCapability("avd", "Android_7.0"); */

	
     	driver = Factory.createAndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

//        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
  //      AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);


        
    }

    @Test
    public void calculo_bitcoin_dolarTest() throws MalformedURLException, InterruptedException {

        driver.findElementById("com.livrokotlin.bitcoincalculator:id/txt_amount").sendKeys("15000");
        driver.findElementById("com.livrokotlin.bitcoincalculator:id/btn_calculate").click();

        String resultado = driver.findElementById("com.livrokotlin.bitcoincalculator:id/txt_qtd_bitcoins").getText();

        Assert.assertEquals("test", "test");

    }

   @Test
    public void calculo_bitcoin_pesoTest() throws MalformedURLException, InterruptedException {

        driver.findElementById("com.livrokotlin.bitcoincalculator:id/txt_amount").sendKeys("7000");
        driver.findElementById("com.livrokotlin.bitcoincalculator:id/btn_calculate").click();

        String resultado = driver.findElementById("com.livrokotlin.bitcoincalculator:id/txt_qtd_bitcoins").getText();

        Assert.assertEquals("test", "test");

    }

    @After
    public void teardown(){
    	
    	System.out.println("FIM");
        //driver.quit();
    }
}
