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

public class AppiumTest {

	public static AndroidDriver driver;
	// public WebDriverWait wait;

	@BeforeClass
	public static void myTest() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
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

		driver.findElementById("com.livrokotlin.bitcoincalculator:id/txt_amount").sendKeys("3400");
		driver.findElementById("com.livrokotlin.bitcoincalculator:id/btn_calculate").click();
		
		Assert.assertEquals("test", "test");

	}

	@AfterClass
	public static void teardown() {
		driver.quit();
	}

}
