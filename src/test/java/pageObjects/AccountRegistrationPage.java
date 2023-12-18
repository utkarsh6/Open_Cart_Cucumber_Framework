
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage  extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	//elements
	@FindBy (name="firstname")
	WebElement firstName;
	
	@FindBy (id="input-lastname")
	WebElement lastName;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(id="input-confirm")
	WebElement conPassword;
	
	
	@FindBy(id="input-newsletter-no")
	WebElement  newsletter;
	
	@FindBy(name="agree")
	WebElement policy;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	WebElement btnContinue;
	
	@FindBy(name="telephone")
	WebElement telephoneNo;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement accountSuccess;
	
	
	public void setfirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void setlastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void setEmail(String mailId) {
		email.sendKeys(mailId);
	}
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void confirmPassword(String pwd1) {
		conPassword.sendKeys(pwd1);
	}
	public void setTelephoneNo(String telno) {
		telephoneNo.sendKeys(telno);
	}
	public void setNewsletter() {
		newsletter.click();
	}
	public void setPolicy() {
		policy.click();
	}

	
	public void setContinue() {
		btnContinue.click();
	}
	
	public String getAccountSuccessMsg() {
		try {
			return (accountSuccess.getText());
		}
		catch (Exception e) {
			return(e.getMessage());
		}
	}
	
}
