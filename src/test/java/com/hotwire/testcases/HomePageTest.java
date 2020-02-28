package com.hotwire.testcases;
import java.io.IOException;
import com.hotwire.base.TestBase;
import com.hotwire.pages.HomePage;

public class HomePageTest extends TestBase{
	
	HomePage homepageObj;

	public void SetUp() throws IOException, InterruptedException {
		launchBrowserMethod();
		homepageObj = new HomePage();		
	}
	

	public void openVacationTab() {
		homepageObj.btnFindADeal().click();
	}

}
