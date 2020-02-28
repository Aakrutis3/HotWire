package com.hotwire.base;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	
	public void launchBrowserMethod() throws IOException, InterruptedException{
		//Load properties file keys and values 
		FileReader fr = new FileReader("./src/main/resources/config.properties");
		Properties p = new Properties();
		p.load(fr);		
				
		
		//Register browser
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe"); 
		
		//Initialising chrome browser
		driver = new ChromeDriver();	
		
		//driver.get("https://www.hotwire.com/");
		driver.get(p.getProperty("url")); 
		
		driver.manage().window().maximize();		
		driver.manage().deleteAllCookies();
		
	}
}
