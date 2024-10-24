package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import com.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriver e_driver;
	public static WebDriverListener eventListener;
	
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\EclipseWorkstationForHome\\Testmev01\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\EclipseWorkstationForHome\\chromedriver-win64_130.0.6723.58\\chromedriver.exe");
			e_driver = new ChromeDriver();
		} else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "D:\\\\EclipseWorkstationForHome\\\\geckodriver-v0.30.0-win64\\\\geckodriver.exe");
			e_driver = new FirefoxDriver();
		}
		
		eventListener = new WebEventListener();
		driver = new EventFiringDecorator<WebDriver>(eventListener).decorate(e_driver);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get(prop.getProperty("url"));
		
		
	}
	
}
