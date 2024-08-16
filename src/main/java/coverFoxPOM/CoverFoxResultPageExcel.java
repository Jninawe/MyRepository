package coverFoxPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxResultPageExcel {
	@FindBy(xpath = "//div[contains(text(),'Insurance Plans')]")
	private WebElement resultText;
	@FindBy(className = "plan-card-container")
	private List<WebElement> banners;
	
	@FindBy(xpath="//div[text()='Sort Plans']")
	private WebElement sortPlanFilter;
	

	public CoverFoxResultPageExcel(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void validateBanners() {
		Reporter.log("Getting String Result",false);
		String[] ar = resultText.getText().split(" ");
		int result = Integer.parseInt(ar[0]);
		Reporter.log("Getting total banner",false);
		if (result == banners.size()) {
			System.out.println("Result is matching with banners, TC passed");
		} else {
			System.out.println("Result is not matching with banners, TC failed");
		}
	}

	public int getplannumberfromString() {
		String ar[] = resultText.getText().split(" ");
		Reporter.log("Getting plan number from string",true);
		int result = Integer.parseInt(ar[0]);
		return result;

	}

	public int getplannumberfromBanner() {
		
		int bannersize = banners.size();
		Reporter.log("Getting plan number from banner",true);
		return bannersize;

	}
	public boolean sortPlanFilterIsDisplayed()
	{
		Reporter.log("Checking if sortPlanFilterIsDisplayed",true);
		boolean result = sortPlanFilter.isDisplayed();
		return result;
	}
}
