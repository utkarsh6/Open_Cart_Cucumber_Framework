package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[@id=\"content\"]/h2[1]")
	WebElement SuccessMsg;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")
	WebElement logoutBtn;
	
	public boolean isLoginSucces() {
		try {
			return(SuccessMsg.isDisplayed());
		}
		catch (Exception e) {
			
			// TODO: handle exception
			return false;
			
		}
		
	}
	
	public void clickLogout() {
		logoutBtn.click();
	}

}
