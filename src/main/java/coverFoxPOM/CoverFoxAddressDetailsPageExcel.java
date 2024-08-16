package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPageExcel {

	@FindBy(className = "mp-input-text")
	private WebElement pinCodeField;
	@FindBy(id = "want-expert")
	private WebElement mobileNumberField;
	@FindBy(className = "next-btn")
	private WebElement continueButton;

	public CoverFoxAddressDetailsPageExcel(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterPincode(String pincodeValue) {
		Reporter.log("Entering the pincode", true);
		pinCodeField.sendKeys(pincodeValue);
	}

	public void enterMobileNumber(String mobileNumber) {
		Reporter.log("Entering the mobile number", true);
		mobileNumberField.sendKeys(mobileNumber);
	}

	public void clickOnContinueButton() {
		Reporter.log("Click on next button", true);
		continueButton.click();
	}

}
