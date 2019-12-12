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

import org.testng.*;
import org.testng.annotations.*;

public class AppiumTest {

    public AndroidDriver driver;
    public WebDriverWait wait;

//    @BeforeClass
//    public void setup() throws MalformedURLException {
//
//       DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("platformName", "Android");
//        desiredCapabilities.setCapability("deviceName", "SM-G935F");
//        //desiredCapabilities.setCapability("automationName", "uiautomator2");
//        desiredCapabilities.setCapability("app", "/home/javier/Escritorio/app-PF-debug.apk");
//        desiredCapabilities.setCapability("udid", "ad08160310e018e1ec");
//        //desiredCapabilities.setCapability("fullReset", true);
//        //desiredCapabilities.setCapability("avd", "Android_7.0");
//        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
//       // AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
//
//    }


    @BeforeTest
    public void setup() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");

        desiredCapabilities.setCapability("app", "/home/javier/Escritorio/app-PF-debug.apk");

        //S7 - Android 8
//        desiredCapabilities.setCapability("udid", "ad08160310e018e1ec");
//        desiredCapabilities.setCapability("deviceName", "SM-G935F");

        //GRAN PRIME - Android 5
        desiredCapabilities.setCapability("udid", "f58cce01");
        desiredCapabilities.setCapability("deviceName", "SM-G530H");

        //A20 - Android 9
//        desiredCapabilities.setCapability("udid", "R58M83DJ3ZE");
//        desiredCapabilities.setCapability("deviceName", "SM-A205G");


        desiredCapabilities.setCapability("fullReset", true);
        //desiredCapabilities.setCapability("avd", "Android_7.0");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        // AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        //driver.manage().timeouts().implicitlyWait(30, SECONDS);

    }


    @Test
    public void loginASiRecordarTest() throws InterruptedException {

        Thread.sleep(5000);
        driver.findElementById("py.com.itau.nmb.android:id/login_num_doc").sendKeys("298976");
        driver.findElementById("py.com.itau.nmb.android:id/login_num_cuenta").sendKeys("820008260");
        driver.findElementById("py.com.itau.nmb.android:id/edt_login_pass").sendKeys("15000");

        String resultadoActual = driver.findElementById("py.com.itau.nmb.android:id/login_recordar").getText();
        String resultadoEsperado = "recordar documento y cuenta";


        Assert.assertEquals(resultadoEsperado, resultadoActual);

    }


    @Test
    public void loginBConRecordarTest() throws InterruptedException {

        Thread.sleep(5000);
        driver.findElementById("py.com.itau.nmb.android:id/login_num_doc").sendKeys("3709122");
        driver.findElementById("py.com.itau.nmb.android:id/login_num_cuenta").sendKeys("702703180");
        driver.findElementById("py.com.itau.nmb.android:id/edt_login_pass").sendKeys("147258");

        driver.findElementById("py.com.itau.nmb.android:id/reminder").click();


        String resultadoActual = driver.findElementById("py.com.itau.nmb.android:id/login_recordar").getText();
        String resultadoEsperado = "recordar documento y cuenta";


        Assert.assertEquals(resultadoEsperado, resultadoActual);

    }


    @AfterClass
    public void teardown() {

        System.out.println("FIM");
        //driver.quit();
    }

}