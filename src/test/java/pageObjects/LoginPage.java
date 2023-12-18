package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="input-email")
	WebElement txtEmail;
	
	@FindBy(id="input-password")
	WebElement txtpwd;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement loginbtn;
	
	public void setEmail(String mail) {
		txtEmail.sendKeys(mail);
	}
	public void setPassword(String pwd) {
		txtpwd.sendKeys(pwd);
	}
	
	public void clickLogin() {
		loginbtn.click();
	}

}
