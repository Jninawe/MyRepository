package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetailsPageExcel {
	@FindBy(name = "You")
	private WebElement ageDropDown;
	@FindBy(className = "next-btn")
	private WebElement next_btn;

	public CoverFoxMemberDetailsPageExcel(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public void handleAgeDropDown(String age) {
		Reporter.log("Handeling the drop down",true);
		Select s = new Select(ageDropDown);
		s.selectByValue(age + "y");
	}

	public void clickOnNextButton() {
		Reporter.log("Clicking on Next Button", true);
		next_btn.click();
	}
}
