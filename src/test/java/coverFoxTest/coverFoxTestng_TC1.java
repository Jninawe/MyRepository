package coverFoxTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxPOM.CoverFoxAddressDetailsPageExcel;
import coverFoxPOM.CoverFoxHealthPlanPageExcel;
import coverFoxPOM.CoverFoxHomePageExcel;
import coverFoxPOM.CoverFoxMemberDetailsPageExcel;
import coverFoxPOM.CoverFoxResultPageExcel;
import coverFoxUtility.Utility;


public class coverFoxTestng_TC1 extends Base {

	CoverFoxHomePageExcel homepage;
	CoverFoxHealthPlanPageExcel healthpalnpage;
	CoverFoxAddressDetailsPageExcel addresspage;
	CoverFoxMemberDetailsPageExcel memberpage;
	CoverFoxResultPageExcel resultpage;
	String filepath;
	public static Logger logger;
	@BeforeTest

	public void launchBrowser(){
		logger=Logger.getLogger("Cover Fox");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Opening Browser");
		openBrowser();
		homepage= new CoverFoxHomePageExcel(driver);
		healthpalnpage = new CoverFoxHealthPlanPageExcel(driver);
		addresspage = new CoverFoxAddressDetailsPageExcel(driver);
		memberpage = new CoverFoxMemberDetailsPageExcel(driver);
		resultpage = new CoverFoxResultPageExcel(driver);
		//filepath = System.getProperty("user.dir")+"\\Jitendra.xlsx";
		filepath = "C:\\Users\\Serosoft Solutions\\eclipse-workspace\\CoverFoxTest\\FBTest.properties";
		
	}
	
	@BeforeClass
	
	public void precondition() throws InterruptedException, EncryptedDocumentException, IOException
	{
		homepage.clickongenderbutton();
		logger.info("Clicking on gender button");
		Thread.sleep(1000);
		healthpalnpage.nextbutton();
		logger.info("Clicking on next button");
		Thread.sleep(1000);
		//memberpage.handleAgeDropDown(Utility.readDataFromExcel(filepath, "Sheet1", 1, 0));
		memberpage.handleAgeDropDown(Utility.readDataFromPropertiesFile("age"));
		logger.warn("Enter age between 18 to 50 years");
		logger.info("Handeling the age drop down");
		memberpage.clickOnNextButton();
		logger.info("Clicking on next button");
		Thread.sleep(1000);
		//addresspage.enterPincode(Utility.readDataFromExcel(filepath,"Sheet1", 1, 1));
		addresspage.enterPincode(Utility.readDataFromPropertiesFile("pinCode"));
		logger.warn("Enter the valid pin code");
		logger.info("Enter the pin code");
		//addresspage.enterMobileNumber(Utility.readDataFromExcel(filepath, "Sheet1", 1, 2));
		addresspage.enterMobileNumber(Utility.readDataFromPropertiesFile("mobileNum"));
		logger.warn("Enter the valid mobile no.");
		logger.info("Enter the mobile number");
		addresspage.clickOnContinueButton();
		logger.info("Clicking on next button");
		Thread.sleep(1000);
				
	}

	@Test
	public void validateBanner() throws InterruptedException {
		Thread.sleep(1000);
		int bannerplannumber = resultpage.getplannumberfromBanner();
		int stringplannumber = resultpage.getplannumberfromString();
		logger.info("Validating the banners");
		Assert.assertEquals(stringplannumber, bannerplannumber,"plan on banner are not matching with result, TC failed");
	}
	
	@Test
	public void vaildatePresenceofsortbutton() throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		boolean sortPlanFilter = resultpage.sortPlanFilterIsDisplayed();
		logger.info("Validating the presence of sort button");
		Assert.assertTrue(sortPlanFilter, "Sort plan filter is not displayed, TC is failed");
		// Utility.takeScreenShot(driver, "vaildatePresenceofsortbutton");
	}
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		logger.info("Closing the browser");
		browserClose();
	}
}
