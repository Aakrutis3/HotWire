package com.hotwire.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.hotwire.base.TestBase;

public class HomePage extends TestBase{
  //find all webelements of home page
	
	public WebElement btnFindADeal() {
		return driver.findElement(By.xpath("//a[contains(text(),'Vacations')][@data-bdd='packages']"));
	}
	
	
}
