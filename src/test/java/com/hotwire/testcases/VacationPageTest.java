package com.hotwire.testcases;
import java.io.IOException;
import org.testng.annotations.Test;
import com.hotwire.pages.VacationPage;


public class VacationPageTest {
	HomePageTest HomePageTestObj;
	VacationPage VacPageObj;
	
	@Test
	public void findADeal() throws InterruptedException, IOException {
		
		HomePageTestObj = new HomePageTest();
		HomePageTestObj.SetUp();
		HomePageTestObj.openVacationTab();
		
		
		VacPageObj = new VacationPage();
		VacPageObj.testCase1();		
		
	}
		
}