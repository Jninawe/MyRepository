package coverFoxTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import coverFoxPOM.CoverFoxAddressDetailsPageExcel;
import coverFoxPOM.CoverFoxHealthPlanPageExcel;
import coverFoxPOM.CoverFoxHomePageExcel;
import coverFoxPOM.CoverFoxMemberDetailsPageExcel;
import coverFoxPOM.CoverFoxResultPageExcel;
import coverFoxUtility.Utility;


public class CoverFoxTC {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.coverfox.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

		String filePath = System.getProperty("user.dir")+"D:\\Jitendra.xlsx";

		String age = Utility.readDataFromExcel(filePath, "Sheet1", 1, 0);
		String pinCode = Utility.readDataFromExcel(filePath, "Sheet1", 1, 1);
		String mobileNumber = Utility.readDataFromExcel(filePath, "Sheet1", 1, 2);
		// create object of homePage
		CoverFoxHomePageExcel home = new CoverFoxHomePageExcel(driver);
		home.clickongenderbutton();
		CoverFoxHealthPlanPageExcel healthPlanPage = new CoverFoxHealthPlanPageExcel(driver);
		healthPlanPage.nextbutton();
		CoverFoxMemberDetailsPageExcel memberDetailsPage = new CoverFoxMemberDetailsPageExcel(driver);

		memberDetailsPage.handleAgeDropDown(age);
		memberDetailsPage.clickOnNextButton();
		CoverFoxAddressDetailsPageExcel addressDertailsPage = new CoverFoxAddressDetailsPageExcel(driver);
		addressDertailsPage.enterPincode(pinCode);
		addressDertailsPage.enterMobileNumber(mobileNumber);
		addressDertailsPage.clickOnContinueButton();
		Thread.sleep(4000);
		CoverFoxResultPageExcel resultPage = new CoverFoxResultPageExcel(driver);
		resultPage.validateBanners();
		Thread.sleep(4000);
		driver.close();
	}
}
