package stepDefinations;

import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.github.dockerjava.api.model.Driver;

import org.junit.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class steps {
	
	WebDriver driver;
    HomePage hp;
    LoginPage lp;
    MyAccountPage macc;
    List<HashMap<String, String>> datamap;
    
    Properties properties;
    
     Logger  logger; //for logging
    
    String br; //to store browser name from config file
    
    @Before
    public void setup() throws FileNotFoundException {
    	logger= LogManager.getLogger(this.getClass());    	 
    	try {
    		
    		
        	properties =new Properties();
        	InputStream input= new FileInputStream("D:\\Eclipse\\Open_Cart_Cucumber_Framework\\resources\\config.properties");
        	properties.load(input);
        	br= properties.getProperty("browser");
    	}
    	
    catch (Exception e) {
    	e.printStackTrace();
    }
    	
    	
    	
    	
    }
    
    @After
    public void tearDown(Scenario scenario) {
    	System.out.println("scenario status ====>"+scenario.getStatus());
    	if(scenario.isFailed()){
    		TakesScreenshot ts= (TakesScreenshot)driver;
    		byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
    		scenario.attach(screenshot, "image/png", scenario.getName());
    	}
//    	driver.close();
    	
    	
    	
    }
    
    
    
	
	
	
	@Given("User Launch browser")
	public void user_launch_browser() {
	    // Write code here that turns the phrase above into concrete actions
		
	  if(br.equals("chrome")) {
		  driver= new ChromeDriver();
	  }
	  else if(br.equals("edge")) {
		  driver= new EdgeDriver();
	  }
	  else if(br.equals("firefox")){
		  driver= new FirefoxDriver();
	  }
	  
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Given("opens URL {string}")
	public void opnes_url(String url) {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(url);
        driver.manage().window().maximize();
	}

	@When("user navigate to MyAccount menu")
	public void user_navigate_to_my_account_menu() {
	    // Write code here that turns the phrase above into concrete actions
		hp =new HomePage(driver);
		hp.clickMyAccount();
	    logger.info("Clicked on My Account ");
	}

	@When("Click on Login")
	public void click_on_login() {
	    // Write code here that turns the phrase above into concrete actions
	    
	    hp.clickLogin();
	    logger.info("Clicked on Login ");
	}

	@When("User Enter Email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
	    // Write code here that turns the phrase above into concrete actions
		lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
	    logger.info("Entered username and password");
	
	}

	@When("User click on Login button")
	public void user_click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    lp.clickLogin();
	}
	
	


	@Then("user navigate to the My Account Page")
	public void user_navigate_to_the_my_account_page() {
	    // Write code here that turns the phrase above into concrete actions
		macc= new MyAccountPage(driver);
		Boolean targetPage= macc.isLoginSucces();
		
		if(targetPage) {
			 logger.info("Login Success ");
			 Assert.assertTrue(true);
		
		}
		else {
			 logger.info("Login Failed ");
			 Assert.assertTrue(false);
			
		}
	   
	}
	
	
	  @Then("Check user navigate to the My Account Page by passing Email and Password with excel row {string}")
	    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows)
	    {
		  
		  
		  datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx", "Sheet1");
		  int index= Integer.parseInt(rows)-1;
		  
		   String email= datamap.get(index).get("username");
	       String pwd= datamap.get(index).get("password");
	       String exp_res= datamap.get(index).get("res");
	       lp=new LoginPage(driver);
	        lp.setEmail(email);
	        lp.setPassword(pwd);

	        lp.clickLogin();
	        try
	        {
	            boolean targetpage=macc.isLoginSucces();

	            if(exp_res.equals("Valid"))
	            {
	                if(targetpage==true)
	                {
	                    MyAccountPage myaccpage=new MyAccountPage(driver);
	                    myaccpage.clickLogout();
	                    Assert.assertTrue(true);
	                }
	                else
	                {
	                    Assert.assertTrue(false);
	                }
	            }

	            if(exp_res.equals("Invalid"))
	            {
	                if(targetpage==true)
	                {
	                    macc.clickLogout();
	                    Assert.assertTrue(false);
	                }
	                else
	                {
	                    Assert.assertTrue(true);
	                }
	            }


	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
//	            Assert.assertTrue(false);
	        }
	        driver.close();
	        
	    }
	  
	
		  
		  
	    }
	


	  

