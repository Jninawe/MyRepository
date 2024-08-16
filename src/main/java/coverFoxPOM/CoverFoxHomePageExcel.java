package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePageExcel {
	
	// WebElements--> data members
	@FindBy(xpath = "//div[text()='Male']")
	private WebElement maleButton;
	// constructor
	public CoverFoxHomePageExcel(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	public void clickongenderbutton() {
		// TODO Auto-generated method stub
		Reporter.log("Clicking on Gender Button", true);
		maleButton.click();
		
	}

}
