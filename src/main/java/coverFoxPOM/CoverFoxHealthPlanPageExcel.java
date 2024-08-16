package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlanPageExcel {
	// data members
	@FindBy(className = "next-btn")
	private WebElement next_btn;

	// constrcutor
	public CoverFoxHealthPlanPageExcel(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}


	public void nextbutton() {
		// TODO Auto-generated method stub
		Reporter.log("Clicking on Next Button", true);
		next_btn.click();
		
	}

}
