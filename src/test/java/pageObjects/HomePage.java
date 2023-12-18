package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
//Elements 
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	WebElement linkDropddown;
	
	@FindBy(linkText="Register")
	WebElement register;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement login;
	
	
	

	//Action Method


public void clickMyAccount() {
	linkDropddown.click();
}

public void clickRegister() {
	register.click();
}
public void clickLogin() {
	login.click();		
}


}
 	

