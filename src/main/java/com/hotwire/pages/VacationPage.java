package com.hotwire.pages;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.hotwire.base.TestBase;

public class VacationPage extends TestBase{
  
	public void testCase1() throws InterruptedException, IOException {
		//launchBrowserMethod();
		
		//-------------------------------SELECTING CAR, AS FLIGHT AND HOTEL ALREADY SELECTED------------------------------------//
		 //Click on car button option
		btnCar().click();
		
		
		//-------------------------------FLY FROM SFO SELECTION----------------------------------------------------------------//
		 
		//Enter sfo  and select same option search box of fly from 
		getFlyFrom().sendKeys("SFO");		
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		getFlyFrom().sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		
		//-------------------------------FLY TO LAX SELECTION----------------------------------------------------------------//
		
		//Enter sfo  and select same option search box of fly from 
		getFlyTo().sendKeys("LAX");		
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		getFlyTo().sendKeys(Keys.ENTER);		
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;

		//-------------------------------DEPARTING NEXT DAY SELECTION----------------------------------------------------------------//
	
		Date dt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dt);         
        
    	//Departure next date as departure date
        c.add(Calendar.DATE, 1);
        dt = c.getTime();
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");        
        //formatting the date 
	    String strDate= formatter.format(dt); 	    
	   
		getDepartureDate().clear();
		getDepartureDate().sendKeys(strDate);		
		 
		//-------------------------------RETURNING 1 WEEK AFTER ---------------------------------------------//		
		
		//adding 7 days in the current date
		 c.add(Calendar.DATE, 2);	      
		 //formatting the date 
		 String returnDate= formatter.format(dt);     		 
		
		 getReturningDate().clear();
		 getReturningDate().sendKeys(returnDate);			 
		 
		//-------------------------------SELECTING EVENING DROPDOWN VALUE FOR DEPARTURE-------------------------------------//
		getDropdownEve();
		 
		//-------------------------------SELECTING MORNING DROPDOWN VALUE FOR RETURNING-------------------------------------//
		 getDropdownMorn();
		 
		//-------------------------------FINDING VACATION------------------------------------------------------------------//
		 btnFindADeal().click();
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
		 
		//-------------------------------ASSERTION------------------------------------------------------------------//
		 //verifying if Featured button is display which only displays when atleast 1 result is available of a deal		
		 
			String expectedText = "Featured";
			String actualText = assertFeatureTab().getText().trim();
			try {
				assertEquals(expectedText, actualText);
				System.out.println("Pass");
			} catch (AssertionError obj) {
				obj.printStackTrace();
				System.out.println("FAILED :::::::::::::: ");
			}
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			
			driver.quit();
	}
	
	//-------------------------------WEBELEMENTS FINDING METHODS------------------------------------------------------------------//
	public WebElement btnCar() {
		//have to add condition here to check if flight hotel and car buttons are enable, if all are enable then no to click on it otherwise
		return driver.findElement(By.xpath("//button[@data-bdd='farefinder-package-bundleoption-car']"));		
	}
	
	public WebElement getFlyFrom() {
		return driver.findElement(By.xpath("//input[@id='farefinder-package-origin-location-input']"));
	}
	
	public WebElement getFlyTo() {
		return driver.findElement(By.xpath("//input[@id='farefinder-package-destination-location-input']"));
	}
	
	public WebElement getDepartureDate() {
		return driver.findElement(By.xpath("//input[@data-bdd='farefinder-package-startdate-input']"));
	}
	
	public void getDropdownEve() {
		Select s = new Select(driver.findElement(By.xpath("//select[@id='farefinder-package-pickuptime-input']")));
		s.selectByVisibleText("Evening");
	}
	
	public WebElement getReturningDate() {
		return driver.findElement(By.xpath("//input[@id='farefinder-package-enddate-input']"));
	}
	
	public void getDropdownMorn() {
		Select s = new Select(driver.findElement(By.xpath("//select[@id='farefinder-package-dropofftime-input']")));
		s.selectByVisibleText("Morning");
	}	
	
	public WebElement btnFindADeal() {
		return driver.findElement(By.id("farefinder-package-search-button"));
	}
	
	public WebElement assertFeatureTab() {
		return driver.findElement(By.xpath("//button[@data-opt-group='Featured']"));		
	}
}
